package com.enigma2.android.ui.receiversettings

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.lifecycleScope
import androidx.preference.ListPreference
import androidx.preference.Preference
import androidx.preference.PreferenceCategory
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceScreen
import com.enigma2.android.R
import com.enigma2.android.data.repository.Enigma2Repository
import kotlinx.coroutines.launch

class RecordingSettingsFragment : PreferenceFragmentCompat() {
    private val repo = Enigma2Repository()
    private lateinit var currentPref: ListPreference
    private lateinit var statusPref: Preference

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        val ctx = preferenceManager.context
        val screen: PreferenceScreen = preferenceManager.createPreferenceScreen(ctx)

        statusPref = Preference(ctx).apply {
            isIconSpaceReserved = false; isSelectable = false
            setTitle(R.string.recv_status_loading)
        }
        screen.addPreference(statusPref)

        currentPref = ListPreference(ctx).apply {
            key = "recv_rec_default"; setTitle(R.string.recv_rec_default_path); isIconSpaceReserved = false
        }
        screen.addPreference(currentPref)

        screen.addPreference(PreferenceCategory(ctx).apply {
            setTitle(R.string.recv_rec_locations); isIconSpaceReserved = false
        })
        screen.addPreference(Preference(ctx).apply {
            setTitle(R.string.recv_rec_add); isIconSpaceReserved = false
            setOnPreferenceClickListener { promptAddLocation(); true }
        })

        preferenceScreen = screen

        currentPref.setOnPreferenceChangeListener { _, newValue ->
            lifecycleScope.launch {
                try { repo.setCurrentLocation(newValue as String); toast(getString(R.string.recv_op_ok)) }
                catch (e: Exception) { toast(getString(R.string.recv_op_failed, e.message ?: "")) }
            }
            true
        }

        load()
    }

    private fun load() {
        lifecycleScope.launch {
            try {
                val rl = repo.getRecordingLocations()
                statusPref.summary = getString(R.string.recv_rec_count, rl.locations.size)
                val arr = rl.locations.toTypedArray()
                currentPref.entries = arr; currentPref.entryValues = arr
                rl.current?.let { currentPref.value = it }
                rebuildLocationsList(rl.locations)
            } catch (e: Exception) {
                statusPref.summary = getString(R.string.recv_op_failed, e.message ?: "")
            }
        }
    }

    private fun rebuildLocationsList(locations: List<String>) {
        val ctx = preferenceManager.context
        val screen = preferenceScreen
        // Remove any existing per-path rows (those tagged with key prefix "loc_")
        val toRemove = (0 until screen.preferenceCount).map { screen.getPreference(it) }
            .filter { it.key?.startsWith("loc_") == true }
        toRemove.forEach { screen.removePreference(it) }
        for ((i, path) in locations.withIndex()) {
            val pref = Preference(ctx).apply {
                key = "loc_$i"; title = path
                summary = getString(R.string.recv_rec_long_press_remove)
                isIconSpaceReserved = false
                setOnPreferenceClickListener {
                    AlertDialog.Builder(requireContext())
                        .setTitle(R.string.recv_rec_remove_title)
                        .setMessage(getString(R.string.recv_rec_remove_msg, path))
                        .setNegativeButton(android.R.string.cancel, null)
                        .setPositiveButton(R.string.delete) { _, _ ->
                            lifecycleScope.launch {
                                try { repo.removeRecordingLocation(path); load() }
                                catch (e: Exception) { toast(getString(R.string.recv_op_failed, e.message ?: "")) }
                            }
                        }.show()
                    true
                }
            }
            screen.addPreference(pref)
        }
    }

    private fun promptAddLocation() {
        val ctx = requireContext()
        val input = EditText(ctx).apply { hint = "/media/hdd/movie" }
        AlertDialog.Builder(ctx)
            .setTitle(R.string.recv_rec_add)
            .setView(input)
            .setNegativeButton(android.R.string.cancel, null)
            .setPositiveButton(android.R.string.ok) { _, _ ->
                val path = input.text.toString().trim()
                if (path.isNotBlank()) lifecycleScope.launch {
                    try { repo.addRecordingLocation(path); load() }
                    catch (e: Exception) { toast(getString(R.string.recv_op_failed, e.message ?: "")) }
                }
            }.show()
    }

    private fun toast(msg: String) { Toast.makeText(context, msg, Toast.LENGTH_SHORT).show() }
}
