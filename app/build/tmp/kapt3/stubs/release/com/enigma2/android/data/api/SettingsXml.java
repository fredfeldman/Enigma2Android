package com.enigma2.android.data.api;

/**
 * Tolerant parsers for the various OpenWebif "settings" responses (XML + JSON mix).
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000b2\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001c\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u0006J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00102\u0006\u0010\u0005\u001a\u00020\u0006J\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0006J\u001c\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00192\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010 \u001a\u00020!2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\"\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010$\u001a\u00020%2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010&\u001a\u00020\'2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010(\u001a\u00020)2\u0006\u0010\u0005\u001a\u00020\u0006J\f\u0010*\u001a\u00020\u001a*\u00020\u0004H\u0002\u00a8\u0006+"}, d2 = {"Lcom/enigma2/android/data/api/SettingsXml;", "", "()V", "bodyToString", "", "stream", "Ljava/io/InputStream;", "mapType", "Lcom/enigma2/android/data/model/settings/ConfigItemType;", "raw", "parseAllSettings", "", "parseConfigSection", "Lcom/enigma2/android/data/model/settings/ConfigSection;", "name", "parseConfigSections", "", "parseCurrentLocation", "parseFlatXml", "parseLocations", "parsePowerState", "Lcom/enigma2/android/data/model/settings/PowerState;", "parseProtectedServices", "Lcom/enigma2/android/data/model/settings/ProtectedService;", "parseProtectionSettings", "Lkotlin/Pair;", "", "parseRecordingLocations", "Lcom/enigma2/android/data/model/settings/RecordingLocations;", "currentStream", "listStream", "parseSaveAck", "parseSleepTimer", "Lcom/enigma2/android/data/model/settings/SleepTimer;", "parseStatusInfo", "Lcom/enigma2/android/data/model/settings/StatusInfo;", "parseTunerSignal", "Lcom/enigma2/android/data/model/settings/TunerSignal;", "parseVolume", "Lcom/enigma2/android/data/model/settings/VolumeInfo;", "parseWolSetup", "Lcom/enigma2/android/data/model/settings/WolSetup;", "toBoolLoose", "app_release"})
public final class SettingsXml {
    @org.jetbrains.annotations.NotNull()
    public static final com.enigma2.android.data.api.SettingsXml INSTANCE = null;
    
    private SettingsXml() {
        super();
    }
    
    /**
     * Walks a flat `<root><tag>value</tag>…</root>` into a map.
     */
    private final java.util.Map<java.lang.String, java.lang.String> parseFlatXml(java.io.InputStream stream) {
        return null;
    }
    
    private final java.lang.String bodyToString(java.io.InputStream stream) {
        return null;
    }
    
    private final boolean toBoolLoose(java.lang.String $this$toBoolLoose) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.enigma2.android.data.model.settings.StatusInfo parseStatusInfo(@org.jetbrains.annotations.NotNull()
    java.io.InputStream stream) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.enigma2.android.data.model.settings.PowerState parsePowerState(@org.jetbrains.annotations.NotNull()
    java.io.InputStream stream) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.enigma2.android.data.model.settings.SleepTimer parseSleepTimer(@org.jetbrains.annotations.NotNull()
    java.io.InputStream stream) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.enigma2.android.data.model.settings.VolumeInfo parseVolume(@org.jetbrains.annotations.NotNull()
    java.io.InputStream stream) {
        return null;
    }
    
    /**
     * `<e2settings>` is a flat list of `<e2setting><e2settingname>…</e2settingname><e2settingvalue>…</e2settingvalue></e2setting>`.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.String> parseAllSettings(@org.jetbrains.annotations.NotNull()
    java.io.InputStream stream) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> parseConfigSections(@org.jetbrains.annotations.NotNull()
    java.io.InputStream stream) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.enigma2.android.data.model.settings.ConfigSection parseConfigSection(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.io.InputStream stream) {
        return null;
    }
    
    private final com.enigma2.android.data.model.settings.ConfigItemType mapType(java.lang.String raw) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.Pair<java.lang.Boolean, java.lang.Boolean> parseProtectionSettings(@org.jetbrains.annotations.NotNull()
    java.io.InputStream stream) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.enigma2.android.data.model.settings.ProtectedService> parseProtectedServices(@org.jetbrains.annotations.NotNull()
    java.io.InputStream stream) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> parseLocations(@org.jetbrains.annotations.NotNull()
    java.io.InputStream stream) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String parseCurrentLocation(@org.jetbrains.annotations.NotNull()
    java.io.InputStream stream) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.enigma2.android.data.model.settings.RecordingLocations parseRecordingLocations(@org.jetbrains.annotations.NotNull()
    java.io.InputStream currentStream, @org.jetbrains.annotations.NotNull()
    java.io.InputStream listStream) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.enigma2.android.data.model.settings.TunerSignal parseTunerSignal(@org.jetbrains.annotations.NotNull()
    java.io.InputStream stream) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.enigma2.android.data.model.settings.WolSetup parseWolSetup(@org.jetbrains.annotations.NotNull()
    java.io.InputStream stream) {
        return null;
    }
    
    /**
     * Treats anything non-empty containing "true"/"ok"/"saved" as success. Falls back to true on empty 200.
     */
    @org.jetbrains.annotations.NotNull()
    public final kotlin.Pair<java.lang.Boolean, java.lang.String> parseSaveAck(@org.jetbrains.annotations.NotNull()
    java.io.InputStream stream) {
        return null;
    }
}