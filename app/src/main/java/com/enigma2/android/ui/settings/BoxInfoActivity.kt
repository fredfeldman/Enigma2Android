package com.enigma2.android.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.enigma2.android.R
import com.enigma2.android.data.repository.Enigma2Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BoxInfoActivity : AppCompatActivity() {

    private val repo = Enigma2Repository()
    private lateinit var rv: RecyclerView
    private lateinit var progress: ProgressBar
    private lateinit var tvEmpty: TextView
    private val adapter = InfoAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boxinfo)

        findViewById<Toolbar>(R.id.toolbar_boxinfo).setNavigationOnClickListener { finish() }

        rv = findViewById(R.id.rv_boxinfo)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter
        progress = findViewById(R.id.progress_boxinfo)
        tvEmpty = findViewById(R.id.tv_boxinfo_empty)

        load()
    }

    private fun load() {
        progress.visibility = View.VISIBLE
        tvEmpty.visibility = View.GONE
        rv.visibility = View.GONE
        lifecycleScope.launch {
            val info = withContext(Dispatchers.IO) { repo.getBoxInfo() }
            adapter.submit(info)
            progress.visibility = View.GONE
            val empty = info.isEmpty()
            tvEmpty.visibility = if (empty) View.VISIBLE else View.GONE
            rv.visibility = if (empty) View.GONE else View.VISIBLE
        }
    }

    private class InfoAdapter : RecyclerView.Adapter<InfoAdapter.VH>() {
        private val items = mutableListOf<Pair<String, String>>()

        fun submit(list: List<Pair<String, String>>) {
            items.clear()
            items.addAll(list)
            notifyDataSetChanged()
        }

        class VH(view: View) : RecyclerView.ViewHolder(view) {
            val key: TextView = view.findViewById(R.id.tv_boxinfo_key)
            val value: TextView = view.findViewById(R.id.tv_boxinfo_value)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
            val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_boxinfo, parent, false)
            return VH(v)
        }

        override fun onBindViewHolder(holder: VH, position: Int) {
            val (k, v) = items[position]
            holder.key.text = k
            holder.value.text = v.ifEmpty { "—" }
        }

        override fun getItemCount() = items.size
    }
}
