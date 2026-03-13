package com.enigma2.android.ui.timers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.enigma2.android.R
import com.enigma2.android.data.model.Timer
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class TimerAdapter(
    private val onDelete: (Timer) -> Unit
) : ListAdapter<Timer, TimerAdapter.VH>(DIFF) {

    inner class VH(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tv_timer_name)
        val tvService: TextView = view.findViewById(R.id.tv_timer_service)
        val tvTime: TextView = view.findViewById(R.id.tv_timer_time)
        val btnDelete: View = view.findViewById(R.id.btn_timer_delete)

        init {
            btnDelete.setOnClickListener { onDelete(getItem(bindingAdapterPosition)) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_timer, parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val timer = getItem(position)
        holder.tvName.text = timer.name
        holder.tvService.text = timer.serviceName
        val fmt = SimpleDateFormat("dd MMM HH:mm", Locale.getDefault())
        val begin = fmt.format(Date(timer.beginTimestamp * 1000))
        val end = fmt.format(Date(timer.endTimestamp * 1000))
        holder.tvTime.text = "$begin – $end"
    }

    companion object {
        private val DIFF = object : DiffUtil.ItemCallback<Timer>() {
            override fun areItemsTheSame(a: Timer, b: Timer) =
                a.serviceRef == b.serviceRef && a.beginTimestamp == b.beginTimestamp
            override fun areContentsTheSame(a: Timer, b: Timer) = a == b
        }
    }
}
