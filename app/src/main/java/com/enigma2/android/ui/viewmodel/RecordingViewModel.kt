package com.enigma2.android.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enigma2.android.data.model.Recording
import com.enigma2.android.data.repository.Enigma2Repository
import kotlinx.coroutines.launch

class RecordingViewModel : ViewModel() {

    companion object {
        const val SORT_DATE_DESC = 0
        const val SORT_DATE_ASC = 1
        const val SORT_NAME = 2
        const val SORT_CHANNEL = 3
    }

    private val repo = Enigma2Repository()

    private val _allRecordings = MutableLiveData<List<Recording>>(emptyList())
    private var sortOrder = SORT_DATE_DESC

    private val _sortedRecordings = MutableLiveData<List<Recording>>(emptyList())
    val sortedRecordings: LiveData<List<Recording>> = _sortedRecordings

    private val _focusedRecording = MutableLiveData<Recording?>()
    val focusedRecording: LiveData<Recording?> = _focusedRecording

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    fun loadRecordings() {
        viewModelScope.launch {
            _isLoading.value = true
            val recordings = repo.getRecordings()
            _allRecordings.value = recordings
            applySortOrder()
            _isLoading.value = false
        }
    }

    fun setSortOrder(order: Int) {
        sortOrder = order
        applySortOrder()
    }

    private fun applySortOrder() {
        val list = _allRecordings.value ?: return
        _sortedRecordings.value = when (sortOrder) {
            SORT_DATE_DESC -> list.sortedByDescending { it.startTimestamp }
            SORT_DATE_ASC -> list.sortedBy { it.startTimestamp }
            SORT_NAME -> list.sortedBy { it.title }
            SORT_CHANNEL -> list.sortedBy { it.channelName }
            else -> list
        }
    }

    fun onRecordingFocused(recording: Recording) {
        _focusedRecording.value = recording
    }

    fun deleteRecording(recording: Recording, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            val ok = repo.deleteRecording(recording.filename)
            if (ok) {
                val updated = (_allRecordings.value ?: emptyList())
                    .filter { it.filename != recording.filename }
                _allRecordings.value = updated
                if (_focusedRecording.value?.filename == recording.filename) {
                    _focusedRecording.value = null
                }
                applySortOrder()
            }
            onResult(ok)
        }
    }

    /**
     * Toggle the "Watched" tag on the receiver. Optimistic local update so the
     * badge flips immediately; reverted via reload on failure.
     */
    fun toggleWatched(recording: Recording, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            val isWatched = recording.isWatched
            val ok = if (isWatched) {
                repo.updateRecordingTags(recording.serviceRef, del = Recording.WATCHED_TAG)
            } else {
                repo.updateRecordingTags(recording.serviceRef, add = Recording.WATCHED_TAG)
            }
            if (ok) {
                val newRaw = if (isWatched) {
                    recording.tags.filter { !it.equals(Recording.WATCHED_TAG, ignoreCase = true) }
                        .joinToString(" ")
                } else {
                    (recording.tags + Recording.WATCHED_TAG).joinToString(" ")
                }
                val updated = (_allRecordings.value ?: emptyList()).map {
                    if (it.filename == recording.filename) it.copy(tagsRaw = newRaw) else it
                }
                _allRecordings.value = updated
                applySortOrder()
            }
            onResult(ok)
        }
    }
}
