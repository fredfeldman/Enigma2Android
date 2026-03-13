package com.enigma2.android.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0086@\u00a2\u0006\u0002\u0010\fJ&\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0086@\u00a2\u0006\u0002\u0010\u0012J\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00102\u0006\u0010\u0005\u001a\u00020\u0006H\u0086@\u00a2\u0006\u0002\u0010\u0015J\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00102\u0006\u0010\u0005\u001a\u00020\u0006H\u0086@\u00a2\u0006\u0002\u0010\u0015J\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00102\u0006\u0010\u001a\u001a\u00020\u0006H\u0086@\u00a2\u0006\u0002\u0010\u0015J\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\u00102\u0006\u0010\u001a\u001a\u00020\u0006H\u0086@\u00a2\u0006\u0002\u0010\u0015J\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u00102\u0006\u0010\u001a\u001a\u00020\u0006H\u0086@\u00a2\u0006\u0002\u0010\u0015J \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00102\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0006H\u0086@\u00a2\u0006\u0002\u0010\u0015J\u0010\u0010 \u001a\u0004\u0018\u00010!H\u0086@\u00a2\u0006\u0002\u0010\u0012J\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0010H\u0086@\u00a2\u0006\u0002\u0010\u0012J\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00170\u00102\u0006\u0010%\u001a\u00020\u0006H\u0086@\u00a2\u0006\u0002\u0010\u0015J\u0016\u0010&\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0086@\u00a2\u0006\u0002\u0010\u0015\u00a8\u0006\'"}, d2 = {"Lcom/enigma2/android/data/repository/Enigma2Repository;", "", "()V", "addTimer", "", "sRef", "", "begin", "", "end", "name", "description", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTimer", "(Ljava/lang/String;JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllBouquets", "", "Lcom/enigma2/android/data/model/Bouquet;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getChannelsForBouquet", "Lcom/enigma2/android/data/model/Service;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEpgForService", "Lcom/enigma2/android/data/model/EpgEvent;", "getEpgNext", "Lcom/enigma2/android/data/model/NowNextEvent;", "bRef", "getEpgNow", "getMultiEpg", "getRecordings", "Lcom/enigma2/android/data/model/Recording;", "dirname", "getScreenshot", "", "getTimers", "Lcom/enigma2/android/data/model/Timer;", "searchEpg", "query", "zapToService", "app_debug"})
public final class Enigma2Repository {
    
    public Enigma2Repository() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAllBouquets(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.enigma2.android.data.model.Bouquet>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getChannelsForBouquet(@org.jetbrains.annotations.NotNull()
    java.lang.String sRef, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.enigma2.android.data.model.Service>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getEpgNow(@org.jetbrains.annotations.NotNull()
    java.lang.String bRef, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.enigma2.android.data.model.NowNextEvent>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getEpgNext(@org.jetbrains.annotations.NotNull()
    java.lang.String bRef, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.enigma2.android.data.model.NowNextEvent>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getMultiEpg(@org.jetbrains.annotations.NotNull()
    java.lang.String bRef, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.enigma2.android.data.model.EpgEvent>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getEpgForService(@org.jetbrains.annotations.NotNull()
    java.lang.String sRef, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.enigma2.android.data.model.EpgEvent>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object zapToService(@org.jetbrains.annotations.NotNull()
    java.lang.String sRef, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getRecordings(@org.jetbrains.annotations.Nullable()
    java.lang.String dirname, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.enigma2.android.data.model.Recording>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getTimers(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.enigma2.android.data.model.Timer>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addTimer(@org.jetbrains.annotations.NotNull()
    java.lang.String sRef, long begin, long end, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteTimer(@org.jetbrains.annotations.NotNull()
    java.lang.String sRef, long begin, long end, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object searchEpg(@org.jetbrains.annotations.NotNull()
    java.lang.String query, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.enigma2.android.data.model.EpgEvent>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getScreenshot(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super byte[]> $completion) {
        return null;
    }
}