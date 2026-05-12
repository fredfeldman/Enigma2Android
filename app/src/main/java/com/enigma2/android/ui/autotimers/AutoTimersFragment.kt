package com.enigma2.android.ui.autotimers

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.enigma2.android.R
import com.enigma2.android.data.model.AutoTimer
import com.enigma2.android.data.repository.Enigma2Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AutoTimersFragment : Fragment() {

    private val repo = Enigma2Repository()
    private lateinit var adapter: AutoTimerAdapter
    private lateinit var rv: RecyclerView
    private lateinit var progress: ProgressBar
    private lateinit var tvEmpty: TextView
    private lateinit var swipe: SwipeRefreshLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_autotimers, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = AutoTimerAdapter(
            onEdit = { showEditDialog(it) },
            onDelete = { confirmDelete(it) },
            onToggle = { at, enabled -> save(at.copy(enabled = enabled), reloadOnSuccess = false) }
        )

        rv = view.findViewById(R.id.rv_autotimers)
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = adapter

        progress = view.findViewById(R.id.progress_autotimers)
        tvEmpty = view.findViewById(R.id.tv_autotimers_empty)
        swipe = view.findViewById(R.id.swipe_autotimers)
        swipe.setOnRefreshListener { load() }

        view.findViewById<Toolbar>(R.id.toolbar_autotimers)
            .setNavigationOnClickListener { parentFragmentManager.popBackStack() }

        view.findViewById<Button>(R.id.btn_autotimer_add).setOnClickListener {
            showEditDialog(null)
        }

        load()
    }

    private fun load() {
        progress.visibility = View.VISIBLE
        tvEmpty.visibility = View.GONE
        viewLifecycleOwner.lifecycleScope.launch {
            val list = withContext(Dispatchers.IO) { repo.getAutoTimers() }
            adapter.submitList(list)
            progress.visibility = View.GONE
            swipe.isRefreshing = false
            val empty = list.isEmpty()
            tvEmpty.visibility = if (empty) View.VISIBLE else View.GONE
            rv.visibility = if (empty) View.GONE else View.VISIBLE
        }
    }

    private fun confirmDelete(at: AutoTimer) {
        AlertDialog.Builder(requireContext())
            .setTitle(R.string.delete)
            .setMessage(getString(R.string.delete_autotimer_confirm, at.name.ifEmpty { at.match }))
            .setPositiveButton(R.string.delete) { _, _ ->
                viewLifecycleOwner.lifecycleScope.launch {
                    val ok = withContext(Dispatchers.IO) { repo.removeAutoTimer(at.id) }
                    if (ok) load()
                    else Toast.makeText(requireContext(), R.string.delete_failed, Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton(android.R.string.cancel, null)
            .show()
    }

    private fun showEditDialog(existing: AutoTimer?) {
        val view = LayoutInflater.from(requireContext())
            .inflate(R.layout.dialog_autotimer_edit, null, false)
        val etName = view.findViewById<EditText>(R.id.et_at_name)
        val etMatch = view.findViewById<EditText>(R.id.et_at_match)
        val cbEnabled = view.findViewById<CheckBox>(R.id.cb_at_enabled)
        val cbJustplay = view.findViewById<CheckBox>(R.id.cb_at_justplay)

        if (existing != null) {
            etName.setText(existing.name)
            etMatch.setText(existing.match)
            cbEnabled.isChecked = existing.enabled
            cbJustplay.isChecked = existing.justplay
        }

        val titleRes = if (existing == null) R.string.add_autotimer else R.string.edit_autotimer
        AlertDialog.Builder(requireContext())
            .setTitle(titleRes)
            .setView(view)
            .setPositiveButton(R.string.save) { _, _ ->
                val name = etName.text.toString().trim()
                val match = etMatch.text.toString().trim()
                if (name.isEmpty() || match.isEmpty()) {
                    Toast.makeText(requireContext(), R.string.autotimer_name_required, Toast.LENGTH_SHORT).show()
                    return@setPositiveButton
                }
                val updated = (existing ?: AutoTimer()).copy(
                    name = name,
                    match = match,
                    enabled = cbEnabled.isChecked,
                    justplay = cbJustplay.isChecked
                )
                save(updated, reloadOnSuccess = true)
            }
            .setNegativeButton(android.R.string.cancel, null)
            .show()
    }

    private fun save(at: AutoTimer, reloadOnSuccess: Boolean) {
        viewLifecycleOwner.lifecycleScope.launch {
            val ok = withContext(Dispatchers.IO) { repo.saveAutoTimer(at) }
            if (ok) {
                Toast.makeText(requireContext(), R.string.autotimer_saved, Toast.LENGTH_SHORT).show()
                if (reloadOnSuccess) load() else load()
            } else {
                Toast.makeText(requireContext(), R.string.autotimer_save_failed, Toast.LENGTH_LONG).show()
                load()
            }
        }
    }
}
