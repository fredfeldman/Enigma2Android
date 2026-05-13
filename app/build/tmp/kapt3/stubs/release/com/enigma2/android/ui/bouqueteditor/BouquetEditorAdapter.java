package com.enigma2.android.ui.bouqueteditor;

/**
 * Bouquet list for the editor. Edit is always allowed (channel-level edits
 * fall back to local override); Rename/Delete are receiver-only and only
 * apply to user bouquets that the BouquetEditor plugin reports.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eBA\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\u0002\u0010\tJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012H\u0016J*\u0010\u001a\u001a\u00020\u00062\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/enigma2/android/ui/bouqueteditor/BouquetEditorAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/enigma2/android/ui/bouqueteditor/BouquetEditorAdapter$VH;", "onEdit", "Lkotlin/Function1;", "Lcom/enigma2/android/data/model/Bouquet;", "", "onRename", "onDelete", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "capability", "Lcom/enigma2/android/data/repository/Enigma2Repository$BouquetEditorCapability;", "items", "", "userRefs", "", "", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submit", "bouquets", "", "userBouquetRefs", "VH", "app_release"})
public final class BouquetEditorAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.enigma2.android.ui.bouqueteditor.BouquetEditorAdapter.VH> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.enigma2.android.data.model.Bouquet, kotlin.Unit> onEdit = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.enigma2.android.data.model.Bouquet, kotlin.Unit> onRename = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.enigma2.android.data.model.Bouquet, kotlin.Unit> onDelete = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.enigma2.android.data.model.Bouquet> items = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.Set<java.lang.String> userRefs;
    @org.jetbrains.annotations.NotNull()
    private com.enigma2.android.data.repository.Enigma2Repository.BouquetEditorCapability capability = com.enigma2.android.data.repository.Enigma2Repository.BouquetEditorCapability.Missing;
    
    public BouquetEditorAdapter(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.enigma2.android.data.model.Bouquet, kotlin.Unit> onEdit, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.enigma2.android.data.model.Bouquet, kotlin.Unit> onRename, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.enigma2.android.data.model.Bouquet, kotlin.Unit> onDelete) {
        super();
    }
    
    public final void submit(@org.jetbrains.annotations.NotNull()
    java.util.List<com.enigma2.android.data.model.Bouquet> bouquets, @org.jetbrains.annotations.NotNull()
    java.util.Set<java.lang.String> userBouquetRefs, @org.jetbrains.annotations.NotNull()
    com.enigma2.android.data.repository.Enigma2Repository.BouquetEditorCapability capability) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.enigma2.android.ui.bouqueteditor.BouquetEditorAdapter.VH onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.enigma2.android.ui.bouqueteditor.BouquetEditorAdapter.VH holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0011\u0010\r\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0011\u0010\u000f\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\b\u00a8\u0006\u0011"}, d2 = {"Lcom/enigma2/android/ui/bouqueteditor/BouquetEditorAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "btnDelete", "Landroid/widget/TextView;", "getBtnDelete", "()Landroid/widget/TextView;", "btnEdit", "getBtnEdit", "btnRename", "getBtnRename", "name", "getName", "subtitle", "getSubtitle", "app_release"})
    public static final class VH extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView name = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView subtitle = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView btnEdit = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView btnRename = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView btnDelete = null;
        
        public VH(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getSubtitle() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getBtnEdit() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getBtnRename() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getBtnDelete() {
            return null;
        }
    }
}