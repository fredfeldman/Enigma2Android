# Enigma2Android — Release 1.0.5

**Version:** 1.0.5 (versionCode 6)
**Release date:** May 13, 2026
**APK:** `Enigma2Android-release-1.0.5.apk`

This release adds the **Bouquet Editor** — full bouquet and channel-list management from the phone, with both server-side editing (when the Enigma2 BouquetEditor plugin is installed) and a local-override fallback for receivers without the plugin.

---

## Highlights

- **Bouquet Editor** — create, rename, delete bouquets; add, remove and reorder channels inside any bouquet.
- **Server mode** — when the BouquetEditor plugin is detected on the receiver, all changes are pushed to the box and visible to every client.
- **Local-override mode** — when the plugin is not present, reorder/remove still work per-device, stored locally and applied on top of the receiver's bouquet on this phone.
- **Conflict resolution** — if the plugin appears later and you already have local edits, a dialog lets you Discard, Keep as a local layer, or Apply them to the receiver.
- **TV and Radio** — both bouquet roots supported when creating a new bouquet.

---

## Bouquet Editor

Reachable from **Settings → Edit bouquets**.

- Lists every user and provider bouquet with channel counts.
- Banner at the top shows mode:
  - **Green** — server mode, BouquetEditor plugin available, edits go to the receiver.
  - **Amber** — local-only mode, edits stored on this device.
- **+ New** — create a bouquet (TV or Radio). Server mode only.
- **Edit** — open a bouquet to manage its channels:
  - Long-press a row to drag-reorder.
  - Up / Down buttons for fine control.
  - ✕ removes a channel from the bouquet.
  - **+ Add channel** opens a filterable picker that lists every channel from every bouquet, skipping ones already in the target.
- **Rename** / **Delete** — available on user bouquets in server mode. Deleting a bouquet also clears any local override stored for it.

### Endpoints used (server mode)

- `/bouqueteditor/api/getservices` — probe + list user bouquets
- `/bouqueteditor/web/addbouquet`
- `/bouqueteditor/web/renameservice`
- `/bouqueteditor/web/removebouquet`
- `/bouqueteditor/web/addservicetobouquet`
- `/bouqueteditor/web/removeservice`
- `/bouqueteditor/web/moveservice`

XML responses (`<e2simplexmlresult>`) are parsed tolerantly — a non-XML or empty body is treated as success when the HTTP call succeeded.

### Local override mode

- Edits are persisted in `SharedPreferences` as a JSON map keyed by bouquet sRef.
- An override stores either a reordered list of service refs or a set of removed refs (or both).
- The override is applied client-side whenever the bouquet is loaded for display on this device.
- Cleared automatically when the same bouquet is deleted on the receiver, or via the conflict dialog.

---

## Files changed (summary)

**New**

- `data/api/BouquetEditorXml.kt` — `<e2simplexmlresult>` parser
- `ui/bouqueteditor/BouquetEditorActivity.kt`
- `ui/bouqueteditor/BouquetEditorFragment.kt`
- `ui/bouqueteditor/BouquetEditFragment.kt`
- `ui/bouqueteditor/AddServicePickerFragment.kt`
- `ui/bouqueteditor/BouquetEditorAdapter.kt`
- `ui/bouqueteditor/BouquetEditChannelAdapter.kt`
- `ui/bouqueteditor/BouquetEditorEvents.kt`
- 8 new layouts: `activity_bouquet_editor.xml`, `fragment_bouquet_editor.xml`, `fragment_bouquet_edit.xml`, `fragment_add_service_picker.xml`, `dialog_new_bouquet.xml`, `item_bouquet_editor_row.xml`, `item_bouquet_edit_channel.xml`, `item_picker_service.xml`

**Modified**

- `data/api/OpenWebifService.kt` — 7 BouquetEditor endpoints
- `data/repository/Enigma2Repository.kt` — probe, CRUD, move, `applyOverride()`, mode constants
- `data/prefs/ReceiverPreferences.kt` — `BouquetOverride` storage
- `ui/settings/SettingsFragment.kt` — wire the new preference
- `res/xml/preferences.xml` — `manage_bouquets` entry
- `res/values/strings.xml` — Bouquet Editor strings
- `AndroidManifest.xml` — register `BouquetEditorActivity`
- `app/build.gradle.kts` — versionCode 6, versionName 1.0.5
