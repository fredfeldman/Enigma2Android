package com.enigma2.android.data.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/enigma2/android/data/api/ApiClient;", "", "()V", "currentBaseUrl", "", "retrofit", "Lretrofit2/Retrofit;", "service", "Lcom/enigma2/android/data/api/OpenWebifService;", "getService", "()Lcom/enigma2/android/data/api/OpenWebifService;", "initialize", "", "prefs", "Lcom/enigma2/android/data/prefs/ReceiverPreferences;", "app_release"})
public final class ApiClient {
    @org.jetbrains.annotations.Nullable()
    private static retrofit2.Retrofit retrofit;
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String currentBaseUrl = "";
    @org.jetbrains.annotations.NotNull()
    public static final com.enigma2.android.data.api.ApiClient INSTANCE = null;
    
    private ApiClient() {
        super();
    }
    
    public final void initialize(@org.jetbrains.annotations.NotNull()
    com.enigma2.android.data.prefs.ReceiverPreferences prefs) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.enigma2.android.data.api.OpenWebifService getService() {
        return null;
    }
}