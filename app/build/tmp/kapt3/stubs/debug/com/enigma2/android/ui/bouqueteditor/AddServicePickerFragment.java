package com.enigma2.android.ui.bouqueteditor;

/**
 * Flat, filterable list of every channel currently visible across all bouquets
 * on the receiver. Tapping one calls `addServiceToBouquet` and pops back to
 * [BouquetEditFragment]. Channels already present in the target bouquet are skipped.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 &2\u00020\u0001:\u0001&B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\tH\u0002J\b\u0010\u0019\u001a\u00020\u0017H\u0002J$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u0007H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\t0\rj\b\u0012\u0004\u0012\u00020\t`\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\'"}, d2 = {"Lcom/enigma2/android/ui/bouqueteditor/AddServicePickerFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lcom/enigma2/android/ui/bouqueteditor/PickerAdapter;", "all", "", "Lcom/enigma2/android/data/model/Service;", "bouquetRef", "", "etFilter", "Landroid/widget/EditText;", "existingRefs", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "loading", "Landroid/widget/ProgressBar;", "repo", "Lcom/enigma2/android/data/repository/Enigma2Repository;", "rv", "Landroidx/recyclerview/widget/RecyclerView;", "shown", "applyFilter", "", "query", "load", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "pick", "service", "Companion", "app_debug"})
public final class AddServicePickerFragment extends androidx.fragment.app.Fragment {
    private androidx.recyclerview.widget.RecyclerView rv;
    private android.widget.ProgressBar loading;
    private android.widget.EditText etFilter;
    @org.jetbrains.annotations.NotNull()
    private final com.enigma2.android.data.repository.Enigma2Repository repo = null;
    private java.lang.String bouquetRef;
    private java.util.HashSet<java.lang.String> existingRefs;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.enigma2.android.data.model.Service> all = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.enigma2.android.data.model.Service> shown = null;
    @org.jetbrains.annotations.NotNull()
    private final com.enigma2.android.ui.bouqueteditor.PickerAdapter adapter = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String ARG_REF = "ref";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String ARG_EXISTING = "existing";
    @org.jetbrains.annotations.NotNull()
    public static final com.enigma2.android.ui.bouqueteditor.AddServicePickerFragment.Companion Companion = null;
    
    public AddServicePickerFragment() {
        super();
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
    
    private final void load() {
    }
    
    private final void applyFilter(java.lang.String query) {
    }
    
    private final void pick(com.enigma2.android.data.model.Service service) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00040\nj\b\u0012\u0004\u0012\u00020\u0004`\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/enigma2/android/ui/bouqueteditor/AddServicePickerFragment$Companion;", "", "()V", "ARG_EXISTING", "", "ARG_REF", "newInstance", "Lcom/enigma2/android/ui/bouqueteditor/AddServicePickerFragment;", "bouquetRef", "existingRefs", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.enigma2.android.ui.bouqueteditor.AddServicePickerFragment newInstance(@org.jetbrains.annotations.NotNull()
        java.lang.String bouquetRef, @org.jetbrains.annotations.NotNull()
        java.util.ArrayList<java.lang.String> existingRefs) {
            return null;
        }
    }
}