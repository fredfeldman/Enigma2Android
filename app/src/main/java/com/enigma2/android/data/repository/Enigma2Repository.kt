package com.enigma2.android.data.repository

import com.enigma2.android.data.api.ApiClient
import com.enigma2.android.data.model.AutoTimer
import com.enigma2.android.data.model.Bouquet
import com.enigma2.android.data.model.EpgEvent
import com.enigma2.android.data.model.NowNextEvent
import com.enigma2.android.data.model.Recording
import com.enigma2.android.data.model.Timer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.io.StringReader

class Enigma2Repository {

    suspend fun getAllBouquets(): List<Bouquet> = withContext(Dispatchers.IO) {
        // Let exceptions propagate so the ViewModel can display a meaningful error
        ApiClient.service.getAllServices().services ?: emptyList()
    }

    suspend fun getChannelsForBouquet(sRef: String): List<com.enigma2.android.data.model.Service> =
        withContext(Dispatchers.IO) {
            // Let exceptions propagate so the ViewModel can display a meaningful error
            ApiClient.service.getChannelList(sRef).services ?: emptyList()
        }

    suspend fun getEpgNow(bRef: String): List<NowNextEvent> = withContext(Dispatchers.IO) {
        try {
            ApiClient.service.getEpgNow(bRef).events ?: emptyList()
        } catch (e: Exception) {
            emptyList()
        }
    }

    suspend fun getEpgNext(bRef: String): List<NowNextEvent> = withContext(Dispatchers.IO) {
        try {
            ApiClient.service.getEpgNext(bRef).events ?: emptyList()
        } catch (e: Exception) {
            emptyList()
        }
    }

    suspend fun getMultiEpg(bRef: String): List<EpgEvent> = withContext(Dispatchers.IO) {
        try {
            ApiClient.service.getMultiEpg(bRef).events ?: emptyList()
        } catch (e: Exception) {
            emptyList()
        }
    }

    suspend fun getEpgForService(sRef: String): List<EpgEvent> = withContext(Dispatchers.IO) {
        try {
            ApiClient.service.getEpgForService(sRef).events ?: emptyList()
        } catch (e: Exception) {
            emptyList()
        }
    }

    suspend fun zapToService(sRef: String): Boolean = withContext(Dispatchers.IO) {
        try {
            ApiClient.service.zapToService(sRef).result
        } catch (e: Exception) {
            false
        }
    }

    suspend fun getRecordings(dirname: String? = null): List<Recording> = withContext(Dispatchers.IO) {
        try {
            ApiClient.service.getMovieList(dirname).movies ?: emptyList()
        } catch (e: Exception) {
            emptyList()
        }
    }

    suspend fun deleteRecording(filename: String): Boolean = withContext(Dispatchers.IO) {
        try {
            ApiClient.service.deleteMovie(filename).result
        } catch (e: Exception) {
            false
        }
    }

    suspend fun getTimers(): List<Timer> = withContext(Dispatchers.IO) {
        try {
            ApiClient.service.getTimerList().timers ?: emptyList()
        } catch (e: Exception) {
            emptyList()
        }
    }

    suspend fun addTimer(
        sRef: String,
        begin: Long,
        end: Long,
        name: String,
        description: String = ""
    ): Boolean = withContext(Dispatchers.IO) {
        try {
            ApiClient.service.addTimer(sRef, begin, end, name, description).result
        } catch (e: Exception) {
            false
        }
    }

    suspend fun deleteTimer(sRef: String, begin: Long, end: Long): Boolean =
        withContext(Dispatchers.IO) {
            try {
                ApiClient.service.deleteTimer(sRef, begin, end).result
            } catch (e: Exception) {
                false
            }
        }

    suspend fun searchEpg(query: String): List<EpgEvent> = withContext(Dispatchers.IO) {
        try {
            ApiClient.service.searchEpg(query).events ?: emptyList()
        } catch (e: Exception) {
            emptyList()
        }
    }

    suspend fun getScreenshot(): ByteArray? = withContext(Dispatchers.IO) {
        try {
            val response = ApiClient.service.getScreenshot()
            if (response.isSuccessful) response.body()?.bytes() else null
        } catch (e: Exception) {
            null
        }
    }

    // ---------------- AutoTimer (OpenWebif AutoTimer plugin) ----------------

    suspend fun getAutoTimers(): List<AutoTimer> = withContext(Dispatchers.IO) {
        try {
            val response = ApiClient.service.getAutoTimersXml()
            if (!response.isSuccessful) return@withContext emptyList()
            val xml = response.body()?.string() ?: return@withContext emptyList()
            parseAutoTimersXml(xml)
        } catch (e: Exception) {
            emptyList()
        }
    }

    suspend fun removeAutoTimer(id: Int): Boolean = withContext(Dispatchers.IO) {
        try {
            ApiClient.service.removeAutoTimer(id).isSuccessful
        } catch (e: Exception) {
            false
        }
    }

    /** Save an AutoTimer (id < 0 for new). Sends only the commonly-used fields. */
    suspend fun saveAutoTimer(at: AutoTimer): Boolean = withContext(Dispatchers.IO) {
        try {
            val params = mutableMapOf<String, String>()
            if (at.id >= 0) params["id"] = at.id.toString()
            params["name"] = at.name
            params["match"] = at.match
            params["enabled"] = if (at.enabled) "1" else "0"
            params["justplay"] = if (at.justplay) "1" else "0"
            if (at.from.isNotEmpty()) params["timespanFrom"] = at.from
            if (at.to.isNotEmpty()) params["timespanTo"] = at.to
            if (at.location.isNotEmpty()) params["location"] = at.location
            // Services: AutoTimer plugin accepts repeated "services" params; QueryMap can't repeat,
            // so when restricting to services we send the first one. Multiple services aren't editable here.
            at.services.firstOrNull()?.let { params["services"] = it }
            ApiClient.service.editAutoTimer(params).isSuccessful
        } catch (e: Exception) {
            false
        }
    }

    private fun parseAutoTimersXml(xml: String): List<AutoTimer> {        val result = mutableListOf<AutoTimer>()
        val factory = XmlPullParserFactory.newInstance()
        val parser = factory.newPullParser()
        parser.setInput(StringReader(xml))

        var current: AutoTimer? = null
        var services = mutableListOf<String>()
        var serviceNames = mutableListOf<String>()
        var inServiceRef = false
        var inServiceName = false

        var event = parser.eventType
        while (event != XmlPullParser.END_DOCUMENT) {
            when (event) {
                XmlPullParser.START_TAG -> when (parser.name) {
                    "timer" -> {
                        services = mutableListOf()
                        serviceNames = mutableListOf()
                        current = AutoTimer(
                            id = parser.getAttributeValue(null, "id")?.toIntOrNull() ?: -1,
                            name = parser.getAttributeValue(null, "name").orEmpty(),
                            match = parser.getAttributeValue(null, "match").orEmpty(),
                            enabled = (parser.getAttributeValue(null, "enabled") ?: "yes")
                                .equals("yes", ignoreCase = true),
                            from = parser.getAttributeValue(null, "from").orEmpty(),
                            to = parser.getAttributeValue(null, "to").orEmpty(),
                            justplay = parser.getAttributeValue(null, "justplay") == "1",
                            location = parser.getAttributeValue(null, "location").orEmpty()
                        )
                    }
                    "e2servicereference" -> inServiceRef = true
                    "e2servicename" -> inServiceName = true
                }
                XmlPullParser.TEXT -> {
                    if (inServiceRef) services.add(parser.text.trim())
                    if (inServiceName) serviceNames.add(parser.text.trim())
                }
                XmlPullParser.END_TAG -> when (parser.name) {
                    "e2servicereference" -> inServiceRef = false
                    "e2servicename" -> inServiceName = false
                    "timer" -> {
                        current?.let {
                            result.add(it.copy(services = services.toList(), serviceNames = serviceNames.toList()))
                        }
                        current = null
                    }
                }
            }
            event = parser.next()
        }
        return result
    }

    // ---------------- BouquetEditor plugin (optional) ----------------

    /** Distinguishes "plugin available, can mutate on the box" from "no plugin, local-only fallback". */
    enum class BouquetEditorCapability { Available, Missing }

    /** Probes the BouquetEditor plugin. Returns Missing on any HTTP / parse error. */
    suspend fun probeBouquetEditor(): BouquetEditorCapability = withContext(Dispatchers.IO) {
        try {
            ApiClient.service.getBouquetEditorBouquets()
            BouquetEditorCapability.Available
        } catch (e: Exception) {
            BouquetEditorCapability.Missing
        }
    }

    /** Returns the list of editable user bouquets (TV + Radio merged). Channels not populated. */
    suspend fun getUserBouquets(): List<Bouquet> = withContext(Dispatchers.IO) {
        val tv = try { ApiClient.service.getBouquetEditorBouquets().services ?: emptyList() }
                 catch (_: Exception) { emptyList() }
        val radio = try { ApiClient.service.getBouquetEditorBouquets(BOUQUETS_RADIO_ROOT).services ?: emptyList() }
                 catch (_: Exception) { emptyList() }
        tv + radio
    }

    suspend fun addBouquet(name: String, mode: Int = MODE_TV): com.enigma2.android.data.api.BouquetEditorXml.SimpleResult =
        withContext(Dispatchers.IO) {
            val r = ApiClient.service.addBouquet(name, mode)
            (r.body()?.byteStream() ?: java.io.ByteArrayInputStream(ByteArray(0))).use {
                com.enigma2.android.data.api.BouquetEditorXml.parseSimpleResult(it)
            }
        }

    suspend fun renameBouquet(bouquetRef: String, newName: String): com.enigma2.android.data.api.BouquetEditorXml.SimpleResult =
        withContext(Dispatchers.IO) {
            val r = ApiClient.service.renameBouquet(bouquetRef, newName, bouquetMode(bouquetRef))
            (r.body()?.byteStream() ?: java.io.ByteArrayInputStream(ByteArray(0))).use {
                com.enigma2.android.data.api.BouquetEditorXml.parseSimpleResult(it)
            }
        }

    suspend fun removeBouquet(bouquetRef: String): com.enigma2.android.data.api.BouquetEditorXml.SimpleResult =
        withContext(Dispatchers.IO) {
            val r = ApiClient.service.removeBouquet(bouquetRef, bouquetMode(bouquetRef))
            (r.body()?.byteStream() ?: java.io.ByteArrayInputStream(ByteArray(0))).use {
                com.enigma2.android.data.api.BouquetEditorXml.parseSimpleResult(it)
            }
        }

    suspend fun addServiceToBouquet(
        bouquetRef: String, service: com.enigma2.android.data.model.Service
    ): com.enigma2.android.data.api.BouquetEditorXml.SimpleResult = withContext(Dispatchers.IO) {
        val r = ApiClient.service.addServiceToBouquet(bouquetRef, service.ref, service.name)
        (r.body()?.byteStream() ?: java.io.ByteArrayInputStream(ByteArray(0))).use {
            com.enigma2.android.data.api.BouquetEditorXml.parseSimpleResult(it)
        }
    }

    suspend fun removeServiceFromBouquet(
        bouquetRef: String, serviceRef: String
    ): com.enigma2.android.data.api.BouquetEditorXml.SimpleResult = withContext(Dispatchers.IO) {
        val r = ApiClient.service.removeServiceFromBouquet(bouquetRef, serviceRef)
        (r.body()?.byteStream() ?: java.io.ByteArrayInputStream(ByteArray(0))).use {
            com.enigma2.android.data.api.BouquetEditorXml.parseSimpleResult(it)
        }
    }

    suspend fun moveServiceInBouquet(
        bouquetRef: String, serviceRef: String, position: Int
    ): com.enigma2.android.data.api.BouquetEditorXml.SimpleResult = withContext(Dispatchers.IO) {
        val r = ApiClient.service.moveServiceInBouquet(bouquetRef, serviceRef, position)
        (r.body()?.byteStream() ?: java.io.ByteArrayInputStream(ByteArray(0))).use {
            com.enigma2.android.data.api.BouquetEditorXml.parseSimpleResult(it)
        }
    }

    /** Pure helper: returns [services] with the override applied. */
    fun applyOverride(
        services: List<com.enigma2.android.data.model.Service>,
        override: com.enigma2.android.data.prefs.ReceiverPreferences.BouquetOverride
    ): List<com.enigma2.android.data.model.Service> {
        if (override.isEmpty()) return services
        val removed = override.removed.toSet()
        val filtered = services.filter { it.ref !in removed }
        if (override.order.isEmpty()) return filtered
        val byRef = filtered.associateBy { it.ref }
        val ordered = mutableListOf<com.enigma2.android.data.model.Service>()
        val taken = mutableSetOf<String>()
        for (ref in override.order) {
            byRef[ref]?.let { ordered.add(it); taken.add(ref) }
        }
        for (s in filtered) if (s.ref !in taken) ordered.add(s)
        return ordered
    }

    // ---------------- EPGImport plugin (optional) ----------------

    /**
     * Candidate base paths used by different OpenWebif builds for the EPGImport plugin.
     * Order matters: the first one that responds successfully wins and is cached.
     */
    private val epgImportBaseCandidates = listOf(
        "epgimport",
        "api/epgimport",
        "epgimport/plugin",
        "plugin/epgimport"
    )

    @Volatile private var cachedEpgImportBase: String? = null

    private suspend fun resolveEpgImportBase(): String? {
        cachedEpgImportBase?.let { return it }
        for (base in epgImportBaseCandidates) {
            // Try a sub-path that almost always exists when the plugin is installed.
            // We accept either HTTP success OR a body that mentions "epgimport" or "<source"
            // (some OpenWebif builds return 200 with HTML for unknown paths; we want a real signal).
            val candidates = listOf("$base/sources", "$base/status", base)
            for (path in candidates) {
                try {
                    val r = ApiClient.service.probeEpgImportPath(path)
                    if (r.isSuccessful) {
                        val body = r.body()?.string().orEmpty()
                        // Reject obvious "page not found" HTML even on 200 responses
                        val looksLikePlugin = body.contains("source", ignoreCase = true) ||
                            body.contains("epgimport", ignoreCase = true) ||
                            body.contains("description=", ignoreCase = true) ||
                            body.contains("\"sources\"", ignoreCase = true)
                        if (looksLikePlugin) {
                            cachedEpgImportBase = base
                            return base
                        }
                    }
                } catch (_: Exception) { /* try next */ }
            }
        }
        return null
    }

    /** Returns true if the EPGImport plugin appears to be installed/enabled on the receiver. */
    suspend fun isEpgImportAvailable(): Boolean = withContext(Dispatchers.IO) {
        resolveEpgImportBase() != null
    }

    /** Returns a human-readable status snippet from the plugin (best-effort). */
    suspend fun getEpgImportStatus(): String? = withContext(Dispatchers.IO) {
        try {
            val base = resolveEpgImportBase() ?: return@withContext null
            val r = ApiClient.service.getEpgImportStatusAt("$base/status")
            if (!r.isSuccessful) return@withContext null
            r.body()?.string()?.let { extractEpgImportStatus(it) }
        } catch (e: Exception) {
            null
        }
    }

    /** Returns the list of available source descriptions parsed from the plugin response. */
    suspend fun getEpgImportSources(): List<EpgImportSource> = withContext(Dispatchers.IO) {
        try {
            val base = resolveEpgImportBase() ?: return@withContext emptyList()
            val r = ApiClient.service.getEpgImportSourcesAt("$base/sources")
            if (!r.isSuccessful) return@withContext emptyList()
            val all = parseEpgImportSources(r.body()?.string() ?: "")
            val enabled = try {
                val er = ApiClient.service.getEpgImportEnabledSourcesAt("$base/showsources")
                if (er.isSuccessful) parseEpgImportSources(er.body()?.string() ?: "")
                    .map { it.description }.toSet()
                else emptySet()
            } catch (e: Exception) { emptySet() }
            all.map { it.copy(enabled = it.description in enabled) }
        } catch (e: Exception) {
            emptyList()
        }
    }

    /** Saves the set of enabled EPGImport sources (by description). */
    suspend fun saveEpgImportEnabledSources(enabledDescriptions: List<String>): Boolean =
        withContext(Dispatchers.IO) {
            try {
                val base = resolveEpgImportBase() ?: return@withContext false
                val csv = enabledDescriptions.joinToString("|")
                ApiClient.service.saveEpgImportEnabledSourcesAt("$base/savesources", csv).isSuccessful
            } catch (e: Exception) {
                false
            }
        }

    /** Triggers an EPG import on the receiver. Returns true on HTTP success. */
    suspend fun runEpgImport(): Boolean = withContext(Dispatchers.IO) {
        try {
            val base = resolveEpgImportBase() ?: return@withContext false
            ApiClient.service.runEpgImportAt("$base/import").isSuccessful
        } catch (e: Exception) {
            false
        }
    }

    // ---------------- Box info ----------------

    /**
     * Returns the receiver's about/deviceinfo as ordered key/value pairs for display.
     * Tries `api/about` first, falls back to `api/deviceinfo`.
     */
    suspend fun getBoxInfo(): List<Pair<String, String>> = withContext(Dispatchers.IO) {
        val raw = try {
            val r = ApiClient.service.getBoxInfo()
            if (r.isSuccessful) r.body()?.string() else null
        } catch (e: Exception) { null }
            ?: try {
                val r2 = ApiClient.service.getDeviceInfo()
                if (r2.isSuccessful) r2.body()?.string() else null
            } catch (e: Exception) { null }
            ?: return@withContext emptyList()

        flattenJsonScalars(raw)
    }

    /** Flattens a JSON object to ordered (key, value) pairs, joining nested keys with "." */
    private fun flattenJsonScalars(jsonText: String): List<Pair<String, String>> {
        val out = mutableListOf<Pair<String, String>>()
        try {
            val root = com.google.gson.JsonParser.parseString(jsonText)
            if (root.isJsonObject) walkJson("", root.asJsonObject, out)
        } catch (_: Exception) { /* not JSON */ }
        return out
    }

    private fun walkJson(prefix: String, obj: com.google.gson.JsonObject, out: MutableList<Pair<String, String>>) {
        for ((k, v) in obj.entrySet()) {
            val key = if (prefix.isEmpty()) k else "$prefix.$k"
            when {
                v.isJsonPrimitive -> out += key to v.asJsonPrimitive.asString
                v.isJsonArray -> {
                    val items = v.asJsonArray
                    if (items.size() > 0 && items.all { it.isJsonPrimitive }) {
                        out += key to items.joinToString(", ") { it.asJsonPrimitive.asString }
                    } else {
                        items.forEachIndexed { i, e ->
                            if (e.isJsonObject) walkJson("$key[$i]", e.asJsonObject, out)
                            else if (e.isJsonPrimitive) out += "$key[$i]" to e.asJsonPrimitive.asString
                        }
                    }
                }
                v.isJsonObject -> walkJson(key, v.asJsonObject, out)
                v.isJsonNull -> out += key to ""
            }
        }
    }

    private fun extractEpgImportStatus(body: String): String {
        // Try JSON-ish "status":"..." or "message":"...", else strip tags from HTML.
        val key = Regex("\"(status|message|state)\"\\s*:\\s*\"([^\"]+)\"").find(body)
        if (key != null) return key.groupValues[2]
        val stripped = body.replace(Regex("<[^>]+>"), " ").replace(Regex("\\s+"), " ").trim()
        return if (stripped.length > 200) stripped.substring(0, 200) + "…" else stripped
    }

    private fun parseEpgImportSources(body: String): List<EpgImportSource> {
        // Try XML <source ... description="..."> first
        val descRegex = Regex("description\\s*=\\s*\"([^\"]+)\"")
        val xmlMatches = descRegex.findAll(body).map { it.groupValues[1] }.toList()
        if (xmlMatches.isNotEmpty()) {
            return xmlMatches.distinct().map { EpgImportSource(description = it) }
        }

        // Try JSON arrays of strings or objects with "description"/"name"
        val jsonDesc = Regex("\"(?:description|name|source)\"\\s*:\\s*\"([^\"]+)\"")
            .findAll(body).map { it.groupValues[1] }.toList()
        if (jsonDesc.isNotEmpty()) {
            return jsonDesc.distinct().map { EpgImportSource(description = it) }
        }

        return emptyList()
    }

    companion object {
        const val MODE_TV = 0
        const val MODE_RADIO = 1
        private const val BOUQUETS_RADIO_ROOT =
            "1:7:1:0:0:0:0:0:0:0:FROM BOUQUET \"bouquets.radio\" ORDER BY bouquet"

        /** Derives the Enigma2 mode (0=TV, 1=Radio) from a bouquet service reference. */
        fun bouquetMode(ref: String): Int =
            if (ref.contains(".radio") || ref.startsWith("1:7:2")) MODE_RADIO else MODE_TV
    }
}

/** A single EPGImport source advertised by the plugin. */
data class EpgImportSource(val description: String, val enabled: Boolean = false)
