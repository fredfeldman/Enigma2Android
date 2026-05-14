package com.enigma2.android.data.repository

import com.enigma2.android.data.model.DeviceProfile
import okhttp3.Credentials
import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.URLEncoder
import java.util.concurrent.TimeUnit

/**
 * v1.3.0 — Issue OpenWebif requests against a *non-active* receiver profile.
 *
 * The standard [Enigma2Repository] uses the global [com.enigma2.android.data.api.ApiClient],
 * which is bound to the currently-active device profile. Multi-room features
 * (zap on…, future "send message to…", future "record on…") need to talk to
 * other receivers without disturbing the active connection. This object
 * builds short-lived OkHttp calls instead of a separate Retrofit instance.
 */
object RemoteReceiverApi {

    private val client by lazy {
        OkHttpClient.Builder()
            .connectTimeout(6, TimeUnit.SECONDS)
            .readTimeout(8, TimeUnit.SECONDS)
            .build()
    }

    private fun baseUrl(p: DeviceProfile): String {
        val scheme = if (p.useHttps) "https" else "http"
        return "$scheme://${p.host}:${p.port}"
    }

    private fun execute(p: DeviceProfile, path: String): Boolean {
        val url = baseUrl(p) + path
        val builder = Request.Builder().url(url).get()
        if (p.username.isNotBlank() || p.password.isNotBlank()) {
            builder.header("Authorization", Credentials.basic(p.username, p.password))
        }
        return try {
            client.newCall(builder.build()).execute().use { it.isSuccessful }
        } catch (_: Exception) { false }
    }

    /** Tune [serviceRef] on the receiver described by [profile]. */
    fun zap(profile: DeviceProfile, serviceRef: String): Boolean {
        val ref = URLEncoder.encode(serviceRef, "UTF-8")
        return execute(profile, "/api/zap?sRef=$ref")
    }

    /** Send an OSD message to [profile]. type: 1=info, 2=warning, 3=question, 0=error. */
    fun message(
        profile: DeviceProfile,
        text: String,
        type: Int = 1,
        timeoutSec: Int = 10
    ): Boolean {
        val t = URLEncoder.encode(text, "UTF-8")
        return execute(profile, "/api/message?text=$t&type=$type&timeout=$timeoutSec")
    }
}
