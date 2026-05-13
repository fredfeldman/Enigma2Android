package com.enigma2.android.ui.autotimers;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0014\u0015BG\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\t\u00a2\u0006\u0002\u0010\u000bJ\u001c\u0010\f\u001a\u00020\u00062\n\u0010\r\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0010\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH\u0016R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/enigma2/android/ui/autotimers/AutoTimerAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/enigma2/android/data/model/AutoTimer;", "Lcom/enigma2/android/ui/autotimers/AutoTimerAdapter$VH;", "onEdit", "Lkotlin/Function1;", "", "onDelete", "onToggle", "Lkotlin/Function2;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "VH", "app_release"})
public final class AutoTimerAdapter extends androidx.recyclerview.widget.ListAdapter<com.enigma2.android.data.model.AutoTimer, com.enigma2.android.ui.autotimers.AutoTimerAdapter.VH> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.enigma2.android.data.model.AutoTimer, kotlin.Unit> onEdit = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.enigma2.android.data.model.AutoTimer, kotlin.Unit> onDelete = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function2<com.enigma2.android.data.model.AutoTimer, java.lang.Boolean, kotlin.Unit> onToggle = null;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.enigma2.android.data.model.AutoTimer> DIFF = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.enigma2.android.ui.autotimers.AutoTimerAdapter.Companion Companion = null;
    
    public AutoTimerAdapter(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.enigma2.android.data.model.AutoTimer, kotlin.Unit> onEdit, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.enigma2.android.data.model.AutoTimer, kotlin.Unit> onDelete, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super com.enigma2.android.data.model.AutoTimer, ? super java.lang.Boolean, kotlin.Unit> onToggle) {
        super(null);
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.enigma2.android.ui.autotimers.AutoTimerAdapter.VH onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.enigma2.android.ui.autotimers.AutoTimerAdapter.VH holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/enigma2/android/ui/autotimers/AutoTimerAdapter$Companion;", "", "()V", "DIFF", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/enigma2/android/data/model/AutoTimer;", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/enigma2/android/ui/autotimers/AutoTimerAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/enigma2/android/ui/autotimers/AutoTimerAdapter;Landroid/view/View;)V", "btnDelete", "getBtnDelete", "()Landroid/view/View;", "btnEdit", "getBtnEdit", "swEnabled", "Landroidx/appcompat/widget/SwitchCompat;", "getSwEnabled", "()Landroidx/appcompat/widget/SwitchCompat;", "tvMatch", "Landroid/widget/TextView;", "getTvMatch", "()Landroid/widget/TextView;", "tvMeta", "getTvMeta", "tvName", "getTvName", "app_release"})
    public final class VH extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvName = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvMatch = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvMeta = null;
        @org.jetbrains.annotations.NotNull()
        private final androidx.appcompat.widget.SwitchCompat swEnabled = null;
        @org.jetbrains.annotations.NotNull()
        private final android.view.View btnEdit = null;
        @org.jetbrains.annotations.NotNull()
        private final android.view.View btnDelete = null;
        
        public VH(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvMatch() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvMeta() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.appcompat.widget.SwitchCompat getSwEnabled() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.view.View getBtnEdit() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.view.View getBtnDelete() {
            return null;
        }
    }
}