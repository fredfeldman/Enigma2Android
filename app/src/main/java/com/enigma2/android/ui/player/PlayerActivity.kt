package com.enigma2.android.ui.player

import android.app.AlertDialog
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.media3.common.MediaItem
import androidx.media3.common.MimeTypes
import androidx.media3.common.Player
import androidx.media3.common.TrackSelectionParameters
import androidx.media3.datasource.okhttp.OkHttpDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory
import androidx.media3.ui.PlayerView
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import com.enigma2.android.R
import com.enigma2.android.data.api.ApiClient
import com.enigma2.android.data.prefs.ReceiverPreferences
import com.enigma2.android.data.repository.Enigma2Repository
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PlayerActivity : AppCompatActivity() {

    private lateinit var playerView: PlayerView
    private lateinit var player: ExoPlayer
    private lateinit var osdOverlay: View
    private lateinit var tvChannelName: TextView
    private lateinit var tvNowTitle: TextView
    private lateinit var tvNextTitle: TextView
    private lateinit var seekRow: View
    private lateinit var seekBar: SeekBar
    private lateinit var tvPosition: TextView
    private lateinit var tvDuration: TextView
    private lateinit var btnStop: ImageButton
    private lateinit var btnPlayPause: ImageButton
    private lateinit var btnPrevChannel: ImageButton
    private lateinit var btnNextChannel: ImageButton
    private lateinit var btnRewind: ImageButton
    private lateinit var btnFastForward: ImageButton
    private lateinit var btnAudio: ImageButton
    private lateinit var btnSubs: Button
    private lateinit var btnAspect: ImageButton
    private lateinit var btnSleep: ImageButton
    private lateinit var tvBitrate: TextView

    private lateinit var prefs: ReceiverPreferences
    private val repo = Enigma2Repository()

    private var streamUrl: String = ""
    private var channelName: String = ""
    private var serviceRef: String = ""
    private var isRecording: Boolean = false
    private var channelRefs: List<String> = emptyList()
    private var channelNames: List<String> = emptyList()
    private var channelIndex: Int = 0
    private var durationSec: Int = 0

    private val osdHandler = Handler(Looper.getMainLooper())
    private val osdHideRunnable = Runnable { hideOsd() }
    private val progressHandler = Handler(Looper.getMainLooper())
    private var sleepTimer: CountDownTimer? = null
    private var userSeekInProgress = false

    companion object {
        const val EXTRA_STREAM_URL = "stream_url"
        const val EXTRA_CHANNEL_NAME = "channel_name"
        const val EXTRA_SERVICE_REF = "service_ref"
        const val EXTRA_IS_RECORDING = "is_recording"
        const val EXTRA_CHANNEL_REFS = "channel_refs"
        const val EXTRA_CHANNEL_NAMES = "channel_names"
        const val EXTRA_CHANNEL_INDEX = "channel_index"
        const val EXTRA_DURATION_SEC = "duration_sec"
        private const val OSD_HIDE_DELAY_MS = 5000L
        private const val SEEK_STEP_MS = 15_000L

        @Volatile private var httpClientInstance: OkHttpClient? = null
        @Volatile private var httpClientCredentials: String = ""

        private fun getHttpClient(prefs: ReceiverPreferences): OkHttpClient {
            val credentials = "${prefs.username}:${prefs.password}"
            if (httpClientInstance == null || httpClientCredentials != credentials) {
                httpClientCredentials = credentials
                httpClientInstance = OkHttpClient.Builder()
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .apply {
                        if (prefs.username.isNotBlank()) {
                            val creds = android.util.Base64.encodeToString(
                                "${prefs.username}:${prefs.password}".toByteArray(),
                                android.util.Base64.NO_WRAP
                            )
                            addInterceptor { chain ->
                                chain.proceed(
                                    chain.request().newBuilder()
                                        .addHeader("Authorization", "Basic $creds")
                                        .build()
                                )
                            }
                        }
                    }
                    .build()
            }
            return httpClientInstance!!
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        prefs = ReceiverPreferences(this)
        streamUrl = intent.getStringExtra(EXTRA_STREAM_URL) ?: ""
        channelName = intent.getStringExtra(EXTRA_CHANNEL_NAME) ?: ""
        serviceRef = intent.getStringExtra(EXTRA_SERVICE_REF) ?: ""
        isRecording = intent.getBooleanExtra(EXTRA_IS_RECORDING, false)
        channelRefs = intent.getStringArrayListExtra(EXTRA_CHANNEL_REFS) ?: emptyList()
        channelNames = intent.getStringArrayListExtra(EXTRA_CHANNEL_NAMES) ?: emptyList()
        channelIndex = intent.getIntExtra(EXTRA_CHANNEL_INDEX, 0)
        durationSec = intent.getIntExtra(EXTRA_DURATION_SEC, 0)

        bindViews()
        setupPlayer()
        setupOsd()
        setupControls()
    }

    private fun bindViews() {
        playerView = findViewById(R.id.player_view)
        osdOverlay = findViewById(R.id.osd_overlay)
        tvChannelName = findViewById(R.id.tv_osd_channel_name)
        tvNowTitle = findViewById(R.id.tv_osd_now_title)
        tvNextTitle = findViewById(R.id.tv_osd_next_title)
        seekRow = findViewById(R.id.seek_row)
        seekBar = findViewById(R.id.seek_bar)
        tvPosition = findViewById(R.id.tv_position)
        tvDuration = findViewById(R.id.tv_duration)
        btnStop = findViewById(R.id.btn_stop)
        btnPlayPause = findViewById(R.id.btn_play_pause)
        btnPrevChannel = findViewById(R.id.btn_prev_channel)
        btnNextChannel = findViewById(R.id.btn_next_channel)
        btnRewind = findViewById(R.id.btn_rewind)
        btnFastForward = findViewById(R.id.btn_fast_forward)
        btnAudio = findViewById(R.id.btn_audio)
        btnSubs = findViewById(R.id.btn_subs)
        btnAspect = findViewById(R.id.btn_aspect)
        btnSleep = findViewById(R.id.btn_sleep)
        tvBitrate = findViewById(R.id.tv_bitrate)
    }

    private fun setupPlayer() {
        val okHttpClient = getHttpClient(prefs)

        player = ExoPlayer.Builder(this)
            .setMediaSourceFactory(
                DefaultMediaSourceFactory(this)
                    .setDataSourceFactory(OkHttpDataSource.Factory(okHttpClient))
            )
            .build()
        playerView.player = player

        // Disable built-in controls — we use our own OSD
        playerView.useController = false

        player.addListener(object : Player.Listener {
            override fun onPlaybackStateChanged(state: Int) {
                updatePlayPauseButton()
                if (state == Player.STATE_READY && isRecording) {
                    val savedPos = prefs.getPlaybackPosition(streamUrl)
                    if (savedPos > 30_000L) {
                        showResumeDialog(savedPos)
                    }
                }
            }
        })

        loadStream(streamUrl)
    }

    private fun loadStream(url: String) {
        val mediaItem = MediaItem.Builder()
            .setUri(url)
            .setMimeType(MimeTypes.VIDEO_MP2T)
            .build()
        player.setMediaItem(mediaItem)
        player.prepare()
        player.play()
        startProgressUpdates()
    }

    private fun setupOsd() {
        tvChannelName.text = channelName

        // Only show seek controls for recordings
        val seekVisibility = if (isRecording) View.VISIBLE else View.GONE
        seekRow.visibility = seekVisibility
        btnRewind.visibility = seekVisibility
        btnFastForward.visibility = seekVisibility

        // Pre-populate duration from intent so it shows immediately (before ExoPlayer resolves it)
        if (isRecording && durationSec > 0) {
            tvDuration.text = formatTime(durationSec * 1000L)
        }

        // Channel up/down only for live TV
        val navVisibility = if (!isRecording && channelRefs.isNotEmpty()) View.VISIBLE else View.GONE
        btnPrevChannel.visibility = navVisibility
        btnNextChannel.visibility = navVisibility

        showOsd()
        loadNowNext()
    }

    private fun setupControls() {
        // Tap player surface to toggle OSD
        playerView.setOnClickListener {
            if (osdOverlay.visibility == View.VISIBLE) hideOsd() else showOsd()
        }

        btnStop.setOnClickListener {
            finish()
        }

        btnPlayPause.setOnClickListener {
            if (player.isPlaying) player.pause() else player.play()
            updatePlayPauseButton()
            resetOsdTimer()
        }

        btnRewind.setOnClickListener {
            player.seekTo((player.currentPosition - SEEK_STEP_MS).coerceAtLeast(0))
            resetOsdTimer()
        }

        btnFastForward.setOnClickListener {
            player.seekTo(player.currentPosition + SEEK_STEP_MS)
            resetOsdTimer()
        }

        btnPrevChannel.setOnClickListener {
            navigateChannel(-1)
        }

        btnNextChannel.setOnClickListener {
            navigateChannel(1)
        }

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onStartTrackingTouch(sb: SeekBar) {
                userSeekInProgress = true
                osdHandler.removeCallbacks(osdHideRunnable)
            }

            override fun onProgressChanged(sb: SeekBar, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    val pos = (player.duration * progress / 100L).coerceAtLeast(0)
                    tvPosition.text = formatTime(pos)
                }
            }

            override fun onStopTrackingTouch(sb: SeekBar) {
                val pos = (player.duration * sb.progress / 100L).coerceAtLeast(0)
                player.seekTo(pos)
                if (isRecording) prefs.savePlaybackPosition(streamUrl, pos)
                userSeekInProgress = false
                resetOsdTimer()
            }
        })

        btnAudio.setOnClickListener {
            showTrackSelectionDialog(TrackType.AUDIO)
            resetOsdTimer()
        }

        btnSubs.setOnClickListener {
            showTrackSelectionDialog(TrackType.SUBTITLE)
            resetOsdTimer()
        }

        btnAspect.setOnClickListener {
            cycleAspectRatio()
            resetOsdTimer()
        }

        btnSleep.setOnClickListener {
            showSleepTimerDialog()
            resetOsdTimer()
        }
    }

    private fun showOsd() {
        osdOverlay.visibility = View.VISIBLE
        btnStop.visibility = View.VISIBLE
        resetOsdTimer()
    }

    private fun hideOsd() {
        osdOverlay.visibility = View.GONE
        btnStop.visibility = View.GONE
        osdHandler.removeCallbacks(osdHideRunnable)
    }

    private fun resetOsdTimer() {
        osdHandler.removeCallbacks(osdHideRunnable)
        osdHandler.postDelayed(osdHideRunnable, OSD_HIDE_DELAY_MS)
    }

    private fun updatePlayPauseButton() {
        btnPlayPause.setImageResource(
            if (player.isPlaying) R.drawable.ic_pause else R.drawable.ic_play
        )
    }

    private fun startProgressUpdates() {
        val runnable = object : Runnable {
            override fun run() {
                if (!userSeekInProgress && isRecording) {
                    val duration = player.duration
                    if (duration > 0) {
                        val position = player.currentPosition
                        seekBar.progress = (position * 100 / duration).toInt()
                        tvPosition.text = formatTime(position)
                        tvDuration.text = formatTime(duration)
                    }
                }
                progressHandler.postDelayed(this, 1000)
            }
        }
        progressHandler.post(runnable)
    }

    private fun navigateChannel(delta: Int) {
        if (channelRefs.isEmpty()) return
        channelIndex = (channelIndex + delta + channelRefs.size) % channelRefs.size
        val newRef = channelRefs[channelIndex]
        channelName = channelNames.getOrNull(channelIndex) ?: ""
        serviceRef = newRef
        tvChannelName.text = channelName

        val scheme = if (prefs.useHttps) "https" else "http"
        streamUrl = "$scheme://${prefs.host}:8001/$newRef"

        lifecycleScope.launch(Dispatchers.IO) {
            repo.zapToService(newRef)
        }
        loadStream(streamUrl)
        loadNowNext()
        showOsd()
    }

    private fun loadNowNext() {
        if (serviceRef.isBlank()) return
        lifecycleScope.launch {
            try {
                val events = withContext(Dispatchers.IO) {
                    repo.getEpgForService(serviceRef)
                }
                val nowMs = System.currentTimeMillis() / 1000
                val now = events.firstOrNull { nowMs >= it.beginTimestamp && nowMs < it.beginTimestamp + it.durationSeconds }
                val next = events.firstOrNull { it.beginTimestamp > nowMs }
                tvNowTitle.text = now?.title ?: ""
                tvNextTitle.text = next?.let { "Next: ${it.title}" } ?: ""
            } catch (e: Exception) { /* non-critical */ }
        }
    }

    private fun showResumeDialog(posMs: Long) {
        AlertDialog.Builder(this)
            .setTitle(R.string.resume_playback)
            .setMessage(getString(R.string.resume_from, formatTime(posMs)))
            .setPositiveButton(R.string.resume) { _, _ -> player.seekTo(posMs) }
            .setNegativeButton(R.string.start_from_beginning, null)
            .show()
    }

    private enum class TrackType { AUDIO, SUBTITLE }

    private fun showTrackSelectionDialog(type: TrackType) {
        val tracks = player.currentTracks
        val groups = when (type) {
            TrackType.AUDIO -> tracks.groups.filter { it.type == androidx.media3.common.C.TRACK_TYPE_AUDIO }
            TrackType.SUBTITLE -> tracks.groups.filter { it.type == androidx.media3.common.C.TRACK_TYPE_TEXT }
        }
        if (groups.isEmpty()) {
            val msg = if (type == TrackType.AUDIO) R.string.no_audio_tracks else R.string.no_subtitle_tracks
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
            return
        }
        val labels = groups.mapIndexed { i, g ->
            g.getTrackFormat(0).language ?: "Track ${i + 1}"
        }.toTypedArray()

        AlertDialog.Builder(this)
            .setTitle(if (type == TrackType.AUDIO) R.string.select_audio else R.string.select_subtitle)
            .setItems(labels) { _, which ->
                val group = groups[which]
                val params = player.trackSelectionParameters
                    .buildUpon()
                    .setOverrideForType(
                        androidx.media3.common.TrackSelectionOverride(group.mediaTrackGroup, 0)
                    )
                    .build()
                player.trackSelectionParameters = params
            }
            .show()
    }

    private var aspectIndex = 0
    private val aspectModes = listOf(
        androidx.media3.ui.AspectRatioFrameLayout.RESIZE_MODE_FIT,
        androidx.media3.ui.AspectRatioFrameLayout.RESIZE_MODE_FILL,
        androidx.media3.ui.AspectRatioFrameLayout.RESIZE_MODE_ZOOM
    )

    private fun cycleAspectRatio() {
        aspectIndex = (aspectIndex + 1) % aspectModes.size
        playerView.resizeMode = aspectModes[aspectIndex]
    }

    private fun showSleepTimerDialog() {
        val options = arrayOf("15 min", "30 min", "60 min", getString(R.string.cancel_sleep_timer))
        AlertDialog.Builder(this)
            .setTitle(R.string.sleep_timer)
            .setItems(options) { _, which ->
                sleepTimer?.cancel()
                if (which < 3) {
                    val minutes = listOf(15, 30, 60)[which]
                    sleepTimer = object : CountDownTimer(minutes * 60_000L, 60_000L) {
                        override fun onTick(millisUntilFinished: Long) {}
                        override fun onFinish() { finish() }
                    }.start()
                    Toast.makeText(this, getString(R.string.sleep_in_minutes, minutes), Toast.LENGTH_SHORT).show()
                }
            }
            .show()
    }

    private fun formatTime(ms: Long): String {
        val totalSec = ms / 1000
        val h = totalSec / 3600
        val m = (totalSec % 3600) / 60
        val s = totalSec % 60
        return if (h > 0) "%d:%02d:%02d".format(h, m, s) else "%02d:%02d".format(m, s)
    }

    override fun onStop() {
        super.onStop()
        if (isRecording) {
            prefs.savePlaybackPosition(streamUrl, player.currentPosition)
        }
        progressHandler.removeCallbacksAndMessages(null)
        osdHandler.removeCallbacksAndMessages(null)
        sleepTimer?.cancel()
    }

    override fun onDestroy() {
        super.onDestroy()
        player.release()
    }
}
