package com.enigma2.android.data.prefs;

/**
 * Persistent cache of the last successful multi-EPG fetch per bouquet ref.
 * Backed by SharedPreferences-JSON so we avoid pulling in Room. One snapshot
 * per bouquet — kept simple; the EPG screen reloads on every entry anyway and
 * the cache is only consulted when the network call fails.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u001c\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/enigma2/android/data/prefs/EpgCacheStore;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "gson", "Lcom/google/gson/Gson;", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "clear", "", "get", "Lcom/enigma2/android/data/prefs/EpgCacheStore$Entry;", "bouquetRef", "", "key", "put", "events", "", "Lcom/enigma2/android/data/model/EpgEvent;", "Entry", "app_release"})
public final class EpgCacheStore {
    private final android.content.SharedPreferences prefs = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.gson.Gson gson = null;
    
    public EpgCacheStore(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    public final void put(@org.jetbrains.annotations.NotNull()
    java.lang.String bouquetRef, @org.jetbrains.annotations.NotNull()
    java.util.List<com.enigma2.android.data.model.EpgEvent> events) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.enigma2.android.data.prefs.EpgCacheStore.Entry get(@org.jetbrains.annotations.NotNull()
    java.lang.String bouquetRef) {
        return null;
    }
    
    public final void clear() {
    }
    
    private final java.lang.String key(java.lang.String bouquetRef) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0016"}, d2 = {"Lcom/enigma2/android/data/prefs/EpgCacheStore$Entry;", "", "timestamp", "", "events", "", "Lcom/enigma2/android/data/model/EpgEvent;", "(JLjava/util/List;)V", "getEvents", "()Ljava/util/List;", "getTimestamp", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"})
    public static final class Entry {
        private final long timestamp = 0L;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.enigma2.android.data.model.EpgEvent> events = null;
        
        public Entry(long timestamp, @org.jetbrains.annotations.NotNull()
        java.util.List<com.enigma2.android.data.model.EpgEvent> events) {
            super();
        }
        
        public final long getTimestamp() {
            return 0L;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.enigma2.android.data.model.EpgEvent> getEvents() {
            return null;
        }
        
        public final long component1() {
            return 0L;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.enigma2.android.data.model.EpgEvent> component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.enigma2.android.data.prefs.EpgCacheStore.Entry copy(long timestamp, @org.jetbrains.annotations.NotNull()
        java.util.List<com.enigma2.android.data.model.EpgEvent> events) {
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
}