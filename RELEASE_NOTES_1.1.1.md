# Enigma2Android 1.1.1 — EPG quality

Quality-of-life additions on top of the existing EPG screens. Three user-visible
features and one offline survival aid.

## What's new

### Refresh EPG button
The EPG screen toolbar gains a **Refresh** button next to Search. Tapping it
asks the receiver to refresh its EPG data — first via the EPGImport plugin
endpoint (`/web/epgrefresh`) and falling back to a per-channel refresh
(`/api/serviceupdateepg`) when the plugin is not installed. A toast confirms
success or failure, and the grid reloads automatically.

### Per-channel EPG export
Long-press a channel row in the Channels screen → **Export EPG**. The full EPG
window for that channel is written to two files in `Downloads/`:

- `epg_<channel>_<timestamp>.xml` — XMLTV-format, validates against the
  `tv_grab_*` parsers
- `epg_<channel>_<timestamp>.json` — raw event list as JSON (one object per
  programme)

Files are written through `MediaStore` on Android 10+, so no special storage
permissions are required.

### Offline EPG cache
Every successful multi-EPG fetch is now snapshotted to local storage
(`epg_cache` SharedPreferences, one entry per bouquet). When a later fetch
fails — typically because the receiver is unreachable — the EPG screen
transparently falls back to the cached snapshot and shows a yellow banner
("Showing cached EPG (N min old)") so you know the data is stale. As soon as
a fresh fetch succeeds, the banner disappears.

## Notes

- **MHW2 EPGImport sources** were on the original 1.1.1 plan but the
  EPGImport-source picker UI does not yet exist in the app, so the work was
  deferred to the same release that introduces the picker. The endpoint plumbing
  added here is forward-compatible.
- The cache is intentionally simple (SharedPreferences-JSON, one snapshot per
  bouquet) to avoid pulling in Room. Cache is bounded by the size of one EPG
  fetch and survives app restarts.

## Versioning

- versionCode: 11
- versionName: 1.1.1
- minSdk 26, targetSdk 34
