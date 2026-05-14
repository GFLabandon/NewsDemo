package com.example.newsdemo.network

import com.example.newsdemo.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Retrofit 接口定义
 */
interface NewsApiService {

    /**
     * 分页获取新闻列表
     * @param limit 每页条数
     * @param offset 偏移量（第几条开始）
     */
    @GET("articles/")
    suspend fun getNewsList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): NewsResponse
}
