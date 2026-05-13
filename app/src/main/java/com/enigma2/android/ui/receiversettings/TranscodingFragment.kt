package com.enigma2.android.ui.receiversettings

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.preference.EditTextPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceScreen
import com.enigma2.android.R
import com.enigma2.android.data.repository.Enigma2Repository
import kotlinx.coroutines.launch

/** Renders every key from `transcoding` as an EditText row; commits via the same endpoint. */
class TranscodingFragment : PreferenceFragmentCompat() {
    private val repo = Enigma2Repository()

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        val ctx = preferenceManager.context
        preferenceScreen = preferenceManager.createPreferenceScreen(ctx)
        preferenceScreen.addPreference(Preference(ctx).apply {
            key = "tc_status"; setTitle(R.string.recv_status_loading); isSelectable = false; isIconSpaceReserved = false
        })
        load()
    }

    private fun load() {
        lifecycleScope.launch {
            try {
                val map = repo.getTranscodingConfig()
                rebuild(map)
            } catch (e: Exception) {
                findPreference<Preference>("tc_status")?.summary =
                    getString(R.string.recv_op_failed, e.message ?: "")
            }
        }
    }

    private fun rebuild(map: Map<String, String>) {
        val ctx = preferenceManager.context
        val screen = preferenceScreen
        screen.removeAll()
        screen.addPreference(Preference(ctx).apply {
            key = "tc_status"; setTitle(R.string.recv_transcoding_title)
            summary = getString(R.string.recv_transcoding_count, map.size)
            isSelectable = false; isIconSpaceReserved = false
        })
        if (map.isEmpty()) {
            screen.addPreference(Preference(ctx).apply {
                title = getString(R.string.recv_transcoding_empty); isSelectable = false; isIconSpaceReserved = false
            })
            return
        }
        for ((k, v) in map) {
            val pref = EditTextPreference(ctx).apply {
                key = "tc_$k"; title = k; text = v; summary = v; isIconSpaceReserved = false
                setOnPreferenceChangeListener { _, newValue ->
                    val nv = newValue as String
                    lifecycleScope.launch {
                        try {
                            val r = repo.setTranscodingConfig(mapOf(k to nv))
                            Toast.makeText(context,
                                if (r.first) getString(R.string.recv_op_ok)
                                else getString(R.string.recv_op_failed, r.second ?: ""),
                                Toast.LENGTH_SHORT).show()
                        } catch (e: Exception) {
                            Toast.makeText(context, getString(R.string.recv_op_failed, e.message ?: ""), Toast.LENGTH_SHORT).show()
                        }
                    }
                    true
                }
            }
            screen.addPreference(pref)
        }
    }
}
