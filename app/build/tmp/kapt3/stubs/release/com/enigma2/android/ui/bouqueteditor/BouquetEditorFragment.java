package com.enigma2.android.ui.bouqueteditor;

/**
 * Lists every bouquet on the receiver, showing a User/Provider badge and
 * a banner indicating whether server-side editing is available (BouquetEditor
 * plugin installed) or the app is in local-only fallback mode.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0007H\u0002J\b\u0010\"\u001a\u00020\u001fH\u0002J$\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\u0010\'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020\u001fH\u0016J\u001a\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0010\u0010.\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0007H\u0002J\u0010\u0010/\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0007H\u0002J\b\u00100\u001a\u00020\u001fH\u0002J\u0010\u00101\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0007H\u0002J\u0010\u00102\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0007H\u0002J+\u00103\u001a\u00020\u001f2\u001c\u00104\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020706\u0012\u0006\u0012\u0004\u0018\u00010805H\u0002\u00a2\u0006\u0002\u00109R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006:"}, d2 = {"Lcom/enigma2/android/ui/bouqueteditor/BouquetEditorFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lcom/enigma2/android/ui/bouqueteditor/BouquetEditorAdapter;", "allBouquets", "", "Lcom/enigma2/android/data/model/Bouquet;", "banner", "Landroid/widget/TextView;", "btnNew", "btnRefresh", "capability", "Lcom/enigma2/android/data/repository/Enigma2Repository$BouquetEditorCapability;", "empty", "loading", "Landroid/widget/ProgressBar;", "prefs", "Lcom/enigma2/android/data/prefs/ReceiverPreferences;", "getPrefs", "()Lcom/enigma2/android/data/prefs/ReceiverPreferences;", "prefs$delegate", "Lkotlin/Lazy;", "repo", "Lcom/enigma2/android/data/repository/Enigma2Repository;", "rv", "Landroidx/recyclerview/widget/RecyclerView;", "userBouquetRefs", "", "", "applyBanner", "", "applyLocalToServer", "bouquet", "load", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onViewCreated", "view", "openEditor", "promptDelete", "promptNew", "promptRename", "pushEditor", "runOp", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lcom/enigma2/android/data/api/BouquetEditorXml$SimpleResult;", "", "(Lkotlin/jvm/functions/Function1;)V", "app_release"})
public final class BouquetEditorFragment extends androidx.fragment.app.Fragment {
    private androidx.recyclerview.widget.RecyclerView rv;
    private android.widget.ProgressBar loading;
    private android.widget.TextView empty;
    private android.widget.TextView banner;
    private android.widget.TextView btnNew;
    private android.widget.TextView btnRefresh;
    @org.jetbrains.annotations.NotNull()
    private final com.enigma2.android.data.repository.Enigma2Repository repo = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy prefs$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private com.enigma2.android.data.repository.Enigma2Repository.BouquetEditorCapability capability = com.enigma2.android.data.repository.Enigma2Repository.BouquetEditorCapability.Missing;
    @org.jetbrains.annotations.NotNull()
    private java.util.Set<java.lang.String> userBouquetRefs;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.enigma2.android.data.model.Bouquet> allBouquets;
    @org.jetbrains.annotations.NotNull()
    private final com.enigma2.android.ui.bouqueteditor.BouquetEditorAdapter adapter = null;
    
    public BouquetEditorFragment() {
        super();
    }
    
    private final com.enigma2.android.data.prefs.ReceiverPreferences getPrefs() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    private final void load() {
    }
    
    private final void applyBanner() {
    }
    
    private final void openEditor(com.enigma2.android.data.model.Bouquet bouquet) {
    }
    
    private final void pushEditor(com.enigma2.android.data.model.Bouquet bouquet) {
    }
    
    private final void applyLocalToServer(com.enigma2.android.data.model.Bouquet bouquet) {
    }
    
    private final void promptNew() {
    }
    
    private final void promptRename(com.enigma2.android.data.model.Bouquet bouquet) {
    }
    
    private final void promptDelete(com.enigma2.android.data.model.Bouquet bouquet) {
    }
    
    private final void runOp(kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super com.enigma2.android.data.api.BouquetEditorXml.SimpleResult>, ? extends java.lang.Object> block) {
    }
}