# Enigma2 Android — Release Notes 1.4.0

## HDHomeRun import

The **Create bouquet** dialog (Settings → Edit bouquets → New bouquet) now
has an opt-in checkbox **"Import channels from HDHomeRun tuner"**. When
checked, the app reaches out to a SiliconDust HDHomeRun device on your
network and bulk-creates an Enigma2 bouquet containing every channel from
the tuner's lineup, each pointing at the HDHomeRun's HTTP MPEG-TS stream.

This lets a single Enigma2 receiver expose your over-the-air or
cable-via-CableCard HDHomeRun channels alongside its native services with
no manual sRef hand-editing.

### How it works

1. Enter the new bouquet's display name.
2. Tick **Import channels from HDHomeRun tuner**.
3. Enter the tuner's IP or hostname (defaults to `hdhomerun.local`).
4. Optionally untick **Skip encrypted (DRM) channels** — by default,
   channels with `DRM=1` are excluded since they cannot be streamed by
   HDHomeRun's HTTP API anyway.
5. Tap OK. The app:
   - GETs `http://<tuner>/discover.json` to verify the device
   - GETs `http://<tuner>/lineup.json` to read every channel
   - Calls `bouqueteditor/web/addbouquet` to create the bouquet
   - Calls `bouqueteditor/web/addservicetobouquet` for each channel,
     using a service ref of the form
     `4097:0:1:0:0:0:0:0:0:0:<URL-encoded HDHomeRun stream URL>:`
6. A toast reports how many channels were added and how many failed.

### Service-ref format

Service type **4097** is Enigma2's GStreamer-backed external-stream player.
Channel URLs from HDHomeRun (e.g. `http://192.168.1.50:5004/auto/v5`) are
embedded into the ref with `:` and `/` percent-encoded so the Enigma2 parser
doesn't treat them as field separators. After import, channels appear in
the bouquet just like any other and can be played, recorded, or zapped to
exactly as if they were native services.

### Requirements

- The Enigma2 receiver must have the **BouquetEditor** OpenWebif plugin
  installed (the app already requires this for any bouquet editing).
- The HDHomeRun tuner and the Enigma2 receiver must be reachable from each
  other on the network.
- Encrypted (DRM) channels — typically CableCard premium tiers — are
  skipped by default and cannot be streamed even if you opt in.

### Notes

- HDHomeRun import is TV-only. Selecting the checkbox forces the bouquet
  mode to TV and disables the Radio radio button.
- The new bouquet is found server-side by case-insensitive name match. If
  the receiver rewrote the name during creation, you'll see a "Bouquet was
  created but could not be located" toast — refresh the bouquet list and
  re-add channels manually.
- This is a one-shot import. Re-running it creates a second bouquet; there
  is no re-sync. A future release may add periodic re-sync.

### Build

- versionCode `16`, versionName `1.4.0`
- APKs:
  - `app/build/outputs/apk/debug/Enigma2Android-debug-1.4.0.apk`
  - `app/build/outputs/apk/release/Enigma2Android-release-1.4.0.apk`
