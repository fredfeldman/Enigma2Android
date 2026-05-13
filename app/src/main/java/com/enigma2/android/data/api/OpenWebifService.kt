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

    @GET("api/about")
    suspend fun getBoxInfo(): Response<okhttp3.ResponseBody>

    @GET("api/deviceinfo")
    suspend fun getDeviceInfo(): Response<okhttp3.ResponseBody>

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

    @GET("api/movie/delete")
    suspend fun deleteMovie(@Query("sRef") sRef: String): TimerResponse

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

    @GET("api/timerdelete")
    suspend fun deleteTimer(
        @Query("sRef") sRef: String,
        @Query("begin") begin: Long,
        @Query("end") end: Long
    ): TimerResponse

    @GET("api/epgsearch")
    suspend fun searchEpg(@Query("search") query: String): EpgResponse

    @GET("autotimer")
    suspend fun getAutoTimersXml(): Response<okhttp3.ResponseBody>

    @GET("autotimer/remove")
    suspend fun removeAutoTimer(@Query("id") id: Int): Response<okhttp3.ResponseBody>

    @GET("autotimer/edit")
    suspend fun editAutoTimer(
        @retrofit2.http.QueryMap params: Map<String, String>
    ): Response<okhttp3.ResponseBody>

    // ---- EPGImport plugin (optional) ----
    @GET
    suspend fun probeEpgImportPath(@retrofit2.http.Url url: String): Response<okhttp3.ResponseBody>

    @GET
    suspend fun getEpgImportSourcesAt(@retrofit2.http.Url url: String): Response<okhttp3.ResponseBody>

    @GET
    suspend fun getEpgImportEnabledSourcesAt(@retrofit2.http.Url url: String): Response<okhttp3.ResponseBody>

    @GET
    suspend fun saveEpgImportEnabledSourcesAt(
        @retrofit2.http.Url url: String,
        @Query("sources") sourcesCsv: String
    ): Response<okhttp3.ResponseBody>

    @GET
    suspend fun getEpgImportStatusAt(@retrofit2.http.Url url: String): Response<okhttp3.ResponseBody>

    @GET
    suspend fun runEpgImportAt(@retrofit2.http.Url url: String): Response<okhttp3.ResponseBody>

    @GET("grab")
    suspend fun getScreenshot(
        @Query("format") format: String = "jpg",
        @Query("r") resolution: Int = 720
    ): Response<okhttp3.ResponseBody>

    // ---- BouquetEditor plugin (optional) ----
    /** Lists bouquets via the BouquetEditor plugin. Also serves as the capability probe. */
    @GET("bouqueteditor/api/getservices")
    suspend fun getBouquetEditorBouquets(
        @Query("sRef") sRef: String = ""
    ): ServicesResponse

    @GET("bouqueteditor/web/addbouquet")
    suspend fun addBouquet(
        @Query("name") name: String,
        @Query("mode") mode: Int = 0
    ): Response<okhttp3.ResponseBody>

    @GET("bouqueteditor/web/renameservice")
    suspend fun renameBouquet(
        @Query("sRef") sRef: String,
        @Query("newName") newName: String,
        @Query("mode") mode: Int = 0
    ): Response<okhttp3.ResponseBody>

    @GET("bouqueteditor/web/removebouquet")
    suspend fun removeBouquet(
        @Query("sBouquetRef") sBouquetRef: String,
        @Query("mode") mode: Int = 0
    ): Response<okhttp3.ResponseBody>

    @GET("bouqueteditor/web/addservicetobouquet")
    suspend fun addServiceToBouquet(
        @Query("sBouquetRef") sBouquetRef: String,
        @Query("sRef") sRef: String,
        @Query("Name") name: String
    ): Response<okhttp3.ResponseBody>

    @GET("bouqueteditor/web/removeservice")
    suspend fun removeServiceFromBouquet(
        @Query("sBouquetRef") sBouquetRef: String,
        @Query("sRef") sRef: String
    ): Response<okhttp3.ResponseBody>

    @GET("bouqueteditor/web/moveservice")
    suspend fun moveServiceInBouquet(
        @Query("sBouquetRef") sBouquetRef: String,
        @Query("sRef") sRef: String,
        @Query("position") position: Int
    ): Response<okhttp3.ResponseBody>

    // ---- Receiver Settings ----

    /** Live status — used as a header on most receiver-settings screens. */
    @GET("api/statusinfo")
    suspend fun getStatusInfo(): Response<okhttp3.ResponseBody>

    // Power
    @GET("api/powerstate")
    suspend fun getPowerState(): Response<okhttp3.ResponseBody>

    @GET("api/powerstate")
    suspend fun setPowerState(@Query("newstate") newState: Int): Response<okhttp3.ResponseBody>

    @GET("web/sleeptimer")
    suspend fun getSleepTimer(@Query("cmd") cmd: String = "get"): Response<okhttp3.ResponseBody>

    @GET("web/sleeptimer")
    suspend fun setSleepTimer(
        @Query("cmd") cmd: String = "set",
        @Query("time") time: Int,
        @Query("action") action: String,
        @Query("enabled") enabled: String
    ): Response<okhttp3.ResponseBody>

    // Volume
    @GET("web/vol")
    suspend fun getVolume(): Response<okhttp3.ResponseBody>

    @GET("web/vol")
    suspend fun setVolume(@Query("set") set: String): Response<okhttp3.ResponseBody>

    // Generic config tree
    @GET("web/settings")
    suspend fun getAllSettings(): Response<okhttp3.ResponseBody>

    @GET("api/config")
    suspend fun getConfigSections(): Response<okhttp3.ResponseBody>

    @GET
    suspend fun getConfigSection(@retrofit2.http.Url url: String): Response<okhttp3.ResponseBody>

    @GET("web/saveconfig")
    suspend fun saveConfig(
        @Query("key") key: String,
        @Query("value") value: String
    ): Response<okhttp3.ResponseBody>

    // Web UI config
    @GET("web/setwebconfig")
    suspend fun setWebConfig(@retrofit2.http.QueryMap params: Map<String, String>): Response<okhttp3.ResponseBody>

    // Parental control
    @GET("web/parentcontrollist")
    suspend fun getParentControlList(): Response<okhttp3.ResponseBody>

    @GET("BQE/getprotectionsettings")
    suspend fun getProtectionSettings(): Response<okhttp3.ResponseBody>

    // Recording locations
    @GET("api/getlocations")
    suspend fun getLocations(): Response<okhttp3.ResponseBody>

    @GET("api/getcurrlocation")
    suspend fun getCurrentLocation(): Response<okhttp3.ResponseBody>

    @GET("api/setcurrlocation")
    suspend fun setCurrentLocation(@Query("location") location: String): Response<okhttp3.ResponseBody>

    @GET("api/addlocation")
    suspend fun addLocation(
        @Query("dirname") dirname: String,
        @Query("createFolder") createFolder: Int = 1
    ): Response<okhttp3.ResponseBody>

    @GET("api/removelocation")
    suspend fun removeLocation(@Query("dirname") dirname: String): Response<okhttp3.ResponseBody>

    // Tuner / signal
    @GET("web/tunersignal")
    suspend fun getTunerSignal(): Response<okhttp3.ResponseBody>

    // Wake-on-LAN setup
    @GET("wol/setup")
    suspend fun getWolSetup(): Response<okhttp3.ResponseBody>

    @GET("wol/setup")
    suspend fun setWolSetup(@retrofit2.http.QueryMap params: Map<String, String>): Response<okhttp3.ResponseBody>

    // Transcoding
    @GET("transcoding")
    suspend fun getTranscodingConfig(): Response<okhttp3.ResponseBody>

    @GET("transcoding")
    suspend fun setTranscodingConfig(@retrofit2.http.QueryMap params: Map<String, String>): Response<okhttp3.ResponseBody>

    // ---- v1.0.7: Remote control & messaging ----
    @GET("api/remotecontrol")
    suspend fun sendRemoteCommand(@Query("command") commandCode: Int): Response<okhttp3.ResponseBody>

    @GET("api/message")
    suspend fun sendMessage(
        @Query("text") text: String,
        @Query("type") type: Int = 1,
        @Query("timeout") timeout: Int = 10
    ): Response<okhttp3.ResponseBody>
}
