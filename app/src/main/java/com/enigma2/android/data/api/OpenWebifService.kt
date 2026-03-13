package com.enigma2.android.data.api

import com.enigma2.android.data.model.ChannelListResponse
import com.enigma2.android.data.model.EpgResponse
import com.enigma2.android.data.model.MovieListResponse
import com.enigma2.android.data.model.MultiEpgResponse
import com.enigma2.android.data.model.NowNextResponse
import com.enigma2.android.data.model.ServicesResponse
import com.enigma2.android.data.model.TimerListResponse
import com.enigma2.android.data.model.TimerResponse
import com.enigma2.android.data.model.ZapResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWebifService {

    @GET("api/getallservices")
    suspend fun getAllServices(): ServicesResponse

    @GET("api/getservices")
    suspend fun getServices(@Query("sRef") sRef: String): ServicesResponse

    @GET("api/getservices")
    suspend fun getChannelList(@Query("sRef") sRef: String): ChannelListResponse

    @GET("api/epgservice")
    suspend fun getEpgForService(@Query("sRef") sRef: String): EpgResponse

    @GET("api/epgmulti")
    suspend fun getMultiEpg(@Query("bRef") bRef: String): MultiEpgResponse

    @GET("api/epgnow")
    suspend fun getEpgNow(@Query("bRef") bRef: String): NowNextResponse

    @GET("api/epgnext")
    suspend fun getEpgNext(@Query("bRef") bRef: String): NowNextResponse

    @GET("api/zap")
    suspend fun zapToService(@Query("sRef") sRef: String): ZapResponse

    @GET("api/movielist")
    suspend fun getMovieList(@Query("dirname") dirname: String? = null): MovieListResponse

    @GET("api/addtimer")
    suspend fun addTimer(
        @Query("sRef") sRef: String,
        @Query("begin") begin: Long,
        @Query("end") end: Long,
        @Query("name") name: String,
        @Query("description") description: String = "",
        @Query("justplay") justPlay: Int = 0
    ): TimerResponse

    @GET("api/timerlist")
    suspend fun getTimerList(): TimerListResponse

    @GET("api/deltimer")
    suspend fun deleteTimer(
        @Query("sRef") sRef: String,
        @Query("begin") begin: Long,
        @Query("end") end: Long
    ): TimerResponse

    @GET("api/epgsearch")
    suspend fun searchEpg(@Query("search") query: String): EpgResponse

    @GET("grab")
    suspend fun getScreenshot(
        @Query("format") format: String = "jpg",
        @Query("r") resolution: Int = 720
    ): Response<okhttp3.ResponseBody>
}
