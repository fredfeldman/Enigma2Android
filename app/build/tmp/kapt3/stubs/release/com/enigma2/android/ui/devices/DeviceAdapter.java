package com.enigma2.android.ui.devices;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0016\u0017B-\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0005\u00a2\u0006\u0002\u0010\tJ\u001c\u0010\f\u001a\u00020\u00062\n\u0010\r\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0010\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u000e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u000bR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/enigma2/android/ui/devices/DeviceAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/enigma2/android/data/model/DeviceProfile;", "Lcom/enigma2/android/ui/devices/DeviceAdapter$ViewHolder;", "onDeviceClick", "Lkotlin/Function1;", "", "onDeviceLongClick", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "activeId", "", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setActiveId", "id", "Companion", "ViewHolder", "app_release"})
public final class DeviceAdapter extends androidx.recyclerview.widget.ListAdapter<com.enigma2.android.data.model.DeviceProfile, com.enigma2.android.ui.devices.DeviceAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.enigma2.android.data.model.DeviceProfile, kotlin.Unit> onDeviceClick = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.enigma2.android.data.model.DeviceProfile, java.lang.Boolean> onDeviceLongClick = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String activeId = "";
    @org.jetbrains.annotations.NotNull()
    private static final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.enigma2.android.data.model.DeviceProfile> DIFF = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.enigma2.android.ui.devices.DeviceAdapter.Companion Companion = null;
    
    public DeviceAdapter(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.enigma2.android.data.model.DeviceProfile, kotlin.Unit> onDeviceClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.enigma2.android.data.model.DeviceProfile, java.lang.Boolean> onDeviceLongClick) {
        super(null);
    }
    
    public final void setActiveId(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.enigma2.android.ui.devices.DeviceAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.enigma2.android.ui.devices.DeviceAdapter.ViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/enigma2/android/ui/devices/DeviceAdapter$Companion;", "", "()V", "DIFF", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/enigma2/android/data/model/DeviceProfile;", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/enigma2/android/ui/devices/DeviceAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/enigma2/android/ui/devices/DeviceAdapter;Landroid/view/View;)V", "tvActive", "Landroid/widget/TextView;", "getTvActive", "()Landroid/widget/TextView;", "tvAddress", "getTvAddress", "tvName", "getTvName", "app_release"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvName = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvAddress = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvActive = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvAddress() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvActive() {
            return null;
        }
    }
}