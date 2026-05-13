package com.enigma2.android.data.model.settings;

/**
 * Represents one saveable item from `api/config/{section}`.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n0\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\u001b\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n0\tH\u00c6\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0014J\u0010\u0010!\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0014Jj\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n0\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u00c6\u0001\u00a2\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\'\u001a\u00020\fH\u00d6\u0001J\t\u0010(\u001a\u00020\u0003H\u00d6\u0001R#\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\r\u001a\u0004\u0018\u00010\f\u00a2\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012\u00a8\u0006)"}, d2 = {"Lcom/enigma2/android/data/model/settings/ConfigItem;", "", "path", "", "description", "type", "Lcom/enigma2/android/data/model/settings/ConfigItemType;", "value", "choices", "", "Lkotlin/Pair;", "min", "", "max", "(Ljava/lang/String;Ljava/lang/String;Lcom/enigma2/android/data/model/settings/ConfigItemType;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getChoices", "()Ljava/util/List;", "getDescription", "()Ljava/lang/String;", "getMax", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMin", "getPath", "getType", "()Lcom/enigma2/android/data/model/settings/ConfigItemType;", "getValue", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/enigma2/android/data/model/settings/ConfigItemType;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/enigma2/android/data/model/settings/ConfigItem;", "equals", "", "other", "hashCode", "toString", "app_release"})
public final class ConfigItem {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String path = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String description = null;
    @org.jetbrains.annotations.NotNull()
    private final com.enigma2.android.data.model.settings.ConfigItemType type = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String value = null;
    
    /**
     * For Choice: list of (value,label).
     */
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<kotlin.Pair<java.lang.String, java.lang.String>> choices = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer min = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer max = null;
    
    public ConfigItem(@org.jetbrains.annotations.NotNull()
    java.lang.String path, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    com.enigma2.android.data.model.settings.ConfigItemType type, @org.jetbrains.annotations.NotNull()
    java.lang.String value, @org.jetbrains.annotations.NotNull()
    java.util.List<kotlin.Pair<java.lang.String, java.lang.String>> choices, @org.jetbrains.annotations.Nullable()
    java.lang.Integer min, @org.jetbrains.annotations.Nullable()
    java.lang.Integer max) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPath() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.enigma2.android.data.model.settings.ConfigItemType getType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getValue() {
        return null;
    }
    
    /**
     * For Choice: list of (value,label).
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<kotlin.Pair<java.lang.String, java.lang.String>> getChoices() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getMin() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getMax() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.enigma2.android.data.model.settings.ConfigItemType component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<kotlin.Pair<java.lang.String, java.lang.String>> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.enigma2.android.data.model.settings.ConfigItem copy(@org.jetbrains.annotations.NotNull()
    java.lang.String path, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    com.enigma2.android.data.model.settings.ConfigItemType type, @org.jetbrains.annotations.NotNull()
    java.lang.String value, @org.jetbrains.annotations.NotNull()
    java.util.List<kotlin.Pair<java.lang.String, java.lang.String>> choices, @org.jetbrains.annotations.Nullable()
    java.lang.Integer min, @org.jetbrains.annotations.Nullable()
    java.lang.Integer max) {
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