package com.enigma2.android.ui.receiversettings

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceScreen
import androidx.preference.SeekBarPreference
import androidx.preference.SwitchPreferenceCompat
import com.enigma2.android.R
import com.enigma2.android.data.repository.Enigma2Repository
import kotlinx.coroutines.launch

class AudioFragment : PreferenceFragmentCompat() {
    private val repo = Enigma2Repository()
    private lateinit var volumePref: SeekBarPreference
    private lateinit var mutePref: SwitchPreferenceCompat

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        val ctx = preferenceManager.context
        val screen: PreferenceScreen = preferenceManager.createPreferenceScreen(ctx)
        volumePref = SeekBarPreference(ctx).apply {
            key = "recv_volume"; setTitle(R.string.recv_audio_volume)
            min = 0; max = 100; showSeekBarValue = true; isIconSpaceReserved = false
        }
        mutePref = SwitchPreferenceCompat(ctx).apply {
            key = "recv_mute"; setTitle(R.string.recv_audio_mute); isIconSpaceReserved = false
        }
        screen.addPreference(volumePref)
        screen.addPreference(mutePref)
        preferenceScreen = screen

        volumePref.setOnPreferenceChangeListener { _, newValue ->
            lifecycleScope.launch {
                try { repo.setVolume(newValue as Int) }
                catch (e: Exception) { toast(getString(R.string.recv_op_failed, e.message ?: "")) }
            }
            true
        }
        mutePref.setOnPreferenceChangeListener { _, _ ->
            lifecycleScope.launch {
                try {
                    val v = repo.setMute(); mutePref.isChecked = v.muted
                } catch (e: Exception) { toast(getString(R.string.recv_op_failed, e.message ?: "")) }
            }
            // accept the user's intent and let the response correct it
            true
        }

        load()
    }

    private fun load() {
        lifecycleScope.launch {
            try {
                val v = repo.getVolume()
                volumePref.value = v.current
                mutePref.isChecked = v.muted
            } catch (e: Exception) { toast(getString(R.string.recv_op_failed, e.message ?: "")) }
        }
    }

    private fun toast(msg: String) { Toast.makeText(context, msg, Toast.LENGTH_SHORT).show() }
}
