package com.enigma2.android.ui.settings

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.preference.Preference
import androidx.preference.PreferenceCategory
import androidx.preference.PreferenceFragmentCompat
import com.enigma2.android.R
import com.enigma2.android.data.repository.Enigma2Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SettingsFragment : PreferenceFragmentCompat() {

    private val repo = Enigma2Repository()

    // v1.3.0: SAF picker for importing profile JSON
    private val importPicker = registerForActivityResult(
        androidx.activity.result.contract.ActivityResultContracts.OpenDocument()
    ) { uri ->
        if (uri == null) return@registerForActivityResult
        val ctx = context ?: return@registerForActivityResult
        androidx.appcompat.app.AlertDialog.Builder(ctx)
            .setTitle(R.string.import_confirm_title)
            .setMessage(R.string.import_confirm_message)
            .setPositiveButton(android.R.string.ok) { _, _ ->
                val prefs = com.enigma2.android.data.prefs.ReceiverPreferences(ctx)
                val res = com.enigma2.android.data.backup.ProfileBackup
                    .importFromUri(ctx, uri, prefs)
                if (res.ok) {
                    android.widget.Toast.makeText(ctx,
                        getString(R.string.import_done, res.added, res.updated),
                        android.widget.Toast.LENGTH_LONG).show()
                } else {
                    android.widget.Toast.makeText(ctx,
                        R.string.import_failed,
                        android.widget.Toast.LENGTH_LONG).show()
                }
            }
            .setNegativeButton(android.R.string.cancel, null)
            .show()
    }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)

        findPreference<Preference>("pref_hide_bouquets")
            ?.setOnPreferenceClickListener {
                startActivity(Intent(requireContext(), HideBouquetsActivity::class.java))
                true
            }

        findPreference<Preference>("manage_bouquets")
            ?.setOnPreferenceClickListener {
                startActivity(Intent(requireContext(),
                    com.enigma2.android.ui.bouqueteditor.BouquetEditorActivity::class.java))
                true
            }

        findPreference<Preference>("pref_box_info")
            ?.setOnPreferenceClickListener {
                startActivity(Intent(requireContext(), BoxInfoActivity::class.java))
                true
            }

        findPreference<Preference>("pref_receiver_settings")
            ?.setOnPreferenceClickListener {
                startActivity(Intent(requireContext(),
                    com.enigma2.android.ui.receiversettings.ReceiverSettingsActivity::class.java))
                true
            }

        // v1.2.0: External player picker
        val extPref = findPreference<Preference>("preferred_external_player")
        val prefs = com.enigma2.android.data.prefs.ReceiverPreferences(requireContext())
        fun refreshExtSummary() {
            val pkg = prefs.preferredExternalPackage
            extPref?.summary = if (pkg.isBlank())
                getString(R.string.pref_preferred_external_summary)
            else com.enigma2.android.ui.player.ExternalPlayerLauncher
                .resolveAppName(requireContext(), pkg) ?: pkg
        }
        refreshExtSummary()
        extPref?.setOnPreferenceClickListener {
            val installed = com.enigma2.android.ui.player.ExternalPlayerLauncher
                .installedKnownPlayers(requireContext())
            if (installed.isEmpty()) {
                android.widget.Toast.makeText(requireContext(),
                    R.string.player_mode_no_handler,
                    android.widget.Toast.LENGTH_SHORT).show()
                return@setOnPreferenceClickListener true
            }
            val labels = (listOf(getString(R.string.pref_preferred_external_none)) +
                installed.map { it.second } +
                listOf(getString(R.string.pref_preferred_external_clear))).toTypedArray()
            androidx.appcompat.app.AlertDialog.Builder(requireContext())
                .setTitle(R.string.pref_preferred_external_pick)
                .setItems(labels) { _, which ->
                    when {
                        which == 0 -> { prefs.preferredExternalPackage = "" }
                        which == labels.lastIndex -> { prefs.preferredExternalPackage = "" }
                        else -> { prefs.preferredExternalPackage = installed[which - 1].first }
                    }
                    refreshExtSummary()
                }
                .show()
            true
        }

        val epgImportPref = findPreference<Preference>("pref_epg_import")
        val pluginsCat = findPreference<PreferenceCategory>("pref_category_plugins")
        // Hide until we know it's available
        epgImportPref?.isVisible = false
        pluginsCat?.isVisible = false

        epgImportPref?.setOnPreferenceClickListener {
            startActivity(Intent(requireContext(), EpgImportActivity::class.java))
            true
        }

        // v1.3.0: profile export
        findPreference<Preference>("pref_export_profiles")?.setOnPreferenceClickListener {
            val ctx = requireContext()
            val view = android.widget.CheckBox(ctx).apply {
                text = getString(R.string.export_include_passwords)
                setPadding(48, 24, 48, 24)
            }
            androidx.appcompat.app.AlertDialog.Builder(ctx)
                .setTitle(R.string.pref_export_profiles_title)
                .setView(view)
                .setPositiveButton(android.R.string.ok) { _, _ ->
                    val prefs = com.enigma2.android.data.prefs.ReceiverPreferences(ctx)
                    val json = com.enigma2.android.data.backup.ProfileBackup
                        .encode(prefs, includePasswords = view.isChecked)
                    val ts = java.text.SimpleDateFormat("yyyyMMdd_HHmmss",
                        java.util.Locale.US).format(java.util.Date())
                    val path = com.enigma2.android.util.DownloadsWriter.writeText(
                        ctx, "enigma2android_profiles_$ts.json",
                        "application/json", json)
                    if (path != null) {
                        android.widget.Toast.makeText(ctx,
                            getString(R.string.export_done, path),
                            android.widget.Toast.LENGTH_LONG).show()
                    } else {
                        android.widget.Toast.makeText(ctx,
                            R.string.export_failed,
                            android.widget.Toast.LENGTH_LONG).show()
                    }
                }
                .setNegativeButton(android.R.string.cancel, null)
                .show()
            true
        }

        // v1.3.0: profile import (SAF)
        findPreference<Preference>("pref_import_profiles")?.setOnPreferenceClickListener {
            importPicker.launch(arrayOf("application/json", "*/*"))
            true
        }

        viewLifecycleOwnerLiveData.observe(this) { owner ->
            owner ?: return@observe
            owner.lifecycleScope.launch {
                val available = withContext(Dispatchers.IO) { repo.isEpgImportAvailable() }
                epgImportPref?.isVisible = available
                pluginsCat?.isVisible = available
            }
        }
    }
}
