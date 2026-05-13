package com.enigma2.android.ui.recordings

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.enigma2.android.R
import com.enigma2.android.data.model.PlaylistEntry
import com.enigma2.android.data.model.Recording
import com.enigma2.android.data.prefs.PlaylistPreferences
import com.enigma2.android.data.prefs.ReceiverPreferences
import com.enigma2.android.ui.player.PlayerActivity
import com.enigma2.android.ui.playlists.PlaylistManagerFragment
import com.enigma2.android.ui.viewmodel.RecordingViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class RecordingsFragment : Fragment() {

    private val viewModel: RecordingViewModel by activityViewModels()
    private lateinit var prefs: ReceiverPreferences
    private lateinit var playlistPrefs: PlaylistPreferences
    private lateinit var adapter: RecordingAdapter

    // Detail panel views
    private lateinit var panelDetail: View
    private lateinit var tvDetailTitle: TextView
    private lateinit var tvDetailChannel: TextView
    private lateinit var tvDetailDatetime: TextView
    private lateinit var tvDetailDesc: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_recordings, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prefs = ReceiverPreferences(requireContext())
        playlistPrefs = PlaylistPreferences(requireContext())

        panelDetail = view.findViewById(R.id.panel_detail)
        tvDetailTitle = view.findViewById(R.id.tv_detail_title)
        tvDetailChannel = view.findViewById(R.id.tv_detail_channel)
        tvDetailDatetime = view.findViewById(R.id.tv_detail_datetime)
        tvDetailDesc = view.findViewById(R.id.tv_detail_description)

        adapter = RecordingAdapter(
            onRecordingClick = { recording -> showDetail(recording) },
            onRecordingLongClick = { recording -> showRecordingMenu(recording) }
        )

        val rv = view.findViewById<RecyclerView>(R.id.rv_recordings)
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = adapter

        val swipe = view.findViewById<androidx.swiperefreshlayout.widget.SwipeRefreshLayout>(R.id.swipe_recordings)
        swipe.setOnRefreshListener {
            viewModel.loadRecordings()
            swipe.isRefreshing = false
        }

        view.findViewById<View>(R.id.btn_back)?.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        view.findViewById<View>(R.id.btn_playlists)?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_container, PlaylistManagerFragment())
                .addToBackStack(null)
                .commit()
        }

        view.findViewById<View>(R.id.btn_sort)?.setOnClickListener { showSortDialog() }

        view.findViewById<View>(R.id.btn_play_detail)?.setOnClickListener {
            viewModel.focusedRecording.value?.let { playRecording(it) }
        }

        val progress = view.findViewById<View>(R.id.progress_recordings)
        val tvEmpty = view.findViewById<TextView>(R.id.tv_recordings_empty)

        viewModel.isLoading.observe(viewLifecycleOwner) { loading ->
            progress.visibility = if (loading) View.VISIBLE else View.GONE
        }

        viewModel.sortedRecordings.observe(viewLifecycleOwner) { recs ->
            adapter.submitList(recs)
            val isEmpty = recs.isNullOrEmpty() && viewModel.isLoading.value != true
            tvEmpty.visibility = if (isEmpty) View.VISIBLE else View.GONE
            rv.visibility = if (isEmpty) View.GONE else View.VISIBLE
        }

        viewModel.focusedRecording.observe(viewLifecycleOwner) { rec ->
            if (rec != null) populateDetail(rec)
        }

        viewModel.loadRecordings()
    }

    private fun showDetail(recording: Recording) {
        viewModel.onRecordingFocused(recording)
        panelDetail.visibility = View.VISIBLE
    }

    private fun populateDetail(rec: Recording) {
        tvDetailTitle.text = rec.title
        tvDetailChannel.text = rec.channelName
        val fmt = SimpleDateFormat("dd MMM yyyy HH:mm", Locale.getDefault())
        tvDetailDatetime.text = fmt.format(Date(rec.startTimestamp * 1000))
        tvDetailDesc.text = getString(R.string.duration_minutes, rec.lengthMinutes)
    }

    private fun playRecording(recording: Recording) {
        val streamUrl = prefs.recordingStreamUrl(recording.filename)
        // v1.2.0: try external player when preferred
        if (com.enigma2.android.ui.player.ExternalPlayerLauncher
                .launchExternalIfPreferred(requireContext(), streamUrl, recording.title, prefs)) {
            return
        }
        startActivity(
            Intent(requireContext(), PlayerActivity::class.java).apply {
                putExtra(PlayerActivity.EXTRA_STREAM_URL, streamUrl)
                putExtra(PlayerActivity.EXTRA_CHANNEL_NAME, recording.title)
                putExtra(PlayerActivity.EXTRA_IS_RECORDING, true)
                putExtra(PlayerActivity.EXTRA_DURATION_SEC, recording.lengthMinutes.toInt() * 60)
            }
        )
    }

    private fun showRecordingMenu(recording: Recording) {
        val watchedLabel = if (recording.isWatched)
            getString(R.string.rec_action_mark_unwatched)
        else
            getString(R.string.rec_action_mark_watched)
        val options = arrayOf(
            getString(R.string.play),
            getString(R.string.add_to_playlist),
            getString(R.string.rec_action_rename),
            getString(R.string.rec_action_move),
            getString(R.string.rec_action_tags),
            watchedLabel,
            getString(R.string.delete_recording)
        )
        AlertDialog.Builder(requireContext())
            .setTitle(recording.title)
            .setItems(options) { _, which ->
                when (which) {
                    0 -> playRecording(recording)
                    1 -> showAddToPlaylistDialog(recording)
                    2 -> RenameRecordingDialog.show(requireContext(), viewLifecycleOwner, recording) { ok ->
                        Toast.makeText(requireContext(),
                            if (ok) R.string.rec_renamed else R.string.rec_rename_failed,
                            Toast.LENGTH_SHORT).show()
                        if (ok) viewModel.loadRecordings()
                    }
                    3 -> MoveRecordingDialog.show(requireContext(), viewLifecycleOwner, recording) { ok ->
                        Toast.makeText(requireContext(),
                            if (ok) R.string.rec_moved else R.string.rec_move_failed,
                            Toast.LENGTH_SHORT).show()
                        if (ok) viewModel.loadRecordings()
                    }
                    4 -> TagEditorDialog.show(requireContext(), viewLifecycleOwner, recording) { ok ->
                        Toast.makeText(requireContext(),
                            if (ok) R.string.rec_tags_updated else R.string.rec_tags_failed,
                            Toast.LENGTH_SHORT).show()
                        if (ok) viewModel.loadRecordings()
                    }
                    5 -> viewModel.toggleWatched(recording) { ok ->
                        val msg = if (!ok) R.string.rec_watched_failed
                            else if (recording.isWatched) R.string.rec_unwatched
                            else R.string.rec_watched
                        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
                    }
                    6 -> confirmDeleteRecording(recording)
                }
            }
            .show()
    }

    private fun confirmDeleteRecording(recording: Recording) {
        AlertDialog.Builder(requireContext())
            .setTitle(R.string.delete_recording)
            .setMessage(getString(R.string.delete_recording_confirm, recording.title))
            .setPositiveButton(R.string.delete) { _, _ ->
                viewModel.deleteRecording(recording) { ok ->
                    val msgRes = if (ok) R.string.recording_deleted else R.string.recording_delete_failed
                    Toast.makeText(requireContext(), msgRes, Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton(android.R.string.cancel, null)
            .show()
    }

    private fun showAddToPlaylistDialog(recording: Recording) {
        val playlists = playlistPrefs.playlists

        if (playlists.isEmpty()) {
            AlertDialog.Builder(requireContext())
                .setTitle(R.string.add_to_playlist)
                .setMessage(R.string.no_playlists)
                .setPositiveButton(R.string.new_playlist) { _, _ -> showCreateAndAddDialog(recording) }
                .setNegativeButton(android.R.string.cancel, null)
                .show()
            return
        }

        val names = (playlists.map { it.name } + getString(R.string.new_playlist)).toTypedArray()
        AlertDialog.Builder(requireContext())
            .setTitle(R.string.add_to_playlist)
            .setItems(names) { _, which ->
                if (which < playlists.size) {
                    playlistPrefs.addEntry(
                        playlists[which].id,
                        PlaylistEntry(
                            filename = recording.filename,
                            title = recording.title,
                            channel = recording.channelName,
                            durationSec = (recording.lengthMinutes * 60).toString()
                        )
                    )
                    Toast.makeText(requireContext(), R.string.added_to_playlist, Toast.LENGTH_SHORT).show()
                } else {
                    showCreateAndAddDialog(recording)
                }
            }
            .show()
    }

    private fun showCreateAndAddDialog(recording: Recording) {
        val et = EditText(requireContext()).apply {
            hint = getString(R.string.new_playlist)
            setSingleLine(true)
        }
        AlertDialog.Builder(requireContext())
            .setTitle(R.string.new_playlist)
            .setView(et)
            .setPositiveButton(android.R.string.ok) { _, _ ->
                val name = et.text.toString().trim()
                if (name.isNotBlank()) {
                    val pl = playlistPrefs.createPlaylist(name)
                    playlistPrefs.addEntry(
                        pl.id,
                        PlaylistEntry(
                            filename = recording.filename,
                            title = recording.title,
                            channel = recording.channelName,
                            durationSec = (recording.lengthMinutes * 60).toString()
                        )
                    )
                    Toast.makeText(requireContext(), R.string.added_to_playlist, Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton(android.R.string.cancel, null)
            .show()
    }

    private fun showSortDialog() {
        val options = arrayOf(
            getString(R.string.sort_date_desc),
            getString(R.string.sort_date_asc),
            getString(R.string.sort_name),
            getString(R.string.sort_channel)
        )
        AlertDialog.Builder(requireContext())
            .setTitle(R.string.sort_by)
            .setItems(options) { _, which ->
                viewModel.setSortOrder(which)
            }
            .show()
    }
}
