# Enigma2 for Android — Release Notes 1.0.8

**Theme: Recording power-user — turn the recordings list into a real management tool, plus EPG reminders.**

## What's new

### Rename a recording
- Long-press a recording → **Rename** to set a new on-disk name. Uses
  OpenWebif's `/api/movierename` so the file and metadata both update.

### Move a recording to another folder
- Long-press → **Move to folder** → pick from the receiver's known
  recording locations (the same list you manage under Receiver
  Settings → Recording locations). Backed by `/api/moviemove`.

### Mark watched / unwatched
- Long-press → **Mark as watched / Mark as unwatched** flips a `Watched`
  tag on the receiver via `/api/movietags`. A small green dot appears
  next to watched titles in the list. Works on every OpenWebif build —
  no plugin required.

### Tag editor
- Long-press → **Edit tags** opens a free-text editor. Enter a
  space-separated list, save, and the receiver-side tag list is updated
  with a single round trip (only added/removed tags are sent).

### Schedule conflict warning
- When you tap **Record** on an EPG event the app now fetches the
  current timer list, computes overlap with the new timer's window, and
  pops a warning that lists every overlapping timer. You can still
  schedule it anyway — the choice is yours.

### EPG reminders (no recording)
- Long-press an EPG event in the future → **Remind me** → the app
  schedules a local notification at programme start. No timer is created
  on the receiver, so no tuner is consumed.
- Reminders are stored in app prefs and fired by `AlarmManager` /
  `ReminderReceiver`; the reminder is removed automatically after it
  fires.
- Uses inexact alarms so no SCHEDULE_EXACT_ALARM permission grant is
  required on Android 12+.

### Pull-to-refresh
- Already comprehensive after the 1.0.7 audit; no changes here.

## Compatibility

- minSdk 26 (Android 8.0). All endpoints used (`/api/movierename`,
  `/api/moviemove`, `/api/movietags`, `/api/gettags`, `/api/timerlist`)
  are stock OpenWebif — no plugins needed.
- Reminder notifications use the existing POST_NOTIFICATIONS permission
  declared since 1.0.5.

## Build

- versionCode 9, versionName 1.0.8
- Both `app-debug.apk` and `app-release.apk` built cleanly.
