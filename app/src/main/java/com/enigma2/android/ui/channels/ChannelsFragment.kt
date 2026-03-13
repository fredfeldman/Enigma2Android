package com.enigma2.android.ui.channels

import android.app.AlertDialog
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.enigma2.android.R
import com.enigma2.android.data.model.Service
import com.enigma2.android.data.prefs.ReceiverPreferences
import com.enigma2.android.ui.epg.EpgFragment
import com.enigma2.android.ui.main.MainActivity
import com.enigma2.android.ui.player.PlayerActivity
import com.enigma2.android.ui.recordings.RecordingsFragment
import com.enigma2.android.ui.settings.SettingsActivity
import com.enigma2.android.ui.timers.TimersFragment
import com.enigma2.android.ui.viewmodel.ChannelViewModel
import com.enigma2.android.utils.WakeOnLan
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ChannelsFragment : Fragment() {

    private val viewModel: ChannelViewModel by activityViewModels()
    private lateinit var prefs: ReceiverPreferences

    private lateinit var rvBouquets: RecyclerView
    private lateinit var rvChannels: RecyclerView
    private lateinit var etFilter: EditText
    private lateinit var progressBar: ProgressBar
    private lateinit var tvError: TextView

    private lateinit var bouquetAdapter: BouquetAdapter
    private lateinit var channelAdapter: ChannelAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_channels, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prefs = ReceiverPreferences(requireContext())

        rvBouquets = view.findViewById(R.id.rv_bouquets)
        rvChannels = view.findViewById(R.id.rv_channels)
        etFilter = view.findViewById(R.id.et_filter)
        progressBar = view.findViewById(R.id.progress_bar)
        tvError = view.findViewById(R.id.tv_error)

        bouquetAdapter = BouquetAdapter { bouquet ->
            viewModel.selectBouquet(bouquet)
        }

        channelAdapter = ChannelAdapter(
            prefs = prefs,
            onChannelClick = { service -> openPlayer(service) },
            onChannelLongClick = { service -> showChannelMenu(service); true }
        )

        rvBouquets.layoutManager = LinearLayoutManager(requireContext())
        rvBouquets.adapter = bouquetAdapter

        rvChannels.layoutManager = LinearLayoutManager(requireContext())
        rvChannels.adapter = channelAdapter

        etFilter.addTextChangedListener { text ->
            viewModel.setFilter(text?.toString() ?: "")
        }

        setupToolbarButtons(view)
        observeViewModel()

        viewModel.loadBouquets()
    }

    private fun setupToolbarButtons(view: View) {
        view.findViewById<View>(R.id.btn_switch_device)?.setOnClickListener {
            (activity as? MainActivity)?.showDevicePicker()
        }
        view.findViewById<View>(R.id.btn_epg)?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_container, EpgFragment())
                .addToBackStack(null)
                .commit()
        }
        view.findViewById<View>(R.id.btn_recordings)?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_container, RecordingsFragment())
                .addToBackStack(null)
                .commit()
        }
        view.findViewById<View>(R.id.btn_settings)?.setOnClickListener {
            startActivity(Intent(requireContext(), SettingsActivity::class.java))
        }
        view.findViewById<View>(R.id.btn_timers)?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_container, TimersFragment())
                .addToBackStack(null)
                .commit()
        }
        view.findViewById<View>(R.id.btn_wol)?.setOnClickListener {
            sendWakeOnLan()
        }
        view.findViewById<View>(R.id.btn_screenshot)?.setOnClickListener {
            takeScreenshot()
        }
    }

    private fun observeViewModel() {
        viewModel.bouquets.observe(viewLifecycleOwner) { bouquets ->
            bouquetAdapter.submitList(bouquets)
        }

        viewModel.filteredChannels.observe(viewLifecycleOwner) { channels ->
            channelAdapter.submitList(channels)
        }

        viewModel.selectedBouquet.observe(viewLifecycleOwner) { bouquet ->
            bouquet?.let { bouquetAdapter.setSelectedRef(it.ref) }
        }

        viewModel.nowNextMap.observe(viewLifecycleOwner) { events ->
            channelAdapter.updateNowNext(events)
        }

        viewModel.recordingRefs.observe(viewLifecycleOwner) { refs ->
            channelAdapter.updateRecordingRefs(refs)
        }

        viewModel.favorites.observe(viewLifecycleOwner) { favs ->
            channelAdapter.updateFavorites(favs)
        }

        viewModel.isLoading.observe(viewLifecycleOwner) { loading ->
            progressBar.visibility = if (loading) View.VISIBLE else View.GONE
        }

        viewModel.error.observe(viewLifecycleOwner) { error ->
            if (error != null) {
                tvError.text = error
                tvError.visibility = View.VISIBLE
            } else {
                tvError.visibility = View.GONE
            }
        }
    }

    private fun openPlayer(service: Service) {
        val channels = viewModel.filteredChannels.value ?: return
        val index = channels.indexOfFirst { it.ref == service.ref }
        val scheme = if (prefs.useHttps) "https" else "http"
        val streamUrl = "$scheme://${prefs.host}:8001/${service.ref}"
        prefs.lastChannelRef = service.ref
        prefs.lastChannelName = service.name
        val intent = Intent(requireContext(), PlayerActivity::class.java).apply {
            putExtra(PlayerActivity.EXTRA_STREAM_URL, streamUrl)
            putExtra(PlayerActivity.EXTRA_CHANNEL_NAME, service.name)
            putExtra(PlayerActivity.EXTRA_SERVICE_REF, service.ref)
            putExtra(PlayerActivity.EXTRA_CHANNEL_INDEX, index)
            putStringArrayListExtra(
                PlayerActivity.EXTRA_CHANNEL_REFS,
                ArrayList(channels.map { it.ref })
            )
            putStringArrayListExtra(
                PlayerActivity.EXTRA_CHANNEL_NAMES,
                ArrayList(channels.map { it.name })
            )
        }
        startActivity(intent)
    }

    private fun showChannelMenu(service: Service) {
        val isFav = service.ref in (viewModel.favorites.value ?: emptyList())
        val favLabel = if (isFav) getString(R.string.remove_favorite) else getString(R.string.add_favorite)
        val options = arrayOf(
            getString(R.string.play),
            favLabel,
            getString(R.string.epg_info)
        )
        AlertDialog.Builder(requireContext())
            .setTitle(service.name)
            .setItems(options) { _, which ->
                when (which) {
                    0 -> openPlayer(service)
                    1 -> viewModel.toggleFavorite(service.ref)
                    2 -> showEpgInfo(service)
                }
            }
            .show()
    }

    private fun showEpgInfo(service: Service) {
        val nn = viewModel.nowNextMap.value?.find { it.sref == service.ref } ?: return
        AlertDialog.Builder(requireContext())
            .setTitle(service.name)
            .setMessage("Now: ${nn.nowTitle}\n\nNext: ${nn.nextTitle}")
            .setPositiveButton(android.R.string.ok, null)
            .show()
    }

    private fun sendWakeOnLan() {
        val mac = prefs.getActiveProfile()?.macAddress ?: ""
        if (mac.isBlank()) {
            Toast.makeText(requireContext(), R.string.no_mac_address, Toast.LENGTH_SHORT).show()
            return
        }
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
            WakeOnLan.send(mac)
            withContext(Dispatchers.Main) {
                Toast.makeText(requireContext(), R.string.wol_sent, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun takeScreenshot() {
        val repo = com.enigma2.android.data.repository.Enigma2Repository()
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
            val bytes = repo.getScreenshot()
            withContext(Dispatchers.Main) {
                if (bytes != null) {
                    val bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
                    val iv = ImageView(requireContext())
                    iv.setImageBitmap(bmp)
                    AlertDialog.Builder(requireContext())
                        .setTitle(R.string.screenshot)
                        .setView(iv)
                        .setPositiveButton(android.R.string.ok, null)
                        .show()
                } else {
                    Toast.makeText(requireContext(), R.string.screenshot_failed, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
