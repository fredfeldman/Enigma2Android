package com.enigma2.android.data.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\tJ(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u000b\u001a\u00020\u00062\b\b\u0003\u0010\f\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\tJ2\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0010JJ\u0010\u0011\u001a\u00020\u00122\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010\u0013\u001a\u00020\u00142\b\b\u0001\u0010\u0015\u001a\u00020\u00142\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0016\u001a\u00020\u00062\b\b\u0003\u0010\u0017\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\u0018J\u0018\u0010\u0019\u001a\u00020\u00122\b\b\u0001\u0010\u000f\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u001aJ,\u0010\u001b\u001a\u00020\u00122\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010\u0013\u001a\u00020\u00142\b\b\u0001\u0010\u0015\u001a\u00020\u0014H\u00a7@\u00a2\u0006\u0002\u0010\u001cJ*\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0001\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001fH\u00a7@\u00a2\u0006\u0002\u0010 J\u000e\u0010!\u001a\u00020\"H\u00a7@\u00a2\u0006\u0002\u0010#J\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010#J\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010#J\u0018\u0010&\u001a\u00020\"2\b\b\u0003\u0010\u000f\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u001aJ\u0014\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010#J\u0018\u0010(\u001a\u00020)2\b\b\u0001\u0010\u000f\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u001aJ\u001e\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010+\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u001aJ\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010#J\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010#J\u0014\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010#J\u0018\u0010/\u001a\u0002002\b\b\u0001\u0010\u000f\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u001aJ\u001e\u00101\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010+\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u001aJ\u001e\u00102\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010+\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u001aJ\u001e\u00103\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010+\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u001aJ\u0018\u00104\u001a\u0002052\b\b\u0001\u00106\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u001aJ\u0018\u00107\u001a\u0002052\b\b\u0001\u00106\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u001aJ\u0014\u00108\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010#J\u001a\u00109\u001a\u00020:2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u001aJ\u0018\u0010;\u001a\u00020<2\b\b\u0001\u00106\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u001aJ\u0014\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010#J\u0014\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010#J\u0014\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010#J(\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010A\u001a\u00020\u00062\b\b\u0003\u0010B\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\tJ\u0018\u0010C\u001a\u00020\"2\b\b\u0001\u0010\u000f\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u001aJ\u001e\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010E\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u001aJ\u0014\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010#J\u000e\u0010G\u001a\u00020HH\u00a7@\u00a2\u0006\u0002\u0010#J\u0014\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010#J\u0014\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010#J\u0014\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010#J\u0014\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010#J2\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010N\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010OJ\u001e\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010+\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u001aJ\u001e\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010R\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010SJ(\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\tJ\u001e\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u000b\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u001aJ(\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010WJ2\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010Y\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010OJ\u001e\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010+\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u001aJ(\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\\\u001a\u00020\u00062\b\b\u0001\u0010]\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010WJ(\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010+\u001a\u00020\u00062\b\b\u0001\u0010_\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010WJ\u0018\u0010`\u001a\u0002002\b\b\u0001\u0010a\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u001aJ2\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010c\u001a\u00020\u00062\b\b\u0003\u0010d\u001a\u00020\b2\b\b\u0003\u0010e\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010fJ\u001e\u0010g\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010h\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010SJ\u001e\u0010i\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010j\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u001aJ\u001e\u0010k\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010l\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010SJ<\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010E\u001a\u00020\u00062\b\b\u0001\u0010n\u001a\u00020\b2\b\b\u0001\u0010o\u001a\u00020\u00062\b\b\u0001\u0010p\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010qJ*\u0010r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0001\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001fH\u00a7@\u00a2\u0006\u0002\u0010 J\u001e\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010t\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u001aJ*\u0010u\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0001\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001fH\u00a7@\u00a2\u0006\u0002\u0010 J*\u0010v\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0001\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001fH\u00a7@\u00a2\u0006\u0002\u0010 J\u0018\u0010w\u001a\u00020x2\b\b\u0001\u0010\u000f\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u001a\u00a8\u0006y"}, d2 = {"Lcom/enigma2/android/data/api/OpenWebifService;", "", "addBouquet", "Lretrofit2/Response;", "Lokhttp3/ResponseBody;", "name", "", "mode", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addLocation", "dirname", "createFolder", "addServiceToBouquet", "sBouquetRef", "sRef", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addTimer", "Lcom/enigma2/android/data/model/TimerResponse;", "begin", "", "end", "description", "justPlay", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteMovie", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTimer", "(Ljava/lang/String;JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "editAutoTimer", "params", "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllServices", "Lcom/enigma2/android/data/model/ServicesResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllSettings", "getAutoTimersXml", "getBouquetEditorBouquets", "getBoxInfo", "getChannelList", "Lcom/enigma2/android/data/model/ChannelListResponse;", "getConfigSection", "url", "getConfigSections", "getCurrentLocation", "getDeviceInfo", "getEpgForService", "Lcom/enigma2/android/data/model/EpgResponse;", "getEpgImportEnabledSourcesAt", "getEpgImportSourcesAt", "getEpgImportStatusAt", "getEpgNext", "Lcom/enigma2/android/data/model/NowNextResponse;", "bRef", "getEpgNow", "getLocations", "getMovieList", "Lcom/enigma2/android/data/model/MovieListResponse;", "getMultiEpg", "Lcom/enigma2/android/data/model/MultiEpgResponse;", "getParentControlList", "getPowerState", "getProtectionSettings", "getScreenshot", "format", "resolution", "getServices", "getSleepTimer", "cmd", "getStatusInfo", "getTimerList", "Lcom/enigma2/android/data/model/TimerListResponse;", "getTranscodingConfig", "getTunerSignal", "getVolume", "getWolSetup", "moveServiceInBouquet", "position", "(Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "probeEpgImportPath", "removeAutoTimer", "id", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeBouquet", "removeLocation", "removeServiceFromBouquet", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "renameBouquet", "newName", "runEpgImportAt", "saveConfig", "key", "value", "saveEpgImportEnabledSourcesAt", "sourcesCsv", "searchEpg", "query", "sendMessage", "text", "type", "timeout", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendRemoteCommand", "commandCode", "setCurrentLocation", "location", "setPowerState", "newState", "setSleepTimer", "time", "action", "enabled", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setTranscodingConfig", "setVolume", "set", "setWebConfig", "setWolSetup", "zapToService", "Lcom/enigma2/android/data/model/ZapResponse;", "app_debug"})
public abstract interface OpenWebifService {
    
    @retrofit2.http.GET(value = "api/getallservices")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllServices(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enigma2.android.data.model.ServicesResponse> $completion);
    
    @retrofit2.http.GET(value = "api/about")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getBoxInfo(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    @retrofit2.http.GET(value = "api/deviceinfo")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getDeviceInfo(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    @retrofit2.http.GET(value = "api/getservices")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getServices(@retrofit2.http.Query(value = "sRef")
    @org.jetbrains.annotations.NotNull()
    java.lang.String sRef, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enigma2.android.data.model.ServicesResponse> $completion);
    
    @retrofit2.http.GET(value = "api/getservices")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getChannelList(@retrofit2.http.Query(value = "sRef")
    @org.jetbrains.annotations.NotNull()
    java.lang.String sRef, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enigma2.android.data.model.ChannelListResponse> $completion);
    
    @retrofit2.http.GET(value = "api/epgservice")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getEpgForService(@retrofit2.http.Query(value = "sRef")
    @org.jetbrains.annotations.NotNull()
    java.lang.String sRef, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enigma2.android.data.model.EpgResponse> $completion);
    
    @retrofit2.http.GET(value = "api/epgmulti")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getMultiEpg(@retrofit2.http.Query(value = "bRef")
    @org.jetbrains.annotations.NotNull()
    java.lang.String bRef, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enigma2.android.data.model.MultiEpgResponse> $completion);
    
    @retrofit2.http.GET(value = "api/epgnow")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getEpgNow(@retrofit2.http.Query(value = "bRef")
    @org.jetbrains.annotations.NotNull()
    java.lang.String bRef, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enigma2.android.data.model.NowNextResponse> $completion);
    
    @retrofit2.http.GET(value = "api/epgnext")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getEpgNext(@retrofit2.http.Query(value = "bRef")
    @org.jetbrains.annotations.NotNull()
    java.lang.String bRef, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enigma2.android.data.model.NowNextResponse> $completion);
    
    @retrofit2.http.GET(value = "api/zap")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object zapToService(@retrofit2.http.Query(value = "sRef")
    @org.jetbrains.annotations.NotNull()
    java.lang.String sRef, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enigma2.android.data.model.ZapResponse> $completion);
    
    @retrofit2.http.GET(value = "api/movielist")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getMovieList(@retrofit2.http.Query(value = "dirname")
    @org.jetbrains.annotations.Nullable()
    java.lang.String dirname, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enigma2.android.data.model.MovieListResponse> $completion);
    
    @retrofit2.http.GET(value = "api/movie/delete")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteMovie(@retrofit2.http.Query(value = "sRef")
    @org.jetbrains.annotations.NotNull()
    java.lang.String sRef, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enigma2.android.data.model.TimerResponse> $completion);
    
    @retrofit2.http.GET(value = "api/addtimer")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addTimer(@retrofit2.http.Query(value = "sRef")
    @org.jetbrains.annotations.NotNull()
    java.lang.String sRef, @retrofit2.http.Query(value = "begin")
    long begin, @retrofit2.http.Query(value = "end")
    long end, @retrofit2.http.Query(value = "name")
    @org.jetbrains.annotations.NotNull()
    java.lang.String name, @retrofit2.http.Query(value = "description")
    @org.jetbrains.annotations.NotNull()
    java.lang.String description, @retrofit2.http.Query(value = "justplay")
    int justPlay, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enigma2.android.data.model.TimerResponse> $completion);
    
    @retrofit2.http.GET(value = "api/timerlist")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTimerList(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enigma2.android.data.model.TimerListResponse> $completion);
    
    @retrofit2.http.GET(value = "api/timerdelete")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteTimer(@retrofit2.http.Query(value = "sRef")
    @org.jetbrains.annotations.NotNull()
    java.lang.String sRef, @retrofit2.http.Query(value = "begin")
    long begin, @retrofit2.http.Query(value = "end")
    long end, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enigma2.android.data.model.TimerResponse> $completion);
    
    @retrofit2.http.GET(value = "api/epgsearch")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object searchEpg(@retrofit2.http.Query(value = "search")
    @org.jetbrains.annotations.NotNull()
    java.lang.String query, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enigma2.android.data.model.EpgResponse> $completion);
    
    @retrofit2.http.GET(value = "autotimer")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAutoTimersXml(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    @retrofit2.http.GET(value = "autotimer/remove")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object removeAutoTimer(@retrofit2.http.Query(value = "id")
    int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    @retrofit2.http.GET(value = "autotimer/edit")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object editAutoTimer(@retrofit2.http.QueryMap()
    @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    @retrofit2.http.GET()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object probeEpgImportPath(@retrofit2.http.Url()
    @org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    @retrofit2.http.GET()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getEpgImportSourcesAt(@retrofit2.http.Url()
    @org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    @retrofit2.http.GET()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getEpgImportEnabledSourcesAt(@retrofit2.http.Url()
    @org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    @retrofit2.http.GET()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object saveEpgImportEnabledSourcesAt(@retrofit2.http.Url()
    @org.jetbrains.annotations.NotNull()
    java.lang.String url, @retrofit2.http.Query(value = "sources")
    @org.jetbrains.annotations.NotNull()
    java.lang.String sourcesCsv, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    @retrofit2.http.GET()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getEpgImportStatusAt(@retrofit2.http.Url()
    @org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    @retrofit2.http.GET()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object runEpgImportAt(@retrofit2.http.Url()
    @org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    @retrofit2.http.GET(value = "grab")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getScreenshot(@retrofit2.http.Query(value = "format")
    @org.jetbrains.annotations.NotNull()
    java.lang.String format, @retrofit2.http.Query(value = "r")
    int resolution, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    /**
     * Lists bouquets via the BouquetEditor plugin. Also serves as the capability probe.
     */
    @retrofit2.http.GET(value = "bouqueteditor/api/getservices")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getBouquetEditorBouquets(@retrofit2.http.Query(value = "sRef")
    @org.jetbrains.annotations.NotNull()
    java.lang.String sRef, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enigma2.android.data.model.ServicesResponse> $completion);
    
    @retrofit2.http.GET(value = "bouqueteditor/web/addbouquet")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addBouquet(@retrofit2.http.Query(value = "name")
    @org.jetbrains.annotations.NotNull()
    java.lang.String name, @retrofit2.http.Query(value = "mode")
    int mode, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    @retrofit2.http.GET(value = "bouqueteditor/web/renameservice")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object renameBouquet(@retrofit2.http.Query(value = "sRef")
    @org.jetbrains.annotations.NotNull()
    java.lang.String sRef, @retrofit2.http.Query(value = "newName")
    @org.jetbrains.annotations.NotNull()
    java.lang.String newName, @retrofit2.http.Query(value = "mode")
    int mode, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    @retrofit2.http.GET(value = "bouqueteditor/web/removebouquet")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object removeBouquet(@retrofit2.http.Query(value = "sBouquetRef")
    @org.jetbrains.annotations.NotNull()
    java.lang.String sBouquetRef, @retrofit2.http.Query(value = "mode")
    int mode, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    @retrofit2.http.GET(value = "bouqueteditor/web/addservicetobouquet")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addServiceToBouquet(@retrofit2.http.Query(value = "sBouquetRef")
    @org.jetbrains.annotations.NotNull()
    java.lang.String sBouquetRef, @retrofit2.http.Query(value = "sRef")
    @org.jetbrains.annotations.NotNull()
    java.lang.String sRef, @retrofit2.http.Query(value = "Name")
    @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    @retrofit2.http.GET(value = "bouqueteditor/web/removeservice")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object removeServiceFromBouquet(@retrofit2.http.Query(value = "sBouquetRef")
    @org.jetbrains.annotations.NotNull()
    java.lang.String sBouquetRef, @retrofit2.http.Query(value = "sRef")
    @org.jetbrains.annotations.NotNull()
    java.lang.String sRef, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    @retrofit2.http.GET(value = "bouqueteditor/web/moveservice")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object moveServiceInBouquet(@retrofit2.http.Query(value = "sBouquetRef")
    @org.jetbrains.annotations.NotNull()
    java.lang.String sBouquetRef, @retrofit2.http.Query(value = "sRef")
    @org.jetbrains.annotations.NotNull()
    java.lang.String sRef, @retrofit2.http.Query(value = "position")
    int position, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    /**
     * Live status — used as a header on most receiver-settings screens.
     */
    @retrofit2.http.GET(value = "api/statusinfo")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getStatusInfo(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    @retrofit2.http.GET(value = "api/powerstate")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPowerState(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    @retrofit2.http.GET(value = "api/powerstate")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object setPowerState(@retrofit2.http.Query(value = "newstate")
    int newState, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    @retrofit2.http.GET(value = "web/sleeptimer")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getSleepTimer(@retrofit2.http.Query(value = "cmd")
    @org.jetbrains.annotations.NotNull()
    java.lang.String cmd, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    @retrofit2.http.GET(value = "web/sleeptimer")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object setSleepTimer(@retrofit2.http.Query(value = "cmd")
    @org.jetbrains.annotations.NotNull()
    java.lang.String cmd, @retrofit2.http.Query(value = "time")
    int time, @retrofit2.http.Query(value = "action")
    @org.jetbrains.annotations.NotNull()
    java.lang.String action, @retrofit2.http.Query(value = "enabled")
    @org.jetbrains.annotations.NotNull()
    java.lang.String enabled, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    @retrofit2.http.GET(value = "web/vol")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getVolume(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    @retrofit2.http.GET(value = "web/vol")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object setVolume(@retrofit2.http.Query(value = "set")
    @org.jetbrains.annotations.NotNull()
    java.lang.String set, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    @retrofit2.http.GET(value = "web/settings")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllSettings(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    @retrofit2.http.GET(value = "api/config")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getConfigSections(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    @retrofit2.http.GET()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getConfigSection(@retrofit2.http.Url()
    @org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    @retrofit2.http.GET(value = "web/saveconfig")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object saveConfig(@retrofit2.http.Query(value = "key")
    @org.jetbrains.annotations.NotNull()
    java.lang.String key, @retrofit2.http.Query(value = "value")
    @org.jetbrains.annotations.NotNull()
    java.lang.String value, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    @retrofit2.http.GET(value = "web/setwebconfig")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object setWebConfig(@retrofit2.http.QueryMap()
    @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    @retrofit2.http.GET(value = "web/parentcontrollist")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getParentControlList(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    @retrofit2.http.GET(value = "BQE/getprotectionsettings")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getProtectionSettings(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    @retrofit2.http.GET(value = "api/getlocations")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getLocations(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    @retrofit2.http.GET(value = "api/getcurrlocation")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCurrentLocation(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    @retrofit2.http.GET(value = "api/setcurrlocation")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object setCurrentLocation(@retrofit2.http.Query(value = "location")
    @org.jetbrains.annotations.NotNull()
    java.lang.String location, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    @retrofit2.http.GET(value = "api/addlocation")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addLocation(@retrofit2.http.Query(value = "dirname")
    @org.jetbrains.annotations.NotNull()
    java.lang.String dirname, @retrofit2.http.Query(value = "createFolder")
    int createFolder, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    @retrofit2.http.GET(value = "api/removelocation")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object removeLocation(@retrofit2.http.Query(value = "dirname")
    @org.jetbrains.annotations.NotNull()
    java.lang.String dirname, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    @retrofit2.http.GET(value = "web/tunersignal")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTunerSignal(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    @retrofit2.http.GET(value = "wol/setup")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getWolSetup(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    @retrofit2.http.GET(value = "wol/setup")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object setWolSetup(@retrofit2.http.QueryMap()
    @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    @retrofit2.http.GET(value = "transcoding")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTranscodingConfig(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    @retrofit2.http.GET(value = "transcoding")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object setTranscodingConfig(@retrofit2.http.QueryMap()
    @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    @retrofit2.http.GET(value = "api/remotecontrol")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object sendRemoteCommand(@retrofit2.http.Query(value = "command")
    int commandCode, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    @retrofit2.http.GET(value = "api/message")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object sendMessage(@retrofit2.http.Query(value = "text")
    @org.jetbrains.annotations.NotNull()
    java.lang.String text, @retrofit2.http.Query(value = "type")
    int type, @retrofit2.http.Query(value = "timeout")
    int timeout, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}