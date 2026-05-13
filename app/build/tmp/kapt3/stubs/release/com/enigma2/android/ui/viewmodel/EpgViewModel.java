package com.enigma2.android.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010#\u001a\u00020$J\u000e\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\nJ\u000e\u0010\'\u001a\u00020$2\u0006\u0010(\u001a\u00020\nJ\u001c\u0010)\u001a\u00020$2\u0006\u0010(\u001a\u00020\n2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\n0\u000bJ\u0010\u0010+\u001a\u00020$2\u0006\u0010(\u001a\u00020\nH\u0002R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00110\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R)\u0010\u0019\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\t0\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u001d\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00110\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0019\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u000e\u0010!\u001a\u00020\"X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lcom/enigma2/android/ui/viewmodel/EpgViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "app", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_cacheTimestamp", "Landroidx/lifecycle/MutableLiveData;", "", "_epgByService", "", "", "", "Lcom/enigma2/android/data/model/EpgEvent;", "_offline", "", "kotlin.jvm.PlatformType", "_recordingTimerIds", "", "_refreshStatus", "cache", "Lcom/enigma2/android/data/prefs/EpgCacheStore;", "cacheTimestamp", "Landroidx/lifecycle/LiveData;", "getCacheTimestamp", "()Landroidx/lifecycle/LiveData;", "epgByService", "getEpgByService", "offline", "getOffline", "recordingTimerIds", "getRecordingTimerIds", "refreshStatus", "getRefreshStatus", "repo", "Lcom/enigma2/android/data/repository/Enigma2Repository;", "consumeRefreshStatus", "", "loadEpgForService", "serviceRef", "loadMultiEpg", "bouquetRef", "refreshAndReload", "serviceRefs", "serveFromCache", "app_release"})
public final class EpgViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.enigma2.android.data.repository.Enigma2Repository repo = null;
    @org.jetbrains.annotations.NotNull()
    private final com.enigma2.android.data.prefs.EpgCacheStore cache = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.Map<java.lang.String, java.util.List<com.enigma2.android.data.model.EpgEvent>>> _epgByService = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.Map<java.lang.String, java.util.List<com.enigma2.android.data.model.EpgEvent>>> epgByService = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.Set<java.lang.Long>> _recordingTimerIds = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.Set<java.lang.Long>> recordingTimerIds = null;
    
    /**
     * True when the current `epgByService` snapshot was served from cache.
     */
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _offline = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> offline = null;
    
    /**
     * Timestamp (epoch ms) of the cached entry currently shown, when offline.
     */
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Long> _cacheTimestamp = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Long> cacheTimestamp = null;
    
    /**
     * One-shot refresh status messages (for toasts).
     */
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _refreshStatus = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.String> refreshStatus = null;
    
    public EpgViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application app) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.Map<java.lang.String, java.util.List<com.enigma2.android.data.model.EpgEvent>>> getEpgByService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.Set<java.lang.Long>> getRecordingTimerIds() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getOffline() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Long> getCacheTimestamp() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getRefreshStatus() {
        return null;
    }
    
    public final void consumeRefreshStatus() {
    }
    
    public final void loadMultiEpg(@org.jetbrains.annotations.NotNull()
    java.lang.String bouquetRef) {
    }
    
    private final void serveFromCache(java.lang.String bouquetRef) {
    }
    
    /**
     * Trigger a server-side EPG refresh for each visible service then reload.
     */
    public final void refreshAndReload(@org.jetbrains.annotations.NotNull()
    java.lang.String bouquetRef, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> serviceRefs) {
    }
    
    public final void loadEpgForService(@org.jetbrains.annotations.NotNull()
    java.lang.String serviceRef) {
    }
}