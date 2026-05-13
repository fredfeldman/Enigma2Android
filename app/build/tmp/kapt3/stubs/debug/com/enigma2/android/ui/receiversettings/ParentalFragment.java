package com.enigma2.android.ui.receiversettings;

/**
 * Editable parental control: shows status, lets the user change the receiver setup PIN,
 * protect a service by service-ref, unprotect listed services, and configure an
 * app-side PIN gate that locks this screen to a local PIN.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\nH\u0002J\u001c\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\nH\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0016\u0010\u0018\u001a\u00020\n2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u001aH\u0002J\b\u0010\u001b\u001a\u00020\nH\u0002J\b\u0010\u001c\u001a\u00020\nH\u0002J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/enigma2/android/ui/receiversettings/ParentalFragment;", "Landroidx/preference/PreferenceFragmentCompat;", "()V", "repo", "Lcom/enigma2/android/data/repository/Enigma2Repository;", "screen", "Landroidx/preference/PreferenceScreen;", "unlocked", "", "build", "", "confirmUnprotect", "s", "Lcom/enigma2/android/data/model/settings/ProtectedService;", "load", "onCreatePreferences", "savedInstanceState", "Landroid/os/Bundle;", "rootKey", "", "onResume", "promptAppPin", "store", "Lcom/enigma2/android/data/prefs/ParentalAppLockStore;", "rebuildList", "list", "", "showChangePinDialog", "showProtectDialog", "showSetAppPin", "app_debug"})
public final class ParentalFragment extends androidx.preference.PreferenceFragmentCompat {
    @org.jetbrains.annotations.NotNull()
    private final com.enigma2.android.data.repository.Enigma2Repository repo = null;
    private androidx.preference.PreferenceScreen screen;
    private boolean unlocked = false;
    
    public ParentalFragment() {
        super();
    }
    
    @java.lang.Override()
    public void onCreatePreferences(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState, @org.jetbrains.annotations.Nullable()
    java.lang.String rootKey) {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    private final void promptAppPin(com.enigma2.android.data.prefs.ParentalAppLockStore store) {
    }
    
    private final void build() {
    }
    
    private final void load() {
    }
    
    private final void rebuildList(java.util.List<com.enigma2.android.data.model.settings.ProtectedService> list) {
    }
    
    private final void confirmUnprotect(com.enigma2.android.data.model.settings.ProtectedService s) {
    }
    
    private final void showProtectDialog() {
    }
    
    private final void showChangePinDialog() {
    }
    
    private final void showSetAppPin(com.enigma2.android.data.prefs.ParentalAppLockStore store) {
    }
}