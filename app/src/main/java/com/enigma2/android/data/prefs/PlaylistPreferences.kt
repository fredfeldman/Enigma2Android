package com.enigma2.android.data.prefs

import android.content.Context
import android.content.SharedPreferences
import com.enigma2.android.data.model.PlaylistEntry
import com.enigma2.android.data.model.RecordingPlaylist
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.UUID

class PlaylistPreferences(context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences("playlist_prefs", Context.MODE_PRIVATE)
    private val gson = Gson()

    var playlists: List<RecordingPlaylist>
        get() {
            val json = prefs.getString(KEY_PLAYLISTS, null) ?: return emptyList()
            return try {
                gson.fromJson(json, object : TypeToken<List<RecordingPlaylist>>() {}.type)
            } catch (e: Exception) {
                emptyList()
            }
        }
        private set(value) {
            prefs.edit().putString(KEY_PLAYLISTS, gson.toJson(value)).apply()
        }

    fun createPlaylist(name: String): RecordingPlaylist {
        val playlist = RecordingPlaylist(id = UUID.randomUUID().toString(), name = name)
        playlists = playlists + playlist
        return playlist
    }

    fun renamePlaylist(id: String, newName: String) {
        playlists = playlists.map { if (it.id == id) it.copy(name = newName) else it }
    }

    fun deletePlaylist(id: String) {
        playlists = playlists.filter { it.id != id }
    }

    fun addEntry(playlistId: String, entry: PlaylistEntry) {
        playlists = playlists.map { pl ->
            if (pl.id == playlistId) pl.copy(entries = (pl.entries + entry).toMutableList()) else pl
        }
    }

    fun removeEntry(playlistId: String, filename: String) {
        playlists = playlists.map { pl ->
            if (pl.id == playlistId) pl.copy(
                entries = pl.entries.filter { it.filename != filename }.toMutableList()
            ) else pl
        }
    }

    fun moveEntryUp(playlistId: String, index: Int) {
        if (index <= 0) return
        playlists = playlists.map { pl ->
            if (pl.id == playlistId) {
                val entries = pl.entries.toMutableList()
                val tmp = entries[index]
                entries[index] = entries[index - 1]
                entries[index - 1] = tmp
                pl.copy(entries = entries)
            } else pl
        }
    }

    fun moveEntryDown(playlistId: String, index: Int) {
        val pl = playlists.find { it.id == playlistId } ?: return
        if (index >= pl.entries.size - 1) return
        playlists = playlists.map { p ->
            if (p.id == playlistId) {
                val entries = p.entries.toMutableList()
                val tmp = entries[index]
                entries[index] = entries[index + 1]
                entries[index + 1] = tmp
                p.copy(entries = entries)
            } else p
        }
    }

    companion object {
        private const val KEY_PLAYLISTS = "playlists"
    }
}
