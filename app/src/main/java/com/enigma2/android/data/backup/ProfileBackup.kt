package com.enigma2.android.data.backup

import android.content.Context
import android.net.Uri
import com.enigma2.android.data.model.DeviceProfile
import com.enigma2.android.data.prefs.ReceiverPreferences
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser

/**
 * v1.3.0 — Export and import the user's device-profile list as JSON.
 *
 * Passwords are stripped by default. Set [includePasswords] to keep them
 * (the UI surfaces this as an explicit checkbox so the user has to opt in).
 *
 * Format is intentionally human-readable so users can edit by hand:
 * ```
 * { "version": 1,
 *   "profiles": [ { "id": "...", "name": "Living room", "host": "...", ... } ],
 *   "activeId": "..." }
 * ```
 */
object ProfileBackup {

    private const val FORMAT_VERSION = 1
    private val gson = GsonBuilder().setPrettyPrinting().create()

    private data class Envelope(
        val version: Int,
        val profiles: List<DeviceProfile>,
        val activeId: String
    )

    /** Encode the current profile list to a JSON string. */
    fun encode(prefs: ReceiverPreferences, includePasswords: Boolean): String {
        val list = prefs.deviceProfiles.map { p ->
            if (includePasswords) p else p.copy(password = "")
        }
        return gson.toJson(Envelope(FORMAT_VERSION, list, prefs.activeDeviceId))
    }

    /** Result of a decode/import operation. */
    data class ImportResult(
        val ok: Boolean,
        val added: Int = 0,
        val updated: Int = 0,
        val error: String? = null
    )

    /**
     * Read a profile-backup JSON [uri] and merge into [prefs]. Existing
     * profiles with the same id are updated (passwords kept if the import
     * file omits them — never silently wiped).
     */
    fun importFromUri(context: Context, uri: Uri, prefs: ReceiverPreferences): ImportResult {
        return try {
            val text = context.contentResolver.openInputStream(uri)?.use {
                it.bufferedReader().readText()
            } ?: return ImportResult(false, error = "empty")

            val root = JsonParser.parseString(text).asJsonObject
            val version = root.get("version")?.asInt ?: 1
            if (version > FORMAT_VERSION) {
                return ImportResult(false, error = "unsupported version $version")
            }
            val profilesArr = root.getAsJsonArray("profiles")
                ?: return ImportResult(false, error = "no profiles")

            val existing = prefs.deviceProfiles.associateBy { it.id }.toMutableMap()
            var added = 0
            var updated = 0
            for (el in profilesArr) {
                val incoming = gson.fromJson(el, DeviceProfile::class.java)
                    ?: continue
                if (incoming.id.isBlank() || incoming.host.isBlank()) continue
                val prior = existing[incoming.id]
                val merged = if (incoming.password.isBlank() && prior != null) {
                    incoming.copy(password = prior.password)
                } else incoming
                if (prior == null) added++ else updated++
                existing[merged.id] = merged
                prefs.addOrUpdateProfile(merged)
            }
            ImportResult(true, added = added, updated = updated)
        } catch (e: Exception) {
            ImportResult(false, error = e.message)
        }
    }
}
