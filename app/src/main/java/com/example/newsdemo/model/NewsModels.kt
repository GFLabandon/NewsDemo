package com.example.newsdemo.model

import com.google.gson.annotations.SerializedName

/**
 * API 最外层返回结构
 * Spaceflight News API v4 常见字段：count / next / previous / results
 */
data class NewsResponse(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String?,
    @SerializedName("previous")
    val previous: String?,
    @SerializedName("results")
    val results: List<NewsItem>
)

/**
 * 单条新闻数据模型
 */
data class NewsItem(
    val id: Int,
    val title: String,
    val summary: String,
    @SerializedName("image_url")
    val imageUrl: String,
    val url: String
)
