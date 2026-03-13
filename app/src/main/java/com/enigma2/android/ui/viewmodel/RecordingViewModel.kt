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

    fun loadRecordings() {
        viewModelScope.launch {
            val recordings = repo.getRecordings()
            _allRecordings.value = recordings
            applySortOrder()
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
}
