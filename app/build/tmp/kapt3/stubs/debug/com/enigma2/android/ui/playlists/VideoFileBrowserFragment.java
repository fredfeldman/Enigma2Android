package com.enigma2.android.ui.playlists;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0002J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u0012\u0010\u0003\u001a\u00060\u0004R\u00020\u0000X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/enigma2/android/ui/playlists/VideoFileBrowserFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lcom/enigma2/android/ui/playlists/VideoFileBrowserFragment$FileAdapter;", "currentDir", "", "playlistPrefs", "Lcom/enigma2/android/data/prefs/PlaylistPreferences;", "receiverPrefs", "Lcom/enigma2/android/data/prefs/ReceiverPreferences;", "repo", "Lcom/enigma2/android/data/repository/Enigma2Repository;", "loadDirectory", "", "dirname", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "showAddToPlaylistDialog", "recording", "Lcom/enigma2/android/data/model/Recording;", "Companion", "FileAdapter", "app_debug"})
public final class VideoFileBrowserFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull()
    private final com.enigma2.android.data.repository.Enigma2Repository repo = null;
    private com.enigma2.android.data.prefs.PlaylistPreferences playlistPrefs;
    private com.enigma2.android.data.prefs.ReceiverPreferences receiverPrefs;
    private com.enigma2.android.ui.playlists.VideoFileBrowserFragment.FileAdapter adapter;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String currentDir;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.enigma2.android.data.model.Recording> DIFF = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.enigma2.android.ui.playlists.VideoFileBrowserFragment.Companion Companion = null;
    
    public VideoFileBrowserFragment() {
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
    
    private final void loadDirectory(java.lang.String dirname) {
    }
    
    private final void showAddToPlaylistDialog(com.enigma2.android.data.model.Recording recording) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/enigma2/android/ui/playlists/VideoFileBrowserFragment$Companion;", "", "()V", "DIFF", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/enigma2/android/data/model/Recording;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n0\u0003R\u00060\u0000R\u00020\u00040\u0001:\u0001\u0015B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ \u0010\r\u001a\u00020\u00072\u000e\u0010\u000e\u001a\n0\u0003R\u00060\u0000R\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J \u0010\u0011\u001a\n0\u0003R\u00060\u0000R\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0010H\u0016R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/enigma2/android/ui/playlists/VideoFileBrowserFragment$FileAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/enigma2/android/data/model/Recording;", "Lcom/enigma2/android/ui/playlists/VideoFileBrowserFragment$FileAdapter$VH;", "Lcom/enigma2/android/ui/playlists/VideoFileBrowserFragment;", "onClick", "Lkotlin/Function1;", "", "(Lcom/enigma2/android/ui/playlists/VideoFileBrowserFragment;Lkotlin/jvm/functions/Function1;)V", "DIFF", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "getDIFF", "()Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "VH", "app_debug"})
    final class FileAdapter extends androidx.recyclerview.widget.ListAdapter<com.enigma2.android.data.model.Recording, com.enigma2.android.ui.playlists.VideoFileBrowserFragment.FileAdapter.VH> {
        @org.jetbrains.annotations.NotNull()
        private final kotlin.jvm.functions.Function1<com.enigma2.android.data.model.Recording, kotlin.Unit> onClick = null;
        @org.jetbrains.annotations.NotNull()
        private final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.enigma2.android.data.model.Recording> DIFF = null;
        
        public FileAdapter(@org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super com.enigma2.android.data.model.Recording, kotlin.Unit> onClick) {
            super(null);
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public com.enigma2.android.ui.playlists.VideoFileBrowserFragment.FileAdapter.VH onCreateViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.ViewGroup parent, int viewType) {
            return null;
        }
        
        @java.lang.Override()
        public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
        com.enigma2.android.ui.playlists.VideoFileBrowserFragment.FileAdapter.VH holder, int position) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.enigma2.android.data.model.Recording> getDIFF() {
            return null;
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/enigma2/android/ui/playlists/VideoFileBrowserFragment$FileAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/enigma2/android/ui/playlists/VideoFileBrowserFragment$FileAdapter;Landroid/view/View;)V", "tvChannel", "Landroid/widget/TextView;", "getTvChannel", "()Landroid/widget/TextView;", "tvTitle", "getTvTitle", "app_debug"})
        public final class VH extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
            @org.jetbrains.annotations.NotNull()
            private final android.widget.TextView tvTitle = null;
            @org.jetbrains.annotations.NotNull()
            private final android.widget.TextView tvChannel = null;
            
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
        }
    }
}