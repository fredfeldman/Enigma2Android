package com.enigma2.android.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enigma2.android.data.model.EpgEvent
import com.enigma2.android.data.repository.Enigma2Repository
import kotlinx.coroutines.launch

class EpgViewModel : ViewModel() {

    private val repo = Enigma2Repository()

    private val _epgByService = MutableLiveData<Map<String, List<EpgEvent>>>()
    val epgByService: LiveData<Map<String, List<EpgEvent>>> = _epgByService

    private val _recordingTimerIds = MutableLiveData<Set<Long>>(emptySet())
    val recordingTimerIds: LiveData<Set<Long>> = _recordingTimerIds

    fun loadMultiEpg(bouquetRef: String) {
        viewModelScope.launch {
            try {
                val events = repo.getMultiEpg(bouquetRef)
                _epgByService.value = events.groupBy { it.sref }

                // Mark events that have recording timers
                val timers = repo.getTimers()
                val timerKeys = timers.map { "${it.serviceRef}_${it.beginTimestamp}" }.toSet()
                val recordingIds = events
                    .filter { "${it.sref}_${it.beginTimestamp}" in timerKeys }
                    .map { it.id }
                    .toSet()
                _recordingTimerIds.value = recordingIds
            } catch (e: Exception) {
                _epgByService.value = emptyMap()
            }
        }
    }

    fun loadEpgForService(serviceRef: String) {
        viewModelScope.launch {
            try {
                val events = repo.getEpgForService(serviceRef)
                val current = _epgByService.value?.toMutableMap() ?: mutableMapOf()
                current[serviceRef] = events
                _epgByService.value = current
            } catch (e: Exception) { /* non-critical */ }
        }
    }
}
