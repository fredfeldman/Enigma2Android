package com.enigma2.android.ui.bouqueteditor;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u0014\u0010\u0013\u001a\u00020\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/enigma2/android/ui/bouqueteditor/PickerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/enigma2/android/ui/bouqueteditor/PickerAdapter$VH;", "onClick", "Lkotlin/Function1;", "Lcom/enigma2/android/data/model/Service;", "", "(Lkotlin/jvm/functions/Function1;)V", "items", "", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submit", "list", "", "VH", "app_release"})
final class PickerAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.enigma2.android.ui.bouqueteditor.PickerAdapter.VH> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.enigma2.android.data.model.Service, kotlin.Unit> onClick = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.enigma2.android.data.model.Service> items = null;
    
    public PickerAdapter(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.enigma2.android.data.model.Service, kotlin.Unit> onClick) {
        super();
    }
    
    public final void submit(@org.jetbrains.annotations.NotNull()
    java.util.List<com.enigma2.android.data.model.Service> list) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.enigma2.android.ui.bouqueteditor.PickerAdapter.VH onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.enigma2.android.ui.bouqueteditor.PickerAdapter.VH holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/enigma2/android/ui/bouqueteditor/PickerAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "name", "Landroid/widget/TextView;", "getName", "()Landroid/widget/TextView;", "sub", "getSub", "app_release"})
    public static final class VH extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView name = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView sub = null;
        
        public VH(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getSub() {
            return null;
        }
    }
}