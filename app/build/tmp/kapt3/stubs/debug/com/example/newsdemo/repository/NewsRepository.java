package com.example.newsdemo.repository;

/**
 * Repository：统一管理网络与本地缓存
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u000fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/example/newsdemo/repository/NewsRepository;", "", "apiService", "Lcom/example/newsdemo/network/NewsApiService;", "newsDao", "Lcom/example/newsdemo/local/NewsDao;", "(Lcom/example/newsdemo/network/NewsApiService;Lcom/example/newsdemo/local/NewsDao;)V", "fetchNewsPage", "Lcom/example/newsdemo/repository/NewsRepository$PageResult;", "limit", "", "offset", "keyword", "", "(IILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "PageResult", "app_debug"})
public final class NewsRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.newsdemo.network.NewsApiService apiService = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.newsdemo.local.NewsDao newsDao = null;
    
    public NewsRepository(@org.jetbrains.annotations.NotNull()
    com.example.newsdemo.network.NewsApiService apiService, @org.jetbrains.annotations.NotNull()
    com.example.newsdemo.local.NewsDao newsDao) {
        super();
    }
    
    /**
     * 分页获取新闻
     * 规则：
     * 1. 无搜索词时优先走网络，成功后写入 Room
     * 2. 网络失败时回退读取 Room（离线可看）
     * 3. 有搜索词时直接从 Room 搜索（支持离线）
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object fetchNewsPage(int limit, int offset, @org.jetbrains.annotations.NotNull()
    java.lang.String keyword, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.newsdemo.repository.NewsRepository.PageResult> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\bJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0006H\u00c6\u0003J-\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0018"}, d2 = {"Lcom/example/newsdemo/repository/NewsRepository$PageResult;", "", "newsList", "", "Lcom/example/newsdemo/model/NewsItem;", "hasMore", "", "fromCache", "(Ljava/util/List;ZZ)V", "getFromCache", "()Z", "getHasMore", "getNewsList", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "app_debug"})
    public static final class PageResult {
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.example.newsdemo.model.NewsItem> newsList = null;
        private final boolean hasMore = false;
        private final boolean fromCache = false;
        
        public PageResult(@org.jetbrains.annotations.NotNull()
        java.util.List<com.example.newsdemo.model.NewsItem> newsList, boolean hasMore, boolean fromCache) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.example.newsdemo.model.NewsItem> getNewsList() {
            return null;
        }
        
        public final boolean getHasMore() {
            return false;
        }
        
        public final boolean getFromCache() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.example.newsdemo.model.NewsItem> component1() {
            return null;
        }
        
        public final boolean component2() {
            return false;
        }
        
        public final boolean component3() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.newsdemo.repository.NewsRepository.PageResult copy(@org.jetbrains.annotations.NotNull()
        java.util.List<com.example.newsdemo.model.NewsItem> newsList, boolean hasMore, boolean fromCache) {
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