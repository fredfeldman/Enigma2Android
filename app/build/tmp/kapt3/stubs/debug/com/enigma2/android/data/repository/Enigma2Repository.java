package com.enigma2.android.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u00aa\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\u0018\u0000 f2\u00020\u0001:\u0002efB\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010\fJ\u001e\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010\u0011J8\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u0004H\u0086@\u00a2\u0006\u0002\u0010\u0019J\"\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u00062\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u00062\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0004H\u0086@\u00a2\u0006\u0002\u0010 J&\u0010!\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0086@\u00a2\u0006\u0002\u0010\"J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004H\u0002J\"\u0010%\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040&0\u00062\u0006\u0010\'\u001a\u00020\u0004H\u0002J\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u0006H\u0086@\u00a2\u0006\u0002\u0010*J\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u0006H\u0086@\u00a2\u0006\u0002\u0010*J \u0010-\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040&0\u0006H\u0086@\u00a2\u0006\u0002\u0010*J\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00100\u00062\u0006\u0010\u0014\u001a\u00020\u0004H\u0086@\u00a2\u0006\u0002\u0010 J\u001c\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u00062\u0006\u0010\u0014\u001a\u00020\u0004H\u0086@\u00a2\u0006\u0002\u0010 J\u0014\u00101\u001a\b\u0012\u0004\u0012\u0002020\u0006H\u0086@\u00a2\u0006\u0002\u0010*J\u0010\u00103\u001a\u0004\u0018\u00010\u0004H\u0086@\u00a2\u0006\u0002\u0010*J\u001c\u00104\u001a\b\u0012\u0004\u0012\u0002050\u00062\u0006\u00106\u001a\u00020\u0004H\u0086@\u00a2\u0006\u0002\u0010 J\u001c\u00107\u001a\b\u0012\u0004\u0012\u0002050\u00062\u0006\u00106\u001a\u00020\u0004H\u0086@\u00a2\u0006\u0002\u0010 J\u001c\u00108\u001a\b\u0012\u0004\u0012\u0002000\u00062\u0006\u00106\u001a\u00020\u0004H\u0086@\u00a2\u0006\u0002\u0010 J \u00109\u001a\b\u0012\u0004\u0012\u00020:0\u00062\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0004H\u0086@\u00a2\u0006\u0002\u0010 J\u0010\u0010<\u001a\u0004\u0018\u00010=H\u0086@\u00a2\u0006\u0002\u0010*J\u0014\u0010>\u001a\b\u0012\u0004\u0012\u00020?0\u0006H\u0086@\u00a2\u0006\u0002\u0010*J\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020)0\u0006H\u0086@\u00a2\u0006\u0002\u0010*J\u000e\u0010A\u001a\u00020\u0013H\u0086@\u00a2\u0006\u0002\u0010*J&\u0010B\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u00042\u0006\u0010D\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010EJ\u0016\u0010F\u001a\b\u0012\u0004\u0012\u00020,0\u00062\u0006\u0010G\u001a\u00020\u0004H\u0002J\u0016\u0010H\u001a\b\u0012\u0004\u0012\u0002020\u00062\u0006\u0010$\u001a\u00020\u0004H\u0002J\u000e\u0010I\u001a\u00020JH\u0086@\u00a2\u0006\u0002\u0010*J\u0016\u0010K\u001a\u00020\u00132\u0006\u0010L\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010MJ\u0016\u0010N\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0004H\u0086@\u00a2\u0006\u0002\u0010 J\u001e\u0010O\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u0004H\u0086@\u00a2\u0006\u0002\u0010PJ\u001e\u0010Q\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010R\u001a\u00020\u0004H\u0086@\u00a2\u0006\u0002\u0010PJ\u0010\u0010S\u001a\u0004\u0018\u00010\u0004H\u0082@\u00a2\u0006\u0002\u0010*J\u000e\u0010T\u001a\u00020\u0013H\u0086@\u00a2\u0006\u0002\u0010*J\u0016\u0010U\u001a\u00020\u00132\u0006\u0010V\u001a\u00020,H\u0086@\u00a2\u0006\u0002\u0010WJ\u001c\u0010X\u001a\u00020\u00132\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0086@\u00a2\u0006\u0002\u0010ZJ\u001c\u0010[\u001a\b\u0012\u0004\u0012\u0002000\u00062\u0006\u0010\\\u001a\u00020\u0004H\u0086@\u00a2\u0006\u0002\u0010 J2\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020\u00042\u0006\u0010`\u001a\u00020a2\u0018\u0010b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040&0cH\u0002J\u0016\u0010d\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004H\u0086@\u00a2\u0006\u0002\u0010 R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006g"}, d2 = {"Lcom/enigma2/android/data/repository/Enigma2Repository;", "", "()V", "cachedEpgImportBase", "", "epgImportBaseCandidates", "", "addBouquet", "Lcom/enigma2/android/data/api/BouquetEditorXml$SimpleResult;", "name", "mode", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addServiceToBouquet", "bouquetRef", "service", "Lcom/enigma2/android/data/model/Service;", "(Ljava/lang/String;Lcom/enigma2/android/data/model/Service;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addTimer", "", "sRef", "begin", "", "end", "description", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyOverride", "services", "override", "Lcom/enigma2/android/data/prefs/ReceiverPreferences$BouquetOverride;", "deleteRecording", "filename", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTimer", "(Ljava/lang/String;JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "extractEpgImportStatus", "body", "flattenJsonScalars", "Lkotlin/Pair;", "jsonText", "getAllBouquets", "Lcom/enigma2/android/data/model/Bouquet;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAutoTimers", "Lcom/enigma2/android/data/model/AutoTimer;", "getBoxInfo", "getChannelsForBouquet", "getEpgForService", "Lcom/enigma2/android/data/model/EpgEvent;", "getEpgImportSources", "Lcom/enigma2/android/data/repository/EpgImportSource;", "getEpgImportStatus", "getEpgNext", "Lcom/enigma2/android/data/model/NowNextEvent;", "bRef", "getEpgNow", "getMultiEpg", "getRecordings", "Lcom/enigma2/android/data/model/Recording;", "dirname", "getScreenshot", "", "getTimers", "Lcom/enigma2/android/data/model/Timer;", "getUserBouquets", "isEpgImportAvailable", "moveServiceInBouquet", "serviceRef", "position", "(Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseAutoTimersXml", "xml", "parseEpgImportSources", "probeBouquetEditor", "Lcom/enigma2/android/data/repository/Enigma2Repository$BouquetEditorCapability;", "removeAutoTimer", "id", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeBouquet", "removeServiceFromBouquet", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "renameBouquet", "newName", "resolveEpgImportBase", "runEpgImport", "saveAutoTimer", "at", "(Lcom/enigma2/android/data/model/AutoTimer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveEpgImportEnabledSources", "enabledDescriptions", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchEpg", "query", "walkJson", "", "prefix", "obj", "Lcom/google/gson/JsonObject;", "out", "", "zapToService", "BouquetEditorCapability", "Companion", "app_debug"})
public final class Enigma2Repository {
    
    /**
     * Candidate base paths used by different OpenWebif builds for the EPGImport plugin.
     * Order matters: the first one that responds successfully wins and is cached.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> epgImportBaseCandidates = null;
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private volatile java.lang.String cachedEpgImportBase;
    public static final int MODE_TV = 0;
    public static final int MODE_RADIO = 1;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String BOUQUETS_RADIO_ROOT = "1:7:1:0:0:0:0:0:0:0:FROM BOUQUET \"bouquets.radio\" ORDER BY bouquet";
    @org.jetbrains.annotations.NotNull()
    public static final com.enigma2.android.data.repository.Enigma2Repository.Companion Companion = null;
    
    public Enigma2Repository() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAllBouquets(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.enigma2.android.data.model.Bouquet>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getChannelsForBouquet(@org.jetbrains.annotations.NotNull()
    java.lang.String sRef, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.enigma2.android.data.model.Service>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getEpgNow(@org.jetbrains.annotations.NotNull()
    java.lang.String bRef, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.enigma2.android.data.model.NowNextEvent>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getEpgNext(@org.jetbrains.annotations.NotNull()
    java.lang.String bRef, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.enigma2.android.data.model.NowNextEvent>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getMultiEpg(@org.jetbrains.annotations.NotNull()
    java.lang.String bRef, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.enigma2.android.data.model.EpgEvent>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getEpgForService(@org.jetbrains.annotations.NotNull()
    java.lang.String sRef, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.enigma2.android.data.model.EpgEvent>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object zapToService(@org.jetbrains.annotations.NotNull()
    java.lang.String sRef, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getRecordings(@org.jetbrains.annotations.Nullable()
    java.lang.String dirname, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.enigma2.android.data.model.Recording>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteRecording(@org.jetbrains.annotations.NotNull()
    java.lang.String filename, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getTimers(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.enigma2.android.data.model.Timer>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addTimer(@org.jetbrains.annotations.NotNull()
    java.lang.String sRef, long begin, long end, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteTimer(@org.jetbrains.annotations.NotNull()
    java.lang.String sRef, long begin, long end, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object searchEpg(@org.jetbrains.annotations.NotNull()
    java.lang.String query, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.enigma2.android.data.model.EpgEvent>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getScreenshot(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super byte[]> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAutoTimers(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.enigma2.android.data.model.AutoTimer>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object removeAutoTimer(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    /**
     * Save an AutoTimer (id < 0 for new). Sends only the commonly-used fields.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveAutoTimer(@org.jetbrains.annotations.NotNull()
    com.enigma2.android.data.model.AutoTimer at, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    private final java.util.List<com.enigma2.android.data.model.AutoTimer> parseAutoTimersXml(java.lang.String xml) {
        return null;
    }
    
    /**
     * Probes the BouquetEditor plugin. Returns Missing on any HTTP / parse error.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object probeBouquetEditor(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enigma2.android.data.repository.Enigma2Repository.BouquetEditorCapability> $completion) {
        return null;
    }
    
    /**
     * Returns the list of editable user bouquets (TV + Radio merged). Channels not populated.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getUserBouquets(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.enigma2.android.data.model.Bouquet>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addBouquet(@org.jetbrains.annotations.NotNull()
    java.lang.String name, int mode, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enigma2.android.data.api.BouquetEditorXml.SimpleResult> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object renameBouquet(@org.jetbrains.annotations.NotNull()
    java.lang.String bouquetRef, @org.jetbrains.annotations.NotNull()
    java.lang.String newName, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enigma2.android.data.api.BouquetEditorXml.SimpleResult> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object removeBouquet(@org.jetbrains.annotations.NotNull()
    java.lang.String bouquetRef, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enigma2.android.data.api.BouquetEditorXml.SimpleResult> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addServiceToBouquet(@org.jetbrains.annotations.NotNull()
    java.lang.String bouquetRef, @org.jetbrains.annotations.NotNull()
    com.enigma2.android.data.model.Service service, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enigma2.android.data.api.BouquetEditorXml.SimpleResult> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object removeServiceFromBouquet(@org.jetbrains.annotations.NotNull()
    java.lang.String bouquetRef, @org.jetbrains.annotations.NotNull()
    java.lang.String serviceRef, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enigma2.android.data.api.BouquetEditorXml.SimpleResult> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object moveServiceInBouquet(@org.jetbrains.annotations.NotNull()
    java.lang.String bouquetRef, @org.jetbrains.annotations.NotNull()
    java.lang.String serviceRef, int position, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enigma2.android.data.api.BouquetEditorXml.SimpleResult> $completion) {
        return null;
    }
    
    /**
     * Pure helper: returns [services] with the override applied.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.enigma2.android.data.model.Service> applyOverride(@org.jetbrains.annotations.NotNull()
    java.util.List<com.enigma2.android.data.model.Service> services, @org.jetbrains.annotations.NotNull()
    com.enigma2.android.data.prefs.ReceiverPreferences.BouquetOverride override) {
        return null;
    }
    
    private final java.lang.Object resolveEpgImportBase(kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    /**
     * Returns true if the EPGImport plugin appears to be installed/enabled on the receiver.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object isEpgImportAvailable(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    /**
     * Returns a human-readable status snippet from the plugin (best-effort).
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getEpgImportStatus(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    /**
     * Returns the list of available source descriptions parsed from the plugin response.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getEpgImportSources(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.enigma2.android.data.repository.EpgImportSource>> $completion) {
        return null;
    }
    
    /**
     * Saves the set of enabled EPGImport sources (by description).
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveEpgImportEnabledSources(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> enabledDescriptions, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    /**
     * Triggers an EPG import on the receiver. Returns true on HTTP success.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object runEpgImport(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    /**
     * Returns the receiver's about/deviceinfo as ordered key/value pairs for display.
     * Tries `api/about` first, falls back to `api/deviceinfo`.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getBoxInfo(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<kotlin.Pair<java.lang.String, java.lang.String>>> $completion) {
        return null;
    }
    
    /**
     * Flattens a JSON object to ordered (key, value) pairs, joining nested keys with "."
     */
    private final java.util.List<kotlin.Pair<java.lang.String, java.lang.String>> flattenJsonScalars(java.lang.String jsonText) {
        return null;
    }
    
    private final void walkJson(java.lang.String prefix, com.google.gson.JsonObject obj, java.util.List<kotlin.Pair<java.lang.String, java.lang.String>> out) {
    }
    
    private final java.lang.String extractEpgImportStatus(java.lang.String body) {
        return null;
    }
    
    private final java.util.List<com.enigma2.android.data.repository.EpgImportSource> parseEpgImportSources(java.lang.String body) {
        return null;
    }
    
    /**
     * Distinguishes "plugin available, can mutate on the box" from "no plugin, local-only fallback".
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/enigma2/android/data/repository/Enigma2Repository$BouquetEditorCapability;", "", "(Ljava/lang/String;I)V", "Available", "Missing", "app_debug"})
    public static enum BouquetEditorCapability {
        /*public static final*/ Available /* = new Available() */,
        /*public static final*/ Missing /* = new Missing() */;
        
        BouquetEditorCapability() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public static kotlin.enums.EnumEntries<com.enigma2.android.data.repository.Enigma2Repository.BouquetEditorCapability> getEntries() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/enigma2/android/data/repository/Enigma2Repository$Companion;", "", "()V", "BOUQUETS_RADIO_ROOT", "", "MODE_RADIO", "", "MODE_TV", "bouquetMode", "ref", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        /**
         * Derives the Enigma2 mode (0=TV, 1=Radio) from a bouquet service reference.
         */
        public final int bouquetMode(@org.jetbrains.annotations.NotNull()
        java.lang.String ref) {
            return 0;
        }
    }
}