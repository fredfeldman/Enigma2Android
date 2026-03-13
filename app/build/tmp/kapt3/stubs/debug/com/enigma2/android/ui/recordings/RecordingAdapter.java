package com.enigma2.android.ui.recordings;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0011\u0012B1\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\bJ\u001c\u0010\t\u001a\u00020\u00062\n\u0010\n\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/enigma2/android/ui/recordings/RecordingAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/enigma2/android/data/model/Recording;", "Lcom/enigma2/android/ui/recordings/RecordingAdapter$ViewHolder;", "onRecordingClick", "Lkotlin/Function1;", "", "onRecordingLongClick", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "ViewHolder", "app_debug"})
public final class RecordingAdapter extends androidx.recyclerview.widget.ListAdapter<com.enigma2.android.data.model.Recording, com.enigma2.android.ui.recordings.RecordingAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.enigma2.android.data.model.Recording, kotlin.Unit> onRecordingClick = null;
    @org.jetbrains.annotations.Nullable()
    private final kotlin.jvm.functions.Function1<com.enigma2.android.data.model.Recording, kotlin.Unit> onRecordingLongClick = null;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.enigma2.android.data.model.Recording> DIFF = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.enigma2.android.ui.recordings.RecordingAdapter.Companion Companion = null;
    
    public RecordingAdapter(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.enigma2.android.data.model.Recording, kotlin.Unit> onRecordingClick, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super com.enigma2.android.data.model.Recording, kotlin.Unit> onRecordingLongClick) {
        super(null);
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.enigma2.android.ui.recordings.RecordingAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.enigma2.android.ui.recordings.RecordingAdapter.ViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/enigma2/android/ui/recordings/RecordingAdapter$Companion;", "", "()V", "DIFF", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/enigma2/android/data/model/Recording;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0011\u0010\r\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lcom/enigma2/android/ui/recordings/RecordingAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/enigma2/android/ui/recordings/RecordingAdapter;Landroid/view/View;)V", "tvChannel", "Landroid/widget/TextView;", "getTvChannel", "()Landroid/widget/TextView;", "tvDatetime", "getTvDatetime", "tvDuration", "getTvDuration", "tvTitle", "getTvTitle", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvTitle = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvChannel = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvDatetime = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvDuration = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvTitle() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvChannel() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvDatetime() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvDuration() {
            return null;
        }
    }
}