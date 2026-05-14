package com.example.newsdemo.local;

/**
 * Room 数据访问接口
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\bJ,\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\fJ\u001c\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/example/newsdemo/local/NewsDao;", "", "getPaged", "", "Lcom/example/newsdemo/local/NewsEntity;", "limit", "", "offset", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchPaged", "keyword", "", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "upsertAll", "", "list", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface NewsDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object upsertAll(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.newsdemo.local.NewsEntity> list, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM news ORDER BY id DESC LIMIT :limit OFFSET :offset")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPaged(int limit, int offset, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.newsdemo.local.NewsEntity>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM news WHERE title LIKE \'%\' || :keyword || \'%\' ORDER BY id DESC LIMIT :limit OFFSET :offset")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object searchPaged(@org.jetbrains.annotations.NotNull()
    java.lang.String keyword, int limit, int offset, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.newsdemo.local.NewsEntity>> $completion);
}