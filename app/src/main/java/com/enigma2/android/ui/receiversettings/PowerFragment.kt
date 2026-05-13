package com.enigma2.android.ui.receiversettings

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.preference.ListPreference
import androidx.preference.Preference
import androidx.preference.PreferenceCategory
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceScreen
import androidx.preference.SwitchPreferenceCompat
import com.enigma2.android.R
import com.enigma2.android.data.repository.Enigma2Repository
import kotlinx.coroutines.launch

class PowerFragment : PreferenceFragmentCompat() {

    private val repo = Enigma2Repository()
    private lateinit var statusPref: Preference
    private lateinit var enabledPref: SwitchPreferenceCompat
    private lateinit var minutesPref: ListPreference
    private lateinit var actionPref: ListPreference

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        val ctx = preferenceManager.context
        val screen: PreferenceScreen = preferenceManager.createPreferenceScreen(ctx)

        statusPref = Preference(ctx).apply {
            isIconSpaceReserved = false
            isSelectable = false
            setTitle(R.string.recv_status_loading)
        }
        screen.addPreference(statusPref)

        screen.addPreference(PreferenceCategory(ctx).apply {
            setTitle(R.string.recv_power_cat_actions); isIconSpaceReserved = false
        })
        screen.addPreference(actionPref(ctx, R.string.recv_power_action_toggle, 0))
        screen.addPreference(actionPref(ctx, R.string.recv_power_action_standby, 5))
        screen.addPreference(actionPref(ctx, R.string.recv_power_action_wakeup, 4))
        screen.addPreference(actionPref(ctx, R.string.recv_power_action_reboot, 2))
        screen.addPreference(actionPref(ctx, R.string.recv_power_action_restart_gui, 3))

        screen.addPreference(PreferenceCategory(ctx).apply {
            setTitle(R.string.recv_power_cat_sleep); isIconSpaceReserved = false
        })
        enabledPref = SwitchPreferenceCompat(ctx).apply {
            key = "recv_sleep_enabled"
            setTitle(R.string.recv_sleep_enabled); isIconSpaceReserved = false
        }
        minutesPref = ListPreference(ctx).apply {
            key = "recv_sleep_minutes"
            setTitle(R.string.recv_sleep_time)
            entries = arrayOf("15", "30", "45", "60", "90", "120", "180")
            entryValues = entries
            isIconSpaceReserved = false
        }
        actionPref = ListPreference(ctx).apply {
            key = "recv_sleep_action"
            setTitle(R.string.recv_sleep_action)
            entries = arrayOf("Standby", "Shutdown")
            entryValues = arrayOf("standby", "shutdown")
            isIconSpaceReserved = false
        }
        screen.addPreference(enabledPref)
        screen.addPreference(minutesPref)
        screen.addPreference(actionPref)

        preferenceScreen = screen

        val onChange = Preference.OnPreferenceChangeListener { _, _ ->
            // schedule the save on the lifecycle scope after the value commits
            view?.post { saveSleep() }
            true
        }
        enabledPref.onPreferenceChangeListener = onChange
        minutesPref.onPreferenceChangeListener = onChange
        actionPref.onPreferenceChangeListener = onChange

        load()
    }

    private fun actionPref(ctx: android.content.Context, titleRes: Int, newState: Int): Preference =
        Preference(ctx).apply {
            setTitle(titleRes); isIconSpaceReserved = false
            setOnPreferenceClickListener {
                lifecycleScope.launch {
                    try {
                        val s = repo.setPowerState(newState)
                        toast(getString(if (s.inStandby) R.string.recv_power_now_standby else R.string.recv_power_now_on))
                        load()
                    } catch (e: Exception) { toast(getString(R.string.recv_op_failed, e.message ?: "")) }
                }
                true
            }
        }

    private fun load() {
        lifecycleScope.launch {
            try {
                val ps = repo.getPowerState()
                val st = repo.getSleepTimer()
                statusPref.summary = getString(
                    if (ps.inStandby) R.string.recv_power_state_standby else R.string.recv_power_state_on
                )
                enabledPref.isChecked = st.enabled
                minutesPref.value = st.minutes.coerceAtLeast(15).toString()
                actionPref.value = st.action.ifBlank { "standby" }
            } catch (e: Exception) {
                statusPref.summary = getString(R.string.recv_op_failed, e.message ?: "")
            }
        }
    }

    private fun saveSleep() {
        lifecycleScope.launch {
            try {
                val mins = minutesPref.value?.toIntOrNull() ?: 30
                val act = actionPref.value ?: "standby"
                val en = enabledPref.isChecked
                repo.setSleepTimer(mins, act, en)
                toast(getString(R.string.recv_op_ok))
            } catch (e: Exception) { toast(getString(R.string.recv_op_failed, e.message ?: "")) }
        }
    }

    private fun toast(msg: String) { Toast.makeText(context, msg, Toast.LENGTH_SHORT).show() }
}
