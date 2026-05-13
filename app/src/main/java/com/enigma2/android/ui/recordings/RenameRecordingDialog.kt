package com.enigma2.android.ui.recordings

import android.app.AlertDialog
import android.content.Context
import android.text.InputType
import android.widget.EditText
import android.widget.FrameLayout
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.enigma2.android.R
import com.enigma2.android.data.model.Recording
import com.enigma2.android.data.repository.Enigma2Repository
import kotlinx.coroutines.launch

object RenameRecordingDialog {
    fun show(
        context: Context,
        owner: LifecycleOwner,
        recording: Recording,
        onDone: (Boolean) -> Unit
    ) {
        val pad = (context.resources.displayMetrics.density * 16).toInt()
        val container = FrameLayout(context).apply { setPadding(pad, pad, pad, 0) }
        val input = EditText(context).apply {
            setText(recording.title)
            inputType = InputType.TYPE_CLASS_TEXT
            setSelectAllOnFocus(true)
            hint = context.getString(R.string.rec_rename_hint)
        }
        container.addView(input)

        AlertDialog.Builder(context)
            .setTitle(R.string.rec_rename_title)
            .setView(container)
            .setPositiveButton(android.R.string.ok) { _, _ ->
                val newName = input.text.toString().trim()
                if (newName.isEmpty() || newName == recording.title) { onDone(false); return@setPositiveButton }
                owner.lifecycleScope.launch {
                    val ok = Enigma2Repository().renameRecording(recording.serviceRef, newName)
                    onDone(ok)
                }
            }
            .setNegativeButton(android.R.string.cancel, null)
            .show()
    }
}
