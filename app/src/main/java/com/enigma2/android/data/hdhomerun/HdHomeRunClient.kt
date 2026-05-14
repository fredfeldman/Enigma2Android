package com.enigma2.android.data.hdhomerun

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import okhttp3.OkHttpClient
import okhttp3.Request
import java.util.concurrent.TimeUnit

/**
 * Minimal HDHomeRun (SiliconDust) tuner client.
 *
 * HDHomeRun devices expose a JSON HTTP API on port 80:
 *   GET /discover.json  -> device info (model, firmware, BaseURL)
 *   GET /lineup.json    -> [{ GuideNumber, GuideName, URL, ... }]
 *
 * The stream URL returned by lineup.json is a plain HTTP MPEG-TS endpoint
 * such as http://192.168.1.50:5004/auto/v5 — directly usable as an
 * Enigma2 IPTV service ref (service type 4097).
 */
object HdHomeRunClient {

    private val gson = Gson()
    private val client: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .connectTimeout(3, TimeUnit.SECONDS)
            .readTimeout(5, TimeUnit.SECONDS)
            .build()
    }

    data class DiscoverInfo(
        @SerializedName("FriendlyName") val friendlyName: String? = null,
        @SerializedName("ModelNumber") val model: String? = null,
        @SerializedName("FirmwareName") val firmwareName: String? = null,
        @SerializedName("FirmwareVersion") val firmwareVersion: String? = null,
        @SerializedName("DeviceID") val deviceId: String? = null,
        @SerializedName("DeviceAuth") val deviceAuth: String? = null,
        @SerializedName("BaseURL") val baseUrl: String? = null,
        @SerializedName("LineupURL") val lineupUrl: String? = null,
        @SerializedName("TunerCount") val tunerCount: Int? = null
    )

    data class Channel(
        @SerializedName("GuideNumber") val guideNumber: String = "",
        @SerializedName("GuideName") val guideName: String = "",
        @SerializedName("URL") val url: String = "",
        @SerializedName("HD") val hd: Int? = null,
        @SerializedName("Favorite") val favorite: Int? = null,
        @SerializedName("DRM") val drm: Int? = null
    ) {
        /** True when the channel is encrypted/DRM-protected (cannot be streamed). */
        val isProtected: Boolean get() = (drm ?: 0) != 0
    }

    /** Normalise a host. Accepts "1.2.3.4", "hdhomerun.local", "http://1.2.3.4". */
    private fun baseUrl(host: String): String {
        val trimmed = host.trim().removeSuffix("/")
        return when {
            trimmed.startsWith("http://") || trimmed.startsWith("https://") -> trimmed
            else -> "http://$trimmed"
        }
    }

    /**
     * Fetch device info from `<host>/discover.json`. Returns null on any error
     * (timeout, non-200, malformed JSON).
     */
    fun discover(host: String): DiscoverInfo? {
        if (host.isBlank()) return null
        val url = baseUrl(host) + "/discover.json"
        return try {
            client.newCall(Request.Builder().url(url).get().build()).execute().use { resp ->
                if (!resp.isSuccessful) return null
                gson.fromJson(resp.body?.string().orEmpty(), DiscoverInfo::class.java)
            }
        } catch (_: Exception) { null }
    }

    /**
     * Fetch the channel lineup from `<host>/lineup.json`. Returns an empty
     * list on any error so the caller can present "no channels found" without
     * exception handling.
     */
    fun fetchLineup(host: String): List<Channel> {
        if (host.isBlank()) return emptyList()
        val url = baseUrl(host) + "/lineup.json"
        return try {
            client.newCall(Request.Builder().url(url).get().build()).execute().use { resp ->
                if (!resp.isSuccessful) return emptyList()
                val arr = gson.fromJson(resp.body?.string().orEmpty(),
                    Array<Channel>::class.java) ?: emptyArray()
                arr.toList()
            }
        } catch (_: Exception) { emptyList() }
    }

    /**
     * Build an Enigma2 IPTV service reference for an HDHomeRun stream URL.
     *
     * Format used by Enigma2 user-bouquet entries for HTTP streams:
     *   `4097:0:1:0:0:0:0:0:0:0:<url-encoded-url>:<name>`
     *
     * Service type 4097 = GStreamer-backed external stream player. Colons
     * and slashes inside the URL are %-encoded so the Enigma2 parser doesn't
     * mistake them for ref-field separators.
     */
    fun toEnigma2Ref(channel: Channel): String {
        val encoded = channel.url
            .replace(":", "%3a")
            .replace("/", "%2f")
        return "4097:0:1:0:0:0:0:0:0:0:$encoded:"
    }

    /** Friendly display label for a [Channel] in pickers. */
    fun displayName(channel: Channel): String {
        val num = channel.guideNumber.ifBlank { "?" }
        val name = channel.guideName.ifBlank { "(unnamed)" }
        return "$num  $name"
    }
}
