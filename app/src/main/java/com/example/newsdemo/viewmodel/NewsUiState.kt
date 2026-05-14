package com.example.newsdemo.viewmodel

import com.example.newsdemo.model.NewsItem

/**
 * 页面状态：集中管理列表、加载、错误、搜索等状态
 */
data class NewsUiState(
    val newsList: List<NewsItem> = emptyList(),
    val searchKeyword: String = "",
    val isInitialLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val isLoadingMore: Boolean = false,
    val showFullScreenError: Boolean = false,
    val showLoadMoreRetry: Boolean = false,
    val errorMessage: String? = null,
    val hasMore: Boolean = true,
    val isFromCache: Boolean = false
)
