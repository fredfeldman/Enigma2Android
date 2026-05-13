package com.enigma2.android.data.prefs;

/**
 * Local-only PIN to gate the in-app Parental screen. This is *not* the receiver
 * setup PIN — the receiver enforces its own. Hash is SHA-256, stored in shared prefs.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bR\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/enigma2/android/data/prefs/ParentalAppLockStore;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "clear", "", "hash", "", "pin", "isEnabled", "", "set", "verify", "Companion", "app_release"})
public final class ParentalAppLockStore {
    private final android.content.SharedPreferences prefs = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_HASH = "pin_hash";
    @org.jetbrains.annotations.NotNull()
    public static final com.enigma2.android.data.prefs.ParentalAppLockStore.Companion Companion = null;
    
    public ParentalAppLockStore(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    public final boolean isEnabled() {
        return false;
    }
    
    public final void set(@org.jetbrains.annotations.NotNull()
    java.lang.String pin) {
    }
    
    public final void clear() {
    }
    
    public final boolean verify(@org.jetbrains.annotations.NotNull()
    java.lang.String pin) {
        return false;
    }
    
    private final java.lang.String hash(java.lang.String pin) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/enigma2/android/data/prefs/ParentalAppLockStore$Companion;", "", "()V", "KEY_HASH", "", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}