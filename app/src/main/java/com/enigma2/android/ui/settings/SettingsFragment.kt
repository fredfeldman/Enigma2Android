package com.enigma2.android.ui.settings

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.enigma2.android.R

class SettingsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)

        findPreference<androidx.preference.Preference>("pref_hide_bouquets")
            ?.setOnPreferenceClickListener {
                startActivity(android.content.Intent(requireContext(), HideBouquetsActivity::class.java))
                true
            }
    }
}
