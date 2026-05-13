package com.enigma2.android.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.enigma2.android.data.model.EpgEvent
import com.enigma2.android.data.prefs.EpgCacheStore
import com.enigma2.android.data.repository.Enigma2Repository
import kotlinx.coroutines.launch

class EpgViewModel(app: Application) : AndroidViewModel(app) {

    private val repo = Enigma2Repository()
    private val cache = EpgCacheStore(app)

    private val _epgByService = MutableLiveData<Map<String, List<EpgEvent>>>()
    val epgByService: LiveData<Map<String, List<EpgEvent>>> = _epgByService

    private val _recordingTimerIds = MutableLiveData<Set<Long>>(emptySet())
    val recordingTimerIds: LiveData<Set<Long>> = _recordingTimerIds

    /** True when the current `epgByService` snapshot was served from cache. */
    private val _offline = MutableLiveData(false)
    val offline: LiveData<Boolean> = _offline

    /** Timestamp (epoch ms) of the cached entry currently shown, when offline. */
    private val _cacheTimestamp = MutableLiveData<Long?>(null)
    val cacheTimestamp: LiveData<Long?> = _cacheTimestamp

    /** One-shot refresh status messages (for toasts). */
    private val _refreshStatus = MutableLiveData<String?>(null)
    val refreshStatus: LiveData<String?> = _refreshStatus
    fun consumeRefreshStatus() { _refreshStatus.value = null }

    fun loadMultiEpg(bouquetRef: String) {
        viewModelScope.launch {
            try {
                val events = repo.getMultiEpg(bouquetRef)
                if (events.isNotEmpty()) {
                    _epgByService.value = events.groupBy { it.sref }
                    _offline.value = false
                    _cacheTimestamp.value = null
                    cache.put(bouquetRef, events)
                } else {
                    serveFromCache(bouquetRef)
                }
                val timers = repo.getTimers()
                val timerKeys = timers.map { "${it.serviceRef}_${it.beginTimestamp}" }.toSet()
                val recordingIds = (events.ifEmpty { cache.get(bouquetRef)?.events.orEmpty() })
                    .filter { "${it.sref}_${it.beginTimestamp}" in timerKeys }
                    .map { it.id }
                    .toSet()
                _recordingTimerIds.value = recordingIds
            } catch (_: Exception) {
                serveFromCache(bouquetRef)
            }
        }
    }

    private fun serveFromCache(bouquetRef: String) {
        val cached = cache.get(bouquetRef)
        if (cached != null) {
            _epgByService.value = cached.events.groupBy { it.sref }
            _offline.value = true
            _cacheTimestamp.value = cached.timestamp
        } else {
            _epgByService.value = emptyMap()
            _offline.value = false
            _cacheTimestamp.value = null
        }
    }

    /** Trigger a server-side EPG refresh for each visible service then reload. */
    fun refreshAndReload(bouquetRef: String, serviceRefs: List<String>) {
        viewModelScope.launch {
            var ok = repo.triggerEpgRefresh()
            if (!ok) {
                // Fall back to per-service refresh
                ok = serviceRefs.any { repo.refreshEpgForService(it) }
            }
            _refreshStatus.value = if (ok) "ok" else "failed"
            loadMultiEpg(bouquetRef)
        }
    }

    fun loadEpgForService(serviceRef: String) {
        viewModelScope.launch {
            try {
                val events = repo.getEpgForService(serviceRef)
                val current = _epgByService.value?.toMutableMap() ?: mutableMapOf()
                current[serviceRef] = events
                _epgByService.value = current
            } catch (_: Exception) { /* non-critical */ }
        }
    }
}
