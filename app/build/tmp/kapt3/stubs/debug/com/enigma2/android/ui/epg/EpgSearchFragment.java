package com.enigma2.android.ui.epg;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 &2\u00020\u0001:\u0002&\'B\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\nH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00060\u0014R\u00020\u0000X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/enigma2/android/ui/epg/EpgSearchFragment;", "Landroidx/fragment/app/Fragment;", "()V", "channelViewModel", "Lcom/enigma2/android/ui/viewmodel/ChannelViewModel;", "getChannelViewModel", "()Lcom/enigma2/android/ui/viewmodel/ChannelViewModel;", "channelViewModel$delegate", "Lkotlin/Lazy;", "lastQuery", "", "prefs", "Lcom/enigma2/android/data/prefs/ReceiverPreferences;", "progress", "Landroid/widget/ProgressBar;", "repo", "Lcom/enigma2/android/data/repository/Enigma2Repository;", "rv", "Landroidx/recyclerview/widget/RecyclerView;", "searchAdapter", "Lcom/enigma2/android/ui/epg/EpgSearchFragment$SearchResultAdapter;", "searchJob", "Lkotlinx/coroutines/Job;", "tvEmpty", "Landroid/widget/TextView;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "performSearch", "query", "Companion", "SearchResultAdapter", "app_debug"})
public final class EpgSearchFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull()
    private final com.enigma2.android.data.repository.Enigma2Repository repo = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy channelViewModel$delegate = null;
    private com.enigma2.android.data.prefs.ReceiverPreferences prefs;
    private com.enigma2.android.ui.epg.EpgSearchFragment.SearchResultAdapter searchAdapter;
    private androidx.recyclerview.widget.RecyclerView rv;
    private android.widget.ProgressBar progress;
    private android.widget.TextView tvEmpty;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job searchJob;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String lastQuery = "";
    @org.jetbrains.annotations.NotNull()
    private static final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.enigma2.android.data.model.EpgEvent> DIFF = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.enigma2.android.ui.epg.EpgSearchFragment.Companion Companion = null;
    
    public EpgSearchFragment() {
        super();
    }
    
    private final com.enigma2.android.ui.viewmodel.ChannelViewModel getChannelViewModel() {
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
    
    private final void performSearch(java.lang.String query) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/enigma2/android/ui/epg/EpgSearchFragment$Companion;", "", "()V", "DIFF", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/enigma2/android/data/model/EpgEvent;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n0\u0003R\u00060\u0000R\u00020\u00040\u0001:\u0001\u001aB\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ \u0010\u0010\u001a\u00020\u00072\u000e\u0010\u0011\u001a\n0\u0003R\u00060\u0000R\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J \u0010\u0014\u001a\n0\u0003R\u00060\u0000R\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\u001a\u0010\u0018\u001a\u00020\u00072\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/enigma2/android/ui/epg/EpgSearchFragment$SearchResultAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/enigma2/android/data/model/EpgEvent;", "Lcom/enigma2/android/ui/epg/EpgSearchFragment$SearchResultAdapter$VH;", "Lcom/enigma2/android/ui/epg/EpgSearchFragment;", "onEventClick", "Lkotlin/Function1;", "", "(Lcom/enigma2/android/ui/epg/EpgSearchFragment;Lkotlin/jvm/functions/Function1;)V", "DIFF", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "getDIFF", "()Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "channelNames", "", "", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateChannelNames", "map", "VH", "app_debug"})
    final class SearchResultAdapter extends androidx.recyclerview.widget.ListAdapter<com.enigma2.android.data.model.EpgEvent, com.enigma2.android.ui.epg.EpgSearchFragment.SearchResultAdapter.VH> {
        @org.jetbrains.annotations.NotNull()
        private final kotlin.jvm.functions.Function1<com.enigma2.android.data.model.EpgEvent, kotlin.Unit> onEventClick = null;
        @org.jetbrains.annotations.NotNull()
        private java.util.Map<java.lang.String, java.lang.String> channelNames;
        @org.jetbrains.annotations.NotNull()
        private final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.enigma2.android.data.model.EpgEvent> DIFF = null;
        
        public SearchResultAdapter(@org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super com.enigma2.android.data.model.EpgEvent, kotlin.Unit> onEventClick) {
            super(null);
        }
        
        public final void updateChannelNames(@org.jetbrains.annotations.NotNull()
        java.util.Map<java.lang.String, java.lang.String> map) {
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