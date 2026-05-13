package com.enigma2.android.service;

/**
 * Quick-settings tile that toggles the active receiver between standby and on.
 * Uses the `/api/powerstate` endpoint via [Enigma2Repository.setPowerState] with newstate=0
 * (toggle standby).
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/enigma2/android/service/PowerToggleTileService;", "Landroid/service/quicksettings/TileService;", "()V", "repo", "Lcom/enigma2/android/data/repository/Enigma2Repository;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "onClick", "", "onStartListening", "refresh", "app_release"})
@androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
public final class PowerToggleTileService extends android.service.quicksettings.TileService {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope scope = null;
    @org.jetbrains.annotations.NotNull()
    private final com.enigma2.android.data.repository.Enigma2Repository repo = null;
    
    public PowerToggleTileService() {
        super();
    }
    
    @java.lang.Override()
    public void onStartListening() {
    }
    
    @java.lang.Override()
    public void onClick() {
    }
    
    private final void refresh() {
    }
}