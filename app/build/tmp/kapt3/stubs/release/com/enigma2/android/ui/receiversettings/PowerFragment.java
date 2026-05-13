package com.enigma2.android.ui.receiversettings;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u001c\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0012H\u0002J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0017H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/enigma2/android/ui/receiversettings/PowerFragment;", "Landroidx/preference/PreferenceFragmentCompat;", "()V", "actionPref", "Landroidx/preference/ListPreference;", "enabledPref", "Landroidx/preference/SwitchPreferenceCompat;", "minutesPref", "repo", "Lcom/enigma2/android/data/repository/Enigma2Repository;", "statusPref", "Landroidx/preference/Preference;", "ctx", "Landroid/content/Context;", "titleRes", "", "newState", "load", "", "onCreatePreferences", "savedInstanceState", "Landroid/os/Bundle;", "rootKey", "", "saveSleep", "toast", "msg", "app_release"})
public final class PowerFragment extends androidx.preference.PreferenceFragmentCompat {
    @org.jetbrains.annotations.NotNull()
    private final com.enigma2.android.data.repository.Enigma2Repository repo = null;
    private androidx.preference.Preference statusPref;
    private androidx.preference.SwitchPreferenceCompat enabledPref;
    private androidx.preference.ListPreference minutesPref;
    private androidx.preference.ListPreference actionPref;
    
    public PowerFragment() {
        super();
    }
    
    @java.lang.Override()
    public void onCreatePreferences(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState, @org.jetbrains.annotations.Nullable()
    java.lang.String rootKey) {
    }
    
    private final androidx.preference.Preference actionPref(android.content.Context ctx, int titleRes, int newState) {
        return null;
    }
    
    private final void load() {
    }
    
    private final void saveSleep() {
    }
    
    private final void toast(java.lang.String msg) {
    }
}