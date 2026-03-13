package com.enigma2.android.ui.playlists;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0013\u0014BU\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u000bJ\u001c\u0010\f\u001a\u00020\u00062\n\u0010\r\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u001c\u0010\u000f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bH\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/enigma2/android/ui/playlists/PlaylistDetailAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/enigma2/android/data/model/PlaylistEntry;", "Lcom/enigma2/android/ui/playlists/PlaylistDetailAdapter$VH;", "onClick", "Lkotlin/Function1;", "", "onMoveUp", "", "onMoveDown", "onRemove", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "VH", "app_release"})
public final class PlaylistDetailAdapter extends androidx.recyclerview.widget.ListAdapter<com.enigma2.android.data.model.PlaylistEntry, com.enigma2.android.ui.playlists.PlaylistDetailAdapter.VH> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.enigma2.android.data.model.PlaylistEntry, kotlin.Unit> onClick = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> onMoveUp = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> onMoveDown = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.enigma2.android.data.model.PlaylistEntry, kotlin.Unit> onRemove = null;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.enigma2.android.data.model.PlaylistEntry> DIFF = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.enigma2.android.ui.playlists.PlaylistDetailAdapter.Companion Companion = null;
    
    public PlaylistDetailAdapter(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.enigma2.android.data.model.PlaylistEntry, kotlin.Unit> onClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onMoveUp, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onMoveDown, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.enigma2.android.data.model.PlaylistEntry, kotlin.Unit> onRemove) {
        super(null);
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.enigma2.android.ui.playlists.PlaylistDetailAdapter.VH onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.enigma2.android.ui.playlists.PlaylistDetailAdapter.VH holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/enigma2/android/ui/playlists/PlaylistDetailAdapter$Companion;", "", "()V", "DIFF", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/enigma2/android/data/model/PlaylistEntry;", "getDIFF", "()Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.enigma2.android.data.model.PlaylistEntry> getDIFF() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/enigma2/android/ui/playlists/PlaylistDetailAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/enigma2/android/ui/playlists/PlaylistDetailAdapter;Landroid/view/View;)V", "btnDown", "getBtnDown", "()Landroid/view/View;", "btnRemove", "getBtnRemove", "btnUp", "getBtnUp", "tvChannel", "Landroid/widget/TextView;", "getTvChannel", "()Landroid/widget/TextView;", "tvTitle", "getTvTitle", "app_release"})
    public final class VH extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvTitle = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvChannel = null;
        @org.jetbrains.annotations.NotNull()
        private final android.view.View btnUp = null;
        @org.jetbrains.annotations.NotNull()
        private final android.view.View btnDown = null;
        @org.jetbrains.annotations.NotNull()
        private final android.view.View btnRemove = null;
        
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
        public final android.view.View getBtnUp() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.view.View getBtnDown() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.view.View getBtnRemove() {
            return null;
        }
    }
}