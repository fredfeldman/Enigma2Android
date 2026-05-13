package com.enigma2.android.ui.settings

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.preference.Preference
import androidx.preference.PreferenceCategory
import androidx.preference.PreferenceFragmentCompat
import com.enigma2.android.R
import com.enigma2.android.data.repository.Enigma2Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SettingsFragment : PreferenceFragmentCompat() {

    private val repo = Enigma2Repository()

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)

        findPreference<Preference>("pref_hide_bouquets")
            ?.setOnPreferenceClickListener {
                startActivity(Intent(requireContext(), HideBouquetsActivity::class.java))
                true
            }

        findPreference<Preference>("manage_bouquets")
            ?.setOnPreferenceClickListener {
                startActivity(Intent(requireContext(),
                    com.enigma2.android.ui.bouqueteditor.BouquetEditorActivity::class.java))
                true
            }

        findPreference<Preference>("pref_box_info")
            ?.setOnPreferenceClickListener {
                startActivity(Intent(requireContext(), BoxInfoActivity::class.java))
                true
            }

        findPreference<Preference>("pref_receiver_settings")
            ?.setOnPreferenceClickListener {
                startActivity(Intent(requireContext(),
                    com.enigma2.android.ui.receiversettings.ReceiverSettingsActivity::class.java))
                true
            }

        val epgImportPref = findPreference<Preference>("pref_epg_import")
        val pluginsCat = findPreference<PreferenceCategory>("pref_category_plugins")
        // Hide until we know it's available
        epgImportPref?.isVisible = false
        pluginsCat?.isVisible = false

        epgImportPref?.setOnPreferenceClickListener {
            startActivity(Intent(requireContext(), EpgImportActivity::class.java))
            true
        }

        viewLifecycleOwnerLiveData.observe(this) { owner ->
            owner ?: return@observe
            owner.lifecycleScope.launch {
                val available = withContext(Dispatchers.IO) { repo.isEpgImportAvailable() }
                epgImportPref?.isVisible = available
                pluginsCat?.isVisible = available
            }
        }
    }
}
