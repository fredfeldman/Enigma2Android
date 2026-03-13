package com.enigma2.android.ui.settings;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0014B\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u0012\u0010\u0003\u001a\u00060\u0004R\u00020\u0000X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/enigma2/android/ui/settings/HideBouquetsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lcom/enigma2/android/ui/settings/HideBouquetsFragment$BouquetCheckAdapter;", "prefs", "Lcom/enigma2/android/data/prefs/ReceiverPreferences;", "repo", "Lcom/enigma2/android/data/repository/Enigma2Repository;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "BouquetCheckAdapter", "app_release"})
public final class HideBouquetsFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull()
    private final com.enigma2.android.data.repository.Enigma2Repository repo = null;
    private com.enigma2.android.data.prefs.ReceiverPreferences prefs;
    private com.enigma2.android.ui.settings.HideBouquetsFragment.BouquetCheckAdapter adapter;
    
    public HideBouquetsFragment() {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u0018B\u001f\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005\u00a2\u0006\u0002\u0010\tJ\b\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\b2\u000e\u0010\u0010\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J \u0010\u0012\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eH\u0016J\u0014\u0010\u0016\u001a\u00020\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u000bR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/enigma2/android/ui/settings/HideBouquetsFragment$BouquetCheckAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/enigma2/android/ui/settings/HideBouquetsFragment$BouquetCheckAdapter$VH;", "Lcom/enigma2/android/ui/settings/HideBouquetsFragment;", "onToggle", "Lkotlin/Function2;", "", "", "", "(Lcom/enigma2/android/ui/settings/HideBouquetsFragment;Lkotlin/jvm/functions/Function2;)V", "items", "", "Lcom/enigma2/android/data/model/Bouquet;", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submitList", "list", "VH", "app_release"})
    final class BouquetCheckAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.enigma2.android.ui.settings.HideBouquetsFragment.BouquetCheckAdapter.VH> {
        @org.jetbrains.annotations.NotNull()
        private final kotlin.jvm.functions.Function2<java.lang.String, java.lang.Boolean, kotlin.Unit> onToggle = null;
        @org.jetbrains.annotations.NotNull()
        private java.util.List<com.enigma2.android.data.model.Bouquet> items;
        
        public BouquetCheckAdapter(@org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.Boolean, kotlin.Unit> onToggle) {
            super();
        }
        
        public final void submitList(@org.jetbrains.annotations.NotNull()
        java.util.List<com.enigma2.android.data.model.Bouquet> list) {
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public com.enigma2.android.ui.settings.HideBouquetsFragment.BouquetCheckAdapter.VH onCreateViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.ViewGroup parent, int viewType) {
            return null;
        }
        
        @java.lang.Override()
        public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
        com.enigma2.android.ui.settings.HideBouquetsFragment.BouquetCheckAdapter.VH holder, int position) {
        }
        
        @java.lang.Override()
        public int getItemCount() {
            return 0;
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/enigma2/android/ui/settings/HideBouquetsFragment$BouquetCheckAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/enigma2/android/ui/settings/HideBouquetsFragment$BouquetCheckAdapter;Landroid/view/View;)V", "cbHide", "Landroid/widget/CheckBox;", "getCbHide", "()Landroid/widget/CheckBox;", "tvName", "Landroid/widget/TextView;", "getTvName", "()Landroid/widget/TextView;", "app_release"})
        public final class VH extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
            @org.jetbrains.annotations.NotNull()
            private final android.widget.TextView tvName = null;
            @org.jetbrains.annotations.NotNull()
            private final android.widget.CheckBox cbHide = null;
            
            public VH(@org.jetbrains.annotations.NotNull()
            android.view.View view) {
                super(null);
            }
            
            @org.jetbrains.annotations.NotNull()
            public final android.widget.TextView getTvName() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final android.widget.CheckBox getCbHide() {
                return null;
            }
        }
    }
}