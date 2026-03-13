package com.enigma2.android.ui.devices

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.enigma2.android.R
import com.enigma2.android.data.model.DeviceProfile

class DeviceAdapter(
    private val onDeviceClick: (DeviceProfile) -> Unit,
    private val onDeviceLongClick: (DeviceProfile) -> Boolean
) : ListAdapter<DeviceProfile, DeviceAdapter.ViewHolder>(DIFF) {

    private var activeId: String = ""

    fun setActiveId(id: String) {
        val old = currentList.indexOfFirst { it.id == activeId }
        activeId = id
        val new = currentList.indexOfFirst { it.id == id }
        if (old >= 0) notifyItemChanged(old)
        if (new >= 0) notifyItemChanged(new)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tv_device_name)
        val tvAddress: TextView = view.findViewById(R.id.tv_device_address)
        val tvActive: TextView = view.findViewById(R.id.tv_active_indicator)

        init {
            view.setOnClickListener { onDeviceClick(getItem(bindingAdapterPosition)) }
            view.setOnLongClickListener { onDeviceLongClick(getItem(bindingAdapterPosition)) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_device, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val d = getItem(position)
        holder.tvName.text = d.name
        val scheme = if (d.useHttps) "https" else "http"
        holder.tvAddress.text = "$scheme://${d.host}:${d.port}"
        holder.tvActive.visibility = if (d.id == activeId) View.VISIBLE else View.GONE
    }

    companion object {
        private val DIFF = object : DiffUtil.ItemCallback<DeviceProfile>() {
            override fun areItemsTheSame(a: DeviceProfile, b: DeviceProfile) = a.id == b.id
            override fun areContentsTheSame(a: DeviceProfile, b: DeviceProfile) = a == b
        }
    }
}
