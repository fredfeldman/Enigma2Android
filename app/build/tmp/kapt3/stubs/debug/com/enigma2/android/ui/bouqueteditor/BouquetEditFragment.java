package com.enigma2.android.ui.bouqueteditor;

/**
 * Edits the channels inside a single bouquet. Two operating modes:
 * * Server mode (plugin available + user bouquet): every reorder/add/remove triggers an HTTP call.
 * * Local mode (plugin missing, provider bouquet, or user opted to keep local edits):
 *   edits are stored as a per-device [ReceiverPreferences.BouquetOverride].
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 :2\u00020\u0001:\u0001:B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\"H\u0002J\u0018\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020&H\u0002J$\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00100\u001a\u00020\"H\u0016J\u001a\u00101\u001a\u00020\"2\u0006\u00102\u001a\u00020)2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00103\u001a\u00020\"H\u0002J\b\u00104\u001a\u00020\"H\u0002J\u0018\u00105\u001a\u00020\"2\u0006\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020&H\u0002J\u0010\u00106\u001a\u00020\"2\u0006\u00107\u001a\u00020&H\u0002J\u0012\u00108\u001a\u00020\"2\b\u00109\u001a\u0004\u0018\u00010\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006;"}, d2 = {"Lcom/enigma2/android/ui/bouqueteditor/BouquetEditFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lcom/enigma2/android/ui/bouqueteditor/BouquetEditChannelAdapter;", "banner", "Landroid/widget/TextView;", "bouquetName", "", "bouquetRef", "btnAdd", "display", "", "Lcom/enigma2/android/data/model/Service;", "empty", "isUserBouquet", "", "loading", "Landroid/widget/ProgressBar;", "prefs", "Lcom/enigma2/android/data/prefs/ReceiverPreferences;", "getPrefs", "()Lcom/enigma2/android/data/prefs/ReceiverPreferences;", "prefs$delegate", "Lkotlin/Lazy;", "repo", "Lcom/enigma2/android/data/repository/Enigma2Repository;", "rv", "Landroidx/recyclerview/widget/RecyclerView;", "serverList", "", "serverMode", "tvTitle", "applyBanner", "", "load", "moveItem", "from", "", "to", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onViewCreated", "view", "openPicker", "persistLocalOverride", "persistMove", "removeAt", "idx", "revertWithError", "msg", "Companion", "app_debug"})
public final class BouquetEditFragment extends androidx.fragment.app.Fragment {
    private androidx.recyclerview.widget.RecyclerView rv;
    private android.widget.ProgressBar loading;
    private android.widget.TextView empty;
    private android.widget.TextView banner;
    private android.widget.TextView btnAdd;
    private android.widget.TextView tvTitle;
    @org.jetbrains.annotations.NotNull()
    private final com.enigma2.android.data.repository.Enigma2Repository repo = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy prefs$delegate = null;
    private java.lang.String bouquetRef;
    private java.lang.String bouquetName;
    private boolean isUserBouquet = false;
    private boolean serverMode = false;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.enigma2.android.data.model.Service> serverList;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.enigma2.android.data.model.Service> display = null;
    private com.enigma2.android.ui.bouqueteditor.BouquetEditChannelAdapter adapter;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String ARG_REF = "ref";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String ARG_NAME = "name";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String ARG_IS_USER = "is_user";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String ARG_SERVER_MODE = "server_mode";
    @org.jetbrains.annotations.NotNull()
    public static final com.enigma2.android.ui.bouqueteditor.BouquetEditFragment.Companion Companion = null;
    
    public BouquetEditFragment() {
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
    
    private final void applyBanner() {
    }
    
    private final void load() {
    }
    
    private final void moveItem(int from, int to) {
    }
    
    private final void removeAt(int idx) {
    }
    
    private final void persistMove(int from, int to) {
    }
    
    private final void persistLocalOverride() {
    }
    
    private final void revertWithError(java.lang.String msg) {
    }
    
    private final void openPicker() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/enigma2/android/ui/bouqueteditor/BouquetEditFragment$Companion;", "", "()V", "ARG_IS_USER", "", "ARG_NAME", "ARG_REF", "ARG_SERVER_MODE", "newInstance", "Lcom/enigma2/android/ui/bouqueteditor/BouquetEditFragment;", "bouquetRef", "bouquetName", "isUserBouquet", "", "serverMode", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.enigma2.android.ui.bouqueteditor.BouquetEditFragment newInstance(@org.jetbrains.annotations.NotNull()
        java.lang.String bouquetRef, @org.jetbrains.annotations.NotNull()
        java.lang.String bouquetName, boolean isUserBouquet, boolean serverMode) {
            return null;
        }
    }
}