package com.enigma2.android.ui.recordings

import android.app.AlertDialog
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.enigma2.android.R
import com.enigma2.android.data.model.Recording
import com.enigma2.android.data.repository.Enigma2Repository
import kotlinx.coroutines.launch

object MoveRecordingDialog {
    fun show(
        context: Context,
        owner: LifecycleOwner,
        recording: Recording,
        onDone: (Boolean) -> Unit
    ) {
        owner.lifecycleScope.launch {
            val repo = Enigma2Repository()
            val locs = repo.getRecordingLocations().locations
            if (locs.isEmpty()) {
                Toast.makeText(context, R.string.rec_move_no_locations, Toast.LENGTH_SHORT).show()
                onDone(false)
                return@launch
            }
            AlertDialog.Builder(context)
                .setTitle(R.string.rec_move_title)
                .setItems(locs.toTypedArray()) { _, which ->
                    val target = locs[which]
                    owner.lifecycleScope.launch {
                        val ok = repo.moveRecording(recording.serviceRef, target)
                        onDone(ok)
                    }
                }
                .setNegativeButton(android.R.string.cancel, null)
                .show()
        }
    }
}
