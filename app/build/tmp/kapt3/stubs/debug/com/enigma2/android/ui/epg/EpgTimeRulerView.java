package com.enigma2.android.ui.epg;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J\u0018\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u0016H\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082D\u00a2\u0006\u0002\n\u0000R$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u0016@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006#"}, d2 = {"Lcom/enigma2/android/ui/epg/EpgTimeRulerView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "fmt", "Ljava/text/SimpleDateFormat;", "paintLine", "Landroid/graphics/Paint;", "paintText", "pixelsPerMinute", "", "value", "", "startTimeMs", "getStartTimeMs", "()J", "setStartTimeMs", "(J)V", "tickIntervalMs", "", "totalWidthPx", "getTotalWidthPx", "()I", "setTotalWidthPx", "(I)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "app_debug"})
public final class EpgTimeRulerView extends android.view.View {
    private final float pixelsPerMinute = 6.0F;
    private final long tickIntervalMs = 0L;
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Paint paintText = null;
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Paint paintLine = null;
    private long startTimeMs = 0L;
    private int totalWidthPx = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.text.SimpleDateFormat fmt = null;
    
    @kotlin.jvm.JvmOverloads()
    public EpgTimeRulerView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    public final long getStartTimeMs() {
        return 0L;
    }
    
    public final void setStartTimeMs(long value) {
    }
    
    public final int getTotalWidthPx() {
        return 0;
    }
    
    public final void setTotalWidthPx(int value) {
    }
    
    @java.lang.Override()
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    }
    
    @java.lang.Override()
    protected void onDraw(@org.jetbrains.annotations.NotNull()
    android.graphics.Canvas canvas) {
    }
    
    @kotlin.jvm.JvmOverloads()
    public EpgTimeRulerView(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
}