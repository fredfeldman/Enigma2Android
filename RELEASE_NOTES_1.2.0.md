# Enigma2 Android — Release Notes 1.2.0

## External players

You can now route channel and recording playback to any video app installed
on your phone — VLC, MX Player, Kodi, etc. — instead of the built-in player.

This is the simplest way to "cast" Enigma2 streams to other devices: open
the stream in Kodi or VLC and use that app's own AirPlay / Chromecast / DLNA
support. It also unlocks features the bundled player can't offer (audio
passthrough, custom subtitle rendering, video filters, etc.).

### What's new

- **Settings → Playback → Player** — choose between:
  - **Built-in player** (default; existing behaviour with PiP, EPG OSD, zap)
  - **External player** (every channel/recording tap launches your video app)
  - **Ask every time** (Android picks-an-app chooser on every launch)
- **Settings → Playback → Preferred external player** — when in External
  mode, pin a default app (VLC / MX / Kodi auto-detected) so you skip the
  chooser. Choose "Show chooser each time" to keep the picker.
- The MIME type sent with the stream is `video/mp2t` for live and falls back
  to a sensible value for `.m3u8`, `.mp4`, `.mkv` recordings.
- The integration is **transparent**: every existing playback path
  (channel tap, recording tap, schedule playback, favourites) honours the
  preference automatically.

### Why no Cast button this release

Chromecast's default media receiver does **not** play MPEG-TS, which is what
OpenWebif emits on port 8001. Shipping a Cast button without a custom
receiver application would fail for nearly every user. External players that
already speak MPEG-TS (Kodi → cast to TV, VLC → render to UPnP) give you
a working path right now. A Cast SDK integration with a transcoding-aware
receiver may follow in a future release.

### Notes

- If no external player is installed and **External** mode is selected, the
  app silently falls back to the built-in player so streams always play.
- The pin-a-player chooser only auto-detects well-known packages
  (VLC / MX / Kodi). Other apps still work in **Ask every time** mode.

### Build

- versionCode `12`, versionName `1.2.0`
- APKs:
  - `app/build/outputs/apk/debug/Enigma2Android-debug-1.2.0.apk`
  - `app/build/outputs/apk/release/Enigma2Android-release-1.2.0.apk`
