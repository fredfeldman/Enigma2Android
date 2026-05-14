# Enigma2 Android — Release Notes 1.3.2

## Reminder notification actions

EPG reminder notifications now have two action buttons. Previously they were
informational only — you had to switch to the app and tap the channel
yourself.

### Watch now

Tap **Watch now** in the reminder notification and the built-in player
launches directly on the channel the reminder is for. No need to navigate
through bouquets. The action honours the active receiver's host/port/HTTPS
settings (the same path channel-tap uses).

### Snooze 5 min

Tap **Snooze 5 min** to dismiss the current notification and re-fire the
reminder five minutes later. Useful for "I'm finishing this scene first".
The reminder is re-persisted so it survives reboots.

### Notes

- Snoozed reminders use the same inexact `setAndAllowWhileIdle` alarm path
  as v1.0.8 so they don't require the SCHEDULE_EXACT_ALARM permission.
- The bare notification body (without tapping an action) still auto-cancels
  on tap as before; no behavioural regression for existing users.
- If the reminder fires and you ignore both actions, the reminder is
  removed from the persistent store as before.

### Build

- versionCode `15`, versionName `1.3.2`
- APKs:
  - `app/build/outputs/apk/debug/Enigma2Android-debug-1.3.2.apk`
  - `app/build/outputs/apk/release/Enigma2Android-release-1.3.2.apk`
