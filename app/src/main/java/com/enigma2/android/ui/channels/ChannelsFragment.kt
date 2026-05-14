package com.enigma2.android.ui.channels

import android.app.AlertDialog
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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
import com.enigma2.android.ui.autotimers.AutoTimersFragment
import com.enigma2.android.ui.timers.TimersFragment
import com.enigma2.android.ui.viewmodel.ChannelViewModel
import com.enigma2.android.utils.WakeOnLan
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
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
    private lateinit var btnRetry: Button
    private lateinit var tvEmpty: TextView

    private lateinit var bouquetAdapter: BouquetAdapter
    private lateinit var channelAdapter: ChannelAdapter

    private var filterJob: Job? = null

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
        btnRetry = view.findViewById(R.id.btn_retry)
        tvEmpty = view.findViewById(R.id.tv_empty)
        btnRetry.setOnClickListener { viewModel.loadBouquets() }

        val swipe = view.findViewById<androidx.swiperefreshlayout.widget.SwipeRefreshLayout>(R.id.swipe_channels)
        swipe.setOnRefreshListener {
            viewModel.loadBouquets()
            swipe.isRefreshing = false
        }

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
            filterJob?.cancel()
            filterJob = viewLifecycleOwner.lifecycleScope.launch {
                delay(300)
                viewModel.setFilter(text?.toString() ?: "")
            }
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
        view.findViewById<View>(R.id.btn_autotimers)?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_container, AutoTimersFragment())
                .addToBackStack(null)
                .commit()
        }
        view.findViewById<View>(R.id.btn_wol)?.setOnClickListener {
            sendWakeOnLan()
        }
        view.findViewById<View>(R.id.btn_screenshot)?.setOnClickListener {
            takeScreenshot()
        }
        view.findViewById<View>(R.id.btn_remote)?.setOnClickListener {
            startActivity(Intent(requireContext(),
                com.enigma2.android.ui.remote.RemoteControlActivity::class.java))
        }
        view.findViewById<View>(R.id.btn_message)?.setOnClickListener {
            com.enigma2.android.ui.messages.SendMessageDialog.show(requireContext(), viewLifecycleOwner)
        }
    }

    private fun observeViewModel() {
        viewModel.bouquets.observe(viewLifecycleOwner) { bouquets ->
            bouquetAdapter.submitList(bouquets)
        }

        viewModel.filteredChannels.observe(viewLifecycleOwner) { channels ->
            channelAdapter.submitList(channels)
            updateEmptyState(channels)
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
                btnRetry.visibility = View.VISIBLE
            } else {
                tvError.visibility = View.GONE
                btnRetry.visibility = View.GONE
            }
        }
    }

    private fun updateEmptyState(channels: List<Service>?) {
        val isEmpty = channels.isNullOrEmpty()
        val hasFilter = etFilter.text?.isNotBlank() == true
        val hasBouquetSelected = viewModel.selectedBouquet.value != null
        if (isEmpty && (hasFilter || hasBouquetSelected)) {
            tvEmpty.text = if (hasFilter) {
                getString(R.string.no_channels_match_filter)
            } else {
                getString(R.string.no_channels)
            }
            tvEmpty.visibility = View.VISIBLE
            rvChannels.visibility = View.GONE
        } else {
            tvEmpty.visibility = View.GONE
            rvChannels.visibility = View.VISIBLE
        }
    }

    private fun openPlayer(service: Service) {
        val channels = viewModel.filteredChannels.value ?: return

        val action = prefs.channelTapAction
        val shouldZap = action == ReceiverPreferences.VALUE_TAP_ZAP ||
                action == ReceiverPreferences.VALUE_TAP_BOTH
        val shouldStream = action == ReceiverPreferences.VALUE_TAP_STREAM ||
                action == ReceiverPreferences.VALUE_TAP_BOTH

        if (shouldZap) {
            val sref = service.ref
            val sname = service.name
            viewLifecycleOwner.lifecycleScope.launch {
                val ok = withContext(Dispatchers.IO) {
                    try { com.enigma2.android.data.repository.Enigma2Repository().zapToService(sref) }
                    catch (e: Exception) { false }
                }
                val msg = if (ok) getString(R.string.zapped_to, sname)
                          else getString(R.string.zap_failed)
                Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
            }
        }

        if (!shouldStream) {
            prefs.lastChannelRef = service.ref
            prefs.lastChannelName = service.name
            return
        }

        val index = channels.indexOfFirst { it.ref == service.ref }
        val scheme = if (prefs.useHttps) "https" else "http"
        val streamUrl = "$scheme://${prefs.host}:8001/${service.ref}"
        prefs.lastChannelRef = service.ref
        prefs.lastChannelName = service.name

        // v1.2.0: try external player when the user has selected one
        if (com.enigma2.android.ui.player.ExternalPlayerLauncher
                .launchExternalIfPreferred(requireContext(), streamUrl, service.name, prefs)) {
            return
        }

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
        val otherProfiles = prefs.deviceProfiles.filter { it.id != prefs.activeDeviceId }
        val baseOptions = mutableListOf(
            getString(R.string.play),
            favLabel,
            getString(R.string.epg_info),
            getString(R.string.epg_export_title)
        )
        if (otherProfiles.isNotEmpty()) baseOptions += getString(R.string.zap_on_other)
        val options = baseOptions.toTypedArray()
        AlertDialog.Builder(requireContext())
            .setTitle(service.name)
            .setItems(options) { _, which ->
                when (which) {
                    0 -> openPlayer(service)
                    1 -> viewModel.toggleFavorite(service.ref)
                    2 -> showEpgInfo(service)
                    3 -> exportEpgForChannel(service)
                    4 -> showZapElsewhereDialog(service, otherProfiles)
                }
            }
            .show()
    }

    private fun showZapElsewhereDialog(
        service: Service,
        profiles: List<com.enigma2.android.data.model.DeviceProfile>
    ) {
        if (profiles.isEmpty()) return
        val labels = profiles.map { it.name.ifBlank { it.host } }.toTypedArray()
        AlertDialog.Builder(requireContext())
            .setTitle(R.string.zap_on_other)
            .setItems(labels) { _, idx ->
                val target = profiles[idx]
                val ctx = requireContext()
                Toast.makeText(ctx, getString(R.string.zap_on_starting, labels[idx]),
                    Toast.LENGTH_SHORT).show()
                viewLifecycleOwner.lifecycleScope.launch {
                    val ok = withContext(kotlinx.coroutines.Dispatchers.IO) {
                        com.enigma2.android.data.repository.RemoteReceiverApi
                            .zap(target, service.ref)
                    }
                    Toast.makeText(ctx,
                        if (ok) getString(R.string.zap_on_ok, labels[idx])
                        else getString(R.string.zap_on_failed, labels[idx]),
                        Toast.LENGTH_SHORT).show()
                }
            }
            .show()
    }

    private fun exportEpgForChannel(service: Service) {
        val ctx = requireContext()
        Toast.makeText(ctx, R.string.epg_export_running, Toast.LENGTH_SHORT).show()
        viewLifecycleOwner.lifecycleScope.launch {
            val repo = com.enigma2.android.data.repository.Enigma2Repository()
            val events = try { repo.getEpgForService(service.ref) } catch (_: Exception) { emptyList() }
            if (events.isEmpty()) {
                Toast.makeText(ctx, R.string.epg_export_empty, Toast.LENGTH_SHORT).show()
                return@launch
            }
            val safeName = service.name.replace(Regex("[^A-Za-z0-9._-]"), "_").take(40)
            val ts = java.text.SimpleDateFormat("yyyyMMdd_HHmmss", java.util.Locale.US)
                .format(java.util.Date())
            val baseName = "epg_${safeName}_$ts"

            val xmlPath = com.enigma2.android.util.DownloadsWriter.writeText(
                ctx, "$baseName.xml", "application/xml",
                com.enigma2.android.util.XmltvWriter.write(service.ref, service.name, events)
            )
            val jsonPath = com.enigma2.android.util.DownloadsWriter.writeText(
                ctx, "$baseName.json", "application/json",
                com.google.gson.Gson().toJson(events)
            )
            val msg = if (xmlPath != null || jsonPath != null) {
                getString(R.string.epg_export_done, xmlPath ?: jsonPath ?: "")
            } else getString(R.string.epg_export_failed)
            Toast.makeText(ctx, msg, Toast.LENGTH_LONG).show()
        }
    }

    private fun showEpgInfo(service: Service) {
        val nn = viewModel.nowNextMap.value?.find { it.serviceRef == service.ref } ?: return
        val nowTitle = nn.nowEvent?.title ?: ""
        val nextTitle = nn.nextEvent?.title ?: ""
        AlertDialog.Builder(requireContext())
            .setTitle(service.name)
            .setMessage(getString(R.string.now_next_message, nowTitle, nextTitle))
            .setPositiveButton(android.R.string.ok, null)
            .show()
    }

    private fun sendWakeOnLan() {
        val mac = prefs.getActiveProfile()?.macAddress ?: ""
        if (mac.isBlank()) {
            Toast.makeText(requireContext(), R.string.no_mac_address, Toast.LENGTH_SHORT).show()
            return
        }
        Toast.makeText(requireContext(), R.string.wol_sending, Toast.LENGTH_SHORT).show()
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
            WakeOnLan.send(mac)
            withContext(Dispatchers.Main) {
                Toast.makeText(requireContext(), R.string.wol_sent, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun takeScreenshot() {
        val repo = com.enigma2.android.data.repository.Enigma2Repository()
        progressBar.visibility = View.VISIBLE
        Toast.makeText(requireContext(), R.string.screenshot_taking, Toast.LENGTH_SHORT).show()
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
            val bytes = repo.getScreenshot()
            withContext(Dispatchers.Main) {
                progressBar.visibility = View.GONE
                if (bytes != null) {
                    val bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
                    val iv = ImageView(requireContext())
                    iv.setImageBitmap(bmp)
                    iv.contentDescription = getString(R.string.screenshot)
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
