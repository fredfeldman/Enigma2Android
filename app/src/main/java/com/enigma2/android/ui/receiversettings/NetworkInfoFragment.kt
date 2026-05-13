package com.enigma2.android.ui.receiversettings

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceScreen
import com.enigma2.android.R
import com.enigma2.android.data.repository.Enigma2Repository
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONObject

class NetworkInfoFragment : PreferenceFragmentCompat() {
    private val repo = Enigma2Repository()
    private lateinit var screen: PreferenceScreen
    private var lastText: String = ""

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
            val raw = repo.getNetworkInfoRaw()
            screen.removeAll()
            val rows = parse(raw)
            lastText = rows.joinToString("\n") { "${it.first}: ${it.second}" }
            for ((i, r) in rows.withIndex()) {
                screen.addPreference(Preference(ctx).apply {
                    key = "n_$i"; title = r.first; summary = r.second
                    isSelectable = false; isIconSpaceReserved = false
                })
            }
            if (rows.isEmpty()) {
                screen.addPreference(Preference(ctx).apply {
                    setTitle(R.string.recv_storage_empty); isSelectable = false; isIconSpaceReserved = false
                })
            }
            screen.addPreference(Preference(ctx).apply {
                setTitle(R.string.recv_network_copy); isIconSpaceReserved = false
                setOnPreferenceClickListener { copy(); true }
            })
        }
    }

    private fun parse(raw: String?): List<Pair<String, String>> {
        if (raw.isNullOrBlank()) return emptyList()
        return try {
            val obj = JSONObject(raw)
            val out = mutableListOf<Pair<String, String>>()
            val ifaces: JSONArray? = obj.optJSONArray("ifaces") ?: obj.optJSONArray("interfaces")
            if (ifaces != null) {
                for (i in 0 until ifaces.length()) {
                    val it = ifaces.optJSONObject(i) ?: continue
                    val name = it.optString("name", "iface$i")
                    val ip = it.optString("ip", it.optString("ipv4", ""))
                    val mac = it.optString("mac", "")
                    val mask = it.optString("netmask", it.optString("mask", ""))
                    val gw = it.optString("gateway", "")
                    val parts = listOfNotNull(
                        ip.takeIf { it.isNotBlank() }?.let { "ip=$it" },
                        mask.takeIf { it.isNotBlank() }?.let { "mask=$it" },
                        gw.takeIf { it.isNotBlank() }?.let { "gw=$it" },
                        mac.takeIf { it.isNotBlank() }?.let { "mac=$it" }
                    )
                    out.add(name to parts.joinToString("  "))
                }
            } else {
                obj.keys().forEach { k -> out.add(k to obj.opt(k).toString()) }
            }
            out
        } catch (_: Exception) {
            listOf("network" to raw.take(2000))
        }
    }

    private fun copy() {
        val cm = requireContext().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        cm.setPrimaryClip(ClipData.newPlainText("network", lastText))
        Toast.makeText(context, R.string.recv_network_copied, Toast.LENGTH_SHORT).show()
    }
}
