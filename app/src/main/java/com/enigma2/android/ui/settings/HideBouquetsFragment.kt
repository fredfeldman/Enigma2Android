package com.enigma2.android.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.enigma2.android.R
import com.enigma2.android.data.model.Bouquet
import com.enigma2.android.data.prefs.ReceiverPreferences
import com.enigma2.android.data.repository.Enigma2Repository
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HideBouquetsFragment : Fragment() {

    private val repo = Enigma2Repository()
    private lateinit var prefs: ReceiverPreferences
    private lateinit var adapter: BouquetCheckAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_hide_bouquets, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prefs = ReceiverPreferences(requireContext())

        adapter = BouquetCheckAdapter { ref, hidden ->
            val current = prefs.hiddenBouquets.toMutableList()
            if (hidden) current.add(ref) else current.remove(ref)
            prefs.hiddenBouquets = current
        }

        val rv = view.findViewById<RecyclerView>(R.id.rv_bouquet_checkboxes)
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            val bouquets = withContext(Dispatchers.IO) { repo.getAllBouquets() }
            adapter.submitList(bouquets)
        }
    }

    private inner class BouquetCheckAdapter(
        private val onToggle: (String, Boolean) -> Unit
    ) : RecyclerView.Adapter<BouquetCheckAdapter.VH>() {

        private var items: List<Bouquet> = emptyList()

        fun submitList(list: List<Bouquet>) {
            items = list
            notifyDataSetChanged()
        }

        inner class VH(view: View) : RecyclerView.ViewHolder(view) {
            val tvName: TextView = view.findViewById(R.id.tv_bouquet_check_name)
            val cbHide: CheckBox = view.findViewById(R.id.cb_hide_bouquet)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_bouquet_check, parent, false)
            return VH(view)
        }

        override fun onBindViewHolder(holder: VH, position: Int) {
            val b = items[position]
            holder.tvName.text = b.name
            holder.cbHide.isChecked = b.ref in prefs.hiddenBouquets
            holder.cbHide.setOnCheckedChangeListener { _, checked ->
                onToggle(b.ref, checked)
            }
        }

        override fun getItemCount() = items.size
    }
}
