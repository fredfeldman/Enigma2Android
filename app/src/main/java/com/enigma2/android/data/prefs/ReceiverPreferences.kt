package com.enigma2.android.data.prefs

import android.content.Context
import android.content.SharedPreferences
import com.enigma2.android.data.model.DeviceProfile
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ReceiverPreferences(context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences("receiver_prefs", Context.MODE_PRIVATE)

    // ── Device profiles ──────────────────────────────────────────────
    var deviceProfiles: List<DeviceProfile>
        get() {
            val json = prefs.getString(KEY_DEVICE_PROFILES, null) ?: return emptyList()
            return try {
                gson.fromJson(json, object : TypeToken<List<DeviceProfile>>() {}.type)
            } catch (e: Exception) {
                emptyList()
            }
        }
        set(value) {
            prefs.edit().putString(KEY_DEVICE_PROFILES, gson.toJson(value)).apply()
        }

    var activeDeviceId: String
        get() = prefs.getString(KEY_ACTIVE_DEVICE_ID, "") ?: ""
        set(value) {
            prefs.edit().putString(KEY_ACTIVE_DEVICE_ID, value).apply()
            syncActiveDevice()
        }

    fun getActiveProfile(): DeviceProfile? = deviceProfiles.find { it.id == activeDeviceId }

    fun addOrUpdateProfile(profile: DeviceProfile) {
        val current = deviceProfiles.toMutableList()
        val idx = current.indexOfFirst { it.id == profile.id }
        if (idx >= 0) current[idx] = profile else current.add(profile)
        deviceProfiles = current
    }

    fun removeProfile(id: String) {
        deviceProfiles = deviceProfiles.filter { it.id != id }
        if (activeDeviceId == id) activeDeviceId = deviceProfiles.firstOrNull()?.id ?: ""
    }

    private fun syncActiveDevice() {
        val profile = getActiveProfile() ?: return
        prefs.edit()
            .putString(KEY_HOST, profile.host)
            .putInt(KEY_PORT, profile.port)
            .putBoolean(KEY_HTTPS, profile.useHttps)
            .putString(KEY_USERNAME, profile.username)
            .putString(KEY_PASSWORD, profile.password)
            .apply()
    }

    // ── Legacy flat properties (kept for ApiClient and GlideConfig) ─
    val host: String get() = getActiveProfile()?.host ?: prefs.getString(KEY_HOST, "") ?: ""
    val port: Int get() = getActiveProfile()?.port ?: prefs.getInt(KEY_PORT, 80)
    val useHttps: Boolean get() = getActiveProfile()?.useHttps ?: prefs.getBoolean(KEY_HTTPS, false)
    val username: String get() = getActiveProfile()?.username ?: prefs.getString(KEY_USERNAME, "") ?: ""
    val password: String get() = getActiveProfile()?.password ?: prefs.getString(KEY_PASSWORD, "") ?: ""

    fun isConfigured(): Boolean = host.isNotBlank()

    // ── Picon URL helpers ─────────────────────────────────────────────
    fun piconUrl(serviceRef: String): String {
        val scheme = if (useHttps) "https" else "http"
        val sanitized = serviceRef.replace(":", "_").trimEnd('_')
        return "$scheme://$host:$port/picon/$sanitized.png"
    }

    fun piconUrlAlt1(serviceRef: String): String {
        val scheme = if (useHttps) "https" else "http"
        val parts = serviceRef.split(":").filter { it.isNotEmpty() }
        val name = if (parts.size >= 4) parts.take(4).joinToString("_") else serviceRef.replace(":", "_")
        return "$scheme://$host:$port/picon/$name.png"
    }

    fun piconUrlFromPath(piconPath: String): String {
        val scheme = if (useHttps) "https" else "http"
        return "$scheme://$host:$port$piconPath"
    }

    // ── Favorites ─────────────────────────────────────────────────────
    var favorites: List<String>
        get() {
            val json = prefs.getString(KEY_FAVORITES, null) ?: return emptyList()
            return try {
                gson.fromJson(json, object : TypeToken<List<String>>() {}.type)
            } catch (e: Exception) {
                emptyList()
            }
        }
        set(value) {
            prefs.edit().putString(KEY_FAVORITES, gson.toJson(value)).apply()
        }

    fun toggleFavorite(serviceRef: String) {
        val current = favorites.toMutableList()
        if (serviceRef in current) current.remove(serviceRef) else current.add(serviceRef)
        favorites = current
    }

    // ── Stream URL helpers ──────────────────────────────────────────────
    fun streamUrl(serviceRef: String): String {
        val scheme = if (useHttps) "https" else "http"
        return "$scheme://$host:8001/$serviceRef"
    }

    /** Builds an OpenWebif /file?file= URL for a recording. Uses the configured port and
     *  fully encodes the filename so spaces and special characters are handled correctly. */
    fun recordingStreamUrl(filename: String): String {
        val scheme = if (useHttps) "https" else "http"
        val encoded = android.net.Uri.encode(filename)
        return "$scheme://$host:$port/file?file=$encoded"
    }

    // ── Playback position resume ──────────────────────────────────────
    fun savePlaybackPosition(filename: String, positionMs: Long) {
        prefs.edit().putLong("pos_$filename", positionMs).apply()
    }

    fun getPlaybackPosition(filename: String): Long = prefs.getLong("pos_$filename", 0L)

    fun clearPlaybackPosition(filename: String) {
        prefs.edit().remove("pos_$filename").apply()
    }

    // ── Last channel ──────────────────────────────────────────────────
    var lastChannelRef: String
        get() = prefs.getString(KEY_LAST_CHANNEL, "") ?: ""
        set(value) { prefs.edit().putString(KEY_LAST_CHANNEL, value).apply() }

    var lastChannelName: String
        get() = prefs.getString(KEY_LAST_CHANNEL_NAME, "") ?: ""
        set(value) { prefs.edit().putString(KEY_LAST_CHANNEL_NAME, value).apply() }

    var autoResumeLastChannel: Boolean
        get() = prefs.getBoolean(KEY_AUTO_RESUME, false)
        set(value) { prefs.edit().putBoolean(KEY_AUTO_RESUME, value).apply() }

    // ── Hidden bouquets ───────────────────────────────────────────────
    var hiddenBouquets: List<String>
        get() {
            val json = prefs.getString(KEY_HIDDEN_BOUQUETS, null) ?: return emptyList()
            return try {
                gson.fromJson(json, object : TypeToken<List<String>>() {}.type)
            } catch (e: Exception) {
                emptyList()
            }
        }
        set(value) {
            prefs.edit().putString(KEY_HIDDEN_BOUQUETS, gson.toJson(value)).apply()
        }

    // ── Night mode ────────────────────────────────────────────────────
    var nightMode: Boolean
        get() = prefs.getBoolean(KEY_NIGHT_MODE, true)
        set(value) { prefs.edit().putBoolean(KEY_NIGHT_MODE, value).apply() }

    companion object {
        private val gson = Gson()
        private const val KEY_DEVICE_PROFILES = "device_profiles"
        private const val KEY_ACTIVE_DEVICE_ID = "active_device_id"
        private const val KEY_HOST = "host"
        private const val KEY_PORT = "port"
        private const val KEY_HTTPS = "use_https"
        private const val KEY_USERNAME = "username"
        private const val KEY_PASSWORD = "password"
        private const val KEY_HIDDEN_BOUQUETS = "hidden_bouquets"
        private const val KEY_FAVORITES = "favorites"
        private const val KEY_LAST_CHANNEL = "last_channel_ref"
        private const val KEY_LAST_CHANNEL_NAME = "last_channel_name"
        private const val KEY_AUTO_RESUME = "auto_resume"
        private const val KEY_NIGHT_MODE = "night_mode"
    }
}
