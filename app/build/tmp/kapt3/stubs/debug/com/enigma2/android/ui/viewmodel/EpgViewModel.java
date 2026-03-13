package com.enigma2.android.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006J\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0006R&\u0010\u0003\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R)\u0010\f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00050\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/enigma2/android/ui/viewmodel/EpgViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_epgByService", "Landroidx/lifecycle/MutableLiveData;", "", "", "", "Lcom/enigma2/android/data/model/EpgEvent;", "_recordingTimerIds", "", "", "epgByService", "Landroidx/lifecycle/LiveData;", "getEpgByService", "()Landroidx/lifecycle/LiveData;", "recordingTimerIds", "getRecordingTimerIds", "repo", "Lcom/enigma2/android/data/repository/Enigma2Repository;", "loadEpgForService", "", "serviceRef", "loadMultiEpg", "bouquetRef", "app_debug"})
public final class EpgViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.enigma2.android.data.repository.Enigma2Repository repo = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.Map<java.lang.String, java.util.List<com.enigma2.android.data.model.EpgEvent>>> _epgByService = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.Map<java.lang.String, java.util.List<com.enigma2.android.data.model.EpgEvent>>> epgByService = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.Set<java.lang.Long>> _recordingTimerIds = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.Set<java.lang.Long>> recordingTimerIds = null;
    
    public EpgViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.Map<java.lang.String, java.util.List<com.enigma2.android.data.model.EpgEvent>>> getEpgByService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.Set<java.lang.Long>> getRecordingTimerIds() {
        return null;
    }
    
    public final void loadMultiEpg(@org.jetbrains.annotations.NotNull()
    java.lang.String bouquetRef) {
    }
    
    public final void loadEpgForService(@org.jetbrains.annotations.NotNull()
    java.lang.String serviceRef) {
    }
}