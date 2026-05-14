package com.example.newsdemo.repository

import com.example.newsdemo.local.NewsDao
import com.example.newsdemo.local.toEntity
import com.example.newsdemo.local.toNewsItem
import com.example.newsdemo.model.NewsItem
import com.example.newsdemo.network.NewsApiService

/**
 * Repository：统一管理网络与本地缓存
 */
class NewsRepository(
    private val apiService: NewsApiService,
    private val newsDao: NewsDao
) {

    data class PageResult(
        val newsList: List<NewsItem>,
        val hasMore: Boolean,
        val fromCache: Boolean
    )

    /**
     * 分页获取新闻
     * 规则：
     * 1. 无搜索词时优先走网络，成功后写入 Room
     * 2. 网络失败时回退读取 Room（离线可看）
     * 3. 有搜索词时直接从 Room 搜索（支持离线）
     */
    suspend fun fetchNewsPage(limit: Int, offset: Int, keyword: String): PageResult {
        if (keyword.isNotBlank()) {
            val localList = newsDao.searchPaged(keyword = keyword.trim(), limit = limit, offset = offset)
                .map { it.toNewsItem() }
            return PageResult(
                newsList = localList,
                hasMore = localList.size == limit,
                fromCache = true
            )
        }

        return try {
            val response = apiService.getNewsList(limit = limit, offset = offset)
            val items = response.results
            newsDao.upsertAll(items.map { it.toEntity() })
            PageResult(
                newsList = items,
                hasMore = response.next != null,
                fromCache = false
            )
        } catch (e: Exception) {
            val localList = newsDao.getPaged(limit = limit, offset = offset).map { it.toNewsItem() }
            if (localList.isEmpty()) throw e

            PageResult(
                newsList = localList,
                hasMore = localList.size == limit,
                fromCache = true
            )
        }
    }
}
