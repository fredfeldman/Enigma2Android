package com.enigma2.android.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.enigma2.android.data.model.Bouquet
import com.enigma2.android.data.model.NowNextEvent
import com.enigma2.android.data.model.Service
import com.enigma2.android.data.prefs.ReceiverPreferences
import com.enigma2.android.data.repository.Enigma2Repository
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class ChannelViewModel(application: Application) : AndroidViewModel(application) {

    companion object {
        const val FAVORITES_REF = "__favorites__"
    }

    private val repo = Enigma2Repository()
    private val prefs = ReceiverPreferences(application)

    private val _bouquets = MutableLiveData<List<Bouquet>>()
    val bouquets: LiveData<List<Bouquet>> = _bouquets

    private val _selectedBouquet = MutableLiveData<Bouquet?>()
    val selectedBouquet: LiveData<Bouquet?> = _selectedBouquet

    private val _allChannels = MutableLiveData<List<Service>>()

    private val _filteredChannels = MutableLiveData<List<Service>>()
    val filteredChannels: LiveData<List<Service>> = _filteredChannels

    private val _nowNextMap = MutableLiveData<List<NowNextEvent>>()
    val nowNextMap: LiveData<List<NowNextEvent>> = _nowNextMap

    private val _recordingRefs = MutableLiveData<Set<String>>(emptySet())
    val recordingRefs: LiveData<Set<String>> = _recordingRefs

    private val _favorites = MutableLiveData<List<String>>()
    val favorites: LiveData<List<String>> = _favorites

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    private val _error = MutableLiveData<String?>(null)
    val error: LiveData<String?> = _error

    private var currentFilter: String = ""

    init {
        _favorites.value = prefs.favorites
    }

    fun loadBouquets() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                var bouquets = repo.getAllBouquets()
                val hidden = prefs.hiddenBouquets.toSet()
                bouquets = bouquets.filter { it.ref !in hidden }

                // Inject favorites bouquet if there are any favorites
                val favs = prefs.favorites
                if (favs.isNotEmpty()) {
                    val favBouquet = Bouquet(
                        ref = FAVORITES_REF,
                        name = "★ Favorites",
                        channels = null
                    )
                    bouquets = listOf(favBouquet) + bouquets
                }

                _bouquets.value = bouquets
                bouquets.firstOrNull()?.let { selectBouquet(it) }
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun selectBouquet(bouquet: Bouquet) {
        _selectedBouquet.value = bouquet
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val channels = if (bouquet.ref == FAVORITES_REF) {
                    loadFavoriteServices()
                } else {
                    repo.getChannelsForBouquet(bouquet.ref)
                }
                _allChannels.value = channels
                applyFilter()
                loadNowNext(bouquet.ref)
                loadRecordingTimers(bouquet.ref)
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }

    private suspend fun loadFavoriteServices(): List<Service> {
        val favRefs = prefs.favorites.toSet()
        val allBouquets = repo.getAllBouquets()
        val allChannels = coroutineScope {
            allBouquets.map { b -> async { repo.getChannelsForBouquet(b.ref) } }.awaitAll().flatten()
        }
        return allChannels.filter { it.ref in favRefs }
    }

    private suspend fun loadNowNext(bRef: String) {
        try {
            val now = repo.getEpgNow(bRef)
            val next = repo.getEpgNext(bRef)
            // Merge: now list is primary, add next where missing
            val map = (now + next).groupBy { it.sref }.mapValues { it.value.first() }
            _nowNextMap.value = map.values.toList()
        } catch (e: Exception) { /* non-critical */ }
    }

    private suspend fun loadRecordingTimers(bRef: String) {
        try {
            val timers = repo.getTimers()
            val recordingSet = timers.filter { it.state == 2 }.map { it.serviceRef }.toSet()
            _recordingRefs.value = recordingSet
        } catch (e: Exception) { /* non-critical */ }
    }

    fun setFilter(query: String) {
        currentFilter = query
        applyFilter()
    }

    private fun applyFilter() {
        val all = _allChannels.value ?: return
        _filteredChannels.value = if (currentFilter.isBlank()) {
            all
        } else {
            all.filter { it.name.contains(currentFilter, ignoreCase = true) }
        }
    }

    fun toggleFavorite(serviceRef: String) {
        prefs.toggleFavorite(serviceRef)
        _favorites.value = prefs.favorites
    }

    fun resetForNewDevice() {
        _bouquets.value = emptyList()
        _allChannels.value = emptyList()
        _filteredChannels.value = emptyList()
        _selectedBouquet.value = null
        _nowNextMap.value = emptyList()
        _error.value = null
    }
}
