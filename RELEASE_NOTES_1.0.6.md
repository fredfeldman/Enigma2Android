# Enigma2Android — Release 1.0.6

**Version:** 1.0.6 (versionCode 7)
**Release date:** May 13, 2026
**APK:** `Enigma2Android-release-1.0.6.apk`

This release adds **Receiver Settings** — a full-scope, read+write console for the configuration that OpenWebif exposes on the box: power, audio, recording locations, tuner status, parental control, Wake-on-LAN, transcoding, the OpenWebif Web UI itself, and a generic browser for the entire `config.*` tree.

---

## Highlights

- **Receiver Settings** — new top-level entry under *Settings → Receiver* opening a dedicated activity with nine sub-screens.
- **Capability probing** — the app probes the receiver once on entry and disables sub-screens the box doesn't support (e.g. transcoding plugin not installed, no parental control configured, no `config.*` tree exposed).
- **Read + write from day one** — every editable field is wired to its OpenWebif save endpoint; saves run off the UI thread and toast either *Saved.* or the receiver's error message.
- **Tolerant parsing** — endpoints that vary across OpenWebif builds (JSON vs XML, array vs object, with or without wrapper) are parsed defensively so the screen still loads on older receivers.

---

## Receiver Settings — sub-screens

Reachable from **Settings → Receiver settings**.

1. **Power** — current state (awake / standby), action buttons (toggle standby, enter standby, wake up, reboot, restart GUI) and a sleep-timer block (enable, minutes, action when time is up).
2. **Audio & Volume** — master volume slider (0–100) and mute switch.
3. **Recording** — default recording location (picker), list of known locations, add a new path, tap any path to remove it.
4. **Tuner / Signal** — read-only live tuner status (type, tuner #, SNR, BER, signal). Tap to refresh.
5. **Parental control** — read-only viewer: active/inactive, type, setup-PIN status, list of protected services.
6. **Wake-on-LAN setup** — receiver-side WOL: enabled, wake from standby, wake location/interface.
7. **Transcoding** — dynamic list built from whatever the transcoding plugin reports; each value editable.
8. **OpenWebif Web UI** — six toggles for the Web UI itself (picons, channel picons, channel details, responsive design, MovieDB, show all packages).
9. **All settings (advanced)** — generic browser of the receiver's full `config.*` tree. Each section is loaded on demand and rendered by item type (bool → switch, choice → list, password → masked text, directory/text/int/float/slider → text).

---

## Endpoints used

Read:
- `api/statusinfo`, `api/powerstate`, `api/sleeptimer`, `api/vol`
- `web/settings` (full settings dump), `api/config` (section index), `api/config/<section>`
- `BQE/getprotectionsettings`, parental list endpoints
- `api/getlocations`, `api/getcurrlocation`
- `api/tunersignal`
- `api/getwolsetup`, `api/gettranscodingsetup`

Write:
- `api/powerstate?newstate=…`, `api/sleeptimer?…`
- `api/vol?set=…`, `api/vol?set=mute`
- `api/saveconfig?key=…&value=…`, `api/setwebconfig?…`
- `api/addlocation?dirname=…&createFolder=1`, `api/removelocation?dirname=…`, `api/setcurrlocation?dirname=…`
- `api/setwolsetup?…`, `api/settranscodingsetup?…`

Save acknowledgements (`{result, message}` JSON, `<e2state>/<e2statetext>` XML, or empty 200) are all parsed tolerantly — an empty body on a 2xx response is treated as success.

---

## Files changed (summary)

**New**

- `data/model/settings/SettingsModels.kt` — data classes (`StatusInfo`, `PowerState`, `SleepTimer`, `VolumeInfo`, `TunerSignal`, `RecordingLocations`, `WolSetup`, `ParentalSettings`, `WebUiConfig`, `TranscodingProfile`, `ConfigItem`/`ConfigItemType`/`ConfigSection`, `ReceiverCapabilities`)
- `data/api/SettingsXml.kt` — tolerant JSON / `<e2…>` parsers + `parseSaveAck`
- `ui/receiversettings/ReceiverSettingsActivity.kt`
- `ui/receiversettings/ReceiverSettingsRootFragment.kt`
- `ui/receiversettings/PowerFragment.kt`
- `ui/receiversettings/AudioFragment.kt`
- `ui/receiversettings/RecordingSettingsFragment.kt`
- `ui/receiversettings/TunerFragment.kt`
- `ui/receiversettings/ParentalFragment.kt`
- `ui/receiversettings/WolFragment.kt`
- `ui/receiversettings/TranscodingFragment.kt`
- `ui/receiversettings/WebUiConfigFragment.kt`
- `ui/receiversettings/ConfigTreeFragment.kt` (also contains `ConfigSectionFragment`)
- `res/layout/activity_receiver_settings.xml`

**Modified**

- `data/api/OpenWebifService.kt` — 25+ Receiver-Settings endpoints
- `data/api/ApiClient.kt` — public `baseUrl` getter (used for `@Url` config-section fetches)
- `data/repository/Enigma2Repository.kt` — `probeReceiverCapabilities()` plus 20+ read/write methods
- `ui/settings/SettingsFragment.kt` — open the new activity from `pref_receiver_settings`
- `res/xml/preferences.xml` — `pref_receiver_settings` entry inside the existing Receiver category
- `res/values/strings.xml` — ~70 strings under *Receiver Settings*
- `AndroidManifest.xml` — register `ReceiverSettingsActivity`
- `app/build.gradle.kts` — versionCode 7, versionName 1.0.6

---

## Compatibility notes

- Sub-screens disable themselves when the receiver doesn't expose the underlying API; nothing crashes on minimal OpenWebif builds.
- The "All settings" tree depends on `api/config` / `api/config/<section>`; older OpenWebif forks that don't ship those endpoints will see this row disabled with *Not available on this receiver.*
- Parental control is read-only in this release (no PIN entry / change UI yet).
- Capabilities are re-probed every time the screen is opened, so installing the relevant plugin on the box is reflected on next entry.
