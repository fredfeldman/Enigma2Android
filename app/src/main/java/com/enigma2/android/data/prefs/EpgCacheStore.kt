package com.enigma2.android.data.prefs

import android.content.Context
import com.enigma2.android.data.model.EpgEvent
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Persistent cache of the last successful multi-EPG fetch per bouquet ref.
 * Backed by SharedPreferences-JSON so we avoid pulling in Room. One snapshot
 * per bouquet — kept simple; the EPG screen reloads on every entry anyway and
 * the cache is only consulted when the network call fails.
 */
class EpgCacheStore(context: Context) {

    private val prefs = context.applicationContext
        .getSharedPreferences("epg_cache", Context.MODE_PRIVATE)
    private val gson = Gson()

    data class Entry(val timestamp: Long, val events: List<EpgEvent>)

    fun put(bouquetRef: String, events: List<EpgEvent>) {
        val entry = Entry(System.currentTimeMillis(), events)
        prefs.edit().putString(key(bouquetRef), gson.toJson(entry)).apply()
    }

    fun get(bouquetRef: String): Entry? {
        val raw = prefs.getString(key(bouquetRef), null) ?: return null
        return try {
            gson.fromJson(raw, object : TypeToken<Entry>() {}.type)
        } catch (_: Exception) { null }
    }

    fun clear() {
        prefs.edit().clear().apply()
    }

    private fun key(bouquetRef: String): String = "b_" + bouquetRef.hashCode().toString()
}
