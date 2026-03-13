package com.enigma2.android.ui.playlists

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.enigma2.android.R
import com.enigma2.android.data.model.RecordingPlaylist

class PlaylistAdapter(
    private val onClick: (RecordingPlaylist) -> Unit,
    private val onLongClick: (RecordingPlaylist) -> Boolean
) : ListAdapter<RecordingPlaylist, PlaylistAdapter.VH>(DIFF) {

    inner class VH(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tv_playlist_name)
        val tvCount: TextView = view.findViewById(R.id.tv_playlist_count)

        init {
            view.setOnClickListener { onClick(getItem(bindingAdapterPosition)) }
            view.setOnLongClickListener { onLongClick(getItem(bindingAdapterPosition)) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_playlist, parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val pl = getItem(position)
        holder.tvName.text = pl.name
        holder.tvCount.text = holder.itemView.context.resources.getQuantityString(
            R.plurals.playlist_entries, pl.entries.size, pl.entries.size
        )
    }

    companion object {
        val DIFF = object : DiffUtil.ItemCallback<RecordingPlaylist>() {
            override fun areItemsTheSame(a: RecordingPlaylist, b: RecordingPlaylist) = a.id == b.id
            override fun areContentsTheSame(a: RecordingPlaylist, b: RecordingPlaylist) = a == b
        }
    }
}
