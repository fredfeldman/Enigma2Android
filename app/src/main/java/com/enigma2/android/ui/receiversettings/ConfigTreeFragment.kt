package com.enigma2.android.ui.receiversettings

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.preference.EditTextPreference
import androidx.preference.ListPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceScreen
import androidx.preference.SwitchPreferenceCompat
import com.enigma2.android.R
import com.enigma2.android.data.model.settings.ConfigItemType
import com.enigma2.android.data.model.settings.ConfigSection
import com.enigma2.android.data.repository.Enigma2Repository
import kotlinx.coroutines.launch

/** Lists the receiver's `api/config` sections; tapping a section pushes [ConfigSectionFragment]. */
class ConfigTreeFragment : PreferenceFragmentCompat() {
    private val repo = Enigma2Repository()

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        val ctx = preferenceManager.context
        preferenceScreen = preferenceManager.createPreferenceScreen(ctx)
        preferenceScreen.addPreference(Preference(ctx).apply {
            key = "ct_status"; setTitle(R.string.recv_status_loading); isSelectable = false; isIconSpaceReserved = false
        })

        lifecycleScope.launch {
            try {
                val sections = repo.getConfigSections()
                preferenceScreen.removeAll()
                preferenceScreen.addPreference(Preference(ctx).apply {
                    isSelectable = false; isIconSpaceReserved = false
                    summary = getString(R.string.recv_config_tree_summary_count, sections.size)
                })
                for (s in sections) preferenceScreen.addPreference(Preference(ctx).apply {
                    title = s; isIconSpaceReserved = false
                    setOnPreferenceClickListener {
                        (activity as? ReceiverSettingsActivity)
                            ?.pushFragment(ConfigSectionFragment.newInstance(s), s)
                        true
                    }
                })
            } catch (e: Exception) {
                findPreference<Preference>("ct_status")?.summary =
                    getString(R.string.recv_op_failed, e.message ?: "")
            }
        }
    }
}

/** Edits a single `api/config/{section}` and saves changes via `web/saveconfig`. */
class ConfigSectionFragment : PreferenceFragmentCompat() {
    private val repo = Enigma2Repository()
    private val sectionName: String get() = arguments?.getString(ARG_SECTION).orEmpty()

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        val ctx = preferenceManager.context
        preferenceScreen = preferenceManager.createPreferenceScreen(ctx)
        preferenceScreen.addPreference(Preference(ctx).apply {
            key = "cs_status"; setTitle(R.string.recv_status_loading); isSelectable = false; isIconSpaceReserved = false
        })
        lifecycleScope.launch {
            try {
                val section = repo.getConfigSection(sectionName)
                render(section)
            } catch (e: Exception) {
                findPreference<Preference>("cs_status")?.summary =
                    getString(R.string.recv_op_failed, e.message ?: "")
            }
        }
    }

    private fun render(section: ConfigSection) {
        val ctx = preferenceManager.context
        val screen: PreferenceScreen = preferenceScreen
        screen.removeAll()
        if (section.items.isEmpty()) {
            screen.addPreference(Preference(ctx).apply {
                title = getString(R.string.recv_config_section_empty); isSelectable = false; isIconSpaceReserved = false
            })
            return
        }
        for (item in section.items) {
            val pref: Preference = when (item.type) {
                ConfigItemType.Bool -> SwitchPreferenceCompat(ctx).apply {
                    isChecked = item.value.equals("true", true) || item.value == "1"
                    setOnPreferenceChangeListener { _, newValue ->
                        save(item.path, if (newValue as Boolean) "true" else "false"); true
                    }
                }
                ConfigItemType.Choice -> ListPreference(ctx).apply {
                    entries = item.choices.map { it.second }.toTypedArray()
                    entryValues = item.choices.map { it.first }.toTypedArray()
                    value = item.value
                    setOnPreferenceChangeListener { _, newValue ->
                        save(item.path, newValue as String); summary = newValue; true
                    }
                    summary = item.value
                }
                ConfigItemType.Password -> EditTextPreference(ctx).apply {
                    text = item.value
                    setOnBindEditTextListener { it.inputType =
                        android.text.InputType.TYPE_CLASS_TEXT or android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD }
                    setOnPreferenceChangeListener { _, newValue -> save(item.path, newValue as String); true }
                }
                else -> EditTextPreference(ctx).apply {
                    text = item.value; summary = item.value
                    setOnPreferenceChangeListener { _, newValue ->
                        save(item.path, newValue as String); summary = newValue as String; true
                    }
                }
            }
            pref.title = item.description.ifBlank { item.path }
            pref.isIconSpaceReserved = false
            pref.key = "ci_${item.path}"
            screen.addPreference(pref)
        }
    }

    private fun save(path: String, value: String) {
        lifecycleScope.launch {
            try {
                val r = repo.saveConfig(path, value)
                Toast.makeText(context,
                    if (r.first) getString(R.string.recv_op_ok)
                    else getString(R.string.recv_op_failed, r.second ?: ""),
                    Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Toast.makeText(context, getString(R.string.recv_op_failed, e.message ?: ""), Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        private const val ARG_SECTION = "section"
        fun newInstance(section: String): ConfigSectionFragment =
            ConfigSectionFragment().apply { arguments = Bundle().apply { putString(ARG_SECTION, section) } }
    }
}
