package com.enigma2.android.ui.player

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import com.enigma2.android.data.prefs.ReceiverPreferences

/**
 * Routes a stream URL to either the built-in PlayerActivity or an installed
 * external player (VLC, MX Player, Kodi) based on the user's preference.
 *
 * Why no Cast SDK: Chromecast's default media receiver does not play MPEG-TS
 * streams that OpenWebif emits at port 8001, and providing a custom receiver
 * application is out of scope for this release. External players (VLC, MX,
 * Kodi, etc.) handle MPEG-TS natively, which gives users an immediate "cast
 * to TV via Kodi" path through their existing tooling.
 */
object ExternalPlayerLauncher {

    /** Pref values for the player_choice ListPreference. */
    const val MODE_INTERNAL = "internal"
    const val MODE_EXTERNAL = "external"
    const val MODE_ASK = "ask"

    /** Known package names with friendly labels — used for the chooser title. */
    private val KNOWN_PLAYERS = mapOf(
        "org.videolan.vlc" to "VLC",
        "com.mxtech.videoplayer.ad" to "MX Player",
        "com.mxtech.videoplayer.pro" to "MX Player Pro",
        "org.xbmc.kodi" to "Kodi",
        "org.xbmc.kodi19" to "Kodi 19",
        "org.xbmc.kodi20" to "Kodi 20"
    )

    /** Returns the friendly label for any installed known player, in install-order. */
    fun installedKnownPlayers(context: Context): List<Pair<String, String>> {
        val pm = context.packageManager
        return KNOWN_PLAYERS.entries.mapNotNull { (pkg, label) ->
            try { pm.getPackageInfo(pkg, 0); pkg to label } catch (_: PackageManager.NameNotFoundException) { null }
        }
    }

    /** Best-effort MIME type for a given OpenWebif stream URL. */
    fun mimeFor(url: String): String {
        val lower = url.lowercase()
        return when {
            lower.endsWith(".m3u8") || lower.contains(".m3u8?") -> "application/vnd.apple.mpegurl"
            lower.endsWith(".mp4") -> "video/mp4"
            lower.endsWith(".mkv") -> "video/x-matroska"
            else -> "video/mp2t"
        }
    }

    /**
     * Build an ACTION_VIEW intent for [url]. If [forcedPackage] is set, the
     * intent is pinned to that package (no chooser).
     */
    fun buildViewIntent(url: String, title: String?, forcedPackage: String? = null): Intent {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            setDataAndType(Uri.parse(url), mimeFor(url))
            putExtra("title", title ?: "")
            // VLC/Kodi look for these too:
            if (!title.isNullOrBlank()) putExtra("forcename", title)
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }
        if (forcedPackage != null) intent.setPackage(forcedPackage)
        return intent
    }

    /** True if at least one app on the device can handle ACTION_VIEW for [url]. */
    fun hasExternalHandler(context: Context, url: String): Boolean {
        val intent = buildViewIntent(url, null)
        return intent.resolveActivity(context.packageManager) != null
    }

    /**
     * Convenience entry point used by Channel + Recording paths. Honours the
     * user's player-mode preference. Always falls back to the internal player
     * when no external app is available.
     *
     * Returns true when an external app was launched, false when the internal
     * player should handle playback (the caller is responsible for that path
     * to keep zap/PiP behaviour intact).
     */
    fun launchExternalIfPreferred(
        context: Context,
        url: String,
        title: String?,
        prefs: ReceiverPreferences
    ): Boolean {
        val mode = prefs.playerMode
        if (mode == MODE_INTERNAL) return false
        if (!hasExternalHandler(context, url)) return false

        val pinned = prefs.preferredExternalPackage.takeIf { it.isNotBlank() }
        val intent = buildViewIntent(url, title, pinned)
        return try {
            if (mode == MODE_ASK) {
                context.startActivity(Intent.createChooser(intent, title ?: ""))
            } else {
                // MODE_EXTERNAL: try pinned first, otherwise default chooser
                if (pinned != null && intent.resolveActivity(context.packageManager) != null) {
                    context.startActivity(intent)
                } else {
                    context.startActivity(Intent.createChooser(intent, title ?: ""))
                }
            }
            true
        } catch (_: Exception) { false }
    }

    fun resolveAppName(context: Context, pkg: String): String? {
        if (pkg.isBlank()) return null
        return try {
            val pm = context.packageManager
            pm.getApplicationLabel(pm.getApplicationInfo(pkg, 0)).toString()
        } catch (_: Exception) { KNOWN_PLAYERS[pkg] }
    }
}
