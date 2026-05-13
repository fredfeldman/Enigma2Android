package com.enigma2.android.ui.receiversettings;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u001c\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0002J\u0016\u0010\u0011\u001a\u00020\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/enigma2/android/ui/receiversettings/RecordingSettingsFragment;", "Landroidx/preference/PreferenceFragmentCompat;", "()V", "currentPref", "Landroidx/preference/ListPreference;", "repo", "Lcom/enigma2/android/data/repository/Enigma2Repository;", "statusPref", "Landroidx/preference/Preference;", "load", "", "onCreatePreferences", "savedInstanceState", "Landroid/os/Bundle;", "rootKey", "", "promptAddLocation", "rebuildLocationsList", "locations", "", "toast", "msg", "app_release"})
public final class RecordingSettingsFragment extends androidx.preference.PreferenceFragmentCompat {
    @org.jetbrains.annotations.NotNull()
    private final com.enigma2.android.data.repository.Enigma2Repository repo = null;
    private androidx.preference.ListPreference currentPref;
    private androidx.preference.Preference statusPref;
    
    public RecordingSettingsFragment() {
        super();
    }
    
    @java.lang.Override()
    public void onCreatePreferences(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState, @org.jetbrains.annotations.Nullable()
    java.lang.String rootKey) {
    }
    
    private final void load() {
    }
    
    private final void rebuildLocationsList(java.util.List<java.lang.String> locations) {
    }
    
    private final void promptAddLocation() {
    }
    
    private final void toast(java.lang.String msg) {
    }
}