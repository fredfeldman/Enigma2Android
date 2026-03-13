package com.enigma2.android.data.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\bH\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\bH\u00c6\u0003JO\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\"\u001a\u00020\bH\u00d6\u0001J\t\u0010#\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\n\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000b\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012\u00a8\u0006$"}, d2 = {"Lcom/enigma2/android/data/model/NowNextEvent;", "", "sref", "", "nowTitle", "nowBegin", "", "nowDuration", "", "nextTitle", "nextBegin", "nextDuration", "(Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;JI)V", "getNextBegin", "()J", "getNextDuration", "()I", "getNextTitle", "()Ljava/lang/String;", "getNowBegin", "getNowDuration", "getNowTitle", "getSref", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class NowNextEvent {
    @com.google.gson.annotations.SerializedName(value = "sref")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String sref = null;
    @com.google.gson.annotations.SerializedName(value = "now_title")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String nowTitle = null;
    @com.google.gson.annotations.SerializedName(value = "now_begin")
    private final long nowBegin = 0L;
    @com.google.gson.annotations.SerializedName(value = "now_duration")
    private final int nowDuration = 0;
    @com.google.gson.annotations.SerializedName(value = "next_title")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String nextTitle = null;
    @com.google.gson.annotations.SerializedName(value = "next_begin")
    private final long nextBegin = 0L;
    @com.google.gson.annotations.SerializedName(value = "next_duration")
    private final int nextDuration = 0;
    
    public NowNextEvent(@org.jetbrains.annotations.NotNull()
    java.lang.String sref, @org.jetbrains.annotations.NotNull()
    java.lang.String nowTitle, long nowBegin, int nowDuration, @org.jetbrains.annotations.NotNull()
    java.lang.String nextTitle, long nextBegin, int nextDuration) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSref() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNowTitle() {
        return null;
    }
    
    public final long getNowBegin() {
        return 0L;
    }
    
    public final int getNowDuration() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNextTitle() {
        return null;
    }
    
    public final long getNextBegin() {
        return 0L;
    }
    
    public final int getNextDuration() {
        return 0;
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
    
    public final long component3() {
        return 0L;
    }
    
    public final int component4() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    public final long component6() {
        return 0L;
    }
    
    public final int component7() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.enigma2.android.data.model.NowNextEvent copy(@org.jetbrains.annotations.NotNull()
    java.lang.String sref, @org.jetbrains.annotations.NotNull()
    java.lang.String nowTitle, long nowBegin, int nowDuration, @org.jetbrains.annotations.NotNull()
    java.lang.String nextTitle, long nextBegin, int nextDuration) {
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