package com.enigma2.android.ui.receiversettings;

/**
 * Edits a single `api/config/{section}` and saves changes via `web/saveconfig`.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0015"}, d2 = {"Lcom/enigma2/android/ui/receiversettings/ConfigSectionFragment;", "Landroidx/preference/PreferenceFragmentCompat;", "()V", "repo", "Lcom/enigma2/android/data/repository/Enigma2Repository;", "sectionName", "", "getSectionName", "()Ljava/lang/String;", "onCreatePreferences", "", "savedInstanceState", "Landroid/os/Bundle;", "rootKey", "render", "section", "Lcom/enigma2/android/data/model/settings/ConfigSection;", "save", "path", "value", "Companion", "app_release"})
public final class ConfigSectionFragment extends androidx.preference.PreferenceFragmentCompat {
    @org.jetbrains.annotations.NotNull()
    private final com.enigma2.android.data.repository.Enigma2Repository repo = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String ARG_SECTION = "section";
    @org.jetbrains.annotations.NotNull()
    public static final com.enigma2.android.ui.receiversettings.ConfigSectionFragment.Companion Companion = null;
    
    public ConfigSectionFragment() {
        super();
    }
    
    private final java.lang.String getSectionName() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreatePreferences(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState, @org.jetbrains.annotations.Nullable()
    java.lang.String rootKey) {
    }
    
    private final void render(com.enigma2.android.data.model.settings.ConfigSection section) {
    }
    
    private final void save(java.lang.String path, java.lang.String value) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/enigma2/android/ui/receiversettings/ConfigSectionFragment$Companion;", "", "()V", "ARG_SECTION", "", "newInstance", "Lcom/enigma2/android/ui/receiversettings/ConfigSectionFragment;", "section", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.enigma2.android.ui.receiversettings.ConfigSectionFragment newInstance(@org.jetbrains.annotations.NotNull()
        java.lang.String section) {
            return null;
        }
    }
}