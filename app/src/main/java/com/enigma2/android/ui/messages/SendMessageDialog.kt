package com.enigma2.android.ui.messages

import android.app.AlertDialog
import android.content.Context
import android.text.InputType
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.enigma2.android.R
import com.enigma2.android.data.repository.Enigma2Repository
import kotlinx.coroutines.launch

object SendMessageDialog {

    private val repo = Enigma2Repository()

    fun show(context: Context, owner: LifecycleOwner) {
        val pad = (context.resources.displayMetrics.density * 16).toInt()
        val container = LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(pad, pad, pad, pad)
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
                // OpenWebif accepts type 1=info, 2=warning, 3=question, 4=error
                val typeCode = typeSpinner.selectedItemPosition + 1
                val to = timeout.text.toString().toIntOrNull() ?: 10
                owner.lifecycleScope.launch {
                    val ok = repo.sendMessageToReceiver(msg, typeCode, to)
                    Toast.makeText(context,
                        if (ok) R.string.send_message_sent else R.string.send_message_failed,
                        Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton(android.R.string.cancel, null)
            .show()
    }
}
