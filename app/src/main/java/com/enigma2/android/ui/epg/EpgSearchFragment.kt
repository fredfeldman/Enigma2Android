package com.enigma2.android.ui.epg

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.SearchView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.enigma2.android.R
import com.enigma2.android.data.model.EpgEvent
import com.enigma2.android.data.repository.Enigma2Repository
import com.enigma2.android.data.prefs.ReceiverPreferences
import com.enigma2.android.ui.player.PlayerActivity
import com.enigma2.android.ui.viewmodel.ChannelViewModel
import android.content.Intent
import android.view.inputmethod.InputMethodManager
import android.content.Context
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class EpgSearchFragment : Fragment() {

    private val repo = Enigma2Repository()
    private val channelViewModel: ChannelViewModel by activityViewModels()
    private lateinit var prefs: ReceiverPreferences
    private lateinit var searchAdapter: SearchResultAdapter

    private lateinit var rv: RecyclerView
    private lateinit var progress: ProgressBar
    private lateinit var tvEmpty: TextView

    private var searchJob: Job? = null
    private var lastQuery: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_epg_search, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prefs = ReceiverPreferences(requireContext())

        searchAdapter = SearchResultAdapter { event ->
            val nowSec = System.currentTimeMillis() / 1000
            if (nowSec >= event.beginTimestamp &&
                nowSec < event.beginTimestamp + event.durationSeconds
            ) {
                val scheme = if (prefs.useHttps) "https" else "http"
                val streamUrl = "$scheme://${prefs.host}:8001/${event.sref}"
                startActivity(
                    Intent(requireContext(), PlayerActivity::class.java).apply {
                        putExtra(PlayerActivity.EXTRA_STREAM_URL, streamUrl)
                        putExtra(PlayerActivity.EXTRA_SERVICE_REF, event.sref)
                    }
                )
            } else {
                Toast.makeText(requireContext(), R.string.event_not_airing, Toast.LENGTH_SHORT).show()
            }
        }

        rv = view.findViewById(R.id.rv_search_results)
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = searchAdapter

        progress = view.findViewById(R.id.progress_search)
        tvEmpty = view.findViewById(R.id.tv_search_empty)
        tvEmpty.text = getString(R.string.search_hint)
        tvEmpty.visibility = View.VISIBLE

        view.findViewById<View>(R.id.btn_back)?.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        // Refresh channel-name lookup when channel list changes
        channelViewModel.filteredChannels.observe(viewLifecycleOwner) { channels ->
            val map = channels?.associate { it.ref to it.name } ?: emptyMap()
            searchAdapter.updateChannelNames(map)
        }

        val searchView = view.findViewById<SearchView>(R.id.search_view)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                performSearch(query)
                searchView.clearFocus()
                val imm = requireContext()
                    .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(searchView.windowToken, 0)
                return true
            }

            override fun onQueryTextChange(text: String): Boolean {
                searchJob?.cancel()
                if (text.length < 3) {
                    searchAdapter.submitList(emptyList())
                    progress.visibility = View.GONE
                    tvEmpty.text = getString(R.string.search_hint)
                    tvEmpty.visibility = View.VISIBLE
                    rv.visibility = View.GONE
                    return true
                }
                searchJob = viewLifecycleOwner.lifecycleScope.launch {
                    delay(400)
                    performSearch(text)
                }
                return true
            }
        })
    }

    private fun performSearch(query: String) {
        lastQuery = query
        progress.visibility = View.VISIBLE
        tvEmpty.visibility = View.GONE
        rv.visibility = View.GONE
        viewLifecycleOwner.lifecycleScope.launch {
            val results = withContext(Dispatchers.IO) { repo.searchEpg(query) }
            // Discard if a newer search has started
            if (query != lastQuery) return@launch
            searchAdapter.submitList(results)
            progress.visibility = View.GONE
            val isEmpty = results.isEmpty()
            if (isEmpty) {
                tvEmpty.text = getString(R.string.no_search_results)
                tvEmpty.visibility = View.VISIBLE
                rv.visibility = View.GONE
            } else {
                tvEmpty.visibility = View.GONE
                rv.visibility = View.VISIBLE
            }
        }
    }

    private inner class SearchResultAdapter(
        private val onEventClick: (EpgEvent) -> Unit
    ) : ListAdapter<EpgEvent, SearchResultAdapter.VH>(DIFF) {

        private var channelNames: Map<String, String> = emptyMap()

        fun updateChannelNames(map: Map<String, String>) {
            channelNames = map
            notifyDataSetChanged()
        }

        inner class VH(view: View) : RecyclerView.ViewHolder(view) {
            val tvTitle: TextView = view.findViewById(R.id.tv_event_title)
            val tvChannel: TextView = view.findViewById(R.id.tv_event_channel)
            val tvTime: TextView = view.findViewById(R.id.tv_event_time)

            init {
                view.setOnClickListener { onEventClick(getItem(bindingAdapterPosition)) }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_epg_search_result, parent, false)
            return VH(view)
        }

        override fun onBindViewHolder(holder: VH, position: Int) {
            val event = getItem(position)
            holder.tvTitle.text = event.title
            holder.tvChannel.text = channelNames[event.sref] ?: event.sref
            val fmt = SimpleDateFormat("EEE dd MMM HH:mm", Locale.getDefault())
            holder.tvTime.text = fmt.format(Date(event.beginTimestamp * 1000))
        }

        val DIFF = object : DiffUtil.ItemCallback<EpgEvent>() {
            override fun areItemsTheSame(a: EpgEvent, b: EpgEvent) = a.id == b.id
            override fun areContentsTheSame(a: EpgEvent, b: EpgEvent) = a == b
        }
    }

    companion object {
        private val DIFF = object : DiffUtil.ItemCallback<EpgEvent>() {
            override fun areItemsTheSame(a: EpgEvent, b: EpgEvent) = a.id == b.id
            override fun areContentsTheSame(a: EpgEvent, b: EpgEvent) = a == b
        }
    }
}
