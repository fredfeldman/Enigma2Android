package com.enigma2.android.ui.messages

import android.app.AlertDialog
import android.content.Context
import android.text.InputType
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.enigma2.android.R
import com.enigma2.android.data.prefs.ReceiverPreferences
import com.enigma2.android.data.repository.Enigma2Repository
import com.enigma2.android.data.repository.RemoteReceiverApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

object SendMessageDialog {

    private val repo = Enigma2Repository()

    fun show(context: Context, owner: LifecycleOwner) {
        val pad = (context.resources.displayMetrics.density * 16).toInt()
        val container = LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(pad, pad, pad, pad)
        }

        // v1.3.1: multi-room target picker (only when more than one profile)
        val prefs = ReceiverPreferences(context)
        val profiles = prefs.deviceProfiles
        val targetLabel = TextView(context).apply { text = context.getString(R.string.send_message_target) }
        val targetSpinner = Spinner(context).apply {
            adapter = ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item,
                profiles.map { it.name.ifBlank { it.host } })
            setSelection(profiles.indexOfFirst { it.id == prefs.activeDeviceId }.coerceAtLeast(0))
        }
        if (profiles.size > 1) {
            container.addView(targetLabel)
            container.addView(targetSpinner)
        }

        val text = EditText(context).apply {
            hint = context.getString(R.string.send_message_hint)
            inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_MULTI_LINE
            minLines = 2
        }
        val typeSpinner = Spinner(context).apply {
            adapter = ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item, arrayOf(
                context.getString(R.string.msg_type_info),
                context.getString(R.string.msg_type_warning),
                context.getString(R.string.msg_type_question),
                context.getString(R.string.msg_type_error)
            ))
        }
        val timeout = EditText(context).apply {
            hint = context.getString(R.string.send_message_timeout)
            inputType = InputType.TYPE_CLASS_NUMBER
            setText("10")
        }
        container.addView(text)
        container.addView(typeSpinner)
        container.addView(timeout)

        AlertDialog.Builder(context)
            .setTitle(R.string.send_message)
            .setView(container)
            .setPositiveButton(R.string.send_message_send) { _, _ ->
                val msg = text.text.toString().trim()
                if (msg.isEmpty()) return@setPositiveButton
                val typeCode = typeSpinner.selectedItemPosition + 1
                val to = timeout.text.toString().toIntOrNull() ?: 10
                val targetIdx = if (profiles.size > 1) targetSpinner.selectedItemPosition else -1
                owner.lifecycleScope.launch {
                    val ok = if (targetIdx < 0 || profiles[targetIdx].id == prefs.activeDeviceId) {
                        repo.sendMessageToReceiver(msg, typeCode, to)
                    } else withContext(Dispatchers.IO) {
                        RemoteReceiverApi.message(profiles[targetIdx], msg, typeCode, to)
                    }
                    Toast.makeText(context,
                        if (ok) R.string.send_message_sent else R.string.send_message_failed,
                        Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton(android.R.string.cancel, null)
            .show()
    }
}
