package com.enigma2.android.ui.settings;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0017B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0011H\u0002J\b\u0010\u0016\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/enigma2/android/ui/settings/EpgImportActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "btnSave", "Landroid/widget/Button;", "progress", "Landroid/widget/ProgressBar;", "repo", "Lcom/enigma2/android/data/repository/Enigma2Repository;", "rv", "Landroidx/recyclerview/widget/RecyclerView;", "sourcesAdapter", "Lcom/enigma2/android/ui/settings/EpgImportActivity$SourcesAdapter;", "tvEmpty", "Landroid/widget/TextView;", "tvStatus", "loadAll", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "runImport", "saveEnabledSources", "SourcesAdapter", "app_debug"})
public final class EpgImportActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    private final com.enigma2.android.data.repository.Enigma2Repository repo = null;
    private android.widget.TextView tvStatus;
    private android.widget.TextView tvEmpty;
    private androidx.recyclerview.widget.RecyclerView rv;
    private android.widget.ProgressBar progress;
    private android.widget.Button btnSave;
    @org.jetbrains.annotations.NotNull()
    private final com.enigma2.android.ui.settings.EpgImportActivity.SourcesAdapter sourcesAdapter = null;
    
    public EpgImportActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void loadAll() {
    }
    
    private final void runImport() {
    }
    
    private final void saveEnabledSources() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u0005\u00a2\u0006\u0002\u0010\u0003J\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\u0014\u0010\u0014\u001a\u00020\r2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\bR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/enigma2/android/ui/settings/EpgImportActivity$SourcesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/enigma2/android/ui/settings/EpgImportActivity$SourcesAdapter$VH;", "()V", "items", "", "Lcom/enigma2/android/data/repository/EpgImportSource;", "enabledDescriptions", "", "", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submit", "list", "VH", "app_debug"})
    static final class SourcesAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.enigma2.android.ui.settings.EpgImportActivity.SourcesAdapter.VH> {
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.enigma2.android.data.repository.EpgImportSource> items = null;
        
        public SourcesAdapter() {
            super();
        }
        
        public final void submit(@org.jetbrains.annotations.NotNull()
        java.util.List<com.enigma2.android.data.repository.EpgImportSource> list) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> enabledDescriptions() {
            return null;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public com.enigma2.android.ui.settings.EpgImportActivity.SourcesAdapter.VH onCreateViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.ViewGroup parent, int viewType) {
            return null;
        }
        
        @java.lang.Override()
        public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
        com.enigma2.android.ui.settings.EpgImportActivity.SourcesAdapter.VH holder, int position) {
        }
        
        @java.lang.Override()
        public int getItemCount() {
            return 0;
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/enigma2/android/ui/settings/EpgImportActivity$SourcesAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "cb", "Landroid/widget/CheckBox;", "(Landroid/widget/CheckBox;)V", "getCb", "()Landroid/widget/CheckBox;", "app_debug"})
        public static final class VH extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
            @org.jetbrains.annotations.NotNull()
            private final android.widget.CheckBox cb = null;
            
            public VH(@org.jetbrains.annotations.NotNull()
            android.widget.CheckBox cb) {
                super(null);
            }
            
            @org.jetbrains.annotations.NotNull()
            public final android.widget.CheckBox getCb() {
                return null;
            }
        }
    }
}