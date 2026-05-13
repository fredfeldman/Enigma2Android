package com.enigma2.android.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\"\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00062\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00180\u001cJ\u0006\u0010\u001d\u001a\u00020\u0018J\u000e\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0006J\u000e\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u0014J\"\u0010!\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00062\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00180\u001cR\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000f\u00a8\u0006#"}, d2 = {"Lcom/enigma2/android/ui/viewmodel/RecordingViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_allRecordings", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/enigma2/android/data/model/Recording;", "_focusedRecording", "_isLoading", "", "kotlin.jvm.PlatformType", "_sortedRecordings", "focusedRecording", "Landroidx/lifecycle/LiveData;", "getFocusedRecording", "()Landroidx/lifecycle/LiveData;", "isLoading", "repo", "Lcom/enigma2/android/data/repository/Enigma2Repository;", "sortOrder", "", "sortedRecordings", "getSortedRecordings", "applySortOrder", "", "deleteRecording", "recording", "onResult", "Lkotlin/Function1;", "loadRecordings", "onRecordingFocused", "setSortOrder", "order", "toggleWatched", "Companion", "app_release"})
public final class RecordingViewModel extends androidx.lifecycle.ViewModel {
    public static final int SORT_DATE_DESC = 0;
    public static final int SORT_DATE_ASC = 1;
    public static final int SORT_NAME = 2;
    public static final int SORT_CHANNEL = 3;
    @org.jetbrains.annotations.NotNull()
    private final com.enigma2.android.data.repository.Enigma2Repository repo = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.enigma2.android.data.model.Recording>> _allRecordings = null;
    private int sortOrder = 0;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.enigma2.android.data.model.Recording>> _sortedRecordings = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.enigma2.android.data.model.Recording>> sortedRecordings = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.enigma2.android.data.model.Recording> _focusedRecording = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.enigma2.android.data.model.Recording> focusedRecording = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.enigma2.android.ui.viewmodel.RecordingViewModel.Companion Companion = null;
    
    public RecordingViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.enigma2.android.data.model.Recording>> getSortedRecordings() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.enigma2.android.data.model.Recording> getFocusedRecording() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading() {
        return null;
    }
    
    public final void loadRecordings() {
    }
    
    public final void setSortOrder(int order) {
    }
    
    private final void applySortOrder() {
    }
    
    public final void onRecordingFocused(@org.jetbrains.annotations.NotNull()
    com.enigma2.android.data.model.Recording recording) {
    }
    
    public final void deleteRecording(@org.jetbrains.annotations.NotNull()
    com.enigma2.android.data.model.Recording recording, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onResult) {
    }
    
    /**
     * Toggle the "Watched" tag on the receiver. Optimistic local update so the
     * badge flips immediately; reverted via reload on failure.
     */
    public final void toggleWatched(@org.jetbrains.annotations.NotNull()
    com.enigma2.android.data.model.Recording recording, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onResult) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/enigma2/android/ui/viewmodel/RecordingViewModel$Companion;", "", "()V", "SORT_CHANNEL", "", "SORT_DATE_ASC", "SORT_DATE_DESC", "SORT_NAME", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}