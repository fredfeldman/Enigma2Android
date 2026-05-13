package com.enigma2.android.ui.remote;

/**
 * Virtual remote control. Each button posts an Enigma2 keycode to
 * `/api/remotecontrol?command=<code>`. Codes are the standard input event
 * numbers used by Enigma2's `eRCInput` driver.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/enigma2/android/ui/remote/RemoteControlActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "repo", "Lcom/enigma2/android/data/repository/Enigma2Repository;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onSupportNavigateUp", "", "send", "code", "", "app_release"})
public final class RemoteControlActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    private final com.enigma2.android.data.repository.Enigma2Repository repo = null;
    
    public RemoteControlActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void send(int code) {
    }
    
    @java.lang.Override()
    public boolean onSupportNavigateUp() {
        return false;
    }
}