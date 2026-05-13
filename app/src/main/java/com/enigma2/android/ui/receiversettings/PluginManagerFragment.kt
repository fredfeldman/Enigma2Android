package com.enigma2.android.ui.receiversettings

import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.lifecycleScope
import androidx.preference.Preference
import androidx.preference.PreferenceCategory
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceScreen
import com.enigma2.android.R
import com.enigma2.android.data.repository.Enigma2Repository
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONObject

class PluginManagerFragment : PreferenceFragmentCompat() {
    private val repo = Enigma2Repository()
    private lateinit var screen: PreferenceScreen

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        val ctx = preferenceManager.context
        screen = preferenceManager.createPreferenceScreen(ctx)
        preferenceScreen = screen
        load()
    }

    private fun load() {
        val ctx = preferenceManager.context
        screen.removeAll()
        screen.addPreference(Preference(ctx).apply {
            setTitle(R.string.recv_status_loading); isSelectable = false; isIconSpaceReserved = false
        })
        lifecycleScope.launch {
            val raw = repo.listPluginsRaw()
            screen.removeAll()

            screen.addPreference(Preference(ctx).apply {
                setTitle(R.string.recv_plugins_install); isIconSpaceReserved = false
                setOnPreferenceClickListener { installDialog(); true }
            })
            screen.addPreference(Preference(ctx).apply {
                setSummary(R.string.recv_plugins_warn); isSelectable = false; isIconSpaceReserved = false
            })

            val plugins = parsePlugins(raw)
            screen.addPreference(PreferenceCategory(ctx).apply {
                title = getString(R.string.recv_plugins_count, plugins.size)
                isIconSpaceReserved = false
            })
            for ((i, p) in plugins.withIndex()) {
                screen.addPreference(Preference(ctx).apply {
                    key = "plg_$i"; title = p.name; summary = p.pkg
                    isIconSpaceReserved = false
                    setOnPreferenceClickListener { confirmRemove(p.pkg); true }
                })
            }
        }
    }

    private data class Plug(val name: String, val pkg: String)

    private fun parsePlugins(raw: String?): List<Plug> {
        if (raw.isNullOrBlank()) return emptyList()
        return try {
            val obj = JSONObject(raw)
            val arr: JSONArray = obj.optJSONArray("plugins")
                ?: obj.optJSONArray("Plugins")
                ?: return emptyList()
            val out = mutableListOf<Plug>()
            for (i in 0 until arr.length()) {
                when (val v = arr.opt(i)) {
                    is JSONObject -> {
                        val name = v.optString("name", v.optString("Name", ""))
                        val pkg = v.optString("package", v.optString("Package", v.optString("pkg", name)))
                        if (pkg.isNotBlank()) out.add(Plug(if (name.isNotBlank()) name else pkg, pkg))
                    }
                    is String -> if (v.isNotBlank()) out.add(Plug(v, v))
                    else -> {}
                }
            }
            out
        } catch (_: Exception) { emptyList() }
    }

    private fun installDialog() {
        val ctx = requireContext()
        val et = EditText(ctx).apply {
            inputType = InputType.TYPE_CLASS_TEXT
            hint = getString(R.string.recv_plugins_install_hint)
        }
        AlertDialog.Builder(ctx)
            .setTitle(R.string.recv_plugins_install)
            .setView(et)
            .setNegativeButton(android.R.string.cancel, null)
            .setPositiveButton(android.R.string.ok) { _, _ ->
                val pkg = et.text.toString().trim()
                if (pkg.isNotEmpty()) doInstall(pkg)
            }
            .show()
    }

    private fun doInstall(pkg: String) {
        Toast.makeText(context, R.string.recv_plugins_op_running, Toast.LENGTH_SHORT).show()
        lifecycleScope.launch {
            val ok = repo.installPlugin(pkg)
            Toast.makeText(context,
                if (ok) R.string.recv_plugins_op_done else R.string.recv_plugins_op_failed,
                Toast.LENGTH_SHORT).show()
            if (ok) load()
        }
    }

    private fun confirmRemove(pkg: String) {
        AlertDialog.Builder(requireContext())
            .setTitle(R.string.recv_plugins_remove)
            .setMessage(getString(R.string.recv_plugins_remove_confirm, pkg))
            .setNegativeButton(android.R.string.cancel, null)
            .setPositiveButton(android.R.string.ok) { _, _ -> doRemove(pkg) }
            .show()
    }

    private fun doRemove(pkg: String) {
        Toast.makeText(context, R.string.recv_plugins_op_running, Toast.LENGTH_SHORT).show()
        lifecycleScope.launch {
            val ok = repo.removePlugin(pkg)
            Toast.makeText(context,
                if (ok) R.string.recv_plugins_op_done else R.string.recv_plugins_op_failed,
                Toast.LENGTH_SHORT).show()
            if (ok) load()
        }
    }
}
