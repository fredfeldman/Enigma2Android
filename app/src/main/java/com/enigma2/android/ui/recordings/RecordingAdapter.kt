package com.enigma2.android.ui.recordings

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.enigma2.android.R
import com.enigma2.android.data.model.Recording
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class RecordingAdapter(
    private val onRecordingClick: (Recording) -> Unit,
    private val onRecordingLongClick: ((Recording) -> Unit)? = null
) : ListAdapter<Recording, RecordingAdapter.ViewHolder>(DIFF) {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = view.findViewById(R.id.tv_recording_title)
        val tvChannel: TextView = view.findViewById(R.id.tv_recording_channel)
        val tvDatetime: TextView = view.findViewById(R.id.tv_recording_datetime)
        val tvDuration: TextView = view.findViewById(R.id.tv_recording_duration)

        init {
            view.setOnClickListener {
                onRecordingClick(getItem(bindingAdapterPosition))
            }
            view.setOnLongClickListener {
                onRecordingLongClick?.invoke(getItem(bindingAdapterPosition))
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recording, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val rec = getItem(position)
        holder.tvTitle.text = rec.title
        holder.tvChannel.text = rec.channelName
        val fmt = SimpleDateFormat("dd MMM yyyy HH:mm", Locale.getDefault())
        holder.tvDatetime.text = fmt.format(Date(rec.startTimestamp * 1000))
        holder.tvDuration.text = holder.itemView.context.getString(R.string.duration_minutes, rec.lengthMinutes)
    }

    companion object {
        private val DIFF = object : DiffUtil.ItemCallback<Recording>() {
            override fun areItemsTheSame(a: Recording, b: Recording) = a.filename == b.filename
            override fun areContentsTheSame(a: Recording, b: Recording) = a == b
        }
    }
}
