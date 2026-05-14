# Enigma2 Android — Release Notes 1.3.1

## Multi-room polish

Small follow-up to v1.3.0 that finishes wiring the multi-room plumbing into
the two screens that already had single-receiver versions of the feature.

### Multi-room Wake-on-LAN

The **Wake** button on the channel toolbar now pops a picker when more than
one configured receiver has a MAC address. Pick the box you want to wake
and the magic packet is sent. With a single MAC-equipped profile the old
one-tap behaviour is preserved.

### Multi-room "Send message"

The **Send message** dialog now shows a *Send to* spinner at the top
when you have more than one device profile. Picking a non-active receiver
routes the message via the v1.3.0 `RemoteReceiverApi` so your active
receiver/playback is undisturbed. Single-profile setups see no change.

### Notes

- WOL only lists profiles with a non-blank MAC. Set the MAC in the device
  profile editor to enable wake for that box.
- Picon manager, theme picker, and receiver-config backup remain deferred.

### Build

- versionCode `14`, versionName `1.3.1`
- APKs:
  - `app/build/outputs/apk/debug/Enigma2Android-debug-1.3.1.apk`
  - `app/build/outputs/apk/release/Enigma2Android-release-1.3.1.apk`
