package com.enigma2.android.data.api;

/**
 * Tolerant parser for the BouquetEditor plugin's XML mutation responses.
 * Expected shape: `<e2simplexmlresult><e2state>True</e2state><e2statetext>…</e2statetext></e2simplexmlresult>`.
 * Empty / non-XML bodies are treated as success (some images return HTTP 200 with no payload).
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\b"}, d2 = {"Lcom/enigma2/android/data/api/BouquetEditorXml;", "", "()V", "parseSimpleResult", "Lcom/enigma2/android/data/api/BouquetEditorXml$SimpleResult;", "stream", "Ljava/io/InputStream;", "SimpleResult", "app_debug"})
public final class BouquetEditorXml {
    @org.jetbrains.annotations.NotNull()
    public static final com.enigma2.android.data.api.BouquetEditorXml INSTANCE = null;
    
    private BouquetEditorXml() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.enigma2.android.data.api.BouquetEditorXml.SimpleResult parseSimpleResult(@org.jetbrains.annotations.NotNull()
    java.io.InputStream stream) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0005H\u00d6\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lcom/enigma2/android/data/api/BouquetEditorXml$SimpleResult;", "", "ok", "", "message", "", "(ZLjava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "getOk", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
    public static final class SimpleResult {
        private final boolean ok = false;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String message = null;
        
        public SimpleResult(boolean ok, @org.jetbrains.annotations.Nullable()
        java.lang.String message) {
            super();
        }
        
        public final boolean getOk() {
            return false;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getMessage() {
            return null;
        }
        
        public final boolean component1() {
            return false;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.enigma2.android.data.api.BouquetEditorXml.SimpleResult copy(boolean ok, @org.jetbrains.annotations.Nullable()
        java.lang.String message) {
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