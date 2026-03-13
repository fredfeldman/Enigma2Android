package com.enigma2.android.ui.timers

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.enigma2.android.R
import com.enigma2.android.data.model.Timer
import com.enigma2.android.data.repository.Enigma2Repository
import com.enigma2.android.ui.viewmodel.RecordingViewModel
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TimersFragment : Fragment() {

    private val repo = Enigma2Repository()
    private lateinit var adapter: TimerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_timers, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = TimerAdapter { timer -> confirmDelete(timer) }

        val rv = view.findViewById<RecyclerView>(R.id.rv_timers)
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = adapter

        view.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar_timers)
            .setNavigationOnClickListener { parentFragmentManager.popBackStack() }

        loadTimers()
    }

    private fun loadTimers() {
        viewLifecycleOwner.lifecycleScope.launch {
            val timers = withContext(Dispatchers.IO) { repo.getTimers() }
            adapter.submitList(timers)
        }
    }

    private fun confirmDelete(timer: Timer) {
        AlertDialog.Builder(requireContext())
            .setTitle(R.string.delete_timer)
            .setMessage(getString(R.string.delete_timer_confirm, timer.name))
            .setPositiveButton(R.string.delete) { _, _ -> deleteTimer(timer) }
            .setNegativeButton(android.R.string.cancel, null)
            .show()
    }

    private fun deleteTimer(timer: Timer) {
        viewLifecycleOwner.lifecycleScope.launch {
            val ok = withContext(Dispatchers.IO) {
                repo.deleteTimer(timer.serviceRef, timer.beginTimestamp, timer.endTimestamp)
            }
            if (ok) loadTimers()
            else Toast.makeText(requireContext(), R.string.delete_failed, Toast.LENGTH_SHORT).show()
        }
    }
}
