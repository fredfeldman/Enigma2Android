package com.enigma2.android.ui.epg;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u00015B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J$\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016J\u001a\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020\"2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u0010.\u001a\u00020 2\u0006\u0010,\u001a\u00020-H\u0002J\b\u0010/\u001a\u00020 H\u0002J\u0010\u00100\u001a\u00020 2\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u00101\u001a\u00020 2\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u00102\u001a\u00020 2\u0006\u00103\u001a\u000204H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\b\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00066"}, d2 = {"Lcom/enigma2/android/ui/epg/EpgFragment;", "Landroidx/fragment/app/Fragment;", "()V", "channelViewModel", "Lcom/enigma2/android/ui/viewmodel/ChannelViewModel;", "getChannelViewModel", "()Lcom/enigma2/android/ui/viewmodel/ChannelViewModel;", "channelViewModel$delegate", "Lkotlin/Lazy;", "epgGrid", "Lcom/enigma2/android/ui/epg/EpgGridView;", "epgViewModel", "Lcom/enigma2/android/ui/viewmodel/EpgViewModel;", "getEpgViewModel", "()Lcom/enigma2/android/ui/viewmodel/EpgViewModel;", "epgViewModel$delegate", "hScrollView", "Landroid/widget/HorizontalScrollView;", "prefs", "Lcom/enigma2/android/data/prefs/ReceiverPreferences;", "repo", "Lcom/enigma2/android/data/repository/Enigma2Repository;", "rvChannelNames", "Landroidx/recyclerview/widget/RecyclerView;", "timeRuler", "Lcom/enigma2/android/ui/epg/EpgTimeRulerView;", "tvInfoBar", "Landroid/widget/TextView;", "tvSelectedEvent", "computeStartTime", "", "observeViewModel", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "playEvent", "event", "Lcom/enigma2/android/data/model/EpgEvent;", "scheduleRecording", "setupChannelNamesAdapter", "showEventInfo", "showRecordDialog", "syncChannelNameScroll", "scrollX", "", "ChannelNamesAdapter", "app_debug"})
public final class EpgFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy channelViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy epgViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final com.enigma2.android.data.repository.Enigma2Repository repo = null;
    private com.enigma2.android.data.prefs.ReceiverPreferences prefs;
    private androidx.recyclerview.widget.RecyclerView rvChannelNames;
    private com.enigma2.android.ui.epg.EpgGridView epgGrid;
    private com.enigma2.android.ui.epg.EpgTimeRulerView timeRuler;
    private android.widget.HorizontalScrollView hScrollView;
    private android.widget.TextView tvInfoBar;
    private android.widget.TextView tvSelectedEvent;
    
    public EpgFragment() {
        super();
    }
    
    private final com.enigma2.android.ui.viewmodel.ChannelViewModel getChannelViewModel() {
        return null;
    }
    
    private final com.enigma2.android.ui.viewmodel.EpgViewModel getEpgViewModel() {
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
    
    private final void setupChannelNamesAdapter() {
    }
    
    private final void observeViewModel() {
    }
    
    private final long computeStartTime() {
        return 0L;
    }
    
    private final void showEventInfo(com.enigma2.android.data.model.EpgEvent event) {
    }
    
    private final void playEvent(com.enigma2.android.data.model.EpgEvent event) {
    }
    
    private final void showRecordDialog(com.enigma2.android.data.model.EpgEvent event) {
    }
    
    private final void scheduleRecording(com.enigma2.android.data.model.EpgEvent event) {
    }
    
    private final void syncChannelNameScroll(int scrollX) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u0019B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\tH\u0016J \u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0012\u001a\u00020\tH\u0016J \u0010\u0013\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\tH\u0016J\u0014\u0010\u0017\u001a\u00020\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u001a"}, d2 = {"Lcom/enigma2/android/ui/epg/EpgFragment$ChannelNamesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/enigma2/android/ui/epg/EpgFragment$ChannelNamesAdapter$VH;", "Lcom/enigma2/android/ui/epg/EpgFragment;", "(Lcom/enigma2/android/ui/epg/EpgFragment;)V", "names", "", "", "rowHeightPx", "", "getRowHeightPx", "()I", "rowHeightPx$delegate", "Lkotlin/Lazy;", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateChannels", "list", "VH", "app_debug"})
    public final class ChannelNamesAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.enigma2.android.ui.epg.EpgFragment.ChannelNamesAdapter.VH> {
        @org.jetbrains.annotations.NotNull()
        private java.util.List<java.lang.String> names;
        @org.jetbrains.annotations.NotNull()
        private final kotlin.Lazy rowHeightPx$delegate = null;
        
        public ChannelNamesAdapter() {
            super();
        }
        
        private final int getRowHeightPx() {
            return 0;
        }
        
        public final void updateChannels(@org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> list) {
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public com.enigma2.android.ui.epg.EpgFragment.ChannelNamesAdapter.VH onCreateViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.ViewGroup parent, int viewType) {
            return null;
        }
        
        @java.lang.Override()
        public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
        com.enigma2.android.ui.epg.EpgFragment.ChannelNamesAdapter.VH holder, int position) {
        }
        
        @java.lang.Override()
        public int getItemCount() {
            return 0;
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/enigma2/android/ui/epg/EpgFragment$ChannelNamesAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/enigma2/android/ui/epg/EpgFragment$ChannelNamesAdapter;Landroid/view/View;)V", "tv", "Landroid/widget/TextView;", "getTv", "()Landroid/widget/TextView;", "app_debug"})
        public final class VH extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
            @org.jetbrains.annotations.NotNull()
            private final android.widget.TextView tv = null;
            
            public VH(@org.jetbrains.annotations.NotNull()
            android.view.View view) {
                super(null);
            }
            
            @org.jetbrains.annotations.NotNull()
            public final android.widget.TextView getTv() {
                return null;
            }
        }
    }
}