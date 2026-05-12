package com.enigma2.android.data.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J5\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u0003H\u00d6\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r\u00a8\u0006\u001a"}, d2 = {"Lcom/enigma2/android/data/model/NowNextEvent;", "", "serviceRef", "", "serviceName", "nowEvent", "Lcom/enigma2/android/data/model/EpgEvent;", "nextEvent", "(Ljava/lang/String;Ljava/lang/String;Lcom/enigma2/android/data/model/EpgEvent;Lcom/enigma2/android/data/model/EpgEvent;)V", "getNextEvent", "()Lcom/enigma2/android/data/model/EpgEvent;", "getNowEvent", "getServiceName", "()Ljava/lang/String;", "getServiceRef", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"})
public final class NowNextEvent {
    @com.google.gson.annotations.SerializedName(value = "sref", alternate = {"servicereference"})
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String serviceRef = null;
    @com.google.gson.annotations.SerializedName(value = "sname")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String serviceName = null;
    @com.google.gson.annotations.SerializedName(value = "now_event")
    @org.jetbrains.annotations.Nullable()
    private final com.enigma2.android.data.model.EpgEvent nowEvent = null;
    @com.google.gson.annotations.SerializedName(value = "next_event")
    @org.jetbrains.annotations.Nullable()
    private final com.enigma2.android.data.model.EpgEvent nextEvent = null;
    
    public NowNextEvent(@org.jetbrains.annotations.NotNull()
    java.lang.String serviceRef, @org.jetbrains.annotations.NotNull()
    java.lang.String serviceName, @org.jetbrains.annotations.Nullable()
    com.enigma2.android.data.model.EpgEvent nowEvent, @org.jetbrains.annotations.Nullable()
    com.enigma2.android.data.model.EpgEvent nextEvent) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getServiceRef() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getServiceName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.enigma2.android.data.model.EpgEvent getNowEvent() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.enigma2.android.data.model.EpgEvent getNextEvent() {
        return null;
    }
    
    public NowNextEvent() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.enigma2.android.data.model.EpgEvent component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.enigma2.android.data.model.EpgEvent component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.enigma2.android.data.model.NowNextEvent copy(@org.jetbrains.annotations.NotNull()
    java.lang.String serviceRef, @org.jetbrains.annotations.NotNull()
    java.lang.String serviceName, @org.jetbrains.annotations.Nullable()
    com.enigma2.android.data.model.EpgEvent nowEvent, @org.jetbrains.annotations.Nullable()
    com.enigma2.android.data.model.EpgEvent nextEvent) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}