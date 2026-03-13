package com.enigma2.android.ui.epg;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0002\u0017\u0018B\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00060\bR\u00020\u0000X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/enigma2/android/ui/epg/EpgSearchFragment;", "Landroidx/fragment/app/Fragment;", "()V", "prefs", "Lcom/enigma2/android/data/prefs/ReceiverPreferences;", "repo", "Lcom/enigma2/android/data/repository/Enigma2Repository;", "searchAdapter", "Lcom/enigma2/android/ui/epg/EpgSearchFragment$SearchResultAdapter;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "performSearch", "query", "", "Companion", "SearchResultAdapter", "app_debug"})
public final class EpgSearchFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull()
    private final com.enigma2.android.data.repository.Enigma2Repository repo = null;
    private com.enigma2.android.data.prefs.ReceiverPreferences prefs;
    private com.enigma2.android.ui.epg.EpgSearchFragment.SearchResultAdapter searchAdapter;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.enigma2.android.data.model.EpgEvent> DIFF = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.enigma2.android.ui.epg.EpgSearchFragment.Companion Companion = null;
    
    public EpgSearchFragment() {
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
    
    private final void performSearch(java.lang.String query) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/enigma2/android/ui/epg/EpgSearchFragment$Companion;", "", "()V", "DIFF", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/enigma2/android/data/model/EpgEvent;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n0\u0003R\u00060\u0000R\u00020\u00040\u0001:\u0001\u0015B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ \u0010\r\u001a\u00020\u00072\u000e\u0010\u000e\u001a\n0\u0003R\u00060\u0000R\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J \u0010\u0011\u001a\n0\u0003R\u00060\u0000R\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0010H\u0016R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/enigma2/android/ui/epg/EpgSearchFragment$SearchResultAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/enigma2/android/data/model/EpgEvent;", "Lcom/enigma2/android/ui/epg/EpgSearchFragment$SearchResultAdapter$VH;", "Lcom/enigma2/android/ui/epg/EpgSearchFragment;", "onEventClick", "Lkotlin/Function1;", "", "(Lcom/enigma2/android/ui/epg/EpgSearchFragment;Lkotlin/jvm/functions/Function1;)V", "DIFF", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "getDIFF", "()Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "VH", "app_debug"})
    final class SearchResultAdapter extends androidx.recyclerview.widget.ListAdapter<com.enigma2.android.data.model.EpgEvent, com.enigma2.android.ui.epg.EpgSearchFragment.SearchResultAdapter.VH> {
        @org.jetbrains.annotations.NotNull()
        private final kotlin.jvm.functions.Function1<com.enigma2.android.data.model.EpgEvent, kotlin.Unit> onEventClick = null;
        @org.jetbrains.annotations.NotNull()
        private final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.enigma2.android.data.model.EpgEvent> DIFF = null;
        
        public SearchResultAdapter(@org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super com.enigma2.android.data.model.EpgEvent, kotlin.Unit> onEventClick) {
            super(null);
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public com.enigma2.android.ui.epg.EpgSearchFragment.SearchResultAdapter.VH onCreateViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.ViewGroup parent, int viewType) {
            return null;
        }
        
        @java.lang.Override()
        public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
        com.enigma2.android.ui.epg.EpgSearchFragment.SearchResultAdapter.VH holder, int position) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.enigma2.android.data.model.EpgEvent> getDIFF() {
            return null;
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/enigma2/android/ui/epg/EpgSearchFragment$SearchResultAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/enigma2/android/ui/epg/EpgSearchFragment$SearchResultAdapter;Landroid/view/View;)V", "tvChannel", "Landroid/widget/TextView;", "getTvChannel", "()Landroid/widget/TextView;", "tvTime", "getTvTime", "tvTitle", "getTvTitle", "app_debug"})
        public final class VH extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
            @org.jetbrains.annotations.NotNull()
            private final android.widget.TextView tvTitle = null;
            @org.jetbrains.annotations.NotNull()
            private final android.widget.TextView tvChannel = null;
            @org.jetbrains.annotations.NotNull()
            private final android.widget.TextView tvTime = null;
            
            public VH(@org.jetbrains.annotations.NotNull()
            android.view.View view) {
                super(null);
            }
            
            @org.jetbrains.annotations.NotNull()
            public final android.widget.TextView getTvTitle() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final android.widget.TextView getTvChannel() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final android.widget.TextView getTvTime() {
                return null;
            }
        }
    }
}