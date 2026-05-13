package com.enigma2.android.ui.receiversettings

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceScreen
import com.enigma2.android.R
import com.enigma2.android.data.repository.Enigma2Repository
import kotlinx.coroutines.launch

class TunerFragment : PreferenceFragmentCompat() {
    private val repo = Enigma2Repository()

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        val ctx = preferenceManager.context
        val screen: PreferenceScreen = preferenceManager.createPreferenceScreen(ctx)
        screen.addPreference(Preference(ctx).apply {
            key = "tuner_status"; setTitle(R.string.recv_status_loading)
            isSelectable = false; isIconSpaceReserved = false
        })
        screen.addPreference(Preference(ctx).apply {
            key = "tuner_refresh"; setTitle(R.string.refresh); isIconSpaceReserved = false
            setOnPreferenceClickListener { load(); true }
        })
        preferenceScreen = screen
        load()
    }

    private fun load() {
        val status = findPreference<Preference>("tuner_status") ?: return
        lifecycleScope.launch {
            try {
                val s = repo.getTunerSignal()
                val parts = listOfNotNull(
                    s.tunerType?.let { "Type: $it" },
                    s.tunerNumber?.let { "Tuner #$it" },
                    s.snr?.let { "SNR: $it" },
                    s.ber?.let { "BER: $it" },
                    s.signal?.let { "Signal: $it" }
                )
                status.summary = if (parts.isEmpty()) getString(R.string.recv_tuner_idle) else parts.joinToString("\n")
            } catch (e: Exception) {
                status.summary = getString(R.string.recv_op_failed, e.message ?: "")
            }
        }
    }
}
