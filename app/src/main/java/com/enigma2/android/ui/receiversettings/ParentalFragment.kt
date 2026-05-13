package com.enigma2.android.ui.receiversettings

import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.lifecycleScope
import androidx.preference.Preference
import androidx.preference.PreferenceCategory
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceScreen
import com.enigma2.android.R
import com.enigma2.android.data.model.settings.ProtectedService
import com.enigma2.android.data.prefs.ParentalAppLockStore
import com.enigma2.android.data.repository.Enigma2Repository
import kotlinx.coroutines.launch

/**
 * Editable parental control: shows status, lets the user change the receiver setup PIN,
 * protect a service by service-ref, unprotect listed services, and configure an
 * app-side PIN gate that locks this screen to a local PIN.
 */
class ParentalFragment : PreferenceFragmentCompat() {
    private val repo = Enigma2Repository()
    private lateinit var screen: PreferenceScreen
    private var unlocked = false

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        val ctx = preferenceManager.context
        screen = preferenceManager.createPreferenceScreen(ctx)
        preferenceScreen = screen
        screen.addPreference(Preference(ctx).apply {
            setTitle(R.string.recv_status_loading); isSelectable = false; isIconSpaceReserved = false
        })
    }

    override fun onResume() {
        super.onResume()
        if (unlocked) { build(); return }
        val store = ParentalAppLockStore(requireContext())
        if (!store.isEnabled()) { unlocked = true; build(); return }
        promptAppPin(store)
    }

    private fun promptAppPin(store: ParentalAppLockStore) {
        val ctx = requireContext()
        val et = EditText(ctx).apply {
            inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_VARIATION_PASSWORD
        }
        AlertDialog.Builder(ctx)
            .setTitle(R.string.recv_parental_app_lock_prompt)
            .setView(et)
            .setCancelable(false)
            .setNegativeButton(android.R.string.cancel) { _, _ -> parentFragmentManager.popBackStack() }
            .setPositiveButton(android.R.string.ok) { _, _ ->
                if (store.verify(et.text.toString())) { unlocked = true; build() }
                else {
                    Toast.makeText(ctx, R.string.recv_parental_app_lock_wrong, Toast.LENGTH_SHORT).show()
                    parentFragmentManager.popBackStack()
                }
            }
            .show()
    }

    private fun build() {
        val ctx = preferenceManager.context
        screen.removeAll()

        val status = Preference(ctx).apply {
            key = "p_status"; setTitle(R.string.recv_status_loading)
            isSelectable = false; isIconSpaceReserved = false
        }
        screen.addPreference(status)

        screen.addPreference(Preference(ctx).apply {
            setTitle(R.string.recv_parental_pin_set_title); isIconSpaceReserved = false
            setOnPreferenceClickListener { showChangePinDialog(); true }
        })
        screen.addPreference(Preference(ctx).apply {
            setTitle(R.string.recv_parental_action_protect); isIconSpaceReserved = false
            setOnPreferenceClickListener { showProtectDialog(); true }
        })
        screen.addPreference(Preference(ctx).apply {
            key = "p_refresh"; setTitle(R.string.refresh); isIconSpaceReserved = false
            setOnPreferenceClickListener { load(); true }
        })

        screen.addPreference(PreferenceCategory(ctx).apply {
            setTitle(R.string.recv_parental_app_lock_title); isIconSpaceReserved = false
        })
        val store = ParentalAppLockStore(requireContext())
        screen.addPreference(Preference(ctx).apply {
            setSummary(R.string.recv_parental_app_lock_summary); isSelectable = false; isIconSpaceReserved = false
        })
        screen.addPreference(Preference(ctx).apply {
            setTitle(R.string.recv_parental_app_lock_set); isIconSpaceReserved = false
            setOnPreferenceClickListener { showSetAppPin(store); true }
        })
        screen.addPreference(Preference(ctx).apply {
            setTitle(R.string.recv_parental_app_lock_clear); isIconSpaceReserved = false
            setOnPreferenceClickListener {
                store.clear()
                Toast.makeText(context, R.string.recv_op_ok, Toast.LENGTH_SHORT).show(); true
            }
        })

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

    private fun rebuildList(list: List<ProtectedService>) {
        val ctx = preferenceManager.context
        val toRemove = (0 until screen.preferenceCount).map { screen.getPreference(it) }
            .filter { it.key?.startsWith("psvc_") == true }
        toRemove.forEach { screen.removePreference(it) }
        for ((i, s) in list.withIndex()) {
            screen.addPreference(Preference(ctx).apply {
                key = "psvc_$i"; title = s.name; summary = s.ref
                isIconSpaceReserved = false
                setOnPreferenceClickListener { confirmUnprotect(s); true }
            })
        }
    }

    private fun confirmUnprotect(s: ProtectedService) {
        AlertDialog.Builder(requireContext())
            .setTitle(R.string.recv_parental_action_unprotect)
            .setMessage(s.name + "\n" + s.ref)
            .setNegativeButton(android.R.string.cancel, null)
            .setPositiveButton(android.R.string.ok) { _, _ ->
                lifecycleScope.launch {
                    val ok = repo.unprotectService(s.ref)
                    Toast.makeText(context,
                        if (ok) R.string.recv_parental_unprotected else R.string.recv_op_failed,
                        Toast.LENGTH_SHORT).show()
                    if (ok) load()
                }
            }
            .show()
    }

    private fun showProtectDialog() {
        val ctx = requireContext()
        val et = EditText(ctx).apply {
            inputType = InputType.TYPE_CLASS_TEXT
            hint = "1:0:1:..."
        }
        AlertDialog.Builder(ctx)
            .setTitle(R.string.recv_parental_action_protect)
            .setView(et)
            .setNegativeButton(android.R.string.cancel, null)
            .setPositiveButton(android.R.string.ok) { _, _ ->
                val ref = et.text.toString().trim()
                if (ref.isNotEmpty()) lifecycleScope.launch {
                    val ok = repo.protectService(ref)
                    Toast.makeText(context,
                        if (ok) R.string.recv_parental_protected_added else R.string.recv_op_failed,
                        Toast.LENGTH_SHORT).show()
                    if (ok) load()
                }
            }
            .show()
    }

    private fun showChangePinDialog() {
        val ctx = requireContext()
        val container = LinearLayout(ctx).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(48, 16, 48, 0)
        }
        val old = EditText(ctx).apply {
            inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_VARIATION_PASSWORD
            hint = getString(R.string.recv_parental_pin_old)
        }
        val newPin = EditText(ctx).apply {
            inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_VARIATION_PASSWORD
            hint = getString(R.string.recv_parental_pin_new)
        }
        val confirm = EditText(ctx).apply {
            inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_VARIATION_PASSWORD
            hint = getString(R.string.recv_parental_pin_confirm)
        }
        container.addView(old); container.addView(newPin); container.addView(confirm)
        AlertDialog.Builder(ctx)
            .setTitle(R.string.recv_parental_pin_set_title)
            .setView(container)
            .setNegativeButton(android.R.string.cancel, null)
            .setPositiveButton(android.R.string.ok) { _, _ ->
                val n = newPin.text.toString()
                if (n != confirm.text.toString() || n.isBlank()) {
                    Toast.makeText(ctx, R.string.recv_parental_pin_mismatch, Toast.LENGTH_SHORT).show()
                    return@setPositiveButton
                }
                lifecycleScope.launch {
                    val ok = repo.changeSetupPin(old.text.toString(), n)
                    Toast.makeText(context,
                        if (ok) R.string.recv_parental_pin_changed else R.string.recv_parental_pin_failed,
                        Toast.LENGTH_SHORT).show()
                    if (ok) load()
                }
            }
            .show()
    }

    private fun showSetAppPin(store: ParentalAppLockStore) {
        val ctx = requireContext()
        val container = LinearLayout(ctx).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(48, 16, 48, 0)
        }
        val newPin = EditText(ctx).apply {
            inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_VARIATION_PASSWORD
            hint = getString(R.string.recv_parental_pin_new)
        }
        val confirm = EditText(ctx).apply {
            inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_VARIATION_PASSWORD
            hint = getString(R.string.recv_parental_pin_confirm)
        }
        container.addView(newPin); container.addView(confirm)
        AlertDialog.Builder(ctx)
            .setTitle(R.string.recv_parental_app_lock_set)
            .setView(container)
            .setNegativeButton(android.R.string.cancel, null)
            .setPositiveButton(android.R.string.ok) { _, _ ->
                val n = newPin.text.toString()
                if (n.isBlank() || n != confirm.text.toString()) {
                    Toast.makeText(ctx, R.string.recv_parental_pin_mismatch, Toast.LENGTH_SHORT).show()
                    return@setPositiveButton
                }
                store.set(n)
                Toast.makeText(context, R.string.recv_op_ok, Toast.LENGTH_SHORT).show()
            }
            .show()
    }
}
