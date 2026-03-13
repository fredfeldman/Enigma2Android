package com.enigma2.android.data.api

import com.enigma2.android.data.prefs.ReceiverPreferences
import okhttp3.Credentials
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {
    private var retrofit: Retrofit? = null
    private var currentBaseUrl: String = ""

    fun initialize(prefs: ReceiverPreferences) {
        val scheme = if (prefs.useHttps) "https" else "http"
        val baseUrl = "$scheme://${prefs.host}:${prefs.port}/"
        if (baseUrl == currentBaseUrl && retrofit != null) return
        currentBaseUrl = baseUrl

        val clientBuilder = OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)

        if (prefs.username.isNotBlank()) {
            val credentials = Credentials.basic(prefs.username, prefs.password)
            clientBuilder.addInterceptor { chain ->
                chain.proceed(
                    chain.request().newBuilder()
                        .header("Authorization", credentials)
                        .build()
                )
            }
        }

        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(clientBuilder.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val service: OpenWebifService
        get() = retrofit?.create(OpenWebifService::class.java)
            ?: error("ApiClient not initialized. Call initialize() first.")
}
