package com.enigma2.android.ui.receiversettings

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.enigma2.android.R
import com.enigma2.android.data.repository.Enigma2Repository
import kotlinx.coroutines.launch

class LogViewerFragment : Fragment() {
    private val repo = Enigma2Repository()
    private var fullLog: String = ""
    private lateinit var tv: TextView
    private lateinit var et: EditText

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, s: Bundle?): View {
        return inflater.inflate(R.layout.fragment_log_viewer, container, false)
    }

    override fun onViewCreated(view: View, s: Bundle?) {
        tv = view.findViewById(R.id.tv_log)
        et = view.findViewById(R.id.et_log_filter)
        view.findViewById<Button>(R.id.btn_log_share).setOnClickListener { share() }
        et.addTextChangedListener(object : android.text.TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, a: Int, b: Int, c: Int) {}
            override fun afterTextChanged(s: android.text.Editable?) { applyFilter() }
            override fun onTextChanged(s: CharSequence?, a: Int, b: Int, c: Int) {}
        })
        tv.text = getString(R.string.recv_status_loading)
        load()
    }

    private fun load() {
        lifecycleScope.launch {
            val raw = repo.getReceiverLogRaw()
            fullLog = raw?.takeIf { it.isNotBlank() } ?: getString(R.string.recv_log_empty)
            applyFilter()
        }
    }

    private fun applyFilter() {
        val q = et.text?.toString()?.trim().orEmpty()
        tv.text = if (q.isEmpty()) fullLog
        else fullLog.lineSequence().filter { it.contains(q, ignoreCase = true) }.joinToString("\n")
    }

    private fun share() {
        val text = tv.text?.toString().orEmpty()
        if (text.isBlank()) {
            Toast.makeText(context, R.string.recv_log_empty, Toast.LENGTH_SHORT).show(); return
        }
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_SUBJECT, getString(R.string.recv_log_share_subject))
            putExtra(Intent.EXTRA_TEXT, text)
        }
        startActivity(Intent.createChooser(intent, getString(R.string.recv_log_share)))
    }
}
