package com.enigma2.android.ui.channels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J$\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u001a\u0010\'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020+H\u0002J\b\u0010,\u001a\u00020\u001eH\u0002J\u0010\u0010-\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020 H\u0002J\u0010\u0010.\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010/\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020+H\u0002J\b\u00100\u001a\u00020\u001eH\u0002J\u0018\u00101\u001a\u00020\u001e2\u000e\u00102\u001a\n\u0012\u0004\u0012\u00020+\u0018\u000103H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001a\u00a8\u00064"}, d2 = {"Lcom/enigma2/android/ui/channels/ChannelsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "bouquetAdapter", "Lcom/enigma2/android/ui/channels/BouquetAdapter;", "btnRetry", "Landroid/widget/Button;", "channelAdapter", "Lcom/enigma2/android/ui/channels/ChannelAdapter;", "etFilter", "Landroid/widget/EditText;", "filterJob", "Lkotlinx/coroutines/Job;", "prefs", "Lcom/enigma2/android/data/prefs/ReceiverPreferences;", "progressBar", "Landroid/widget/ProgressBar;", "rvBouquets", "Landroidx/recyclerview/widget/RecyclerView;", "rvChannels", "tvEmpty", "Landroid/widget/TextView;", "tvError", "viewModel", "Lcom/enigma2/android/ui/viewmodel/ChannelViewModel;", "getViewModel", "()Lcom/enigma2/android/ui/viewmodel/ChannelViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "observeViewModel", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "openPlayer", "service", "Lcom/enigma2/android/data/model/Service;", "sendWakeOnLan", "setupToolbarButtons", "showChannelMenu", "showEpgInfo", "takeScreenshot", "updateEmptyState", "channels", "", "app_release"})
public final class ChannelsFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private com.enigma2.android.data.prefs.ReceiverPreferences prefs;
    private androidx.recyclerview.widget.RecyclerView rvBouquets;
    private androidx.recyclerview.widget.RecyclerView rvChannels;
    private android.widget.EditText etFilter;
    private android.widget.ProgressBar progressBar;
    private android.widget.TextView tvError;
    private android.widget.Button btnRetry;
    private android.widget.TextView tvEmpty;
    private com.enigma2.android.ui.channels.BouquetAdapter bouquetAdapter;
    private com.enigma2.android.ui.channels.ChannelAdapter channelAdapter;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job filterJob;
    
    public ChannelsFragment() {
        super();
    }
    
    private final com.enigma2.android.ui.viewmodel.ChannelViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupToolbarButtons(android.view.View view) {
    }
    
    private final void observeViewModel() {
    }
    
    private final void updateEmptyState(java.util.List<com.enigma2.android.data.model.Service> channels) {
    }
    
    private final void openPlayer(com.enigma2.android.data.model.Service service) {
    }
    
    private final void showChannelMenu(com.enigma2.android.data.model.Service service) {
    }
    
    private final void showEpgInfo(com.enigma2.android.data.model.Service service) {
    }
    
    private final void sendWakeOnLan() {
    }
    
    private final void takeScreenshot() {
    }
}