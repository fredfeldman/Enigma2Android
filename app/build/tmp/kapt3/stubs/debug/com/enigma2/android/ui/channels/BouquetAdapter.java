package com.enigma2.android.ui.channels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0014\u0015B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\u001c\u0010\n\u001a\u00020\u00062\n\u0010\u000b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\tR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/enigma2/android/ui/channels/BouquetAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/enigma2/android/data/model/Bouquet;", "Lcom/enigma2/android/ui/channels/BouquetAdapter$ViewHolder;", "onBouquetSelected", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "selectedRef", "", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setSelectedRef", "ref", "Companion", "ViewHolder", "app_debug"})
public final class BouquetAdapter extends androidx.recyclerview.widget.ListAdapter<com.enigma2.android.data.model.Bouquet, com.enigma2.android.ui.channels.BouquetAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.enigma2.android.data.model.Bouquet, kotlin.Unit> onBouquetSelected = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String selectedRef = "";
    @org.jetbrains.annotations.NotNull()
    private static final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.enigma2.android.data.model.Bouquet> DIFF = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.enigma2.android.ui.channels.BouquetAdapter.Companion Companion = null;
    
    public BouquetAdapter(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.enigma2.android.data.model.Bouquet, kotlin.Unit> onBouquetSelected) {
        super(null);
    }
    
    public final void setSelectedRef(@org.jetbrains.annotations.NotNull()
    java.lang.String ref) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.enigma2.android.ui.channels.BouquetAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.enigma2.android.ui.channels.BouquetAdapter.ViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/enigma2/android/ui/channels/BouquetAdapter$Companion;", "", "()V", "DIFF", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/enigma2/android/data/model/Bouquet;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/enigma2/android/ui/channels/BouquetAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/enigma2/android/ui/channels/BouquetAdapter;Landroid/view/View;)V", "tvName", "Landroid/widget/TextView;", "getTvName", "()Landroid/widget/TextView;", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvName = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvName() {
            return null;
        }
    }
}