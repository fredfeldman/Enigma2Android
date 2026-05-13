package com.enigma2.android.ui.receiversettings

import android.os.Bundle
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

/** Read-only viewer for receiver storage: mountpoints + SMART summary. */
class StorageFragment : PreferenceFragmentCompat() {
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
        val loading = Preference(ctx).apply {
            setTitle(R.string.recv_status_loading); isSelectable = false; isIconSpaceReserved = false
        }
        screen.addPreference(loading)
        lifecycleScope.launch {
            val mounts = repo.getMountInfoRaw()
            val smart = repo.getSmartInfoRaw()
            screen.removeAll()

            screen.addPreference(PreferenceCategory(ctx).apply {
                setTitle(R.string.recv_storage_mounts); isIconSpaceReserved = false
            })
            val mountLines = parseMountInfo(mounts)
            if (mountLines.isEmpty()) {
                screen.addPreference(Preference(ctx).apply {
                    setTitle(R.string.recv_storage_empty); isSelectable = false; isIconSpaceReserved = false
                })
            } else {
                for ((i, line) in mountLines.withIndex()) {
                    screen.addPreference(Preference(ctx).apply {
                        key = "mnt_$i"; title = line.first; summary = line.second
                        isSelectable = false; isIconSpaceReserved = false
                    })
                }
            }

            screen.addPreference(PreferenceCategory(ctx).apply {
                setTitle(R.string.recv_storage_smart); isIconSpaceReserved = false
            })
            val smartText = smart?.takeIf { it.isNotBlank() } ?: getString(R.string.recv_storage_empty)
            screen.addPreference(Preference(ctx).apply {
                key = "smart"; summary = smartText
                isSelectable = false; isIconSpaceReserved = false
            })
        }
    }

    private fun parseMountInfo(raw: String?): List<Pair<String, String>> {
        if (raw.isNullOrBlank()) return emptyList()
        return try {
            val obj = JSONObject(raw)
            val arr: JSONArray = obj.optJSONArray("mountinfo") ?: obj.optJSONArray("mounts")
                ?: return listOf("Mountinfo" to raw.take(2000))
            val out = mutableListOf<Pair<String, String>>()
            for (i in 0 until arr.length()) {
                val m = arr.optJSONObject(i) ?: continue
                val mount = m.optString("mountpoint", m.optString("mount", "?"))
                val total = m.optString("total", "")
                val free = m.optString("free", "")
                val used = m.optString("used", "")
                val summary = listOf("total" to total, "used" to used, "free" to free)
                    .filter { it.second.isNotBlank() }
                    .joinToString("  ") { "${it.first}=${it.second}" }
                out.add(mount to summary)
            }
            out
        } catch (_: Exception) {
            listOf("Mountinfo" to raw.take(2000))
        }
    }
}
