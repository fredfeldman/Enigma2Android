package com.enigma2.android.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\u0018\u0000 =2\u00020\u0001:\u0001=B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010-\u001a\u00020.H\u0002J\u0006\u0010/\u001a\u00020.J\u0014\u00100\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0082@\u00a2\u0006\u0002\u00101J\u0016\u00102\u001a\u00020.2\u0006\u00103\u001a\u00020\fH\u0082@\u00a2\u0006\u0002\u00104J\u0016\u00105\u001a\u00020.2\u0006\u00103\u001a\u00020\fH\u0082@\u00a2\u0006\u0002\u00104J\u0006\u00106\u001a\u00020.J\u000e\u00107\u001a\u00020.2\u0006\u00108\u001a\u00020\nJ\u000e\u00109\u001a\u00020.2\u0006\u0010:\u001a\u00020\fJ\u000e\u0010;\u001a\u00020.2\u0006\u0010<\u001a\u00020\fR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u00100\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00150\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u001d\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u001d\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00100\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u001d\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00070\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u000e\u0010%\u001a\u00020&X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00150\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u000e\u0010)\u001a\u00020*X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001a\u00a8\u0006>"}, d2 = {"Lcom/enigma2/android/ui/viewmodel/ChannelViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_allChannels", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/enigma2/android/data/model/Service;", "_bouquets", "Lcom/enigma2/android/data/model/Bouquet;", "_error", "", "_favorites", "_filteredChannels", "_isLoading", "", "kotlin.jvm.PlatformType", "_nowNextMap", "Lcom/enigma2/android/data/model/NowNextEvent;", "_recordingRefs", "", "_selectedBouquet", "bouquets", "Landroidx/lifecycle/LiveData;", "getBouquets", "()Landroidx/lifecycle/LiveData;", "currentFilter", "error", "getError", "favorites", "getFavorites", "filteredChannels", "getFilteredChannels", "isLoading", "nowNextMap", "getNowNextMap", "prefs", "Lcom/enigma2/android/data/prefs/ReceiverPreferences;", "recordingRefs", "getRecordingRefs", "repo", "Lcom/enigma2/android/data/repository/Enigma2Repository;", "selectedBouquet", "getSelectedBouquet", "applyFilter", "", "loadBouquets", "loadFavoriteServices", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadNowNext", "bRef", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadRecordingTimers", "resetForNewDevice", "selectBouquet", "bouquet", "setFilter", "query", "toggleFavorite", "serviceRef", "Companion", "app_debug"})
public final class ChannelViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String FAVORITES_REF = "__favorites__";
    @org.jetbrains.annotations.NotNull()
    private final com.enigma2.android.data.repository.Enigma2Repository repo = null;
    @org.jetbrains.annotations.NotNull()
    private final com.enigma2.android.data.prefs.ReceiverPreferences prefs = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.enigma2.android.data.model.Bouquet>> _bouquets = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.enigma2.android.data.model.Bouquet>> bouquets = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.enigma2.android.data.model.Bouquet> _selectedBouquet = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.enigma2.android.data.model.Bouquet> selectedBouquet = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.enigma2.android.data.model.Service>> _allChannels = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.enigma2.android.data.model.Service>> _filteredChannels = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.enigma2.android.data.model.Service>> filteredChannels = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.enigma2.android.data.model.NowNextEvent>> _nowNextMap = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.enigma2.android.data.model.NowNextEvent>> nowNextMap = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.Set<java.lang.String>> _recordingRefs = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.Set<java.lang.String>> recordingRefs = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<java.lang.String>> _favorites = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<java.lang.String>> favorites = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _error = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.String> error = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String currentFilter = "";
    @org.jetbrains.annotations.NotNull()
    public static final com.enigma2.android.ui.viewmodel.ChannelViewModel.Companion Companion = null;
    
    public ChannelViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.enigma2.android.data.model.Bouquet>> getBouquets() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.enigma2.android.data.model.Bouquet> getSelectedBouquet() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.enigma2.android.data.model.Service>> getFilteredChannels() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.enigma2.android.data.model.NowNextEvent>> getNowNextMap() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.Set<java.lang.String>> getRecordingRefs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<java.lang.String>> getFavorites() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getError() {
        return null;
    }
    
    public final void loadBouquets() {
    }
    
    public final void selectBouquet(@org.jetbrains.annotations.NotNull()
    com.enigma2.android.data.model.Bouquet bouquet) {
    }
    
    private final java.lang.Object loadFavoriteServices(kotlin.coroutines.Continuation<? super java.util.List<com.enigma2.android.data.model.Service>> $completion) {
        return null;
    }
    
    private final java.lang.Object loadNowNext(java.lang.String bRef, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object loadRecordingTimers(java.lang.String bRef, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    public final void setFilter(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
    }
    
    private final void applyFilter() {
    }
    
    public final void toggleFavorite(@org.jetbrains.annotations.NotNull()
    java.lang.String serviceRef) {
    }
    
    public final void resetForNewDevice() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/enigma2/android/ui/viewmodel/ChannelViewModel$Companion;", "", "()V", "FAVORITES_REF", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}