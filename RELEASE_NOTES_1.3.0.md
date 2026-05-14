# Enigma2 Android — Release Notes 1.3.0

## Multi-room and backup

Two long-requested features for users who run more than one Enigma2 box or
who set the app up across multiple phones/tablets.

### Zap on another receiver

Long-press any channel → **Zap on…**. The menu lists every other configured
device profile (the entry only appears when you have more than one). Picking
a receiver sends `/api/zap` to *that* box without disturbing the playback or
zap state on your active receiver.

Useful for "tune the bedroom box from the couch", multi-room sports, or
"set up channels in another room before walking over".

### Profile export / import

**Settings → Backup → Export device profiles** writes every configured
receiver to a JSON file in `Downloads/enigma2android_profiles_<timestamp>.json`.
Passwords are stripped by default — tick *Include passwords (less secure)*
when you want a fully self-contained backup.

**Settings → Backup → Import device profiles** opens Android's file picker
(any `.json` file). Profiles with the same `id` are updated in-place;
passwords kept by the import file are merged in, but a missing password
**never silently wipes** your existing one.

Format is intentionally human-readable — you can hand-edit the file before
re-importing if you want to bulk-rename receivers or adjust IPs.

### Notes

- Multi-room "send message to receiver" and "record on…" share the new
  `RemoteReceiverApi` plumbing. They'll surface in a follow-up release.
- Picon manager, theme picker, and receiver-config backup were on the v1.3.0
  longlist but are deferred — they each carry distinct risks (file upload to
  the receiver, theme regression surface area, image-variant config paths).

### Build

- versionCode `13`, versionName `1.3.0`
- APKs:
  - `app/build/outputs/apk/debug/Enigma2Android-debug-1.3.0.apk`
  - `app/build/outputs/apk/release/Enigma2Android-release-1.3.0.apk`
