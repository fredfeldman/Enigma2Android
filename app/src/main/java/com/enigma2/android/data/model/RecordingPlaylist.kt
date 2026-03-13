package com.enigma2.android.data.model

data class PlaylistEntry(
    val filename: String,
    val title: String,
    val channel: String,
    val durationSec: String
)

data class RecordingPlaylist(
    val id: String,
    val name: String,
    val entries: MutableList<PlaylistEntry> = mutableListOf()
)
