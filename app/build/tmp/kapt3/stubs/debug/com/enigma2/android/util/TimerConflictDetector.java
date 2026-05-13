package com.enigma2.android.util;

/**
 * Lightweight overlap detection for timers. Two timers conflict when their
 * [begin, end) intervals overlap. We don't try to compute "tuner count" — that
 * is hard to derive reliably across images — but we surface the count of
 * overlapping timers so the user can decide.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004\u00a8\u0006\f"}, d2 = {"Lcom/enigma2/android/util/TimerConflictDetector;", "", "()V", "findConflicts", "", "Lcom/enigma2/android/util/TimerConflictDetector$Conflict;", "beginSec", "", "endSec", "existing", "Lcom/enigma2/android/data/model/Timer;", "Conflict", "app_debug"})
public final class TimerConflictDetector {
    @org.jetbrains.annotations.NotNull()
    public static final com.enigma2.android.util.TimerConflictDetector INSTANCE = null;
    
    private TimerConflictDetector() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.enigma2.android.util.TimerConflictDetector.Conflict> findConflicts(long beginSec, long endSec, @org.jetbrains.annotations.NotNull()
    java.util.List<com.enigma2.android.data.model.Timer> existing) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\f\u001a\u00020\rH\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/enigma2/android/util/TimerConflictDetector$Conflict;", "", "timer", "Lcom/enigma2/android/data/model/Timer;", "(Lcom/enigma2/android/data/model/Timer;)V", "getTimer", "()Lcom/enigma2/android/data/model/Timer;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
    public static final class Conflict {
        @org.jetbrains.annotations.NotNull()
        private final com.enigma2.android.data.model.Timer timer = null;
        
        public Conflict(@org.jetbrains.annotations.NotNull()
        com.enigma2.android.data.model.Timer timer) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.enigma2.android.data.model.Timer getTimer() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.enigma2.android.data.model.Timer component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.enigma2.android.util.TimerConflictDetector.Conflict copy(@org.jetbrains.annotations.NotNull()
        com.enigma2.android.data.model.Timer timer) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
}