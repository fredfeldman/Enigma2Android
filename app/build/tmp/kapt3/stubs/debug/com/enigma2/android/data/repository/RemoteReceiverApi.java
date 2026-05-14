package com.enigma2.android.data.repository;

/**
 * v1.3.0 — Issue OpenWebif requests against a *non-active* receiver profile.
 *
 * The standard [Enigma2Repository] uses the global [com.enigma2.android.data.api.ApiClient],
 * which is bound to the currently-active device profile. Multi-room features
 * (zap on…, future "send message to…", future "record on…") need to talk to
 * other receivers without disturbing the active connection. This object
 * builds short-lived OkHttp calls instead of a separate Retrofit instance.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\nH\u0002J*\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0014J\u0016\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\nR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0018"}, d2 = {"Lcom/enigma2/android/data/repository/RemoteReceiverApi;", "", "()V", "client", "Lokhttp3/OkHttpClient;", "getClient", "()Lokhttp3/OkHttpClient;", "client$delegate", "Lkotlin/Lazy;", "baseUrl", "", "p", "Lcom/enigma2/android/data/model/DeviceProfile;", "execute", "", "path", "message", "profile", "text", "type", "", "timeoutSec", "zap", "serviceRef", "app_debug"})
public final class RemoteReceiverApi {
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy client$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.enigma2.android.data.repository.RemoteReceiverApi INSTANCE = null;
    
    private RemoteReceiverApi() {
        super();
    }
    
    private final okhttp3.OkHttpClient getClient() {
        return null;
    }
    
    private final java.lang.String baseUrl(com.enigma2.android.data.model.DeviceProfile p) {
        return null;
    }
    
    private final boolean execute(com.enigma2.android.data.model.DeviceProfile p, java.lang.String path) {
        return false;
    }
    
    /**
     * Tune [serviceRef] on the receiver described by [profile].
     */
    public final boolean zap(@org.jetbrains.annotations.NotNull()
    com.enigma2.android.data.model.DeviceProfile profile, @org.jetbrains.annotations.NotNull()
    java.lang.String serviceRef) {
        return false;
    }
    
    /**
     * Send an OSD message to [profile]. type: 1=info, 2=warning, 3=question, 0=error.
     */
    public final boolean message(@org.jetbrains.annotations.NotNull()
    com.enigma2.android.data.model.DeviceProfile profile, @org.jetbrains.annotations.NotNull()
    java.lang.String text, int type, int timeoutSec) {
        return false;
    }
}