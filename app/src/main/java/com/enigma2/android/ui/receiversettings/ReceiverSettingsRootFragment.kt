package com.enigma2.android.ui.receiversettings

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.preference.Preference
import androidx.preference.PreferenceCategory
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceScreen
import com.enigma2.android.R
import com.enigma2.android.data.model.settings.ReceiverCapabilities
import com.enigma2.android.data.repository.Enigma2Repository
import kotlinx.coroutines.launch

/** Root menu listing the receiver-settings sub-screens. */
class ReceiverSettingsRootFragment : PreferenceFragmentCompat() {

    private val repo = Enigma2Repository()

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        val ctx = preferenceManager.context
        val screen: PreferenceScreen = preferenceManager.createPreferenceScreen(ctx)

        fun add(title: Int, summary: Int, build: () -> androidx.fragment.app.Fragment): Preference =
            Preference(ctx).apply {
                setTitle(title)
                setSummary(summary)
                isIconSpaceReserved = false
                setOnPreferenceClickListener {
                    (activity as? ReceiverSettingsActivity)
                        ?.pushFragment(build(), getString(title))
                    true
                }
            }

        screen.addPreference(PreferenceCategory(ctx).apply {
            setTitle(R.string.receiver_settings_cat_general); isIconSpaceReserved = false
        })
        screen.addPreference(add(R.string.recv_power_title, R.string.recv_power_summary) { PowerFragment() })
        screen.addPreference(add(R.string.recv_audio_title, R.string.recv_audio_summary) { AudioFragment() })
        screen.addPreference(add(R.string.recv_recording_title, R.string.recv_recording_summary) { RecordingSettingsFragment() })
        screen.addPreference(add(R.string.recv_tuner_title, R.string.recv_tuner_summary) { TunerFragment() })

        screen.addPreference(PreferenceCategory(ctx).apply {
            setTitle(R.string.receiver_settings_cat_protected); isIconSpaceReserved = false
        })
        val parental = add(R.string.recv_parental_title, R.string.recv_parental_summary) { ParentalFragment() }
        val transcoding = add(R.string.recv_transcoding_title, R.string.recv_transcoding_summary) { TranscodingFragment() }
        val wol = add(R.string.recv_wol_title, R.string.recv_wol_summary) { WolFragment() }
        val configTree = add(R.string.recv_config_tree_title, R.string.recv_config_tree_summary) { ConfigTreeFragment() }
        screen.addPreference(parental)
        screen.addPreference(transcoding)
        screen.addPreference(wol)
        screen.addPreference(configTree)

        screen.addPreference(PreferenceCategory(ctx).apply {
            setTitle(R.string.receiver_settings_cat_webui); isIconSpaceReserved = false
        })
        screen.addPreference(add(R.string.recv_webui_title, R.string.recv_webui_summary) { WebUiConfigFragment() })

        screen.addPreference(PreferenceCategory(ctx).apply {
            setTitle(R.string.receiver_settings_cat_system); isIconSpaceReserved = false
        })
        screen.addPreference(add(R.string.recv_storage_title, R.string.recv_storage_summary) { StorageFragment() })
        screen.addPreference(add(R.string.recv_log_title, R.string.recv_log_summary) { LogViewerFragment() })
        screen.addPreference(add(R.string.recv_plugins_title, R.string.recv_plugins_summary) { PluginManagerFragment() })
        screen.addPreference(add(R.string.recv_network_title, R.string.recv_network_summary) { NetworkInfoFragment() })

        preferenceScreen = screen

        // Capability probe is informational only: append a hint to the summary when the
        // underlying endpoint is missing, but keep the row enabled so the user can still
        // open the screen and see its own empty / error state.
        viewLifecycleOwnerLiveData.observe(this) { owner ->
            owner ?: return@observe
            owner.lifecycleScope.launch {
                val caps: ReceiverCapabilities = try { repo.probeReceiverCapabilities() }
                    catch (_: Exception) { ReceiverCapabilities(false, false, false, false) }
                annotate(parental, R.string.recv_parental_summary, caps.hasParental)
                annotate(transcoding, R.string.recv_transcoding_summary, caps.hasTranscoding)
                annotate(wol, R.string.recv_wol_summary, caps.hasWol)
                annotate(configTree, R.string.recv_config_tree_summary, caps.hasConfigTree)
            }
        }
    }

    private fun annotate(pref: Preference, baseSummary: Int, available: Boolean) {
        pref.summary = if (available) getString(baseSummary)
        else getString(baseSummary) + "  •  " + getString(R.string.recv_not_available)
    }
}
