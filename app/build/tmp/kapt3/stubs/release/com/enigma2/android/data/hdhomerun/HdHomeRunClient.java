package com.enigma2.android.data.hdhomerun;

/**
 * Minimal HDHomeRun (SiliconDust) tuner client.
 *
 * HDHomeRun devices expose a JSON HTTP API on port 80:
 *  GET /discover.json  -> device info (model, firmware, BaseURL)
 *  GET /lineup.json    -> [{ GuideNumber, GuideName, URL, ... }]
 *
 * The stream URL returned by lineup.json is a plain HTTP MPEG-TS endpoint
 * such as http://192.168.1.50:5004/auto/v5 — directly usable as an
 * Enigma2 IPTV service ref (service type 4097).
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00142\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/enigma2/android/data/hdhomerun/HdHomeRunClient;", "", "()V", "client", "Lokhttp3/OkHttpClient;", "getClient", "()Lokhttp3/OkHttpClient;", "client$delegate", "Lkotlin/Lazy;", "gson", "Lcom/google/gson/Gson;", "baseUrl", "", "host", "discover", "Lcom/enigma2/android/data/hdhomerun/HdHomeRunClient$DiscoverInfo;", "displayName", "channel", "Lcom/enigma2/android/data/hdhomerun/HdHomeRunClient$Channel;", "fetchLineup", "", "toEnigma2Ref", "Channel", "DiscoverInfo", "app_release"})
public final class HdHomeRunClient {
    @org.jetbrains.annotations.NotNull()
    private static final com.google.gson.Gson gson = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy client$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.enigma2.android.data.hdhomerun.HdHomeRunClient INSTANCE = null;
    
    private HdHomeRunClient() {
        super();
    }
    
    private final okhttp3.OkHttpClient getClient() {
        return null;
    }
    
    /**
     * Normalise a host. Accepts "1.2.3.4", "hdhomerun.local", "http://1.2.3.4".
     */
    private final java.lang.String baseUrl(java.lang.String host) {
        return null;
    }
    
    /**
     * Fetch device info from `<host>/discover.json`. Returns null on any error
     * (timeout, non-200, malformed JSON).
     */
    @org.jetbrains.annotations.Nullable()
    public final com.enigma2.android.data.hdhomerun.HdHomeRunClient.DiscoverInfo discover(@org.jetbrains.annotations.NotNull()
    java.lang.String host) {
        return null;
    }
    
    /**
     * Fetch the channel lineup from `<host>/lineup.json`. Returns an empty
     * list on any error so the caller can present "no channels found" without
     * exception handling.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.enigma2.android.data.hdhomerun.HdHomeRunClient.Channel> fetchLineup(@org.jetbrains.annotations.NotNull()
    java.lang.String host) {
        return null;
    }
    
    /**
     * Build an Enigma2 IPTV service reference for an HDHomeRun stream URL.
     *
     * Format used by Enigma2 user-bouquet entries for HTTP streams:
     *  `4097:0:1:0:0:0:0:0:0:0:<url-encoded-url>:<name>`
     *
     * Service type 4097 = GStreamer-backed external stream player. Colons
     * and slashes inside the URL are %-encoded so the Enigma2 parser doesn't
     * mistake them for ref-field separators.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String toEnigma2Ref(@org.jetbrains.annotations.NotNull()
    com.enigma2.android.data.hdhomerun.HdHomeRunClient.Channel channel) {
        return null;
    }
    
    /**
     * Friendly display label for a [Channel] in pickers.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String displayName(@org.jetbrains.annotations.NotNull()
    com.enigma2.android.data.hdhomerun.HdHomeRunClient.Channel channel) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010\fJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010\fJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010\fJP\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007H\u00c6\u0001\u00a2\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u00142\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010!\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\"\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0012\u0010\fR\u0011\u0010\u0013\u001a\u00020\u00148F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010\u00a8\u0006#"}, d2 = {"Lcom/enigma2/android/data/hdhomerun/HdHomeRunClient$Channel;", "", "guideNumber", "", "guideName", "url", "hd", "", "favorite", "drm", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getDrm", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFavorite", "getGuideName", "()Ljava/lang/String;", "getGuideNumber", "getHd", "isProtected", "", "()Z", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/enigma2/android/data/hdhomerun/HdHomeRunClient$Channel;", "equals", "other", "hashCode", "toString", "app_release"})
    public static final class Channel {
        @com.google.gson.annotations.SerializedName(value = "GuideNumber")
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String guideNumber = null;
        @com.google.gson.annotations.SerializedName(value = "GuideName")
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String guideName = null;
        @com.google.gson.annotations.SerializedName(value = "URL")
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String url = null;
        @com.google.gson.annotations.SerializedName(value = "HD")
        @org.jetbrains.annotations.Nullable()
        private final java.lang.Integer hd = null;
        @com.google.gson.annotations.SerializedName(value = "Favorite")
        @org.jetbrains.annotations.Nullable()
        private final java.lang.Integer favorite = null;
        @com.google.gson.annotations.SerializedName(value = "DRM")
        @org.jetbrains.annotations.Nullable()
        private final java.lang.Integer drm = null;
        
        public Channel(@org.jetbrains.annotations.NotNull()
        java.lang.String guideNumber, @org.jetbrains.annotations.NotNull()
        java.lang.String guideName, @org.jetbrains.annotations.NotNull()
        java.lang.String url, @org.jetbrains.annotations.Nullable()
        java.lang.Integer hd, @org.jetbrains.annotations.Nullable()
        java.lang.Integer favorite, @org.jetbrains.annotations.Nullable()
        java.lang.Integer drm) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getGuideNumber() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getGuideName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getUrl() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer getHd() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer getFavorite() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer getDrm() {
            return null;
        }
        
        public final boolean isProtected() {
            return false;
        }
        
        public Channel() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer component4() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer component5() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer component6() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.enigma2.android.data.hdhomerun.HdHomeRunClient.Channel copy(@org.jetbrains.annotations.NotNull()
        java.lang.String guideNumber, @org.jetbrains.annotations.NotNull()
        java.lang.String guideName, @org.jetbrains.annotations.NotNull()
        java.lang.String url, @org.jetbrains.annotations.Nullable()
        java.lang.Integer hd, @org.jetbrains.annotations.Nullable()
        java.lang.Integer favorite, @org.jetbrains.annotations.Nullable()
        java.lang.Integer drm) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0002\u0010\rJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0018Jz\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00c6\u0001\u00a2\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010\'\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010(\u001a\u00020\fH\u00d6\u0001J\t\u0010)\u001a\u00020\u0003H\u00d6\u0001R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006*"}, d2 = {"Lcom/enigma2/android/data/hdhomerun/HdHomeRunClient$DiscoverInfo;", "", "friendlyName", "", "model", "firmwareName", "firmwareVersion", "deviceId", "deviceAuth", "baseUrl", "lineupUrl", "tunerCount", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getBaseUrl", "()Ljava/lang/String;", "getDeviceAuth", "getDeviceId", "getFirmwareName", "getFirmwareVersion", "getFriendlyName", "getLineupUrl", "getModel", "getTunerCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/enigma2/android/data/hdhomerun/HdHomeRunClient$DiscoverInfo;", "equals", "", "other", "hashCode", "toString", "app_release"})
    public static final class DiscoverInfo {
        @com.google.gson.annotations.SerializedName(value = "FriendlyName")
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String friendlyName = null;
        @com.google.gson.annotations.SerializedName(value = "ModelNumber")
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String model = null;
        @com.google.gson.annotations.SerializedName(value = "FirmwareName")
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String firmwareName = null;
        @com.google.gson.annotations.SerializedName(value = "FirmwareVersion")
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String firmwareVersion = null;
        @com.google.gson.annotations.SerializedName(value = "DeviceID")
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String deviceId = null;
        @com.google.gson.annotations.SerializedName(value = "DeviceAuth")
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String deviceAuth = null;
        @com.google.gson.annotations.SerializedName(value = "BaseURL")
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String baseUrl = null;
        @com.google.gson.annotations.SerializedName(value = "LineupURL")
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String lineupUrl = null;
        @com.google.gson.annotations.SerializedName(value = "TunerCount")
        @org.jetbrains.annotations.Nullable()
        private final java.lang.Integer tunerCount = null;
        
        public DiscoverInfo(@org.jetbrains.annotations.Nullable()
        java.lang.String friendlyName, @org.jetbrains.annotations.Nullable()
        java.lang.String model, @org.jetbrains.annotations.Nullable()
        java.lang.String firmwareName, @org.jetbrains.annotations.Nullable()
        java.lang.String firmwareVersion, @org.jetbrains.annotations.Nullable()
        java.lang.String deviceId, @org.jetbrains.annotations.Nullable()
        java.lang.String deviceAuth, @org.jetbrains.annotations.Nullable()
        java.lang.String baseUrl, @org.jetbrains.annotations.Nullable()
        java.lang.String lineupUrl, @org.jetbrains.annotations.Nullable()
        java.lang.Integer tunerCount) {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getFriendlyName() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getModel() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getFirmwareName() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getFirmwareVersion() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getDeviceId() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getDeviceAuth() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getBaseUrl() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getLineupUrl() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer getTunerCount() {
            return null;
        }
        
        public DiscoverInfo() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component4() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component5() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component6() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component7() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component8() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer component9() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.enigma2.android.data.hdhomerun.HdHomeRunClient.DiscoverInfo copy(@org.jetbrains.annotations.Nullable()
        java.lang.String friendlyName, @org.jetbrains.annotations.Nullable()
        java.lang.String model, @org.jetbrains.annotations.Nullable()
        java.lang.String firmwareName, @org.jetbrains.annotations.Nullable()
        java.lang.String firmwareVersion, @org.jetbrains.annotations.Nullable()
        java.lang.String deviceId, @org.jetbrains.annotations.Nullable()
        java.lang.String deviceAuth, @org.jetbrains.annotations.Nullable()
        java.lang.String baseUrl, @org.jetbrains.annotations.Nullable()
        java.lang.String lineupUrl, @org.jetbrains.annotations.Nullable()
        java.lang.Integer tunerCount) {
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
}