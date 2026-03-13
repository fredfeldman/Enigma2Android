package com.enigma2.android.ui.channels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\u0018\u0000 \"2\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\"#B5\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\u0007\u00a2\u0006\u0002\u0010\u000bJ\u001c\u0010\u0013\u001a\u00020\b2\n\u0010\u0014\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001c\u0010\u0017\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\u0014\u0010\u001b\u001a\u00020\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001dJ\u0014\u0010\u001e\u001a\u00020\b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00110\u001dJ\u0014\u0010 \u001a\u00020\b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\rR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/enigma2/android/ui/channels/ChannelAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/enigma2/android/data/model/Service;", "Lcom/enigma2/android/ui/channels/ChannelAdapter$ViewHolder;", "prefs", "Lcom/enigma2/android/data/prefs/ReceiverPreferences;", "onChannelClick", "Lkotlin/Function1;", "", "onChannelLongClick", "", "(Lcom/enigma2/android/data/prefs/ReceiverPreferences;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "favoriteRefs", "", "", "nowNextMap", "", "Lcom/enigma2/android/data/model/NowNextEvent;", "recordingRefs", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateFavorites", "favs", "", "updateNowNext", "events", "updateRecordingRefs", "refs", "Companion", "ViewHolder", "app_release"})
public final class ChannelAdapter extends androidx.recyclerview.widget.ListAdapter<com.enigma2.android.data.model.Service, com.enigma2.android.ui.channels.ChannelAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final com.enigma2.android.data.prefs.ReceiverPreferences prefs = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.enigma2.android.data.model.Service, kotlin.Unit> onChannelClick = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.enigma2.android.data.model.Service, java.lang.Boolean> onChannelLongClick = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.Set<java.lang.String> favoriteRefs;
    @org.jetbrains.annotations.NotNull()
    private java.util.Set<java.lang.String> recordingRefs;
    @org.jetbrains.annotations.NotNull()
    private java.util.Map<java.lang.String, com.enigma2.android.data.model.NowNextEvent> nowNextMap;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.enigma2.android.data.model.Service> DIFF = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.enigma2.android.ui.channels.ChannelAdapter.Companion Companion = null;
    
    public ChannelAdapter(@org.jetbrains.annotations.NotNull()
    com.enigma2.android.data.prefs.ReceiverPreferences prefs, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.enigma2.android.data.model.Service, kotlin.Unit> onChannelClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.enigma2.android.data.model.Service, java.lang.Boolean> onChannelLongClick) {
        super(null);
    }
    
    public final void updateFavorites(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> favs) {
    }
    
    public final void updateRecordingRefs(@org.jetbrains.annotations.NotNull()
    java.util.Set<java.lang.String> refs) {
    }
    
    public final void updateNowNext(@org.jetbrains.annotations.NotNull()
    java.util.List<com.enigma2.android.data.model.NowNextEvent> events) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.enigma2.android.ui.channels.ChannelAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.enigma2.android.ui.channels.ChannelAdapter.ViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/enigma2/android/ui/channels/ChannelAdapter$Companion;", "", "()V", "DIFF", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/enigma2/android/data/model/Service;", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u0011\u0010\u0013\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\bR\u0011\u0010\u0015\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\bR\u0011\u0010\u0017\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\bR\u0011\u0010\u0019\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\b\u00a8\u0006\u001b"}, d2 = {"Lcom/enigma2/android/ui/channels/ChannelAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/enigma2/android/ui/channels/ChannelAdapter;Landroid/view/View;)V", "btnFavorite", "Landroid/widget/TextView;", "getBtnFavorite", "()Landroid/widget/TextView;", "ivPicon", "Landroid/widget/ImageView;", "getIvPicon", "()Landroid/widget/ImageView;", "progressNow", "Landroid/widget/ProgressBar;", "getProgressNow", "()Landroid/widget/ProgressBar;", "tvName", "getTvName", "tvNext", "getTvNext", "tvNow", "getTvNow", "tvNumber", "getTvNumber", "tvRecBadge", "getTvRecBadge", "app_release"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvNumber = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageView ivPicon = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvName = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvNow = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvNext = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ProgressBar progressNow = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvRecBadge = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView btnFavorite = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvNumber() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getIvPicon() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvNow() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvNext() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ProgressBar getProgressNow() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvRecBadge() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getBtnFavorite() {
            return null;
        }
    }
}