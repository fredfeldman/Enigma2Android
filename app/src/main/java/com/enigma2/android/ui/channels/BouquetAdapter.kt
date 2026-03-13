package com.enigma2.android.ui.channels

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.enigma2.android.R
import com.enigma2.android.data.model.Bouquet

class BouquetAdapter(
    private val onBouquetSelected: (Bouquet) -> Unit
) : ListAdapter<Bouquet, BouquetAdapter.ViewHolder>(DIFF) {

    private var selectedRef: String = ""

    fun setSelectedRef(ref: String) {
        val old = currentList.indexOfFirst { it.ref == selectedRef }
        val new = currentList.indexOfFirst { it.ref == ref }
        selectedRef = ref
        if (old >= 0) notifyItemChanged(old)
        if (new >= 0) notifyItemChanged(new)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tv_bouquet_name)

        init {
            view.setOnClickListener {
                val item = getItem(bindingAdapterPosition)
                onBouquetSelected(item)
                this@BouquetAdapter.setSelectedRef(item.ref)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_bouquet, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bouquet = getItem(position)
        holder.tvName.text = bouquet.name
        holder.itemView.isSelected = bouquet.ref == selectedRef
    }

    companion object {
        private val DIFF = object : DiffUtil.ItemCallback<Bouquet>() {
            override fun areItemsTheSame(a: Bouquet, b: Bouquet) = a.ref == b.ref
            override fun areContentsTheSame(a: Bouquet, b: Bouquet) = a == b
        }
    }
}
