# Enigma2Android — Release 1.0.3

**Version:** 1.0.3 (versionCode 4)
**Release date:** May 12, 2026
**APK:** `Enigma2Android-release-1.0.3.apk`

This release is a comprehensive UX polish pass following a full app review. No new features were removed; everything is additive or quality-of-life.

---

## Highlights

- **Audio fixed.** Live channel playback now produces sound reliably and ducks correctly with system audio focus.
- **Snappier feedback** across channel switching, filtering, screenshots and Wake-on-LAN.
- **Empty / loading states everywhere** — no more silent blank lists.
- **Pull-to-refresh** on Channels, Recordings and Timers.
- **Accessibility & i18n** — larger touch targets, ripple feedback, and all user-visible strings extracted to resources.

---

## Player

- **Audio output restored.** ExoPlayer is now built with `AudioAttributes` (`USAGE_MEDIA` / `CONTENT_TYPE_MOVIE`), `handleAudioFocus = true`, and `setHandleAudioBecomingNoisy(true)`. This fixes the "no audio on playing channel" regression and properly cooperates with phone calls, notifications and headphone unplug events.
- **Cleaner channel switching.** `loadStream()` now calls `stop()` + `clearMediaItems()` before loading a new media item, eliminating audio glitches and stale-track issues when zapping.
- **Zap toast.** Switching channel via the on-screen controls now shows a "Switching to <channel>…" toast so the user gets immediate confirmation.
- **Internationalised strings.** Sleep timer options ("15 / 30 / 60 min"), audio "Track N" labels and "Next: …" labels are now in `strings.xml`.

## Channels

- **Empty state.** Shows "No channels" or "No channels match filter" instead of a blank list.
- **Debounced filter.** The filter EditText now debounces input by 300 ms, preventing UI jank while typing on long bouquets.
- **Wake-on-LAN feedback.** Tapping WoL now shows a "Sending…" toast immediately and a result toast on completion.
- **Screenshot feedback.** A progress indicator and toast are shown while fetching, plus a `contentDescription` for accessibility.
- **Favorite star polish.** The ★ button now has a borderless ripple, is properly focusable, and exposes a `contentDescription`.
- **Pull-to-refresh.** Swipe down on the channel list to reload the current bouquet.

## Recordings

- **Delete recording.** Long-press a recording to open a menu (Play / Add to Playlist / Delete). Delete asks for confirmation, then calls the OpenWebif `api/movie/delete` endpoint and removes the entry from the list.
- **Loading + empty states.** A progress bar shows while the list loads; an empty-state message appears when there are no recordings.
- **Pull-to-refresh.**

## Timers

- **Loading + empty states.** Progress bar while loading and "No timers" empty message.
- **Accessible delete button.** The delete action button now has a 48 dp × 48 dp minimum touch target with comfortable padding.
- **Pull-to-refresh.**

## EPG

- **Search debounce.** EPG search debounces input by 400 ms and only triggers on queries of 3+ characters; stale results are discarded.
- **Loading + empty states.** Progress bar, hint text and "No results" message added to EPG search; "No EPG data" message added to the EPG grid.
- **Channel names in search results.** Search hits now resolve `event.sref` against the channel list and display the channel name instead of a raw service reference.

## Settings

- Confirmed Up-navigation works (`setDisplayHomeAsUpEnabled(true)` + `onSupportNavigateUp()` already in place).

---

## Files changed (summary)

- `app/build.gradle.kts` — version bump, added `androidx.swiperefreshlayout`.
- `app/src/main/java/com/enigma2/android/ui/player/PlayerActivity.kt` — audio fix, zap toast, i18n.
- `app/src/main/java/com/enigma2/android/ui/channels/ChannelsFragment.kt` — empty state, debounce, WoL/screenshot feedback, pull-to-refresh, i18n.
- `app/src/main/java/com/enigma2/android/ui/channels/ChannelAdapter.kt` — i18n.
- `app/src/main/java/com/enigma2/android/ui/recordings/RecordingsFragment.kt` — delete menu, loading/empty, pull-to-refresh.
- `app/src/main/java/com/enigma2/android/ui/viewmodel/RecordingViewModel.kt` — `isLoading`, `deleteRecording`.
- `app/src/main/java/com/enigma2/android/ui/timers/TimersFragment.kt` — loading/empty, pull-to-refresh.
- `app/src/main/java/com/enigma2/android/ui/epg/EpgFragment.kt` — empty state.
- `app/src/main/java/com/enigma2/android/ui/epg/EpgSearchFragment.kt` — debounce, loading/empty, channel name resolution.
- `app/src/main/java/com/enigma2/android/data/api/OpenWebifService.kt` — `deleteMovie` endpoint.
- `app/src/main/java/com/enigma2/android/data/repository/Enigma2Repository.kt` — `deleteRecording`.
- Layouts: `fragment_channels.xml`, `fragment_recordings.xml`, `fragment_timers.xml`, `fragment_epg.xml`, `fragment_epg_search.xml`, `item_channel.xml`, `item_timer.xml`.
- `app/src/main/res/values/strings.xml` — many new resources.

---

## Upgrade notes

- No breaking changes; settings, bouquets and favorites are preserved.
- New gradle dependency: `androidx.swiperefreshlayout:swiperefreshlayout:1.1.0` (resolves automatically on first build with internet access).
