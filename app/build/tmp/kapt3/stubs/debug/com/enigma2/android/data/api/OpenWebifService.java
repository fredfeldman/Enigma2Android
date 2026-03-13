package com.enigma2.android.data.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001JJ\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\t\u001a\u00020\u00052\b\b\u0003\u0010\n\u001a\u00020\u00052\b\b\u0003\u0010\u000b\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\rJ,\u0010\u000e\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\u000fJ\u000e\u0010\u0010\u001a\u00020\u0011H\u00a7@\u00a2\u0006\u0002\u0010\u0012J\u0018\u0010\u0013\u001a\u00020\u00142\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u00172\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0015J\u0018\u0010\u0018\u001a\u00020\u00192\b\b\u0001\u0010\u001a\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0015J\u0018\u0010\u001b\u001a\u00020\u00192\b\b\u0001\u0010\u001a\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0015J\u001a\u0010\u001c\u001a\u00020\u001d2\n\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0015J\u0018\u0010\u001f\u001a\u00020 2\b\b\u0001\u0010\u001a\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0015J(\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\b\b\u0003\u0010$\u001a\u00020\u00052\b\b\u0003\u0010%\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010&J\u0018\u0010\'\u001a\u00020\u00112\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0015J\u000e\u0010(\u001a\u00020)H\u00a7@\u00a2\u0006\u0002\u0010\u0012J\u0018\u0010*\u001a\u00020\u00172\b\b\u0001\u0010+\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0015J\u0018\u0010,\u001a\u00020-2\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0015\u00a8\u0006."}, d2 = {"Lcom/enigma2/android/data/api/OpenWebifService;", "", "addTimer", "Lcom/enigma2/android/data/model/TimerResponse;", "sRef", "", "begin", "", "end", "name", "description", "justPlay", "", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTimer", "(Ljava/lang/String;JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllServices", "Lcom/enigma2/android/data/model/ServicesResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getChannelList", "Lcom/enigma2/android/data/model/ChannelListResponse;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEpgForService", "Lcom/enigma2/android/data/model/EpgResponse;", "getEpgNext", "Lcom/enigma2/android/data/model/NowNextResponse;", "bRef", "getEpgNow", "getMovieList", "Lcom/enigma2/android/data/model/MovieListResponse;", "dirname", "getMultiEpg", "Lcom/enigma2/android/data/model/MultiEpgResponse;", "getScreenshot", "Lretrofit2/Response;", "Lokhttp3/ResponseBody;", "format", "resolution", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getServices", "getTimerList", "Lcom/enigma2/android/data/model/TimerListResponse;", "searchEpg", "query", "zapToService", "Lcom/enigma2/android/data/model/ZapResponse;", "app_debug"})
public abstract interface OpenWebifService {
    
    @retrofit2.http.GET(value = "api/getallservices")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllServices(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enigma2.android.data.model.ServicesResponse> $completion);
    
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
    
    @retrofit2.http.GET(value = "api/deltimer")
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
    
    @retrofit2.http.GET(value = "grab")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getScreenshot(@retrofit2.http.Query(value = "format")
    @org.jetbrains.annotations.NotNull()
    java.lang.String format, @retrofit2.http.Query(value = "r")
    int resolution, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}