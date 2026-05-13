package com.enigma2.android.ui.receiversettings

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.preference.EditTextPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceScreen
import androidx.preference.SwitchPreferenceCompat
import com.enigma2.android.R
import com.enigma2.android.data.repository.Enigma2Repository
import kotlinx.coroutines.launch

class WolFragment : PreferenceFragmentCompat() {
    private val repo = Enigma2Repository()
    private lateinit var enabledPref: SwitchPreferenceCompat
    private lateinit var standbyPref: SwitchPreferenceCompat
    private lateinit var locationPref: EditTextPreference
    private lateinit var statusPref: Preference

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        val ctx = preferenceManager.context
        val screen: PreferenceScreen = preferenceManager.createPreferenceScreen(ctx)
        statusPref = Preference(ctx).apply {
            isSelectable = false; isIconSpaceReserved = false; setTitle(R.string.recv_status_loading)
        }
        enabledPref = SwitchPreferenceCompat(ctx).apply {
            key = "wol_enabled"; setTitle(R.string.recv_wol_enabled); isIconSpaceReserved = false
        }
        standbyPref = SwitchPreferenceCompat(ctx).apply {
            key = "wol_standby"; setTitle(R.string.recv_wol_standby); isIconSpaceReserved = false
        }
        locationPref = EditTextPreference(ctx).apply {
            key = "wol_location"; setTitle(R.string.recv_wol_location); isIconSpaceReserved = false
        }
        screen.addPreference(statusPref)
        screen.addPreference(enabledPref)
        screen.addPreference(standbyPref)
        screen.addPreference(locationPref)
        preferenceScreen = screen

        val ch = Preference.OnPreferenceChangeListener { _, _ -> view?.post { save() }; true }
        enabledPref.onPreferenceChangeListener = ch
        standbyPref.onPreferenceChangeListener = ch
        locationPref.onPreferenceChangeListener = ch

        load()
    }

    private fun load() {
        lifecycleScope.launch {
            try {
                val w = repo.getWolSetup()
                statusPref.summary = getString(if (w.enabled) R.string.recv_wol_active else R.string.recv_wol_inactive)
                enabledPref.isChecked = w.enabled
                standbyPref.isChecked = w.wolStandby
                locationPref.text = w.location.orEmpty()
            } catch (e: Exception) {
                statusPref.summary = getString(R.string.recv_op_failed, e.message ?: "")
            }
        }
    }

    private fun save() {
        lifecycleScope.launch {
            try {
                val r = repo.setWolSetup(enabledPref.isChecked, locationPref.text, standbyPref.isChecked)
                Toast.makeText(context,
                    if (r.first) getString(R.string.recv_op_ok)
                    else getString(R.string.recv_op_failed, r.second ?: ""),
                    Toast.LENGTH_SHORT).show()
                load()
            } catch (e: Exception) {
                Toast.makeText(context, getString(R.string.recv_op_failed, e.message ?: ""), Toast.LENGTH_SHORT).show()
            }
        }
    }
}
