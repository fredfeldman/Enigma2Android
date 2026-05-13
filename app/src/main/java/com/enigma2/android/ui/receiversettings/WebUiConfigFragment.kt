package com.enigma2.android.ui.receiversettings

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceScreen
import androidx.preference.SwitchPreferenceCompat
import com.enigma2.android.R
import com.enigma2.android.data.repository.Enigma2Repository
import kotlinx.coroutines.launch

/** Boolean toggles for the OpenWebif Web UI (`web/setwebconfig`). Commonly used keys only. */
class WebUiConfigFragment : PreferenceFragmentCompat() {
    private val repo = Enigma2Repository()

    private val booleanKeys = linkedMapOf(
        "showpicons" to R.string.recv_webui_show_picons,
        "showchannelpicon" to R.string.recv_webui_show_channel_picon,
        "showchanneldetails" to R.string.recv_webui_show_channel_details,
        "responsive" to R.string.recv_webui_responsive,
        "moviedb" to R.string.recv_webui_moviedb,
        "showallpackages" to R.string.recv_webui_show_all_packages
    )

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        val ctx = preferenceManager.context
        val screen: PreferenceScreen = preferenceManager.createPreferenceScreen(ctx)
        screen.addPreference(Preference(ctx).apply {
            key = "wu_status"; setTitle(R.string.recv_status_loading)
            isSelectable = false; isIconSpaceReserved = false
        })
        for ((k, label) in booleanKeys) {
            screen.addPreference(SwitchPreferenceCompat(ctx).apply {
                key = "wu_$k"; setTitle(label); isIconSpaceReserved = false
                setOnPreferenceChangeListener { _, newValue ->
                    val v = if (newValue as Boolean) "true" else "false"
                    lifecycleScope.launch {
                        try {
                            val r = repo.setWebUiConfig(mapOf(k to v))
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
            })
        }
        preferenceScreen = screen

        load()
    }

    private fun load() {
        lifecycleScope.launch {
            try {
                val all = repo.getAllSettings()
                findPreference<Preference>("wu_status")?.summary =
                    getString(R.string.recv_webui_loaded, all.size)
                for (k in booleanKeys.keys) {
                    val v = all["config.OpenWebif.webcache.$k"] ?: all[k] ?: continue
                    findPreference<SwitchPreferenceCompat>("wu_$k")?.isChecked =
                        v.equals("true", true) || v == "1"
                }
            } catch (e: Exception) {
                findPreference<Preference>("wu_status")?.summary =
                    getString(R.string.recv_op_failed, e.message ?: "")
            }
        }
    }
}
