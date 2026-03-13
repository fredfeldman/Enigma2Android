package com.enigma2.android.ui.epg

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.enigma2.android.R
import com.enigma2.android.data.model.EpgEvent
import com.enigma2.android.data.prefs.ReceiverPreferences
import com.enigma2.android.data.repository.Enigma2Repository
import com.enigma2.android.ui.player.PlayerActivity
import com.enigma2.android.ui.viewmodel.ChannelViewModel
import com.enigma2.android.ui.viewmodel.EpgViewModel
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.concurrent.TimeUnit

class EpgFragment : Fragment() {

    private val channelViewModel: ChannelViewModel by activityViewModels()
    private val epgViewModel: EpgViewModel by activityViewModels()
    private val repo = Enigma2Repository()
    private lateinit var prefs: ReceiverPreferences

    private lateinit var rvChannelNames: RecyclerView
    private lateinit var epgGrid: EpgGridView
    private lateinit var timeRuler: EpgTimeRulerView
    private lateinit var hScrollView: HorizontalScrollView
    private lateinit var tvInfoBar: TextView
    private lateinit var tvSelectedEvent: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_epg, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prefs = ReceiverPreferences(requireContext())

        rvChannelNames = view.findViewById(R.id.rv_channel_names)
        epgGrid = view.findViewById(R.id.epg_grid)
        timeRuler = view.findViewById(R.id.epg_time_ruler)
        hScrollView = view.findViewById(R.id.epg_h_scroll)
        tvInfoBar = view.findViewById(R.id.tv_epg_info)
        tvSelectedEvent = view.findViewById(R.id.tv_selected_event)

        view.findViewById<View>(R.id.btn_back)?.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        view.findViewById<View>(R.id.btn_epg_search)?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_container, EpgSearchFragment())
                .addToBackStack(null)
                .commit()
        }

        epgGrid.onEventSelected = { event ->
            showEventInfo(event)
        }
        epgGrid.onEventDoubleClicked = { event ->
            playEvent(event)
        }
        epgGrid.onEventLongPressed = { event ->
            showRecordDialog(event)
        }

        // Sync horizontal scroll between ruler and grid
        hScrollView.setOnScrollChangeListener { _, scrollX, _, _, _ ->
            timeRuler.scrollTo(scrollX, 0)
            syncChannelNameScroll(scrollX)
        }

        setupChannelNamesAdapter()
        observeViewModel()

        val bouquet = channelViewModel.selectedBouquet.value
        if (bouquet != null) {
            epgViewModel.loadMultiEpg(bouquet.ref)
        }
    }

    private fun setupChannelNamesAdapter() {
        rvChannelNames.layoutManager = LinearLayoutManager(requireContext())
        rvChannelNames.adapter = ChannelNamesAdapter()
    }

    private fun observeViewModel() {
        epgViewModel.epgByService.observe(viewLifecycleOwner) { eventsMap ->
            val serviceRefs = channelViewModel.filteredChannels.value?.map { it.ref } ?: return@observe
            val allEvents = serviceRefs.flatMap { eventsMap[it] ?: emptyList() }
            val startMs = computeStartTime()
            epgGrid.startTimeMs = startMs
            timeRuler.startTimeMs = startMs
            epgGrid.setEvents(allEvents, serviceRefs)
            (rvChannelNames.adapter as? ChannelNamesAdapter)?.updateChannels(
                channelViewModel.filteredChannels.value?.map { it.name } ?: emptyList()
            )
        }

        epgViewModel.recordingTimerIds.observe(viewLifecycleOwner) { ids ->
            epgGrid.setRecordingIds(ids)
        }
    }

    private fun computeStartTime(): Long {
        val cal = Calendar.getInstance()
        cal.set(Calendar.MINUTE, if (cal.get(Calendar.MINUTE) < 30) 0 else 30)
        cal.set(Calendar.SECOND, 0)
        cal.set(Calendar.MILLISECOND, 0)
        return cal.timeInMillis - TimeUnit.HOURS.toMillis(1)
    }

    private fun showEventInfo(event: EpgEvent) {
        val fmt = SimpleDateFormat("HH:mm", Locale.getDefault())
        val begin = fmt.format(Date(event.beginTimestamp * 1000))
        val end = fmt.format(Date((event.beginTimestamp + event.durationSeconds) * 1000))
        tvSelectedEvent.text = "$begin-$end  ${event.title}"
        tvInfoBar.text = event.shortDesc
    }

    private fun playEvent(event: EpgEvent) {
        val nowSec = System.currentTimeMillis() / 1000
        if (nowSec < event.beginTimestamp || nowSec >= event.beginTimestamp + event.durationSeconds) {
            Toast.makeText(requireContext(), R.string.event_not_airing, Toast.LENGTH_SHORT).show()
            return
        }
        val scheme = if (prefs.useHttps) "https" else "http"
        val streamUrl = "$scheme://${prefs.host}:8001/${event.sref}"
        startActivity(
            Intent(requireContext(), PlayerActivity::class.java).apply {
                putExtra(PlayerActivity.EXTRA_STREAM_URL, streamUrl)
                putExtra(PlayerActivity.EXTRA_SERVICE_REF, event.sref)
            }
        )
    }

    private fun showRecordDialog(event: EpgEvent) {
        AlertDialog.Builder(requireContext())
            .setTitle(event.title)
            .setMessage(getString(R.string.record_confirm, event.title))
            .setPositiveButton(R.string.record) { _, _ -> scheduleRecording(event) }
            .setNegativeButton(android.R.string.cancel, null)
            .show()
    }

    private fun scheduleRecording(event: EpgEvent) {
        viewLifecycleOwner.lifecycleScope.launch {
            val ok = withContext(Dispatchers.IO) {
                repo.addTimer(
                    sRef = event.sref,
                    begin = event.beginTimestamp,
                    end = event.beginTimestamp + event.durationSeconds,
                    name = event.title,
                    description = event.shortDesc
                )
            }
            val msgRes = if (ok) R.string.timer_added else R.string.timer_failed
            Toast.makeText(requireContext(), msgRes, Toast.LENGTH_SHORT).show()
        }
    }

    private fun syncChannelNameScroll(scrollX: Int) {
        // Channel names scroll vertically synchronized with grid via RecyclerView; no-op here
    }

    inner class ChannelNamesAdapter : RecyclerView.Adapter<ChannelNamesAdapter.VH>() {
        private var names: List<String> = emptyList()
        private val rowHeightPx: Int by lazy {
            resources.getDimensionPixelSize(R.dimen.epg_row_height)
        }

        fun updateChannels(list: List<String>) {
            val oldSize = names.size
            names = list
            val newSize = names.size
            if (oldSize == newSize) {
                notifyItemRangeChanged(0, newSize)
            } else {
                notifyItemRangeChanged(0, minOf(oldSize, newSize))
                if (newSize > oldSize) notifyItemRangeInserted(oldSize, newSize - oldSize)
                else notifyItemRangeRemoved(newSize, oldSize - newSize)
            }
        }

        inner class VH(view: View) : RecyclerView.ViewHolder(view) {
            val tv: TextView = view.findViewById(R.id.tv_channel_name_epg)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_epg_channel_name, parent, false)
            view.layoutParams = ViewGroup.LayoutParams(
                resources.getDimensionPixelSize(R.dimen.epg_channel_col_width),
                rowHeightPx
            )
            return VH(view)
        }

        override fun onBindViewHolder(holder: VH, position: Int) {
            holder.tv.text = names[position]
        }

        override fun getItemCount() = names.size
    }
}
