package com.enigma2.android.ui.playlists

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.enigma2.android.R
import com.enigma2.android.data.prefs.PlaylistPreferences

class PlaylistManagerFragment : Fragment() {

    private lateinit var prefs: PlaylistPreferences
    private lateinit var adapter: PlaylistAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_playlist_manager, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prefs = PlaylistPreferences(requireContext())

        adapter = PlaylistAdapter(
            onClick = { playlist ->
                parentFragmentManager.beginTransaction()
                    .replace(R.id.main_container, PlaylistDetailFragment.newInstance(playlist.id))
                    .addToBackStack(null)
                    .commit()
            },
            onLongClick = { playlist ->
                showPlaylistOptions(playlist.id, playlist.name)
                true
            }
        )

        val rv = view.findViewById<RecyclerView>(R.id.rv_playlists)
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = adapter

        view.findViewById<View>(R.id.btn_new_playlist)?.setOnClickListener {
            showCreateDialog()
        }

        refreshList()
    }

    private fun refreshList() {
        adapter.submitList(prefs.playlists.toList())
    }

    private fun showCreateDialog() {
        val et = EditText(requireContext())
        AlertDialog.Builder(requireContext())
            .setTitle(R.string.new_playlist)
            .setView(et)
            .setPositiveButton(android.R.string.ok) { _, _ ->
                val name = et.text.toString().trim()
                if (name.isNotBlank()) {
                    prefs.createPlaylist(name)
                    refreshList()
                }
            }
            .setNegativeButton(android.R.string.cancel, null)
            .show()
    }

    private fun showPlaylistOptions(id: String, name: String) {
        AlertDialog.Builder(requireContext())
            .setTitle(name)
            .setItems(arrayOf(getString(R.string.rename), getString(R.string.delete))) { _, which ->
                when (which) {
                    0 -> showRenameDialog(id, name)
                    1 -> {
                        prefs.deletePlaylist(id)
                        refreshList()
                    }
                }
            }
            .show()
    }

    private fun showRenameDialog(id: String, currentName: String) {
        val et = EditText(requireContext()).apply { setText(currentName) }
        AlertDialog.Builder(requireContext())
            .setTitle(R.string.rename)
            .setView(et)
            .setPositiveButton(android.R.string.ok) { _, _ ->
                val name = et.text.toString().trim()
                if (name.isNotBlank()) {
                    prefs.renamePlaylist(id, name)
                    refreshList()
                }
            }
            .setNegativeButton(android.R.string.cancel, null)
            .show()
    }
}
