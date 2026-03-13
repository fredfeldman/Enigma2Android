package com.enigma2.android.worker

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.enigma2.android.R
import com.enigma2.android.data.api.ApiClient
import com.enigma2.android.data.prefs.ReceiverPreferences
import com.enigma2.android.data.repository.Enigma2Repository

class TimerPollingWorker(
    context: Context,
    params: WorkerParameters
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        return try {
            val prefs = ReceiverPreferences(applicationContext)
            if (!prefs.isConfigured()) return Result.success()

            ApiClient.initialize(prefs)
            val repo = Enigma2Repository()
            val timers = repo.getTimers()
            val recording = timers.filter { it.state == 2 }

            if (recording.isNotEmpty()) {
                sendNotification(recording.first().name)
            }

            Result.success()
        } catch (e: Exception) {
            Result.retry()
        }
    }

    private fun sendNotification(title: String) {
        val manager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE)
            as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Recording Notifications",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            manager.createNotificationChannel(channel)
        }

        val notification = NotificationCompat.Builder(applicationContext, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_channel_placeholder)
            .setContentTitle(applicationContext.getString(R.string.recording_started))
            .setContentText(title)
            .setAutoCancel(true)
            .build()

        manager.notify(NOTIFICATION_ID, notification)
    }

    companion object {
        private const val CHANNEL_ID = "recording_channel"
        private const val NOTIFICATION_ID = 1001
    }
}
