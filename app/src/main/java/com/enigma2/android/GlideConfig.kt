package com.enigma2.android

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions
import com.enigma2.android.data.prefs.ReceiverPreferences
import okhttp3.Credentials
import okhttp3.OkHttpClient
import java.io.InputStream
import java.util.concurrent.TimeUnit

@GlideModule
class GlideConfig : AppGlideModule() {

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        builder.setDiskCache(
            InternalCacheDiskCacheFactory(context, "picons", 50L * 1024 * 1024)
        )
        builder.setDefaultRequestOptions(
            RequestOptions().diskCacheStrategy(DiskCacheStrategy.DATA)
        )
    }

    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        val prefs = ReceiverPreferences(context)
        val client = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val req = chain.request()
                if (prefs.username.isNotBlank()) {
                    chain.proceed(
                        req.newBuilder()
                            .header("Authorization", Credentials.basic(prefs.username, prefs.password))
                            .build()
                    )
                } else {
                    chain.proceed(req)
                }
            }
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .build()

        registry.replace(
            GlideUrl::class.java,
            InputStream::class.java,
            OkHttpUrlLoader.Factory(client)
        )
    }
}
