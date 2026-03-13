package com.enigma2.android.ui.playlists

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.enigma2.android.R
import com.enigma2.android.data.model.PlaylistEntry

class PlaylistDetailAdapter(
    private val onClick: (PlaylistEntry) -> Unit,
    private val onMoveUp: (Int) -> Unit,
    private val onMoveDown: (Int) -> Unit,
    private val onRemove: (PlaylistEntry) -> Unit
) : ListAdapter<PlaylistEntry, PlaylistDetailAdapter.VH>(DIFF) {

    inner class VH(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = view.findViewById(R.id.tv_entry_title)
        val tvChannel: TextView = view.findViewById(R.id.tv_entry_channel)
        val btnUp: View = view.findViewById(R.id.btn_entry_up)
        val btnDown: View = view.findViewById(R.id.btn_entry_down)
        val btnRemove: View = view.findViewById(R.id.btn_entry_remove)

        init {
            view.setOnClickListener { onClick(getItem(bindingAdapterPosition)) }
            btnUp.setOnClickListener { onMoveUp(bindingAdapterPosition) }
            btnDown.setOnClickListener { onMoveDown(bindingAdapterPosition) }
            btnRemove.setOnClickListener { onRemove(getItem(bindingAdapterPosition)) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_playlist_entry, parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val entry = getItem(position)
        holder.tvTitle.text = entry.title
        holder.tvChannel.text = entry.channel
    }

    companion object {
        val DIFF = object : DiffUtil.ItemCallback<PlaylistEntry>() {
            override fun areItemsTheSame(a: PlaylistEntry, b: PlaylistEntry) = a.filename == b.filename
            override fun areContentsTheSame(a: PlaylistEntry, b: PlaylistEntry) = a == b
        }
    }
}
