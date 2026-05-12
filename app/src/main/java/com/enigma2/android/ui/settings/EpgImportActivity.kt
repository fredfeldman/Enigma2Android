package com.enigma2.android.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.enigma2.android.R
import com.enigma2.android.data.repository.Enigma2Repository
import com.enigma2.android.data.repository.EpgImportSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EpgImportActivity : AppCompatActivity() {

    private val repo = Enigma2Repository()
    private lateinit var tvStatus: TextView
    private lateinit var tvEmpty: TextView
    private lateinit var rv: RecyclerView
    private lateinit var progress: ProgressBar
    private lateinit var btnSave: Button
    private val sourcesAdapter = SourcesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_epgimport)

        findViewById<Toolbar>(R.id.toolbar_epgimport).setNavigationOnClickListener { finish() }

        tvStatus = findViewById(R.id.tv_epgimport_status)
        tvEmpty = findViewById(R.id.tv_epgimport_empty)
        progress = findViewById(R.id.progress_epgimport)
        rv = findViewById(R.id.rv_epgimport_sources)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = sourcesAdapter
        btnSave = findViewById(R.id.btn_epgimport_save_sources)

        findViewById<Button>(R.id.btn_epgimport_refresh).setOnClickListener { loadAll() }
        findViewById<Button>(R.id.btn_epgimport_run).setOnClickListener { runImport() }
        btnSave.setOnClickListener { saveEnabledSources() }

        loadAll()
    }

    private fun loadAll() {
        progress.visibility = View.VISIBLE
        tvEmpty.visibility = View.GONE
        lifecycleScope.launch {
            val status = withContext(Dispatchers.IO) { repo.getEpgImportStatus() }
            tvStatus.text = status?.takeIf { it.isNotBlank() }
                ?: getString(R.string.epg_import_status_unknown)

            val sources = withContext(Dispatchers.IO) { repo.getEpgImportSources() }
            sourcesAdapter.submit(sources)
            progress.visibility = View.GONE
            val empty = sources.isEmpty()
            tvEmpty.visibility = if (empty) View.VISIBLE else View.GONE
            rv.visibility = if (empty) View.GONE else View.VISIBLE
            btnSave.visibility = if (empty) View.GONE else View.VISIBLE
        }
    }

    private fun runImport() {
        Toast.makeText(this, R.string.epg_import_starting, Toast.LENGTH_SHORT).show()
        lifecycleScope.launch {
            val ok = withContext(Dispatchers.IO) { repo.runEpgImport() }
            val msg = if (ok) R.string.epg_import_started else R.string.epg_import_failed
            Toast.makeText(this@EpgImportActivity, msg, Toast.LENGTH_SHORT).show()
            loadAll()
        }
    }

    private fun saveEnabledSources() {
        val enabled = sourcesAdapter.enabledDescriptions()
        Toast.makeText(this, R.string.saving_ellipsis, Toast.LENGTH_SHORT).show()
        lifecycleScope.launch {
            val ok = withContext(Dispatchers.IO) { repo.saveEpgImportEnabledSources(enabled) }
            val msg = if (ok) R.string.sources_saved else R.string.sources_save_failed
            Toast.makeText(this@EpgImportActivity, msg, Toast.LENGTH_SHORT).show()
            if (ok) loadAll()
        }
    }

    private class SourcesAdapter : RecyclerView.Adapter<SourcesAdapter.VH>() {
        private val items = mutableListOf<EpgImportSource>()

        fun submit(list: List<EpgImportSource>) {
            items.clear()
            items.addAll(list)
            notifyDataSetChanged()
        }

        fun enabledDescriptions(): List<String> =
            items.filter { it.enabled }.map { it.description }

        class VH(val cb: CheckBox) : RecyclerView.ViewHolder(cb)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
            val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_epgimport_source, parent, false) as CheckBox
            return VH(v)
        }

        override fun onBindViewHolder(holder: VH, position: Int) {
            val item = items[position]
            holder.cb.setOnCheckedChangeListener(null)
            holder.cb.text = item.description
            holder.cb.isChecked = item.enabled
            holder.cb.setOnCheckedChangeListener { _, checked ->
                items[position] = items[position].copy(enabled = checked)
            }
        }

        override fun getItemCount() = items.size
    }
}
