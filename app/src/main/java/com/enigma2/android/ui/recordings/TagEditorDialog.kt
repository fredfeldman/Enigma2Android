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

object TagEditorDialog {
    fun show(
        context: Context,
        owner: LifecycleOwner,
        recording: Recording,
        onDone: (Boolean) -> Unit
    ) {
        val pad = (context.resources.displayMetrics.density * 16).toInt()
        val container = FrameLayout(context).apply { setPadding(pad, pad, pad, 0) }
        val input = EditText(context).apply {
            setText(recording.tags.joinToString(" "))
            inputType = InputType.TYPE_CLASS_TEXT
            hint = context.getString(R.string.rec_tags_hint)
        }
        container.addView(input)

        AlertDialog.Builder(context)
            .setTitle(R.string.rec_tags_title)
            .setView(container)
            .setPositiveButton(android.R.string.ok) { _, _ ->
                val newTags = input.text.toString()
                    .split(' ', '\t', '\n', ',').map { it.trim() }.filter { it.isNotEmpty() }
                val current = recording.tags
                val toAdd = newTags.filter { t -> current.none { it.equals(t, ignoreCase = true) } }
                val toDel = current.filter { t -> newTags.none { it.equals(t, ignoreCase = true) } }
                owner.lifecycleScope.launch {
                    val repo = Enigma2Repository()
                    var ok = true
                    if (toAdd.isNotEmpty()) ok = ok && repo.updateRecordingTags(
                        recording.serviceRef, add = toAdd.joinToString(" "))
                    if (toDel.isNotEmpty()) ok = ok && repo.updateRecordingTags(
                        recording.serviceRef, del = toDel.joinToString(" "))
                    onDone(ok)
                }
            }
            .setNegativeButton(android.R.string.cancel, null)
            .show()
    }
}
