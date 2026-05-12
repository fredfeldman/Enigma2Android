# Enigma2Android — Release 1.0.4

**Version:** 1.0.4 (versionCode 5)
**Release date:** May 12, 2026
**APK:** `Enigma2Android-release-1.0.4.apk`

This release adds significant new functionality on top of the 1.0.3 polish pass: AutoTimer management, an EPGImport plugin interface, a Box Info screen, a configurable channel-tap action ("zap on channel change"), plus several bug fixes.

---

## Highlights

- **AutoTimer management** — list, toggle, edit and remove AutoTimer rules directly from the app.
- **EPGImport plugin integration** — when the EPGImport plugin is installed on the receiver, a new Settings entry lets you enable/disable sources, save selections and trigger an import on demand. Detection is robust across the various OpenWebif builds that expose EPGImport at different paths.
- **Box Info screen** — Settings → Receiver → Box Info displays the receiver's hardware, image, tuner, network and storage details.
- **Zap on channel change** — choose what tapping a channel does: stream in the player (existing behavior), zap the receiver only, or both. A separate option controls whether prev/next in the player also zaps the receiver.
- **EPG row alignment fixed** — channel names now line up exactly with their EPG rows.
- **Timer delete fixed** — uses the correct `api/timerdelete` endpoint.

---

## AutoTimers

- New AutoTimers screen reachable from the toolbar on Channels.
- Lists all AutoTimer rules with name, match text, services, time window and enabled state.
- Switch toggle to enable/disable a rule in place.
- Edit dialog for name, match, time window and "zap only" flag.
- Long-press to delete with confirmation.
- Backed by `autotimer`, `autotimer/edit` and `autotimer/remove` endpoints; XML response parsed with `XmlPullParser`.

## EPGImport

- New "EPG Import" entry under Settings → Receiver Plugins, shown only when the plugin is detected on the receiver.
- Robust detection that probes multiple known base paths (`epgimport`, `api/epgimport`, `epgimport/plugin`, `plugin/epgimport`) and validates the response body content. The first working base is cached for the session.
- Source list with checkboxes — enable or disable individual EPG sources and save the selection back to the receiver.
- "Run Import Now" button to trigger an import; current status is shown.
- "Refresh" reloads the source list and status.

## Box Info

- New Settings → Receiver → **Box Info** screen.
- Calls `api/about`, falls back to `api/deviceinfo`, and flattens the JSON response to an ordered key/value list (image version, kernel, model, tuner info, drives, network, etc.).
- Empty-state message shown when neither endpoint is available.

## Settings — Zap on channel change

- New **Action when tapping a channel** list preference under Playback:
  - **Stream in player** (default — original behavior)
  - **Zap receiver only** — sends `api/zap` and shows a toast, doesn't open the player
  - **Zap receiver and stream** — does both
- New **Zap receiver when changing channel in player** checkbox (default on) controlling whether prev/next navigation in the player also tunes the box.

## Bug fixes

- **EPG channel name alignment.** The channel-name list and EPG grid now share a single vertical scroll container, so rows always line up regardless of scroll position.
- **Delete timer.** The wrong OpenWebif endpoint (`api/deltimer`) was being called; corrected to `api/timerdelete`.

---

## Files changed (summary)

- `app/build.gradle.kts` — version bump to 1.0.4 (versionCode 5).
- `app/src/main/AndroidManifest.xml` — registered `EpgImportActivity` and `BoxInfoActivity`.
- `app/src/main/java/com/enigma2/android/data/api/OpenWebifService.kt` — fixed timer-delete endpoint; added autotimer endpoints, `@Url`-based EPGImport endpoints, and `api/about` / `api/deviceinfo` for Box Info.
- `app/src/main/java/com/enigma2/android/data/repository/Enigma2Repository.kt` — AutoTimer XML parsing, EPGImport probe with caching and body validation, source enable/disable, Box Info JSON flattening.
- `app/src/main/java/com/enigma2/android/data/model/Models.kt` — new `AutoTimer` data class.
- `app/src/main/java/com/enigma2/android/data/prefs/ReceiverPreferences.kt` — new `channelTapAction` and `zapOnPlayerNavigate` properties with `VALUE_TAP_STREAM/ZAP/BOTH` constants.
- `app/src/main/java/com/enigma2/android/ui/autotimers/AutoTimersFragment.kt` + `AutoTimerAdapter.kt` — new.
- `app/src/main/java/com/enigma2/android/ui/settings/SettingsFragment.kt` — async EPGImport visibility probe; click handlers for Box Info and EPG Import.
- `app/src/main/java/com/enigma2/android/ui/settings/EpgImportActivity.kt` — new screen with status, source checkboxes, run/save/refresh buttons.
- `app/src/main/java/com/enigma2/android/ui/settings/BoxInfoActivity.kt` — new screen with key/value RecyclerView.
- `app/src/main/java/com/enigma2/android/ui/channels/ChannelsFragment.kt` — honors `channelTapAction` setting; AutoTimers toolbar button.
- `app/src/main/java/com/enigma2/android/ui/player/PlayerActivity.kt` — honors `zapOnPlayerNavigate` setting.
- `app/src/main/java/com/enigma2/android/ui/epg/EpgFragment.kt` + `app/src/main/res/layout/fragment_epg.xml` — restructured for unified vertical scrolling.
- Layouts: `activity_boxinfo.xml`, `item_boxinfo.xml`, `activity_epg_import.xml`, `item_epg_import_source.xml`, `fragment_autotimers.xml`, `item_autotimer.xml`, `dialog_autotimer_edit.xml`.
- `app/src/main/res/xml/preferences.xml` — added Receiver category (Box Info), Plugins category (EPG Import) and Playback options (channel-tap action, zap-on-player-nav).
- `app/src/main/res/values/strings.xml` and `arrays.xml` — many new resources.

---

## Upgrade notes

- No breaking changes; settings, bouquets, favorites and saved playback positions are preserved.
- The new "Action when tapping a channel" setting defaults to **Stream in player**, matching previous behavior.
- "Zap receiver when changing channel in player" defaults to **on**, matching previous behavior.
- EPG Import and Box Info entries appear only when the receiver supports them.
