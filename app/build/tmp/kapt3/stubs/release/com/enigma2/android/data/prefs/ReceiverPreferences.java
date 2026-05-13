package com.enigma2.android.data.prefs;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0013\u0018\u0000 d2\u00020\u0001:\u0002cdB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u0016J\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020J0IJ\u000e\u0010K\u001a\u00020F2\u0006\u0010L\u001a\u00020\u0006J\u000e\u0010M\u001a\u00020F2\u0006\u0010N\u001a\u00020\u0006J\b\u0010O\u001a\u0004\u0018\u00010\u0016J\u0010\u0010P\u001a\u0004\u0018\u00010J2\u0006\u0010L\u001a\u00020\u0006J\u000e\u0010Q\u001a\u00020R2\u0006\u0010N\u001a\u00020\u0006J\u0006\u0010S\u001a\u00020\fJ\u000e\u0010T\u001a\u00020\u00062\u0006\u0010U\u001a\u00020\u0006J\u000e\u0010V\u001a\u00020\u00062\u0006\u0010U\u001a\u00020\u0006J\u000e\u0010W\u001a\u00020\u00062\u0006\u0010X\u001a\u00020\u0006J\u000e\u0010Y\u001a\u00020\u00062\u0006\u0010N\u001a\u00020\u0006J\u000e\u0010Z\u001a\u00020F2\u0006\u0010[\u001a\u00020\u0006J\u0016\u0010\\\u001a\u00020F2\u0006\u0010N\u001a\u00020\u00062\u0006\u0010]\u001a\u00020RJ\u0016\u0010^\u001a\u00020F2\u0006\u0010L\u001a\u00020\u00062\u0006\u0010_\u001a\u00020JJ\u000e\u0010`\u001a\u00020\u00062\u0006\u0010U\u001a\u00020\u0006J\b\u0010a\u001a\u00020FH\u0002J\u000e\u0010b\u001a\u00020F2\u0006\u0010U\u001a\u00020\u0006R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR0\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR0\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u00152\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00158F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR0\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00152\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00158F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u0011\u0010\"\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b#\u0010\tR$\u0010$\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b%\u0010\t\"\u0004\b&\u0010\u000bR$\u0010\'\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b(\u0010\t\"\u0004\b)\u0010\u000bR$\u0010*\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b+\u0010\u000f\"\u0004\b,\u0010\u0011R\u0011\u0010-\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b.\u0010\tR$\u0010/\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b0\u0010\u000f\"\u0004\b1\u0010\u0011R$\u00102\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b3\u0010\t\"\u0004\b4\u0010\u000bR\u0011\u00105\u001a\u0002068F\u00a2\u0006\u0006\u001a\u0004\b7\u00108R$\u00109\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b:\u0010\t\"\u0004\b;\u0010\u000bR\u000e\u0010<\u001a\u00020=X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010>\u001a\u00020\f8F\u00a2\u0006\u0006\u001a\u0004\b?\u0010\u000fR\u0011\u0010@\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\bA\u0010\tR$\u0010B\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bC\u0010\u000f\"\u0004\bD\u0010\u0011\u00a8\u0006e"}, d2 = {"Lcom/enigma2/android/data/prefs/ReceiverPreferences;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "", "activeDeviceId", "getActiveDeviceId", "()Ljava/lang/String;", "setActiveDeviceId", "(Ljava/lang/String;)V", "", "autoResumeLastChannel", "getAutoResumeLastChannel", "()Z", "setAutoResumeLastChannel", "(Z)V", "channelTapAction", "getChannelTapAction", "setChannelTapAction", "", "Lcom/enigma2/android/data/model/DeviceProfile;", "deviceProfiles", "getDeviceProfiles", "()Ljava/util/List;", "setDeviceProfiles", "(Ljava/util/List;)V", "favorites", "getFavorites", "setFavorites", "hiddenBouquets", "getHiddenBouquets", "setHiddenBouquets", "host", "getHost", "lastChannelName", "getLastChannelName", "setLastChannelName", "lastChannelRef", "getLastChannelRef", "setLastChannelRef", "nightMode", "getNightMode", "setNightMode", "password", "getPassword", "pipOnHome", "getPipOnHome", "setPipOnHome", "playerMode", "getPlayerMode", "setPlayerMode", "port", "", "getPort", "()I", "preferredExternalPackage", "getPreferredExternalPackage", "setPreferredExternalPackage", "prefs", "Landroid/content/SharedPreferences;", "useHttps", "getUseHttps", "username", "getUsername", "zapOnPlayerNavigate", "getZapOnPlayerNavigate", "setZapOnPlayerNavigate", "addOrUpdateProfile", "", "profile", "bouquetOverrides", "", "Lcom/enigma2/android/data/prefs/ReceiverPreferences$BouquetOverride;", "clearBouquetOverride", "bouquetRef", "clearPlaybackPosition", "filename", "getActiveProfile", "getBouquetOverride", "getPlaybackPosition", "", "isConfigured", "piconUrl", "serviceRef", "piconUrlAlt1", "piconUrlFromPath", "piconPath", "recordingStreamUrl", "removeProfile", "id", "savePlaybackPosition", "positionMs", "setBouquetOverride", "override", "streamUrl", "syncActiveDevice", "toggleFavorite", "BouquetOverride", "Companion", "app_release"})
public final class ReceiverPreferences {
    @org.jetbrains.annotations.NotNull()
    private final android.content.SharedPreferences prefs = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String VALUE_TAP_STREAM = "stream";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String VALUE_TAP_ZAP = "zap";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String VALUE_TAP_BOTH = "both";
    @org.jetbrains.annotations.NotNull()
    private static final com.google.gson.Gson gson = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_DEVICE_PROFILES = "device_profiles";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_ACTIVE_DEVICE_ID = "active_device_id";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_HOST = "host";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_PORT = "port";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_HTTPS = "use_https";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_USERNAME = "username";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_PASSWORD = "password";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_HIDDEN_BOUQUETS = "hidden_bouquets";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_BOUQUET_OVERRIDES = "bouquet_overrides_json";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_FAVORITES = "favorites";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_LAST_CHANNEL = "last_channel_ref";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_LAST_CHANNEL_NAME = "last_channel_name";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_AUTO_RESUME = "auto_resume";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_NIGHT_MODE = "night_mode";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_CHANNEL_TAP_ACTION = "channel_tap_action";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_ZAP_ON_PLAYER_NAV = "zap_on_player_nav";
    @org.jetbrains.annotations.NotNull()
    public static final com.enigma2.android.data.prefs.ReceiverPreferences.Companion Companion = null;
    
    public ReceiverPreferences(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.enigma2.android.data.model.DeviceProfile> getDeviceProfiles() {
        return null;
    }
    
    public final void setDeviceProfiles(@org.jetbrains.annotations.NotNull()
    java.util.List<com.enigma2.android.data.model.DeviceProfile> value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getActiveDeviceId() {
        return null;
    }
    
    public final void setActiveDeviceId(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.enigma2.android.data.model.DeviceProfile getActiveProfile() {
        return null;
    }
    
    public final void addOrUpdateProfile(@org.jetbrains.annotations.NotNull()
    com.enigma2.android.data.model.DeviceProfile profile) {
    }
    
    public final void removeProfile(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
    }
    
    private final void syncActiveDevice() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getHost() {
        return null;
    }
    
    public final int getPort() {
        return 0;
    }
    
    public final boolean getUseHttps() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUsername() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPassword() {
        return null;
    }
    
    public final boolean isConfigured() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String piconUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String serviceRef) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String piconUrlAlt1(@org.jetbrains.annotations.NotNull()
    java.lang.String serviceRef) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String piconUrlFromPath(@org.jetbrains.annotations.NotNull()
    java.lang.String piconPath) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getFavorites() {
        return null;
    }
    
    public final void setFavorites(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> value) {
    }
    
    public final void toggleFavorite(@org.jetbrains.annotations.NotNull()
    java.lang.String serviceRef) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String streamUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String serviceRef) {
        return null;
    }
    
    /**
     * Builds an OpenWebif /file?file= URL for a recording. Uses the configured port and
     * fully encodes the filename so spaces and special characters are handled correctly.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String recordingStreamUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String filename) {
        return null;
    }
    
    public final void savePlaybackPosition(@org.jetbrains.annotations.NotNull()
    java.lang.String filename, long positionMs) {
    }
    
    public final long getPlaybackPosition(@org.jetbrains.annotations.NotNull()
    java.lang.String filename) {
        return 0L;
    }
    
    public final void clearPlaybackPosition(@org.jetbrains.annotations.NotNull()
    java.lang.String filename) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLastChannelRef() {
        return null;
    }
    
    public final void setLastChannelRef(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLastChannelName() {
        return null;
    }
    
    public final void setLastChannelName(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    public final boolean getAutoResumeLastChannel() {
        return false;
    }
    
    public final void setAutoResumeLastChannel(boolean value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getHiddenBouquets() {
        return null;
    }
    
    public final void setHiddenBouquets(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, com.enigma2.android.data.prefs.ReceiverPreferences.BouquetOverride> bouquetOverrides() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.enigma2.android.data.prefs.ReceiverPreferences.BouquetOverride getBouquetOverride(@org.jetbrains.annotations.NotNull()
    java.lang.String bouquetRef) {
        return null;
    }
    
    public final void setBouquetOverride(@org.jetbrains.annotations.NotNull()
    java.lang.String bouquetRef, @org.jetbrains.annotations.NotNull()
    com.enigma2.android.data.prefs.ReceiverPreferences.BouquetOverride override) {
    }
    
    public final void clearBouquetOverride(@org.jetbrains.annotations.NotNull()
    java.lang.String bouquetRef) {
    }
    
    public final boolean getNightMode() {
        return false;
    }
    
    public final void setNightMode(boolean value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getChannelTapAction() {
        return null;
    }
    
    public final void setChannelTapAction(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    public final boolean getZapOnPlayerNavigate() {
        return false;
    }
    
    public final void setZapOnPlayerNavigate(boolean value) {
    }
    
    public final boolean getPipOnHome() {
        return false;
    }
    
    public final void setPipOnHome(boolean value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPlayerMode() {
        return null;
    }
    
    public final void setPlayerMode(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPreferredExternalPackage() {
        return null;
    }
    
    public final void setPreferredExternalPackage(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    /**
     * Per-bouquet user override: desired channel order + removed channel refs.
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0006J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J)\u0010\f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001J\u0006\u0010\u0012\u001a\u00020\u000eJ\t\u0010\u0013\u001a\u00020\u0004H\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b\u00a8\u0006\u0014"}, d2 = {"Lcom/enigma2/android/data/prefs/ReceiverPreferences$BouquetOverride;", "", "order", "", "", "removed", "(Ljava/util/List;Ljava/util/List;)V", "getOrder", "()Ljava/util/List;", "getRemoved", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "isEmpty", "toString", "app_release"})
    public static final class BouquetOverride {
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<java.lang.String> order = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<java.lang.String> removed = null;
        
        public BouquetOverride(@org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> order, @org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> removed) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> getOrder() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> getRemoved() {
            return null;
        }
        
        public final boolean isEmpty() {
            return false;
        }
        
        public BouquetOverride() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.enigma2.android.data.prefs.ReceiverPreferences.BouquetOverride copy(@org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> order, @org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> removed) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/enigma2/android/data/prefs/ReceiverPreferences$Companion;", "", "()V", "KEY_ACTIVE_DEVICE_ID", "", "KEY_AUTO_RESUME", "KEY_BOUQUET_OVERRIDES", "KEY_CHANNEL_TAP_ACTION", "KEY_DEVICE_PROFILES", "KEY_FAVORITES", "KEY_HIDDEN_BOUQUETS", "KEY_HOST", "KEY_HTTPS", "KEY_LAST_CHANNEL", "KEY_LAST_CHANNEL_NAME", "KEY_NIGHT_MODE", "KEY_PASSWORD", "KEY_PORT", "KEY_USERNAME", "KEY_ZAP_ON_PLAYER_NAV", "VALUE_TAP_BOTH", "VALUE_TAP_STREAM", "VALUE_TAP_ZAP", "gson", "Lcom/google/gson/Gson;", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}