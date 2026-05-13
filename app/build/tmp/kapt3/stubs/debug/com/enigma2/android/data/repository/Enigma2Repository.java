package com.enigma2.android.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0090\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b7\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\u0018\u0000 \u00bb\u00012\u00020\u0001:\u0004\u00ba\u0001\u00bb\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010\fJ$\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000e2\u0006\u0010\u0010\u001a\u00020\u0004H\u0086@\u00a2\u0006\u0002\u0010\u0011J\u001e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0086@\u00a2\u0006\u0002\u0010\u0016J8\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\u001c\u001a\u00020\u0004H\u0086@\u00a2\u0006\u0002\u0010\u001dJ\"\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00150\u00062\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00150\u00062\u0006\u0010 \u001a\u00020!J\u001e\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004H\u0086@\u00a2\u0006\u0002\u0010%J\u0016\u0010&\u001a\u00020\u000f2\u0006\u0010\'\u001a\u00020\u0004H\u0086@\u00a2\u0006\u0002\u0010\u0011J&\u0010(\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0086@\u00a2\u0006\u0002\u0010)J\b\u0010*\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u0004H\u0002J\"\u0010.\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000e0\u00062\u0006\u0010/\u001a\u00020\u0004H\u0002J\u0014\u00100\u001a\b\u0012\u0004\u0012\u0002010\u0006H\u0086@\u00a2\u0006\u0002\u00102J\u001a\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000404H\u0086@\u00a2\u0006\u0002\u00102J\u0014\u00105\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0086@\u00a2\u0006\u0002\u00102J\u0014\u00106\u001a\b\u0012\u0004\u0012\u0002070\u0006H\u0086@\u00a2\u0006\u0002\u00102J \u00108\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000e0\u0006H\u0086@\u00a2\u0006\u0002\u00102J\u001c\u00109\u001a\b\u0012\u0004\u0012\u00020\u00150\u00062\u0006\u0010\u0018\u001a\u00020\u0004H\u0086@\u00a2\u0006\u0002\u0010\u0011J\u0016\u0010:\u001a\u00020;2\u0006\u0010\t\u001a\u00020\u0004H\u0086@\u00a2\u0006\u0002\u0010\u0011J\u0014\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0086@\u00a2\u0006\u0002\u00102J\u001c\u0010=\u001a\b\u0012\u0004\u0012\u00020>0\u00062\u0006\u0010\u0018\u001a\u00020\u0004H\u0086@\u00a2\u0006\u0002\u0010\u0011J\u0014\u0010?\u001a\b\u0012\u0004\u0012\u00020@0\u0006H\u0086@\u00a2\u0006\u0002\u00102J\u0010\u0010A\u001a\u0004\u0018\u00010\u0004H\u0086@\u00a2\u0006\u0002\u00102J\u001c\u0010B\u001a\b\u0012\u0004\u0012\u00020C0\u00062\u0006\u0010D\u001a\u00020\u0004H\u0086@\u00a2\u0006\u0002\u0010\u0011J\u001c\u0010E\u001a\b\u0012\u0004\u0012\u00020C0\u00062\u0006\u0010D\u001a\u00020\u0004H\u0086@\u00a2\u0006\u0002\u0010\u0011J\u0010\u0010F\u001a\u0004\u0018\u00010\u0004H\u0086@\u00a2\u0006\u0002\u00102J\u001c\u0010G\u001a\b\u0012\u0004\u0012\u00020>0\u00062\u0006\u0010D\u001a\u00020\u0004H\u0086@\u00a2\u0006\u0002\u0010\u0011J\u0010\u0010H\u001a\u0004\u0018\u00010\u0004H\u0086@\u00a2\u0006\u0002\u00102J\u000e\u0010I\u001a\u00020JH\u0086@\u00a2\u0006\u0002\u00102J\u000e\u0010K\u001a\u00020LH\u0086@\u00a2\u0006\u0002\u00102J\u0010\u0010M\u001a\u0004\u0018\u00010\u0004H\u0086@\u00a2\u0006\u0002\u00102J\u000e\u0010N\u001a\u00020OH\u0086@\u00a2\u0006\u0002\u00102J \u0010P\u001a\b\u0012\u0004\u0012\u00020Q0\u00062\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u0004H\u0086@\u00a2\u0006\u0002\u0010\u0011J\u0010\u0010S\u001a\u0004\u0018\u00010TH\u0086@\u00a2\u0006\u0002\u00102J\u000e\u0010U\u001a\u00020VH\u0086@\u00a2\u0006\u0002\u00102J\u0010\u0010W\u001a\u0004\u0018\u00010\u0004H\u0086@\u00a2\u0006\u0002\u00102J\u000e\u0010X\u001a\u00020YH\u0086@\u00a2\u0006\u0002\u00102J\u0014\u0010Z\u001a\b\u0012\u0004\u0012\u00020[0\u0006H\u0086@\u00a2\u0006\u0002\u00102J\u001a\u0010\\\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000404H\u0086@\u00a2\u0006\u0002\u00102J\u000e\u0010]\u001a\u00020^H\u0086@\u00a2\u0006\u0002\u00102J\u0014\u0010_\u001a\b\u0012\u0004\u0012\u0002010\u0006H\u0086@\u00a2\u0006\u0002\u00102J\u000e\u0010`\u001a\u00020aH\u0086@\u00a2\u0006\u0002\u00102J\u000e\u0010b\u001a\u00020cH\u0086@\u00a2\u0006\u0002\u00102J\u0016\u0010d\u001a\u00020\u000f2\u0006\u0010e\u001a\u00020\u0004H\u0086@\u00a2\u0006\u0002\u0010\u0011J\u000e\u0010f\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0002\u00102J\u0010\u0010g\u001a\u0004\u0018\u00010\u0004H\u0086@\u00a2\u0006\u0002\u00102J\u001e\u0010h\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010i\u001a\u00020\u0004H\u0086@\u00a2\u0006\u0002\u0010%J&\u0010j\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010k\u001a\u00020\u00042\u0006\u0010l\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010mJ\u0016\u0010n\u001a\b\u0012\u0004\u0012\u0002070\u00062\u0006\u0010o\u001a\u00020\u0004H\u0002J\u0016\u0010p\u001a\b\u0012\u0004\u0012\u00020@0\u00062\u0006\u0010-\u001a\u00020\u0004H\u0002J\u000e\u0010q\u001a\u00020rH\u0086@\u00a2\u0006\u0002\u00102J\u000e\u0010s\u001a\u00020tH\u0086@\u00a2\u0006\u0002\u00102J\u0016\u0010u\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0004H\u0086@\u00a2\u0006\u0002\u0010\u0011J4\u0010v\u001a\u0004\u0018\u00010\u00042\"\u0010w\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020{0z0y\u0012\u0006\u0012\u0004\u0018\u00010\u00010xH\u0082@\u00a2\u0006\u0002\u0010|J\u0016\u0010}\u001a\u00020\u000f2\u0006\u0010~\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010\u007fJ\u0017\u0010\u0080\u0001\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0004H\u0086@\u00a2\u0006\u0002\u0010\u0011J\u0017\u0010\u0081\u0001\u001a\u00020\u000f2\u0006\u0010e\u001a\u00020\u0004H\u0086@\u00a2\u0006\u0002\u0010\u0011J%\u0010\u0082\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000e2\u0006\u0010\u0010\u001a\u00020\u0004H\u0086@\u00a2\u0006\u0002\u0010\u0011J\u001f\u0010\u0083\u0001\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010k\u001a\u00020\u0004H\u0086@\u00a2\u0006\u0002\u0010%J \u0010\u0084\u0001\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00042\u0007\u0010\u0085\u0001\u001a\u00020\u0004H\u0086@\u00a2\u0006\u0002\u0010%J \u0010\u0086\u0001\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00042\u0007\u0010\u0085\u0001\u001a\u00020\u0004H\u0086@\u00a2\u0006\u0002\u0010%J\u0011\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0004H\u0082@\u00a2\u0006\u0002\u00102J\u000f\u0010\u0088\u0001\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0002\u00102J\u0019\u0010\u0089\u0001\u001a\u00020\u000f2\u0007\u0010\u008a\u0001\u001a\u000207H\u0086@\u00a2\u0006\u0003\u0010\u008b\u0001J.\u0010\u008c\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000e2\u0006\u0010\u0010\u001a\u00020\u00042\u0007\u0010\u008d\u0001\u001a\u00020\u0004H\u0086@\u00a2\u0006\u0002\u0010%J\u001f\u0010\u008e\u0001\u001a\u00020\u000f2\r\u0010\u008f\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0086@\u00a2\u0006\u0003\u0010\u0090\u0001J\u001e\u0010\u0091\u0001\u001a\b\u0012\u0004\u0012\u00020>0\u00062\u0007\u0010\u0092\u0001\u001a\u00020\u0004H\u0086@\u00a2\u0006\u0002\u0010\u0011J/\u0010\u0093\u0001\u001a\u00020\u000f2\u0007\u0010\u0094\u0001\u001a\u00020\u00042\t\b\u0002\u0010\u0095\u0001\u001a\u00020\u000b2\t\b\u0002\u0010\u0096\u0001\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0003\u0010\u0097\u0001J\u0018\u0010\u0098\u0001\u001a\u00020\u000f2\u0007\u0010\u0099\u0001\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010\u007fJ%\u0010\u009a\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000e2\u0006\u0010\u0010\u001a\u00020\u0004H\u0086@\u00a2\u0006\u0002\u0010\u0011J\u000f\u0010\u009b\u0001\u001a\u00020aH\u0086@\u00a2\u0006\u0002\u00102J\u0018\u0010\u009c\u0001\u001a\u00020L2\u0007\u0010\u009d\u0001\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010\u007fJ+\u0010\u009e\u0001\u001a\u00020V2\u0007\u0010\u009f\u0001\u001a\u00020\u000b2\u0007\u0010\u00a0\u0001\u001a\u00020\u00042\u0007\u0010\u00a1\u0001\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0003\u0010\u00a2\u0001J3\u0010\u00a3\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000e2\u0013\u0010\u00a4\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000404H\u0086@\u00a2\u0006\u0003\u0010\u00a5\u0001J\u0018\u0010\u00a6\u0001\u001a\u00020a2\u0007\u0010\u00a7\u0001\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010\u007fJ3\u0010\u00a8\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000e2\u0013\u0010\u00a4\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000404H\u0086@\u00a2\u0006\u0003\u0010\u00a5\u0001J;\u0010\u00a9\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000e2\u0007\u0010\u00a1\u0001\u001a\u00020\u000f2\t\u0010\u00aa\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010\u00ab\u0001\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0003\u0010\u00ac\u0001J\u0017\u0010\u00ad\u0001\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0004H\u0086@\u00a2\u0006\u0002\u0010\u0011J2\u0010\u00ae\u0001\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00042\u000b\b\u0002\u0010\u00af\u0001\u001a\u0004\u0018\u00010\u00042\u000b\b\u0002\u0010\u00b0\u0001\u001a\u0004\u0018\u00010\u0004H\u0086@\u00a2\u0006\u0003\u0010\u00b1\u0001J9\u0010\u00b2\u0001\u001a\u00030\u00b3\u00012\u0007\u0010\u00b4\u0001\u001a\u00020\u00042\b\u0010\u00b5\u0001\u001a\u00030\u00b6\u00012\u001a\u0010\u00b7\u0001\u001a\u0015\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000e0\u00b8\u0001H\u0002J\u0017\u0010\u00b9\u0001\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0004H\u0086@\u00a2\u0006\u0002\u0010\u0011R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u00bc\u0001"}, d2 = {"Lcom/enigma2/android/data/repository/Enigma2Repository;", "", "()V", "cachedEpgImportBase", "", "epgImportBaseCandidates", "", "addBouquet", "Lcom/enigma2/android/data/api/BouquetEditorXml$SimpleResult;", "name", "mode", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addRecordingLocation", "Lkotlin/Pair;", "", "path", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addServiceToBouquet", "bouquetRef", "service", "Lcom/enigma2/android/data/model/Service;", "(Ljava/lang/String;Lcom/enigma2/android/data/model/Service;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addTimer", "sRef", "begin", "", "end", "description", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyOverride", "services", "override", "Lcom/enigma2/android/data/prefs/ReceiverPreferences$BouquetOverride;", "changeSetupPin", "oldPin", "newPin", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteRecording", "filename", "deleteTimer", "(Ljava/lang/String;JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emptyStream", "Ljava/io/ByteArrayInputStream;", "extractEpgImportStatus", "body", "flattenJsonScalars", "jsonText", "getAllBouquets", "Lcom/enigma2/android/data/model/Bouquet;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllSettings", "", "getAllTags", "getAutoTimers", "Lcom/enigma2/android/data/model/AutoTimer;", "getBoxInfo", "getChannelsForBouquet", "getConfigSection", "Lcom/enigma2/android/data/model/settings/ConfigSection;", "getConfigSections", "getEpgForService", "Lcom/enigma2/android/data/model/EpgEvent;", "getEpgImportSources", "Lcom/enigma2/android/data/repository/EpgImportSource;", "getEpgImportStatus", "getEpgNext", "Lcom/enigma2/android/data/model/NowNextEvent;", "bRef", "getEpgNow", "getMountInfoRaw", "getMultiEpg", "getNetworkInfoRaw", "getParentalSettings", "Lcom/enigma2/android/data/model/settings/ParentalSettings;", "getPowerState", "Lcom/enigma2/android/data/model/settings/PowerState;", "getReceiverLogRaw", "getRecordingLocations", "Lcom/enigma2/android/data/model/settings/RecordingLocations;", "getRecordings", "Lcom/enigma2/android/data/model/Recording;", "dirname", "getScreenshot", "", "getSleepTimer", "Lcom/enigma2/android/data/model/settings/SleepTimer;", "getSmartInfoRaw", "getStatusInfo", "Lcom/enigma2/android/data/model/settings/StatusInfo;", "getTimers", "Lcom/enigma2/android/data/model/Timer;", "getTranscodingConfig", "getTunerSignal", "Lcom/enigma2/android/data/model/settings/TunerSignal;", "getUserBouquets", "getVolume", "Lcom/enigma2/android/data/model/settings/VolumeInfo;", "getWolSetup", "Lcom/enigma2/android/data/model/settings/WolSetup;", "installPlugin", "pkg", "isEpgImportAvailable", "listPluginsRaw", "moveRecording", "newDir", "moveServiceInBouquet", "serviceRef", "position", "(Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseAutoTimersXml", "xml", "parseEpgImportSources", "probeBouquetEditor", "Lcom/enigma2/android/data/repository/Enigma2Repository$BouquetEditorCapability;", "probeReceiverCapabilities", "Lcom/enigma2/android/data/model/settings/ReceiverCapabilities;", "protectService", "rawGet", "call", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lretrofit2/Response;", "Lokhttp3/ResponseBody;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeAutoTimer", "id", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeBouquet", "removePlugin", "removeRecordingLocation", "removeServiceFromBouquet", "renameBouquet", "newName", "renameRecording", "resolveEpgImportBase", "runEpgImport", "saveAutoTimer", "at", "(Lcom/enigma2/android/data/model/AutoTimer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveConfig", "value", "saveEpgImportEnabledSources", "enabledDescriptions", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchEpg", "query", "sendMessageToReceiver", "text", "type", "timeout", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendRemoteCommand", "command", "setCurrentLocation", "setMute", "setPowerState", "newState", "setSleepTimer", "minutes", "action", "enabled", "(ILjava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setTranscodingConfig", "params", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setVolume", "level", "setWebUiConfig", "setWolSetup", "location", "wolStandby", "(ZLjava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unprotectService", "updateRecordingTags", "add", "del", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "walkJson", "", "prefix", "obj", "Lcom/google/gson/JsonObject;", "out", "", "zapToService", "BouquetEditorCapability", "Companion", "app_debug"})
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
    
    private final java.io.ByteArrayInputStream emptyStream() {
        return null;
    }
    
    /**
     * One-shot capability probe; cheap calls only.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object probeReceiverCapabilities(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enigma2.android.data.model.settings.ReceiverCapabilities> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getStatusInfo(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enigma2.android.data.model.settings.StatusInfo> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getPowerState(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enigma2.android.data.model.settings.PowerState> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object setPowerState(int newState, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enigma2.android.data.model.settings.PowerState> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getSleepTimer(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enigma2.android.data.model.settings.SleepTimer> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object setSleepTimer(int minutes, @org.jetbrains.annotations.NotNull()
    java.lang.String action, boolean enabled, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enigma2.android.data.model.settings.SleepTimer> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getVolume(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enigma2.android.data.model.settings.VolumeInfo> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object setVolume(int level, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enigma2.android.data.model.settings.VolumeInfo> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object setMute(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enigma2.android.data.model.settings.VolumeInfo> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAllSettings(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, java.lang.String>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getConfigSections(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<java.lang.String>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getConfigSection(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enigma2.android.data.model.settings.ConfigSection> $completion) {
        return null;
    }
    
    /**
     * Saves a single config.* path. Returns (ok,message).
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveConfig(@org.jetbrains.annotations.NotNull()
    java.lang.String path, @org.jetbrains.annotations.NotNull()
    java.lang.String value, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Pair<java.lang.Boolean, java.lang.String>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object setWebUiConfig(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Pair<java.lang.Boolean, java.lang.String>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getParentalSettings(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enigma2.android.data.model.settings.ParentalSettings> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getRecordingLocations(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enigma2.android.data.model.settings.RecordingLocations> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object setCurrentLocation(@org.jetbrains.annotations.NotNull()
    java.lang.String path, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Pair<java.lang.Boolean, java.lang.String>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addRecordingLocation(@org.jetbrains.annotations.NotNull()
    java.lang.String path, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Pair<java.lang.Boolean, java.lang.String>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object removeRecordingLocation(@org.jetbrains.annotations.NotNull()
    java.lang.String path, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Pair<java.lang.Boolean, java.lang.String>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getTunerSignal(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enigma2.android.data.model.settings.TunerSignal> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getWolSetup(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.enigma2.android.data.model.settings.WolSetup> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object setWolSetup(boolean enabled, @org.jetbrains.annotations.Nullable()
    java.lang.String location, boolean wolStandby, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Pair<java.lang.Boolean, java.lang.String>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getTranscodingConfig(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, java.lang.String>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object setTranscodingConfig(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Pair<java.lang.Boolean, java.lang.String>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object sendRemoteCommand(int command, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    /**
     * type: 1=Info, 2=Warning, 3=Question, 4=Error. timeout in seconds (-1 = until dismissed).
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object sendMessageToReceiver(@org.jetbrains.annotations.NotNull()
    java.lang.String text, int type, int timeout, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object renameRecording(@org.jetbrains.annotations.NotNull()
    java.lang.String sRef, @org.jetbrains.annotations.NotNull()
    java.lang.String newName, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object moveRecording(@org.jetbrains.annotations.NotNull()
    java.lang.String sRef, @org.jetbrains.annotations.NotNull()
    java.lang.String newDir, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    /**
     * Add and/or remove tags on a recording. Tags are space-separated.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateRecordingTags(@org.jetbrains.annotations.NotNull()
    java.lang.String sRef, @org.jetbrains.annotations.Nullable()
    java.lang.String add, @org.jetbrains.annotations.Nullable()
    java.lang.String del, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    /**
     * All tags known to the receiver. Empty list on failure.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAllTags(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<java.lang.String>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object protectService(@org.jetbrains.annotations.NotNull()
    java.lang.String sRef, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object unprotectService(@org.jetbrains.annotations.NotNull()
    java.lang.String sRef, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object changeSetupPin(@org.jetbrains.annotations.NotNull()
    java.lang.String oldPin, @org.jetbrains.annotations.NotNull()
    java.lang.String newPin, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    /**
     * Raw text body of an admin endpoint; null on failure.
     */
    private final java.lang.Object rawGet(kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>>, ? extends java.lang.Object> call, kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getMountInfoRaw(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getSmartInfoRaw(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getReceiverLogRaw(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getNetworkInfoRaw(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object listPluginsRaw(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object installPlugin(@org.jetbrains.annotations.NotNull()
    java.lang.String pkg, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object removePlugin(@org.jetbrains.annotations.NotNull()
    java.lang.String pkg, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
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