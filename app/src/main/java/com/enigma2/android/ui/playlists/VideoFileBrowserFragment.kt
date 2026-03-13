package com.enigma2.android.ui.playlists

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.enigma2.android.R
import com.enigma2.android.data.prefs.PlaylistPreferences
import com.enigma2.android.data.prefs.ReceiverPreferences
import com.enigma2.android.data.repository.Enigma2Repository
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class VideoFileBrowserFragment : Fragment() {

    private val repo = Enigma2Repository()
    private lateinit var playlistPrefs: PlaylistPreferences
    private lateinit var receiverPrefs: ReceiverPreferences
    private lateinit var adapter: FileAdapter
    private var currentDir: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_video_browser, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        playlistPrefs = PlaylistPreferences(requireContext())
        receiverPrefs = ReceiverPreferences(requireContext())

        adapter = FileAdapter { recording ->
            showAddToPlaylistDialog(recording)
        }

        val rv = view.findViewById<RecyclerView>(R.id.rv_files)
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = adapter

        view.findViewById<View>(R.id.btn_browse_hdd)?.setOnClickListener {
            loadDirectory("/media/hdd")
        }

        loadDirectory(currentDir)
    }

    private fun loadDirectory(dirname: String?) {
        currentDir = dirname
        viewLifecycleOwner.lifecycleScope.launch {
            val recordings = withContext(Dispatchers.IO) { repo.getRecordings(dirname) }
            adapter.submitList(recordings)
        }
    }

    private fun showAddToPlaylistDialog(recording: com.enigma2.android.data.model.Recording) {
        val playlists = playlistPrefs.playlists
        if (playlists.isEmpty()) {
            Toast.makeText(requireContext(), R.string.no_playlists, Toast.LENGTH_SHORT).show()
            return
        }
        val names = playlists.map { it.name }.toTypedArray()
        AlertDialog.Builder(requireContext())
            .setTitle(R.string.add_to_playlist)
            .setItems(names) { _, which ->
                val playlist = playlists[which]
                playlistPrefs.addEntry(
                    playlist.id,
                    com.enigma2.android.data.model.PlaylistEntry(
                        filename = recording.filename,
                        title = recording.title,
                        channel = recording.channelName,
                        durationSec = recording.length
                    )
                )
                Toast.makeText(requireContext(), R.string.added_to_playlist, Toast.LENGTH_SHORT).show()
            }
            .show()
    }

    private inner class FileAdapter(
        private val onClick: (com.enigma2.android.data.model.Recording) -> Unit
    ) : ListAdapter<com.enigma2.android.data.model.Recording, FileAdapter.VH>(DIFF) {

        inner class VH(view: View) : RecyclerView.ViewHolder(view) {
            val tvTitle: TextView = view.findViewById(R.id.tv_recording_title)
            val tvChannel: TextView = view.findViewById(R.id.tv_recording_channel)

            init {
                view.setOnClickListener { onClick(getItem(bindingAdapterPosition)) }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_recording, parent, false)
            return VH(view)
        }

        override fun onBindViewHolder(holder: VH, position: Int) {
            val rec = getItem(position)
            holder.tvTitle.text = rec.title
            holder.tvChannel.text = rec.channelName
        }

        val DIFF = object : DiffUtil.ItemCallback<com.enigma2.android.data.model.Recording>() {
            override fun areItemsTheSame(
                a: com.enigma2.android.data.model.Recording,
                b: com.enigma2.android.data.model.Recording
            ) = a.filename == b.filename
            override fun areContentsTheSame(
                a: com.enigma2.android.data.model.Recording,
                b: com.enigma2.android.data.model.Recording
            ) = a == b
        }
    }

    companion object {
        private val DIFF = object : DiffUtil.ItemCallback<com.enigma2.android.data.model.Recording>() {
            override fun areItemsTheSame(
                a: com.enigma2.android.data.model.Recording,
                b: com.enigma2.android.data.model.Recording
            ) = a.filename == b.filename
            override fun areContentsTheSame(
                a: com.enigma2.android.data.model.Recording,
                b: com.enigma2.android.data.model.Recording
            ) = a == b
        }
    }
}
