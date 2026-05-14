package com.example.newsdemo.network;

/**
 * Retrofit 接口定义
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/example/newsdemo/network/NewsApiService;", "", "getNewsList", "Lcom/example/newsdemo/model/NewsResponse;", "limit", "", "offset", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface NewsApiService {
    
    /**
     * 分页获取新闻列表
     * @param limit 每页条数
     * @param offset 偏移量（第几条开始）
     */
    @retrofit2.http.GET(value = "articles/")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getNewsList(@retrofit2.http.Query(value = "limit")
    int limit, @retrofit2.http.Query(value = "offset")
    int offset, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.newsdemo.model.NewsResponse> $completion);
}