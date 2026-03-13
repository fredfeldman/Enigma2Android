package com.enigma2.android.data.model

import com.google.gson.annotations.SerializedName

data class ServicesResponse(
    @SerializedName("services") val services: List<Bouquet>? = null,
    @SerializedName("result") val result: Boolean = false
)

data class ChannelListResponse(
    @SerializedName("services") val services: List<Service>? = null,
    @SerializedName("result") val result: Boolean = false
)

data class Bouquet(
    @SerializedName("servicereference") val ref: String,
    @SerializedName("servicename") val name: String,
    @SerializedName("subservices") val channels: List<Service>? = null
)

data class Service(
    @SerializedName("servicereference") val ref: String,
    @SerializedName("servicename") val name: String,
    @SerializedName("picon") val piconPath: String? = null
)

data class EpgResponse(
    @SerializedName("events") val events: List<EpgEvent>? = null,
    @SerializedName("result") val result: Boolean = false
)

data class MultiEpgResponse(
    @SerializedName("events") val events: List<EpgEvent>? = null,
    @SerializedName("result") val result: Boolean = false
)

data class NowNextResponse(
    @SerializedName("events") val events: List<NowNextEvent>? = null,
    @SerializedName("result") val result: Boolean = false
)

data class EpgEvent(
    @SerializedName("id") val id: Long = 0,
    @SerializedName("sref") val sref: String = "",
    @SerializedName("title") val title: String = "",
    @SerializedName("shortdesc") val shortDesc: String = "",
    @SerializedName("longdesc") val longDesc: String = "",
    @SerializedName("begin_timestamp") val beginTimestamp: Long = 0,
    @SerializedName("duration_sec") val durationSeconds: Int = 0,
    var isRecordingTimer: Boolean = false
)

data class NowNextEvent(
    @SerializedName("sref") val sref: String = "",
    @SerializedName("now_title") val nowTitle: String = "",
    @SerializedName("now_begin") val nowBegin: Long = 0,
    @SerializedName("now_duration") val nowDuration: Int = 0,
    @SerializedName("next_title") val nextTitle: String = "",
    @SerializedName("next_begin") val nextBegin: Long = 0,
    @SerializedName("next_duration") val nextDuration: Int = 0
)

data class ZapResponse(
    @SerializedName("result") val result: Boolean = false,
    @SerializedName("message") val message: String = ""
)

data class MovieListResponse(
    @SerializedName("movies") val movies: List<Recording>? = null,
    @SerializedName("result") val result: Boolean = false
)

data class Recording(
    @SerializedName("filename") val filename: String = "",
    @SerializedName("eventname") val title: String = "",
    @SerializedName("shortdesc") val description: String = "",
    @SerializedName("servicereference") val serviceRef: String = "",
    @SerializedName("servicename") val channelName: String = "",
    @SerializedName("recordingstart") val startTimestamp: Long = 0,
    @SerializedName("length") val length: String = "",
    @SerializedName("filesize_readable") val fileSizeBytes: String = ""
) {
    /** Converts OpenWebif "H:MM" or "H:MM:SS" length string to total minutes. */
    val lengthMinutes: Long get() {
        val parts = length.split(":")
        return when (parts.size) {
            2 -> (parts[0].toLongOrNull() ?: 0) * 60 + (parts[1].toLongOrNull() ?: 0)
            3 -> (parts[0].toLongOrNull() ?: 0) * 60 + (parts[1].toLongOrNull() ?: 0)
            else -> length.toLongOrNull() ?: 0
        }
    }
}

data class TimerListResponse(
    @SerializedName("timers") val timers: List<Timer>? = null,
    @SerializedName("result") val result: Boolean? = null
)

data class TimerResponse(
    @SerializedName("result") val result: Boolean = false,
    @SerializedName("message") val message: String = ""
)

data class Timer(
    @SerializedName("serviceref") val serviceRef: String = "",
    @SerializedName("name") val name: String = "",
    @SerializedName("begin") val beginTimestamp: Long = 0,
    @SerializedName("end") val endTimestamp: Long = 0,
    @SerializedName("state") val state: Int = 0,
    @SerializedName("servicename") val serviceName: String = ""
)
