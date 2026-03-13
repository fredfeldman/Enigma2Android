package com.enigma2.android.ui.player;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 W2\u00020\u0001:\u0002WXB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u00109\u001a\u00020:H\u0002J\b\u0010;\u001a\u00020:H\u0002J\u0010\u0010<\u001a\u00020\u00152\u0006\u0010=\u001a\u00020>H\u0002J\b\u0010?\u001a\u00020:H\u0002J\b\u0010@\u001a\u00020:H\u0002J\u0010\u0010A\u001a\u00020:2\u0006\u0010B\u001a\u00020\u0015H\u0002J\u0010\u0010C\u001a\u00020:2\u0006\u0010D\u001a\u00020\u0004H\u0002J\u0012\u0010E\u001a\u00020:2\b\u0010F\u001a\u0004\u0018\u00010GH\u0014J\b\u0010H\u001a\u00020:H\u0014J\b\u0010I\u001a\u00020:H\u0014J\b\u0010J\u001a\u00020:H\u0002J\b\u0010K\u001a\u00020:H\u0002J\b\u0010L\u001a\u00020:H\u0002J\b\u0010M\u001a\u00020:H\u0002J\b\u0010N\u001a\u00020:H\u0002J\u0010\u0010O\u001a\u00020:2\u0006\u0010P\u001a\u00020>H\u0002J\b\u0010Q\u001a\u00020:H\u0002J\u0010\u0010R\u001a\u00020:2\u0006\u0010S\u001a\u00020TH\u0002J\b\u0010U\u001a\u00020:H\u0002J\b\u0010V\u001a\u00020:H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\'\u001a\u00020\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020 X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000202X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000202X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000202X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000202X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000202X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006Y"}, d2 = {"Lcom/enigma2/android/ui/player/PlayerActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "aspectIndex", "", "aspectModes", "", "btnAspect", "Landroid/widget/ImageButton;", "btnAudio", "btnFastForward", "btnNextChannel", "btnPlayPause", "btnPrevChannel", "btnRewind", "btnSleep", "btnStop", "btnSubs", "Landroid/widget/Button;", "channelIndex", "channelName", "", "channelNames", "channelRefs", "durationSec", "isRecording", "", "osdHandler", "Landroid/os/Handler;", "osdHideRunnable", "Ljava/lang/Runnable;", "osdOverlay", "Landroid/view/View;", "player", "Landroidx/media3/exoplayer/ExoPlayer;", "playerView", "Landroidx/media3/ui/PlayerView;", "prefs", "Lcom/enigma2/android/data/prefs/ReceiverPreferences;", "progressHandler", "repo", "Lcom/enigma2/android/data/repository/Enigma2Repository;", "seekBar", "Landroid/widget/SeekBar;", "seekRow", "serviceRef", "sleepTimer", "Landroid/os/CountDownTimer;", "streamUrl", "tvBitrate", "Landroid/widget/TextView;", "tvChannelName", "tvDuration", "tvNextTitle", "tvNowTitle", "tvPosition", "userSeekInProgress", "bindViews", "", "cycleAspectRatio", "formatTime", "ms", "", "hideOsd", "loadNowNext", "loadStream", "url", "navigateChannel", "delta", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onStop", "resetOsdTimer", "setupControls", "setupOsd", "setupPlayer", "showOsd", "showResumeDialog", "posMs", "showSleepTimerDialog", "showTrackSelectionDialog", "type", "Lcom/enigma2/android/ui/player/PlayerActivity$TrackType;", "startProgressUpdates", "updatePlayPauseButton", "Companion", "TrackType", "app_debug"})
public final class PlayerActivity extends androidx.appcompat.app.AppCompatActivity {
    private androidx.media3.ui.PlayerView playerView;
    private androidx.media3.exoplayer.ExoPlayer player;
    private android.view.View osdOverlay;
    private android.widget.TextView tvChannelName;
    private android.widget.TextView tvNowTitle;
    private android.widget.TextView tvNextTitle;
    private android.view.View seekRow;
    private android.widget.SeekBar seekBar;
    private android.widget.TextView tvPosition;
    private android.widget.TextView tvDuration;
    private android.widget.ImageButton btnStop;
    private android.widget.ImageButton btnPlayPause;
    private android.widget.ImageButton btnPrevChannel;
    private android.widget.ImageButton btnNextChannel;
    private android.widget.ImageButton btnRewind;
    private android.widget.ImageButton btnFastForward;
    private android.widget.ImageButton btnAudio;
    private android.widget.Button btnSubs;
    private android.widget.ImageButton btnAspect;
    private android.widget.ImageButton btnSleep;
    private android.widget.TextView tvBitrate;
    private com.enigma2.android.data.prefs.ReceiverPreferences prefs;
    @org.jetbrains.annotations.NotNull()
    private final com.enigma2.android.data.repository.Enigma2Repository repo = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String streamUrl = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String channelName = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String serviceRef = "";
    private boolean isRecording = false;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> channelRefs;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> channelNames;
    private int channelIndex = 0;
    private int durationSec = 0;
    @org.jetbrains.annotations.NotNull()
    private final android.os.Handler osdHandler = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Runnable osdHideRunnable = null;
    @org.jetbrains.annotations.NotNull()
    private final android.os.Handler progressHandler = null;
    @org.jetbrains.annotations.Nullable()
    private android.os.CountDownTimer sleepTimer;
    private boolean userSeekInProgress = false;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_STREAM_URL = "stream_url";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_CHANNEL_NAME = "channel_name";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_SERVICE_REF = "service_ref";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_IS_RECORDING = "is_recording";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_CHANNEL_REFS = "channel_refs";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_CHANNEL_NAMES = "channel_names";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_CHANNEL_INDEX = "channel_index";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_DURATION_SEC = "duration_sec";
    private static final long OSD_HIDE_DELAY_MS = 5000L;
    private static final long SEEK_STEP_MS = 15000L;
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private static volatile okhttp3.OkHttpClient httpClientInstance;
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.NotNull()
    private static volatile java.lang.String httpClientCredentials = "";
    private int aspectIndex = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.Integer> aspectModes = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.enigma2.android.ui.player.PlayerActivity.Companion Companion = null;
    
    public PlayerActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void bindViews() {
    }
    
    private final void setupPlayer() {
    }
    
    private final void loadStream(java.lang.String url) {
    }
    
    private final void setupOsd() {
    }
    
    private final void setupControls() {
    }
    
    private final void showOsd() {
    }
    
    private final void hideOsd() {
    }
    
    private final void resetOsdTimer() {
    }
    
    private final void updatePlayPauseButton() {
    }
    
    private final void startProgressUpdates() {
    }
    
    private final void navigateChannel(int delta) {
    }
    
    private final void loadNowNext() {
    }
    
    private final void showResumeDialog(long posMs) {
    }
    
    private final void showTrackSelectionDialog(com.enigma2.android.ui.player.PlayerActivity.TrackType type) {
    }
    
    private final void cycleAspectRatio() {
    }
    
    private final void showSleepTimerDialog() {
    }
    
    private final java.lang.String formatTime(long ms) {
        return null;
    }
    
    @java.lang.Override()
    protected void onStop() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/enigma2/android/ui/player/PlayerActivity$Companion;", "", "()V", "EXTRA_CHANNEL_INDEX", "", "EXTRA_CHANNEL_NAME", "EXTRA_CHANNEL_NAMES", "EXTRA_CHANNEL_REFS", "EXTRA_DURATION_SEC", "EXTRA_IS_RECORDING", "EXTRA_SERVICE_REF", "EXTRA_STREAM_URL", "OSD_HIDE_DELAY_MS", "", "SEEK_STEP_MS", "httpClientCredentials", "httpClientInstance", "Lokhttp3/OkHttpClient;", "getHttpClient", "prefs", "Lcom/enigma2/android/data/prefs/ReceiverPreferences;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        private final okhttp3.OkHttpClient getHttpClient(com.enigma2.android.data.prefs.ReceiverPreferences prefs) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/enigma2/android/ui/player/PlayerActivity$TrackType;", "", "(Ljava/lang/String;I)V", "AUDIO", "SUBTITLE", "app_debug"})
    static enum TrackType {
        /*public static final*/ AUDIO /* = new AUDIO() */,
        /*public static final*/ SUBTITLE /* = new SUBTITLE() */;
        
        TrackType() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public static kotlin.enums.EnumEntries<com.enigma2.android.ui.player.PlayerActivity.TrackType> getEntries() {
            return null;
        }
    }
}