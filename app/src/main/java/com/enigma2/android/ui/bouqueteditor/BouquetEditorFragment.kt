package com.enigma2.android.ui.bouqueteditor

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.enigma2.android.R
import com.enigma2.android.data.model.Bouquet
import com.enigma2.android.data.prefs.ReceiverPreferences
import com.enigma2.android.data.repository.Enigma2Repository
import kotlinx.coroutines.launch

/**
 * Lists every bouquet on the receiver, showing a User/Provider badge and
 * a banner indicating whether server-side editing is available (BouquetEditor
 * plugin installed) or the app is in local-only fallback mode.
 */
class BouquetEditorFragment : Fragment() {

    private lateinit var rv: RecyclerView
    private lateinit var loading: ProgressBar
    private lateinit var empty: TextView
    private lateinit var banner: TextView
    private lateinit var btnNew: TextView
    private lateinit var btnRefresh: TextView

    private val repo = Enigma2Repository()
    private val prefs by lazy { ReceiverPreferences(requireContext()) }

    private var capability: Enigma2Repository.BouquetEditorCapability =
        Enigma2Repository.BouquetEditorCapability.Missing
    private var userBouquetRefs: Set<String> = emptySet()
    private var allBouquets: List<Bouquet> = emptyList()

    private val adapter = BouquetEditorAdapter(
        onEdit = { openEditor(it) },
        onRename = { promptRename(it) },
        onDelete = { promptDelete(it) }
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_bouquet_editor, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv = view.findViewById(R.id.rv_be_bouquets)
        loading = view.findViewById(R.id.be_loading)
        empty = view.findViewById(R.id.tv_be_empty)
        banner = view.findViewById(R.id.tv_be_banner)
        btnNew = view.findViewById(R.id.btn_be_new)
        btnRefresh = view.findViewById(R.id.btn_be_refresh)

        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = adapter

        btnNew.setOnClickListener { promptNew() }
        btnRefresh.setOnClickListener { load() }

        load()
    }

    override fun onResume() {
        super.onResume()
        if (allBouquets.isNotEmpty()) load()
    }

    private fun load() {
        loading.visibility = View.VISIBLE
        empty.visibility = View.GONE
        viewLifecycleOwner.lifecycleScope.launch {
            capability = repo.probeBouquetEditor()
            val all = try { repo.getAllBouquets() } catch (_: Exception) { emptyList() }
            val userBouquets = if (capability == Enigma2Repository.BouquetEditorCapability.Available)
                repo.getUserBouquets() else emptyList()
            userBouquetRefs = userBouquets.map { it.ref }.toSet()
            allBouquets = all

            loading.visibility = View.GONE
            empty.visibility = if (all.isEmpty()) View.VISIBLE else View.GONE
            applyBanner()
            adapter.submit(all, userBouquetRefs, capability)
            btnNew.visibility =
                if (capability == Enigma2Repository.BouquetEditorCapability.Available) View.VISIBLE else View.GONE
        }
    }

    private fun applyBanner() {
        val isServer = capability == Enigma2Repository.BouquetEditorCapability.Available
        banner.visibility = View.VISIBLE
        banner.text = getString(
            if (isServer) R.string.bouquet_editor_banner_server
            else R.string.bouquet_editor_banner_local
        )
        banner.setBackgroundColor(
            if (isServer) 0xFF2E7D32.toInt() // green
            else 0xFFB07300.toInt() // amber
        )
    }

    private fun openEditor(bouquet: Bouquet) {
        val hasOverride = prefs.getBouquetOverride(bouquet.ref) != null
        val isServer = capability == Enigma2Repository.BouquetEditorCapability.Available
        val isUserBouquet = bouquet.ref in userBouquetRefs
        if (isServer && isUserBouquet && hasOverride) {
            AlertDialog.Builder(requireContext())
                .setTitle(R.string.bouquet_local_conflict_title)
                .setMessage(getString(R.string.bouquet_local_conflict_message, bouquet.name))
                .setPositiveButton(R.string.bouquet_local_conflict_discard) { _, _ ->
                    prefs.clearBouquetOverride(bouquet.ref)
                    pushEditor(bouquet)
                }
                .setNeutralButton(R.string.bouquet_local_conflict_keep) { _, _ ->
                    pushEditor(bouquet)
                }
                .setNegativeButton(R.string.bouquet_local_conflict_apply) { _, _ ->
                    applyLocalToServer(bouquet)
                }
                .show()
            return
        }
        pushEditor(bouquet)
    }

    private fun pushEditor(bouquet: Bouquet) {
        val isUserBouquet = bouquet.ref in userBouquetRefs
        parentFragmentManager.beginTransaction()
            .replace(
                R.id.bouquet_editor_container,
                BouquetEditFragment.newInstance(
                    bouquetRef = bouquet.ref,
                    bouquetName = bouquet.name,
                    isUserBouquet = isUserBouquet,
                    serverMode = capability == Enigma2Repository.BouquetEditorCapability.Available
                )
            )
            .addToBackStack(null)
            .commit()
    }

    private fun applyLocalToServer(bouquet: Bouquet) {
        val override = prefs.getBouquetOverride(bouquet.ref) ?: run {
            pushEditor(bouquet); return
        }
        viewLifecycleOwner.lifecycleScope.launch {
            try {
                for (ref in override.removed) {
                    repo.removeServiceFromBouquet(bouquet.ref, ref)
                }
                override.order.forEachIndexed { idx, ref ->
                    repo.moveServiceInBouquet(bouquet.ref, ref, idx)
                }
                prefs.clearBouquetOverride(bouquet.ref)
                Toast.makeText(requireContext(),
                    getString(R.string.bouquet_edit_overrides_cleared, bouquet.name),
                    Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Toast.makeText(requireContext(),
                    getString(R.string.bouquet_editor_op_failed, e.message ?: ""),
                    Toast.LENGTH_LONG).show()
            }
            pushEditor(bouquet)
        }
    }

    private fun promptNew() {
        val view = layoutInflater.inflate(R.layout.dialog_new_bouquet, null)
        val etName = view.findViewById<EditText>(R.id.et_new_bouquet_name)
        val rg = view.findViewById<RadioGroup>(R.id.rg_new_bouquet_mode)
        val cbHdhr = view.findViewById<android.widget.CheckBox>(R.id.cb_import_hdhr)
        val llHdhr = view.findViewById<View>(R.id.ll_hdhr_options)
        val etHost = view.findViewById<EditText>(R.id.et_hdhr_host)
        val cbSkipDrm = view.findViewById<android.widget.CheckBox>(R.id.cb_skip_drm)
        cbHdhr.setOnCheckedChangeListener { _, checked ->
            llHdhr.visibility = if (checked) View.VISIBLE else View.GONE
            // HDHomeRun is TV-only; force TV mode and disable Radio choice
            if (checked) {
                view.findViewById<android.widget.RadioButton>(R.id.rb_mode_tv).isChecked = true
            }
            view.findViewById<android.widget.RadioButton>(R.id.rb_mode_radio).isEnabled = !checked
        }
        AlertDialog.Builder(requireContext())
            .setTitle(R.string.bouquet_new_title)
            .setView(view)
            .setPositiveButton(android.R.string.ok) { _, _ ->
                val name = etName.text.toString().trim()
                if (name.isEmpty()) return@setPositiveButton
                val mode = if (rg.checkedRadioButtonId == R.id.rb_mode_radio)
                    Enigma2Repository.MODE_RADIO else Enigma2Repository.MODE_TV
                if (cbHdhr.isChecked) {
                    val host = etHost.text.toString().trim()
                        .ifBlank { "hdhomerun.local" }
                    importFromHdHomeRun(name, host, cbSkipDrm.isChecked)
                } else {
                    runOp { repo.addBouquet(name, mode) }
                }
            }
            .setNegativeButton(android.R.string.cancel, null)
            .show()
    }

    /**
     * v1.4.0 — Create a new TV bouquet then populate it with every channel
     * exposed by the HDHomeRun device at [host]. Each channel becomes an
     * IPTV service ref (type 4097) pointing at the device's MPEG-TS URL.
     */
    private fun importFromHdHomeRun(name: String, host: String, skipDrm: Boolean) {
        val ctx = requireContext()
        Toast.makeText(ctx, R.string.bouquet_hdhr_starting, Toast.LENGTH_SHORT).show()
        viewLifecycleOwner.lifecycleScope.launch {
            try {
                // 1) Probe device + lineup off the main thread.
                val (info, lineup) = kotlinx.coroutines.withContext(
                    kotlinx.coroutines.Dispatchers.IO
                ) {
                    val info = com.enigma2.android.data.hdhomerun.HdHomeRunClient.discover(host)
                    val lineup = com.enigma2.android.data.hdhomerun.HdHomeRunClient.fetchLineup(host)
                    info to lineup
                }
                if (info == null && lineup.isEmpty()) {
                    Toast.makeText(ctx,
                        getString(R.string.bouquet_hdhr_unreachable, host),
                        Toast.LENGTH_LONG).show()
                    return@launch
                }
                val playable = lineup.filter { !skipDrm || !it.isProtected }
                if (playable.isEmpty()) {
                    Toast.makeText(ctx,
                        R.string.bouquet_hdhr_no_channels,
                        Toast.LENGTH_LONG).show()
                    return@launch
                }

                // 2) Create the bouquet (TV mode).
                val createRes = repo.addBouquet(name, Enigma2Repository.MODE_TV)
                if (!createRes.ok) {
                    Toast.makeText(ctx,
                        getString(R.string.bouquet_editor_op_failed, createRes.message ?: ""),
                        Toast.LENGTH_LONG).show()
                    return@launch
                }

                // 3) Find the freshly-created user bouquet by name. Server may
                //    have rewritten the name (spaces -> underscores etc.); match
                //    by best-effort case-insensitive contains.
                val newBouquet = repo.getUserBouquets()
                    .firstOrNull { it.name.equals(name, ignoreCase = true) }
                    ?: repo.getUserBouquets()
                        .firstOrNull { it.name.contains(name, ignoreCase = true) }
                if (newBouquet == null) {
                    Toast.makeText(ctx,
                        R.string.bouquet_hdhr_not_found,
                        Toast.LENGTH_LONG).show()
                    BouquetEditorEvents.markDirty()
                    load()
                    return@launch
                }

                // 4) Push every channel into the bouquet sequentially.
                var added = 0
                var failed = 0
                for (ch in playable) {
                    val ref = com.enigma2.android.data.hdhomerun.HdHomeRunClient.toEnigma2Ref(ch)
                    val display = ch.guideName.ifBlank { ch.guideNumber }
                    val service = com.enigma2.android.data.model.Service(ref = ref, name = display)
                    try {
                        val r = repo.addServiceToBouquet(newBouquet.ref, service)
                        if (r.ok) added++ else failed++
                    } catch (_: Exception) { failed++ }
                }

                Toast.makeText(ctx,
                    getString(R.string.bouquet_hdhr_done, added, failed),
                    Toast.LENGTH_LONG).show()
                BouquetEditorEvents.markDirty()
                load()
            } catch (e: Exception) {
                Toast.makeText(ctx,
                    getString(R.string.bouquet_editor_op_failed, e.message ?: ""),
                    Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun promptRename(bouquet: Bouquet) {
        val et = EditText(requireContext()).apply { setText(bouquet.name); setSingleLine() }
        AlertDialog.Builder(requireContext())
            .setTitle(R.string.bouquet_rename_title)
            .setView(et)
            .setPositiveButton(android.R.string.ok) { _, _ ->
                val name = et.text.toString().trim()
                if (name.isNotEmpty() && name != bouquet.name)
                    runOp { repo.renameBouquet(bouquet.ref, name) }
            }
            .setNegativeButton(android.R.string.cancel, null)
            .show()
    }

    private fun promptDelete(bouquet: Bouquet) {
        AlertDialog.Builder(requireContext())
            .setTitle(R.string.bouquet_delete_title)
            .setMessage(getString(R.string.bouquet_delete_message, bouquet.name))
            .setPositiveButton(R.string.delete) { _, _ ->
                runOp {
                    val r = repo.removeBouquet(bouquet.ref)
                    prefs.hiddenBouquets = prefs.hiddenBouquets - bouquet.ref
                    prefs.clearBouquetOverride(bouquet.ref)
                    r
                }
            }
            .setNegativeButton(android.R.string.cancel, null)
            .show()
    }

    private fun runOp(block: suspend () -> com.enigma2.android.data.api.BouquetEditorXml.SimpleResult) {
        viewLifecycleOwner.lifecycleScope.launch {
            try {
                val r = block()
                Toast.makeText(requireContext(),
                    if (r.ok) getString(R.string.bouquet_editor_op_ok)
                    else getString(R.string.bouquet_editor_op_failed, r.message ?: ""),
                    Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Toast.makeText(requireContext(),
                    getString(R.string.bouquet_editor_op_failed, e.message ?: ""),
                    Toast.LENGTH_LONG).show()
            }
            BouquetEditorEvents.markDirty()
            load()
        }
    }
}
