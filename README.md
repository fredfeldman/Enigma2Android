# Enigma2Android

An Android tablet remote control app for **Enigma2**-based satellite and cable receivers (Dreambox, VU+, Octagon, etc.) via the [OpenWebif](https://github.com/E2OpenPlugins/e2openplugin-OpenWebif) HTTP API.

## Features

- **Live TV** — Browse bouquets and channels, zap directly from the app
- **Full-screen player** — HLS/MPEG-TS streaming via ExoPlayer with touch OSD
- **EPG** — Full 2D grid programme guide with tap-to-select, double-tap to play, long-press to set timer
- **EPG Search** — Full-text search across all channels
- **Recordings** — Browse, sort and play back recordings stored on the receiver
- **Timers** — View and delete scheduled recording timers
- **Favourites** — Star any channel to add it to an auto-generated Favourites bouquet
- **Multiple devices** — Store and switch between any number of receiver profiles
- **Wake-on-LAN** — Power on your receiver remotely
- **Background timer polling** — Notification when a timer recording starts
- **Picon support** — Channel logos loaded from the receiver using Basic Auth
- **Playlists** — Build local playlists of recordings and browse the receiver's HDD/NAS
- **Hide Bouquets** — Suppress bouquets you don't use from the channel list

## Requirements

| Requirement | Minimum |
|---|---|
| Android | 8.0 (API 26) |
| Target | Android 14 (API 34) |
| Device | Android tablet with touchscreen |
| Receiver firmware | Any Enigma2 image with OpenWebif installed |
| Network | Receiver and tablet on the same LAN (or accessible via port forwarding) |

## Building

### Prerequisites

- Android Studio Iguana (2023.2) or newer, **or** JDK 17+ with command-line tools
- Gradle 8.2 (wrapper included)
- Android SDK with API 34 platform

### Clone & build

```bash
git clone <repo-url>
cd Enigma2Android
./gradlew assembleDebug          # debug APK
./gradlew assembleRelease        # release APK (needs signing config)
```

The output APK is placed at:
```
app/build/outputs/apk/debug/Enigma2Android-debug-1.0.0.apk
```

### Install

```bash
adb install app/build/outputs/apk/debug/Enigma2Android-debug-1.0.0.apk
```

Or open the project in Android Studio and click **Run**.

## First-time Setup

1. Launch **E2Android** on your tablet.
2. The setup screen opens automatically. Enter:
   - **Device Name** — a friendly label (e.g. "Living Room")
   - **Host / IP Address** — the receiver's IP or hostname
   - **Port** — OpenWebif port (default: **80**)
   - **Username / Password** — if authentication is enabled on OpenWebif
   - **MAC Address** — required for Wake-on-LAN (optional)
   - **Use HTTPS** — tick if OpenWebif is configured for SSL
3. Tap **Connect**. The app zaps to the channel list immediately.

Multiple receivers can be added via the **Switch Device** button in the channel list toolbar.

## Architecture

```
app/src/main/java/com/enigma2/android/
├── data/
│   ├── api/            Retrofit service interface + ApiClient singleton
│   ├── model/          Gson data classes (Services, EPG, Recordings, Timers…)
│   ├── prefs/          SharedPreferences wrappers (device profiles, favourites, playlists)
│   └── repository/     Enigma2Repository — all network calls
├── ui/
│   ├── main/           MainActivity (single-activity host)
│   ├── channels/       Bouquet list + Channel list + adapters
│   ├── epg/            EPG grid, time ruler, search
│   ├── player/         ExoPlayer full-screen activity
│   ├── recordings/     Movie list with detail panel
│   ├── timers/         Timer list
│   ├── playlists/      Local playlist manager + HDD browser
│   ├── devices/        Device picker + setup form
│   ├── settings/       PreferenceFragment + Hide-Bouquets screen
│   └── viewmodel/      ChannelViewModel, EpgViewModel, RecordingViewModel
├── utils/              WakeOnLan utility
└── worker/             TimerPollingWorker (WorkManager, 15-min interval)
```

**Pattern:** Single-Activity MVVM — `MainActivity` hosts all fragments on `R.id.main_container`. `PlayerActivity` and `SettingsActivity` are separate activities.

## Technology Stack

| Library | Version | Purpose |
|---|---|---|
| Kotlin | 1.9.22 | Language |
| AGP | 8.2.2 | Build system |
| AndroidX Fragment / ViewModel / LiveData | latest stable | Architecture |
| Retrofit 2 + Gson | 2.9.0 / 2.10.1 | OpenWebif REST API |
| OkHttp | 4.12.0 | HTTP client + Basic Auth for picons |
| Media3 ExoPlayer | 1.2.1 | HLS / MPEG-TS video playback |
| Glide | 4.16.0 | Picon image loading & caching |
| WorkManager | 2.9.0 | Background timer polling |
| Material Components | 1.11.0 | UI widgets & theming |

## Permissions

| Permission | Reason |
|---|---|
| `INTERNET` | OpenWebif API & streaming |
| `ACCESS_NETWORK_STATE` / `ACCESS_WIFI_STATE` | Network availability checks |
| `CHANGE_WIFI_MULTICAST_STATE` | Wake-on-LAN UDP broadcast |
| `RECEIVE_BOOT_COMPLETED` | Restart WorkManager after reboot |
| `POST_NOTIFICATIONS` | Recording-started notifications (Android 13+) |

## OpenWebif API Endpoints Used

| Endpoint | Purpose |
|---|---|
| `GET /api/getallservices` | Load all bouquets |
| `GET /api/getservices?sRef=` | Load channels in a bouquet |
| `GET /api/epgnow?bRef=` | Current programme for bouquet |
| `GET /api/epgnext?bRef=` | Next programme for bouquet |
| `GET /api/epgmulti?bRef=` | Full EPG grid data |
| `GET /api/epgservice?sRef=` | EPG for a single channel |
| `GET /api/epgsearch?search=` | EPG text search |
| `GET /api/zap?sRef=` | Change channel on receiver |
| `GET /api/movielist` | Recording list |
| `GET /api/addtimer` | Schedule a recording |
| `GET /api/timerlist` | List scheduled timers |
| `GET /api/deltimer` | Delete a timer |
| `GET /web/screenshot.m?r=720` | Live screenshot |

Stream URL format: `http(s)://<host>:8001/<serviceReference>`

## Licence

MIT — see [LICENSE](LICENSE) for details.
