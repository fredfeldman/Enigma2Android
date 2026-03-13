# E2Android — User Guide

A touch-optimised Android tablet remote control for **Enigma2** satellite and cable receivers (Dreambox, VU+, Octagon, etc.).

---

## Table of Contents

1. [Quick Start / First Launch](#1-quick-start--first-launch)
2. [Adding & Switching Devices](#2-adding--switching-devices)
3. [Channel Screen](#3-channel-screen)
4. [Playing Live TV](#4-playing-live-tv)
5. [EPG — Electronic Programme Guide](#5-epg--electronic-programme-guide)
6. [EPG Search](#6-epg-search)
7. [Recordings](#7-recordings)
8. [Player Controls](#8-player-controls)
9. [Timers](#9-timers)
10. [Playlists](#10-playlists)
11. [Settings](#11-settings)
12. [Wake-on-LAN](#12-wake-on-lan)
13. [Troubleshooting](#13-troubleshooting)

---

## 1. Quick Start / First Launch

When you open E2Android for the first time the **Setup** screen appears automatically.

| Field | Description |
|---|---|
| **Device Name** | A friendly label for this receiver (e.g. "Living Room") |
| **Host / IP Address** | IP address or hostname (e.g. `192.168.1.100` or `dreambox.local`) |
| **Port** | OpenWebif HTTP port — default is **80**; some setups use **8080** |
| **Username** | Leave blank if OpenWebif has no authentication |
| **Password** | Leave blank if OpenWebif has no authentication |
| **MAC Address** | 12 hex digits (e.g. `AA:BB:CC:DD:EE:FF`) — only needed for Wake-on-LAN |
| **Use HTTPS** | Enable if your OpenWebif is configured for SSL |

Tap **Connect**. The app fetches your bouquet and channel list immediately.

---

## 2. Adding & Switching Devices

E2Android supports any number of receiver profiles.

### Adding a new device
Channel screen → toolbar → **Switch Device** icon → **+ Add Device**.  
Fill in the same fields as first launch and tap **Save**.

### Switching the active receiver
Channel screen → toolbar → **Switch Device** icon → tap any entry in the list.  
The channel list refreshes from the new receiver immediately.

### Editing or deleting a device
Long-press (or swipe) an entry in the device list to reveal **Edit** and **Delete** options.

### Back navigation
Tap **←** (top-left) or use the Android back gesture to return without changing device.

---

## 3. Channel Screen

The channel screen is the main screen of the app.

```
┌─────────────────┬─────────────────────────────────────────────┐
│  Bouquet List   │               Channel List                  │
│                 │  [picon]  Channel Name                      │
│  ★ Favourites   │           Now: Programme title  ████░░░░    │
│  Sky UK         │           Next: Next programme              │
│  BBC HD         │                                             │
│  …              │  …                                          │
└─────────────────┴─────────────────────────────────────────────┘
```

### Bouquet list (left panel)
- Tap a bouquet to load its channels on the right.
- The **★ Favourites** bouquet shows all channels you have starred.

### Channel list (right panel)
Each row shows the channel picon, name, current programme with a progress bar, and the next programme.

| Gesture | Action |
|---|---|
| Tap | Zap the receiver to that channel **and** open the full-screen player |
| Long-press | Context menu — *Show EPG* or *Set Timer* for the current programme |

### Toolbar buttons

| Button | Function |
|---|---|
| 🔍 | Filter/search — type to filter channel names in real time |
| 📷 | Screenshot — triggers a screenshot on the receiver |
| ⋮ | Overflow menu — Switch Device, EPG, Recordings, Timers, Playlists, Settings |

---

## 4. Playing Live TV

Tap any channel to open the full-screen player.

### OSD (On-Screen Display)
- **Tap** the video to show the OSD.
- The OSD **auto-hides** after 5 seconds of inactivity.
- Tap again to show it.

### Stopping playback
Tap **×** in the top-left corner (always visible) — or use the Android back gesture.

---

## 5. EPG — Electronic Programme Guide

**Access:** Channel screen → overflow → **EPG**

The EPG grid shows all programmes across all channels in a scrollable 2D view.

```
        │ 19:00   │ 19:30   │ 20:00   │ 20:30   │ 21:00
────────┼─────────┼─────────┼─────────┴─────────┼──────
BBC One │ News    │ Weather │ EastEnders         │ …
ITV     │ …       │ Emmerdale         │ Corrie   │ …
```

| Gesture | Action |
|---|---|
| Swipe left / right | Scroll through time |
| Swipe up / down | Scroll through channels |
| Tap a programme | Select and show title + description |
| Double-tap | Play the channel immediately |
| Long-press | Set a timer / recording for that programme |

Tap **←** (top-left) to return to the channel screen.

---

## 6. EPG Search

**Access:** EPG screen → 🔍 toolbar icon, or channel screen → overflow → **EPG Search**

1. Type a programme title (full or partial) in the search box.
2. Results show channel, date/time and title.
3. Tap a result to view details and optionally set a timer.
4. Tap **←** to return.

---

## 7. Recordings

**Access:** Channel screen → overflow → **Recordings**

```
┌───────────────────┬─────────────────────────────────────┐
│  Recording List   │   Detail / Info                     │
│                   │                                     │
│  Title A          │   Title:    …                       │
│  Title B  ◄       │   Channel:  …                       │
│  Title C          │   Duration: …                       │
│                   │   [  ▶ PLAY  ]                      │
└───────────────────┴─────────────────────────────────────┘
```

### Sorting
Tap the sort icon to sort by: **Date ↓**, **Date ↑**, **Channel A-Z**, or **Title A-Z**.

### Playing a recording
1. Tap a recording in the list — details appear on the right.
2. Tap **▶ PLAY**. The full-screen player opens.
3. Use the **seek bar** to scrub to any position.
4. Use **⏪ 15s** / **⏩ 15s** for quick jumps.

### Resume playback
If auto-resume is enabled in Settings, the app remembers where you stopped.  
The next time you play that recording it offers to resume from that position.

Tap **←** (top-left) to return to the channel screen.

---

## 8. Player Controls

The same player is used for live TV and recordings. Controls that differ are noted.

### On-Screen Display (OSD)

| Control | Description |
|---|---|
| **×** (top-left) | Stop and exit — always visible |
| Tap video | Toggle OSD visibility (auto-hides after 5 s) |
| ▶ / ⏸ | Play / Pause |
| ◀◀ / ▶▶ | Previous / Next channel *(live TV only)* |
| ⏪ 15s / ⏩ 15s | Rewind / Fast-forward 15 seconds *(recordings only)* |
| Seek bar | Drag to any position *(recordings only)* |

### Audio Tracks
Tap the **audio-track icon** in the OSD to see available audio streams (e.g. English AC3, German, etc.) and switch between them.

### Subtitles / Closed Captions
Tap the **CC icon** in the OSD to enable a subtitle track or turn subtitles off.

### Aspect Ratio
Tap the **aspect-ratio icon** to cycle through:

> **FIT** → **FILL** → **ZOOM** → **16:9** → **4:3** → (back to FIT)

### Sleep Timer
Tap the **moon icon** in the OSD and choose:

| Option | Behaviour |
|---|---|
| 15 min | Stop playback after 15 minutes |
| 30 min | Stop playback after 30 minutes |
| 60 min | Stop playback after 60 minutes |
| Cancel | Remove active timer |

A countdown badge is shown on the icon while a timer is active.

---

## 9. Timers

**Access:** Channel screen → overflow → **Timers**

Shows all recording timers currently scheduled on the receiver.

Each row shows: programme title, channel, start/end time, and timer state (waiting / recording / completed / failed).

### Deleting a timer
Swipe the timer row left, or tap the **delete** icon. A confirmation prompt appears before the timer is removed from the receiver.

> **Tip:** To *create* a new timer, long-press a programme in the EPG grid or long-press a channel in the channel list.

Tap **←** (top-left) to return to the channel screen.

---

## 10. Playlists

**Access:** Channel screen → overflow → **Playlists**

Playlists are stored locally on the tablet and let you build ordered collections of recordings.

### Creating a playlist
Tap **+** → enter a name → tap **Create**.

### Adding recordings
Open a playlist → tap **Add Recording** → browse the receiver's recordings → tap a title to add it.

### Playing a playlist
Open the playlist → tap the first item (or **Play All**). When one recording finishes the next starts automatically.

### Reordering entries
Long-press an entry and drag it to the desired position.

### Renaming or deleting a playlist
Long-press the playlist name → choose **Rename** or **Delete**.

### HDD / NAS Browser
Playlists screen → **Browse Files** — displays folders and video files directly on the receiver's storage. Tap a file to play it immediately.

---

## 11. Settings

**Access:** Channel screen → overflow → **Settings**

| Setting | Description |
|---|---|
| **Device Configuration** | Edit host, port, credentials and MAC address for any device profile |
| **Hide Bouquets** | Tick bouquets you don't want to see in the channel list |
| **Night Mode** | Toggle between dark theme (default) and light theme |
| **Auto-Resume** | Prompt to resume recordings from the last watched position |
| **Background Notifications** | The app polls the receiver's timer list every 15 minutes and shows a notification when a recording starts |

> On **Android 13+** you must grant the **Notifications** permission when prompted for timer notifications to work.

---

## 12. Wake-on-LAN

Wake-on-LAN sends a UDP magic packet to power on a receiver that is in deep standby.

**Requirements:**
- "Wake-on-LAN" enabled in the receiver's network settings
- The receiver's MAC address entered in the device profile
- Tablet and receiver on the same LAN subnet

**How to use:**  
Channel screen → **Switch Device** → tap the **power/WoL icon** next to the device.

After sending, wait 30–60 seconds for the receiver to boot before tapping its name to connect.

---

## 13. Troubleshooting

### "Connection failed" or empty channel list
- Verify the IP address and port in **Settings**.
- Confirm the tablet and receiver are on the same Wi-Fi network.
- Open `http://<receiver-ip>/api/info` in a browser to test OpenWebif directly.
- If OpenWebif requires a login, enter the credentials in the device profile.

### "Unauthorised" / 401 errors
- The username or password stored in the device profile is incorrect.
- Check the OpenWebif plugin settings on the receiver.

### Black screen / video won't play
- Confirm the receiver is tuned to and receiving that channel.
- Some encrypted channels require a valid CAM (smartcard / softcam).
- Check that **port 8001** (the streaming port) is not blocked by a firewall.

### Picon images not showing
- Picons must be installed on the receiver (typically in `/usr/share/enigma2/picon/`).
- The app fetches picons via HTTP using the same credentials as OpenWebif.

### No timer notifications
- On Android 13+ grant **Notifications** permission: Settings → Apps → E2Android → Permissions.
- Disable battery optimisation for E2Android: Settings → Battery → E2Android → **Unrestricted**.

### App shows stale / old data
- Pull down (swipe from the top of the list) to force a manual refresh.

---

*E2Android v1.0.0 — Requires Android 8.0 (API 26) or higher*
