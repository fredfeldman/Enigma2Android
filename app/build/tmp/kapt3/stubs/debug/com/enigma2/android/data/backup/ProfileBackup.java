package com.enigma2.android.data.backup;

/**
 * v1.3.0 — Export and import the user's device-profile list as JSON.
 *
 * Passwords are stripped by default. Set [includePasswords] to keep them
 * (the UI surfaces this as an explicit checkbox so the user has to opt in).
 *
 * Format is intentionally human-readable so users can edit by hand:
 * ```
 * { "version": 1,
 *  "profiles": [ { "id": "...", "name": "Living room", "host": "...", ... } ],
 *  "activeId": "..." }
 * ```
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u0014\u0015B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/enigma2/android/data/backup/ProfileBackup;", "", "()V", "FORMAT_VERSION", "", "gson", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "encode", "", "prefs", "Lcom/enigma2/android/data/prefs/ReceiverPreferences;", "includePasswords", "", "importFromUri", "Lcom/enigma2/android/data/backup/ProfileBackup$ImportResult;", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "Envelope", "ImportResult", "app_debug"})
public final class ProfileBackup {
    private static final int FORMAT_VERSION = 1;
    private static final com.google.gson.Gson gson = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.enigma2.android.data.backup.ProfileBackup INSTANCE = null;
    
    private ProfileBackup() {
        super();
    }
    
    /**
     * Encode the current profile list to a JSON string.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String encode(@org.jetbrains.annotations.NotNull()
    com.enigma2.android.data.prefs.ReceiverPreferences prefs, boolean includePasswords) {
        return null;
    }
    
    /**
     * Read a profile-backup JSON [uri] and merge into [prefs]. Existing
     * profiles with the same id are updated (passwords kept if the import
     * file omits them — never silently wiped).
     */
    @org.jetbrains.annotations.NotNull()
    public final com.enigma2.android.data.backup.ProfileBackup.ImportResult importFromUri(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.net.Uri uri, @org.jetbrains.annotations.NotNull()
    com.enigma2.android.data.prefs.ReceiverPreferences prefs) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\bH\u00c6\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\bH\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0019"}, d2 = {"Lcom/enigma2/android/data/backup/ProfileBackup$Envelope;", "", "version", "", "profiles", "", "Lcom/enigma2/android/data/model/DeviceProfile;", "activeId", "", "(ILjava/util/List;Ljava/lang/String;)V", "getActiveId", "()Ljava/lang/String;", "getProfiles", "()Ljava/util/List;", "getVersion", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
    static final class Envelope {
        private final int version = 0;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.enigma2.android.data.model.DeviceProfile> profiles = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String activeId = null;
        
        public Envelope(int version, @org.jetbrains.annotations.NotNull()
        java.util.List<com.enigma2.android.data.model.DeviceProfile> profiles, @org.jetbrains.annotations.NotNull()
        java.lang.String activeId) {
            super();
        }
        
        public final int getVersion() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.enigma2.android.data.model.DeviceProfile> getProfiles() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getActiveId() {
            return null;
        }
        
        public final int component1() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.enigma2.android.data.model.DeviceProfile> component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.enigma2.android.data.backup.ProfileBackup.Envelope copy(int version, @org.jetbrains.annotations.NotNull()
        java.util.List<com.enigma2.android.data.model.DeviceProfile> profiles, @org.jetbrains.annotations.NotNull()
        java.lang.String activeId) {
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
    
    /**
     * Result of a decode/import operation.
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bH\u00c6\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\bH\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b\u00a8\u0006\u001a"}, d2 = {"Lcom/enigma2/android/data/backup/ProfileBackup$ImportResult;", "", "ok", "", "added", "", "updated", "error", "", "(ZIILjava/lang/String;)V", "getAdded", "()I", "getError", "()Ljava/lang/String;", "getOk", "()Z", "getUpdated", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
    public static final class ImportResult {
        private final boolean ok = false;
        private final int added = 0;
        private final int updated = 0;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String error = null;
        
        public ImportResult(boolean ok, int added, int updated, @org.jetbrains.annotations.Nullable()
        java.lang.String error) {
            super();
        }
        
        public final boolean getOk() {
            return false;
        }
        
        public final int getAdded() {
            return 0;
        }
        
        public final int getUpdated() {
            return 0;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getError() {
            return null;
        }
        
        public final boolean component1() {
            return false;
        }
        
        public final int component2() {
            return 0;
        }
        
        public final int component3() {
            return 0;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component4() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.enigma2.android.data.backup.ProfileBackup.ImportResult copy(boolean ok, int added, int updated, @org.jetbrains.annotations.Nullable()
        java.lang.String error) {
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