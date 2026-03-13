package com.enigma2.android.data.prefs;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0014J\u000e\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0014J\u0016\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u0014J\u0016\u0010!\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R0\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8F@BX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/enigma2/android/data/prefs/PlaylistPreferences;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "gson", "Lcom/google/gson/Gson;", "value", "", "Lcom/enigma2/android/data/model/RecordingPlaylist;", "playlists", "getPlaylists", "()Ljava/util/List;", "setPlaylists", "(Ljava/util/List;)V", "prefs", "Landroid/content/SharedPreferences;", "addEntry", "", "playlistId", "", "entry", "Lcom/enigma2/android/data/model/PlaylistEntry;", "createPlaylist", "name", "deletePlaylist", "id", "moveEntryDown", "index", "", "moveEntryUp", "removeEntry", "filename", "renamePlaylist", "newName", "Companion", "app_debug"})
public final class PlaylistPreferences {
    @org.jetbrains.annotations.NotNull()
    private final android.content.SharedPreferences prefs = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.gson.Gson gson = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_PLAYLISTS = "playlists";
    @org.jetbrains.annotations.NotNull()
    public static final com.enigma2.android.data.prefs.PlaylistPreferences.Companion Companion = null;
    
    public PlaylistPreferences(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.enigma2.android.data.model.RecordingPlaylist> getPlaylists() {
        return null;
    }
    
    private final void setPlaylists(java.util.List<com.enigma2.android.data.model.RecordingPlaylist> value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.enigma2.android.data.model.RecordingPlaylist createPlaylist(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
        return null;
    }
    
    public final void renamePlaylist(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String newName) {
    }
    
    public final void deletePlaylist(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
    }
    
    public final void addEntry(@org.jetbrains.annotations.NotNull()
    java.lang.String playlistId, @org.jetbrains.annotations.NotNull()
    com.enigma2.android.data.model.PlaylistEntry entry) {
    }
    
    public final void removeEntry(@org.jetbrains.annotations.NotNull()
    java.lang.String playlistId, @org.jetbrains.annotations.NotNull()
    java.lang.String filename) {
    }
    
    public final void moveEntryUp(@org.jetbrains.annotations.NotNull()
    java.lang.String playlistId, int index) {
    }
    
    public final void moveEntryDown(@org.jetbrains.annotations.NotNull()
    java.lang.String playlistId, int index) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/enigma2/android/data/prefs/PlaylistPreferences$Companion;", "", "()V", "KEY_PLAYLISTS", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}