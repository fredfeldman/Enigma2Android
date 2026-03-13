package com.enigma2.android.data.repository

import com.enigma2.android.data.api.ApiClient
import com.enigma2.android.data.model.Bouquet
import com.enigma2.android.data.model.EpgEvent
import com.enigma2.android.data.model.NowNextEvent
import com.enigma2.android.data.model.Recording
import com.enigma2.android.data.model.Timer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Enigma2Repository {

    suspend fun getAllBouquets(): List<Bouquet> = withContext(Dispatchers.IO) {
        try {
            ApiClient.service.getAllServices().services ?: emptyList()
        } catch (e: Exception) {
            emptyList()
        }
    }

    suspend fun getChannelsForBouquet(sRef: String): List<com.enigma2.android.data.model.Service> =
        withContext(Dispatchers.IO) {
            try {
                ApiClient.service.getChannelList(sRef).services ?: emptyList()
            } catch (e: Exception) {
                emptyList()
            }
        }

    suspend fun getEpgNow(bRef: String): List<NowNextEvent> = withContext(Dispatchers.IO) {
        try {
            ApiClient.service.getEpgNow(bRef).events ?: emptyList()
        } catch (e: Exception) {
            emptyList()
        }
    }

    suspend fun getEpgNext(bRef: String): List<NowNextEvent> = withContext(Dispatchers.IO) {
        try {
            ApiClient.service.getEpgNext(bRef).events ?: emptyList()
        } catch (e: Exception) {
            emptyList()
        }
    }

    suspend fun getMultiEpg(bRef: String): List<EpgEvent> = withContext(Dispatchers.IO) {
        try {
            ApiClient.service.getMultiEpg(bRef).events ?: emptyList()
        } catch (e: Exception) {
            emptyList()
        }
    }

    suspend fun getEpgForService(sRef: String): List<EpgEvent> = withContext(Dispatchers.IO) {
        try {
            ApiClient.service.getEpgForService(sRef).events ?: emptyList()
        } catch (e: Exception) {
            emptyList()
        }
    }

    suspend fun zapToService(sRef: String): Boolean = withContext(Dispatchers.IO) {
        try {
            ApiClient.service.zapToService(sRef).result
        } catch (e: Exception) {
            false
        }
    }

    suspend fun getRecordings(dirname: String? = null): List<Recording> = withContext(Dispatchers.IO) {
        try {
            ApiClient.service.getMovieList(dirname).movies ?: emptyList()
        } catch (e: Exception) {
            emptyList()
        }
    }

    suspend fun getTimers(): List<Timer> = withContext(Dispatchers.IO) {
        try {
            ApiClient.service.getTimerList().timers ?: emptyList()
        } catch (e: Exception) {
            emptyList()
        }
    }

    suspend fun addTimer(
        sRef: String,
        begin: Long,
        end: Long,
        name: String,
        description: String = ""
    ): Boolean = withContext(Dispatchers.IO) {
        try {
            ApiClient.service.addTimer(sRef, begin, end, name, description).result
        } catch (e: Exception) {
            false
        }
    }

    suspend fun deleteTimer(sRef: String, begin: Long, end: Long): Boolean =
        withContext(Dispatchers.IO) {
            try {
                ApiClient.service.deleteTimer(sRef, begin, end).result
            } catch (e: Exception) {
                false
            }
        }

    suspend fun searchEpg(query: String): List<EpgEvent> = withContext(Dispatchers.IO) {
        try {
            ApiClient.service.searchEpg(query).events ?: emptyList()
        } catch (e: Exception) {
            emptyList()
        }
    }

    suspend fun getScreenshot(): ByteArray? = withContext(Dispatchers.IO) {
        try {
            val response = ApiClient.service.getScreenshot()
            if (response.isSuccessful) response.body()?.bytes() else null
        } catch (e: Exception) {
            null
        }
    }
}
