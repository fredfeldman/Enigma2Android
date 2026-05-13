# Enigma2Android 1.1.0 — Receiver admin

A large release that turns the in-app receiver settings area into a full admin
console: editable parental control, system log viewer, plugin manager, network
info and storage browser.

## What's new

### Parental control (now editable)
- **Change setup PIN** — set or update the receiver's parental setup PIN
  (current PIN required if one already exists).
- **Protect a service** — paste a service reference and add it to the protected
  list.
- **Unprotect** — tap a row in the protected list to remove a service from
  parental control.
- **App-side PIN gate** — optionally protect the in-app Parental screen with a
  separate local PIN (SHA-256 hashed, stored only on the device). Set or clear
  it at the bottom of the parental screen.

### System (new menu category)
- **Storage & mounts** — read-only view of mountpoints (with total/used/free
  when reported) and a SMART information dump.
- **System log** — fetches the receiver's recent log, supports substring
  filtering, and a *Share* action that hands the visible text to any sharing
  target (email, messaging, file save, etc.).
- **Plugin manager** — lists installed plugins, supports installing a package
  by name and removing a plugin (with confirmation). A warning reminds you
  that removing core plugins can break the receiver.
- **Network info** — interfaces, IP / netmask / gateway / MAC where reported,
  with a *Copy to clipboard* action.

### Under the hood
- New endpoints wired into `OpenWebifService`:
  `api/parentcontrol`, `api/changesetuppin`, `api/mountinfo`,
  `api/smartinfo`, `api/getlog`, `api/plugins`, `api/installplugin`,
  `api/removeplugin`, `api/networkinfo`.
- New repository wrappers: `protectService`, `unprotectService`,
  `changeSetupPin`, `getMountInfoRaw`, `getSmartInfoRaw`,
  `getReceiverLogRaw`, `listPluginsRaw`, `installPlugin`,
  `removePlugin`, `getNetworkInfoRaw`.
- New local store: `ParentalAppLockStore` (SHA-256 hashed PIN in
  `parental_app_lock` SharedPreferences).

## Notes & limitations

- Mount/unmount and disk format are intentionally **not** exposed in this
  release — the destructive surface area is too high and OpenWebif endpoints
  vary considerably across images.
- A dedicated channel-scan screen is also deferred — scan endpoints differ
  per tuner family and would need image-specific testing.
- All new endpoints fail gracefully (toast on error, empty/placeholder
  states) so the app stays usable on receivers that don't expose them.

## Versioning

- versionCode: 10
- versionName: 1.1.0
- minSdk 26, targetSdk 34
