package com.enigma2.android.service;

/**
 * Fires when an EPG reminder's start time is reached. Posts a local
 * notification and removes the reminder from the persistent store.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J \u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/enigma2/android/service/ReminderReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "ensureChannel", "", "context", "Landroid/content/Context;", "launchPlayer", "channelName", "", "sref", "onReceive", "intent", "Landroid/content/Intent;", "Companion", "app_release"})
public final class ReminderReceiver extends android.content.BroadcastReceiver {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CHANNEL_ID = "epg_reminder_channel";
    private static final int NOTIF_BASE = 5000;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_ID = "id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_TITLE = "title";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_CHANNEL = "channel";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_SREF = "sref";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_SNOOZE = "com.enigma2.android.ACTION_REMINDER_SNOOZE";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_WATCH = "com.enigma2.android.ACTION_REMINDER_WATCH";
    private static final long SNOOZE_SECONDS = 300L;
    @org.jetbrains.annotations.NotNull()
    public static final com.enigma2.android.service.ReminderReceiver.Companion Companion = null;
    
    public ReminderReceiver() {
        super();
    }
    
    @java.lang.Override()
    public void onReceive(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.content.Intent intent) {
    }
    
    private final void launchPlayer(android.content.Context context, java.lang.String channelName, java.lang.String sref) {
    }
    
    private final void ensureChannel(android.content.Context context) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fJ\u0016\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/enigma2/android/service/ReminderReceiver$Companion;", "", "()V", "ACTION_SNOOZE", "", "ACTION_WATCH", "CHANNEL_ID", "EXTRA_CHANNEL", "EXTRA_ID", "EXTRA_SREF", "EXTRA_TITLE", "NOTIF_BASE", "", "SNOOZE_SECONDS", "", "cancel", "", "context", "Landroid/content/Context;", "id", "schedule", "reminder", "Lcom/enigma2/android/data/prefs/EpgReminder;", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        /**
         * Schedules an alarm to fire at the reminder's start time. Uses inexact
         * `setAndAllowWhileIdle` so we don't need SCHEDULE_EXACT_ALARM grant on
         * Android 12+; tens-of-seconds slop is acceptable for "remind me at start".
         */
        public final void schedule(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        com.enigma2.android.data.prefs.EpgReminder reminder) {
        }
        
        public final void cancel(@org.jetbrains.annotations.NotNull()
        android.content.Context context, int id) {
        }
    }
}