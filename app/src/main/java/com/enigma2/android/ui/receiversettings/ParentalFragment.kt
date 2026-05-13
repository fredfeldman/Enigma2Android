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

/** Read-only viewer for parental control settings + protected service list. */
class ParentalFragment : PreferenceFragmentCompat() {
    private val repo = Enigma2Repository()

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        val ctx = preferenceManager.context
        val screen: PreferenceScreen = preferenceManager.createPreferenceScreen(ctx)
        screen.addPreference(Preference(ctx).apply {
            key = "p_status"; setTitle(R.string.recv_status_loading)
            isSelectable = false; isIconSpaceReserved = false
        })
        screen.addPreference(Preference(ctx).apply {
            key = "p_refresh"; setTitle(R.string.refresh); isIconSpaceReserved = false
            setOnPreferenceClickListener { load(); true }
        })
        preferenceScreen = screen
        load()
    }

    private fun load() {
        val status = findPreference<Preference>("p_status") ?: return
        lifecycleScope.launch {
            try {
                val p = repo.getParentalSettings()
                status.title = getString(
                    if (p.configured) R.string.recv_parental_active else R.string.recv_parental_inactive
                )
                val parts = mutableListOf<String>()
                p.type?.let { parts.add(getString(R.string.recv_parental_type, it)) }
                parts.add(getString(
                    if (p.setupPinActive) R.string.recv_parental_pin_set else R.string.recv_parental_pin_none
                ))
                parts.add(getString(R.string.recv_parental_count, p.protectedServices.size))
                status.summary = parts.joinToString("\n")
                rebuildList(p.protectedServices)
            } catch (e: Exception) {
                status.summary = getString(R.string.recv_op_failed, e.message ?: "")
            }
        }
    }

    private fun rebuildList(list: List<com.enigma2.android.data.model.settings.ProtectedService>) {
        val ctx = preferenceManager.context
        val screen = preferenceScreen
        val toRemove = (0 until screen.preferenceCount).map { screen.getPreference(it) }
            .filter { it.key?.startsWith("psvc_") == true }
        toRemove.forEach { screen.removePreference(it) }
        for ((i, s) in list.withIndex()) {
            screen.addPreference(Preference(ctx).apply {
                key = "psvc_$i"; title = s.name; summary = s.ref
                isIconSpaceReserved = false; isSelectable = false
            })
        }
    }
}
