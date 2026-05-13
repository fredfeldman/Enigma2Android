# Enigma2 for Android — Release Notes 1.0.7

**Theme: Daily-use polish — "the things you reach for every day".**

## What's new

### Virtual remote control
- New **Remote** button in the channel-list toolbar opens an on-screen
  remote with full D-pad, OK/Back/Exit/Menu, EPG/Info/Text, the four
  coloured keys, a number pad, volume / channel / mute, and playback
  transport (play, pause, stop, record).
- Each press is sent to the receiver via OpenWebif's `/api/remotecontrol`
  endpoint using standard Linux input keycodes — works with every box
  that exposes the standard remote API.

### Send a message to the TV
- New **Message** button in the channel-list toolbar lets you push a
  short message that pops up on the TV screen.
- Choose info / warning / question / error, set a timeout in seconds,
  and tap *Send* — the box will display it immediately via the standard
  `/api/message` endpoint.

### Quick Settings tile
- A new **Power** tile is registered with the system Quick Settings
  panel. Pull down twice from the status bar, edit your tiles, and drop
  the *Enigma2 Power* tile in.
- Tapping it toggles the active receiver between standby and on without
  needing to open the app. The tile reflects the current power state.

### App shortcuts
- Long-press the app icon on your launcher to jump straight into:
  - **Live TV** — the channel list
  - **EPG** — the programme guide
  - **Recordings** — your recordings list

### Picture-in-Picture
- When you press Home while the player is open with a live stream, the
  video shrinks into a floating PiP window so you can keep watching
  while you do something else.
- Enabled by default; you can turn it off under
  *Settings → Playback → Picture-in-Picture*.
- Recording playback continues to use the full player so resume
  positions are preserved.

### Pull-to-refresh — audit complete
- Verified that every browseable list (Channels, Recordings, Timers,
  Auto-Timers) supports pull-to-refresh. No code changes needed —
  documenting that the gesture is everywhere you'd expect it.

## Compatibility

- minSdk 26 (Android 8.0). Quick Settings tiles require Android 7.0+,
  PiP requires Android 8.0+; the app silently skips both on older
  hardware.
- Works against any OpenWebif build that supports `/api/remotecontrol`,
  `/api/message` and `/api/powerstate` (i.e. essentially all of them).

## Build

- versionCode 8, versionName 1.0.7
- Both `app-debug.apk` and `app-release.apk` produced cleanly.
