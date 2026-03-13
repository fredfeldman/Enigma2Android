package com.enigma2.android.ui.playlists

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.enigma2.android.R
import com.enigma2.android.data.model.PlaylistEntry
import com.enigma2.android.data.prefs.PlaylistPreferences
import com.enigma2.android.data.prefs.ReceiverPreferences
import com.enigma2.android.ui.player.PlayerActivity

class PlaylistDetailFragment : Fragment() {

    private lateinit var playlistPrefs: PlaylistPreferences
    private lateinit var receiverPrefs: ReceiverPreferences
    private lateinit var adapter: PlaylistDetailAdapter
    private var playlistId: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_playlist_detail, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        playlistPrefs = PlaylistPreferences(requireContext())
        receiverPrefs = ReceiverPreferences(requireContext())
        playlistId = arguments?.getString(ARG_PLAYLIST_ID) ?: return

        adapter = PlaylistDetailAdapter(
            onClick = { entry -> playEntry(entry) },
            onMoveUp = { index ->
                playlistPrefs.moveEntryUp(playlistId, index)
                refreshList()
            },
            onMoveDown = { index ->
                playlistPrefs.moveEntryDown(playlistId, index)
                refreshList()
            },
            onRemove = { entry ->
                playlistPrefs.removeEntry(playlistId, entry.filename)
                refreshList()
            }
        )

        val rv = view.findViewById<RecyclerView>(R.id.rv_playlist_entries)
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = adapter

        refreshList()
    }

    private fun refreshList() {
        val playlist = playlistPrefs.playlists.find { it.id == playlistId } ?: return
        adapter.submitList(playlist.entries.toList())
    }

    private fun playEntry(entry: PlaylistEntry) {
        val url = receiverPrefs.recordingStreamUrl(entry.filename)
        startActivity(
            Intent(requireContext(), PlayerActivity::class.java).apply {
                putExtra(PlayerActivity.EXTRA_STREAM_URL, url)
                putExtra(PlayerActivity.EXTRA_CHANNEL_NAME, entry.title)
                putExtra(PlayerActivity.EXTRA_IS_RECORDING, true)
            }
        )
    }

    companion object {
        const val ARG_PLAYLIST_ID = "playlist_id"
        fun newInstance(id: String) = PlaylistDetailFragment().apply {
            arguments = Bundle().apply { putString(ARG_PLAYLIST_ID, id) }
        }
    }
}
