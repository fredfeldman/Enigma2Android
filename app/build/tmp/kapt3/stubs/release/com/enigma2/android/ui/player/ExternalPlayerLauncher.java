package com.enigma2.android.ui.player;

/**
 * Routes a stream URL to either the built-in PlayerActivity or an installed
 * external player (VLC, MX Player, Kodi) based on the user's preference.
 *
 * Why no Cast SDK: Chromecast's default media receiver does not play MPEG-TS
 * streams that OpenWebif emits at port 8001, and providing a custom receiver
 * application is out of scope for this release. External players (VLC, MX,
 * Kodi, etc.) handle MPEG-TS natively, which gives users an immediate "cast
 * to TV via Kodi" path through their existing tooling.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u0005J \u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00140\u00132\u0006\u0010\u0010\u001a\u00020\u0011J(\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005J\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/enigma2/android/ui/player/ExternalPlayerLauncher;", "", "()V", "KNOWN_PLAYERS", "", "", "MODE_ASK", "MODE_EXTERNAL", "MODE_INTERNAL", "buildViewIntent", "Landroid/content/Intent;", "url", "title", "forcedPackage", "hasExternalHandler", "", "context", "Landroid/content/Context;", "installedKnownPlayers", "", "Lkotlin/Pair;", "launchExternalIfPreferred", "prefs", "Lcom/enigma2/android/data/prefs/ReceiverPreferences;", "mimeFor", "resolveAppName", "pkg", "app_release"})
public final class ExternalPlayerLauncher {
    
    /**
     * Pref values for the player_choice ListPreference.
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MODE_INTERNAL = "internal";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MODE_EXTERNAL = "external";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MODE_ASK = "ask";
    
    /**
     * Known package names with friendly labels — used for the chooser title.
     */
    @org.jetbrains.annotations.NotNull()
    private static final java.util.Map<java.lang.String, java.lang.String> KNOWN_PLAYERS = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.enigma2.android.ui.player.ExternalPlayerLauncher INSTANCE = null;
    
    private ExternalPlayerLauncher() {
        super();
    }
    
    /**
     * Returns the friendly label for any installed known player, in install-order.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<kotlin.Pair<java.lang.String, java.lang.String>> installedKnownPlayers(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    /**
     * Best-effort MIME type for a given OpenWebif stream URL.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String mimeFor(@org.jetbrains.annotations.NotNull()
    java.lang.String url) {
        return null;
    }
    
    /**
     * Build an ACTION_VIEW intent for [url]. If [forcedPackage] is set, the
     * intent is pinned to that package (no chooser).
     */
    @org.jetbrains.annotations.NotNull()
    public final android.content.Intent buildViewIntent(@org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.Nullable()
    java.lang.String title, @org.jetbrains.annotations.Nullable()
    java.lang.String forcedPackage) {
        return null;
    }
    
    /**
     * True if at least one app on the device can handle ACTION_VIEW for [url].
     */
    public final boolean hasExternalHandler(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String url) {
        return false;
    }
    
    /**
     * Convenience entry point used by Channel + Recording paths. Honours the
     * user's player-mode preference. Always falls back to the internal player
     * when no external app is available.
     *
     * Returns true when an external app was launched, false when the internal
     * player should handle playback (the caller is responsible for that path
     * to keep zap/PiP behaviour intact).
     */
    public final boolean launchExternalIfPreferred(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.Nullable()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    com.enigma2.android.data.prefs.ReceiverPreferences prefs) {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String resolveAppName(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String pkg) {
        return null;
    }
}