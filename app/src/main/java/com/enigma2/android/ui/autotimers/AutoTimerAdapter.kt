package com.enigma2.android.ui.autotimers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.enigma2.android.R
import com.enigma2.android.data.model.AutoTimer

class AutoTimerAdapter(
    private val onEdit: (AutoTimer) -> Unit,
    private val onDelete: (AutoTimer) -> Unit,
    private val onToggle: (AutoTimer, Boolean) -> Unit
) : ListAdapter<AutoTimer, AutoTimerAdapter.VH>(DIFF) {

    inner class VH(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tv_at_name)
        val tvMatch: TextView = view.findViewById(R.id.tv_at_match)
        val tvMeta: TextView = view.findViewById(R.id.tv_at_meta)
        val swEnabled: SwitchCompat = view.findViewById(R.id.switch_at_enabled)
        val btnEdit: View = view.findViewById(R.id.btn_at_edit)
        val btnDelete: View = view.findViewById(R.id.btn_at_delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_autotimer, parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val at = getItem(position)
        holder.tvName.text = at.name.ifEmpty { at.match }
        holder.tvMatch.text = "\"${at.match}\""

        val parts = mutableListOf<String>()
        if (at.serviceNames.isNotEmpty()) parts += at.serviceNames.joinToString(", ")
        if (at.from.isNotEmpty() && at.to.isNotEmpty()) parts += "${at.from}–${at.to}"
        if (at.justplay) parts += holder.itemView.context.getString(R.string.justplay_zap_only)
        holder.tvMeta.text = parts.joinToString("  •  ")
        holder.tvMeta.visibility = if (parts.isEmpty()) View.GONE else View.VISIBLE

        // Avoid firing the listener while binding
        holder.swEnabled.setOnCheckedChangeListener(null)
        holder.swEnabled.isChecked = at.enabled
        holder.swEnabled.setOnCheckedChangeListener { _, checked ->
            if (checked != at.enabled) onToggle(at, checked)
        }

        holder.btnEdit.setOnClickListener { onEdit(at) }
        holder.btnDelete.setOnClickListener { onDelete(at) }
    }

    companion object {
        private val DIFF = object : DiffUtil.ItemCallback<AutoTimer>() {
            override fun areItemsTheSame(a: AutoTimer, b: AutoTimer) = a.id == b.id
            override fun areContentsTheSame(a: AutoTimer, b: AutoTimer) = a == b
        }
    }
}
