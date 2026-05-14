package com.enigma2.android.service

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.enigma2.android.R
import com.enigma2.android.data.prefs.EpgReminder
import com.enigma2.android.data.prefs.RemindersStore

/**
 * Fires when an EPG reminder's start time is reached. Posts a local
 * notification and removes the reminder from the persistent store.
 */
class ReminderReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val id = intent.getIntExtra(EXTRA_ID, 0)
        val title = intent.getStringExtra(EXTRA_TITLE).orEmpty()
        val channel = intent.getStringExtra(EXTRA_CHANNEL).orEmpty()
        val sref = intent.getStringExtra(EXTRA_SREF).orEmpty()
        val notifId = NOTIF_BASE + (id and 0x7FFFFFFF) % 1000

        // v1.3.2: handle action callbacks (Snooze / Watch / Dismiss)
        when (intent.action) {
            ACTION_SNOOZE -> {
                val newStart = (System.currentTimeMillis() / 1000) + SNOOZE_SECONDS
                val resched = EpgReminder(id, title, channel, sref, newStart)
                schedule(context, resched)
                runCatching { RemindersStore(context).add(resched) }
                (context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager)
                    .cancel(notifId)
                return
            }
            ACTION_WATCH -> {
                (context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager)
                    .cancel(notifId)
                launchPlayer(context, channel, sref)
                runCatching { RemindersStore(context).remove(id) }
                return
            }
        }

        ensureChannel(context)

        val watchIntent = Intent(context, ReminderReceiver::class.java).apply {
            action = ACTION_WATCH
            putExtra(EXTRA_ID, id); putExtra(EXTRA_TITLE, title)
            putExtra(EXTRA_CHANNEL, channel); putExtra(EXTRA_SREF, sref)
        }
        val snoozeIntent = Intent(context, ReminderReceiver::class.java).apply {
            action = ACTION_SNOOZE
            putExtra(EXTRA_ID, id); putExtra(EXTRA_TITLE, title)
            putExtra(EXTRA_CHANNEL, channel); putExtra(EXTRA_SREF, sref)
        }
        val piFlags = PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        val watchPi = PendingIntent.getBroadcast(context, id * 10 + 1, watchIntent, piFlags)
        val snoozePi = PendingIntent.getBroadcast(context, id * 10 + 2, snoozeIntent, piFlags)

        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_channel_placeholder)
            .setContentTitle(context.getString(R.string.reminder_notification_title, title))
            .setContentText(context.getString(R.string.reminder_notification_text, channel))
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .addAction(0, context.getString(R.string.reminder_action_watch), watchPi)
            .addAction(0, context.getString(R.string.reminder_action_snooze), snoozePi)
            .build()

        val nm = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        nm.notify(notifId, notification)

        runCatching { RemindersStore(context).remove(id) }
    }

    private fun launchPlayer(context: Context, channelName: String, sref: String) {
        if (sref.isBlank()) return
        val prefs = com.enigma2.android.data.prefs.ReceiverPreferences(context)
        val scheme = if (prefs.useHttps) "https" else "http"
        val streamUrl = "$scheme://${prefs.host}:8001/$sref"
        val intent = Intent(context,
            com.enigma2.android.ui.player.PlayerActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            putExtra(com.enigma2.android.ui.player.PlayerActivity.EXTRA_STREAM_URL, streamUrl)
            putExtra(com.enigma2.android.ui.player.PlayerActivity.EXTRA_CHANNEL_NAME, channelName)
            putExtra(com.enigma2.android.ui.player.PlayerActivity.EXTRA_SERVICE_REF, sref)
        }
        try { context.startActivity(intent) } catch (_: Exception) {}
    }

    private fun ensureChannel(context: Context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) return
        val nm = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (nm.getNotificationChannel(CHANNEL_ID) == null) {
            nm.createNotificationChannel(
                NotificationChannel(
                    CHANNEL_ID,
                    context.getString(R.string.reminder_channel_name),
                    NotificationManager.IMPORTANCE_HIGH
                )
            )
        }
    }

    companion object {
        const val CHANNEL_ID = "epg_reminder_channel"
        private const val NOTIF_BASE = 5000

        const val EXTRA_ID = "id"
        const val EXTRA_TITLE = "title"
        const val EXTRA_CHANNEL = "channel"
        const val EXTRA_SREF = "sref"

        // v1.3.2: notification action intents
        const val ACTION_SNOOZE = "com.enigma2.android.ACTION_REMINDER_SNOOZE"
        const val ACTION_WATCH = "com.enigma2.android.ACTION_REMINDER_WATCH"
        private const val SNOOZE_SECONDS = 5 * 60L

        /**
         * Schedules an alarm to fire at the reminder's start time. Uses inexact
         * `setAndAllowWhileIdle` so we don't need SCHEDULE_EXACT_ALARM grant on
         * Android 12+; tens-of-seconds slop is acceptable for "remind me at start".
         */
        fun schedule(context: Context, reminder: EpgReminder) {
            val triggerMs = reminder.startTimestampSec * 1000L
            val intent = Intent(context, ReminderReceiver::class.java).apply {
                putExtra(EXTRA_ID, reminder.id)
                putExtra(EXTRA_TITLE, reminder.title)
                putExtra(EXTRA_CHANNEL, reminder.channelName)
                putExtra(EXTRA_SREF, reminder.sref)
            }
            val flags = PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            val pi = PendingIntent.getBroadcast(context, reminder.id, intent, flags)
            val am = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                am.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, triggerMs, pi)
            } else {
                am.set(AlarmManager.RTC_WAKEUP, triggerMs, pi)
            }
        }

        fun cancel(context: Context, id: Int) {
            val intent = Intent(context, ReminderReceiver::class.java)
            val flags = PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            val pi = PendingIntent.getBroadcast(context, id, intent, flags)
            val am = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
            am.cancel(pi)
        }
    }
}
