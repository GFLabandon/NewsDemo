package com.example.newsdemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsdemo.repository.NewsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * ViewModel：分页 + 刷新 + 搜索 + 本地缓存回退
 */
class NewsViewModel(private val repository: NewsRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(NewsUiState())
    val uiState: StateFlow<NewsUiState> = _uiState.asStateFlow()

    private val pageSize = 20
    private var currentOffset = 0

    init {
        loadInitial()
    }

    fun loadInitial() {
        _uiState.update {
            it.copy(
                isInitialLoading = true,
                isRefreshing = false,
                isLoadingMore = false,
                showFullScreenError = false,
                showLoadMoreRetry = false,
                errorMessage = null
            )
        }
        currentOffset = 0
        requestPage(reset = true)
    }

    fun refresh() {
        val state = _uiState.value
        if (state.isRefreshing || state.isInitialLoading) return

        _uiState.update {
            it.copy(
                isRefreshing = true,
                showFullScreenError = false,
                showLoadMoreRetry = false,
                errorMessage = null
            )
        }
        currentOffset = 0
        requestPage(reset = true)
    }

    fun loadMore() {
        val state = _uiState.value
        if (state.isLoadingMore || state.isInitialLoading || state.isRefreshing || !state.hasMore) return

        _uiState.update { it.copy(isLoadingMore = true, showLoadMoreRetry = false, errorMessage = null) }
        requestPage(reset = false)
    }

    fun retry() {
        loadInitial()
    }

    fun retryLoadMore() {
        loadMore()
    }

    /**
     * 顶部搜索：
     * 这里用 Room 做本地搜索，支持离线。
     */
    fun onSearchKeywordChanged(keyword: String) {
        _uiState.update { it.copy(searchKeyword = keyword) }
        currentOffset = 0
        _uiState.update {
            it.copy(
                isInitialLoading = true,
                showFullScreenError = false,
                showLoadMoreRetry = false,
                errorMessage = null,
                hasMore = true
            )
        }
        requestPage(reset = true)
    }

    fun clearErrorMessage() {
        _uiState.update { it.copy(errorMessage = null) }
    }

    private fun requestPage(reset: Boolean) {
        viewModelScope.launch {
            try {
                val state = _uiState.value
                val result = repository.fetchNewsPage(
                    limit = pageSize,
                    offset = currentOffset,
                    keyword = state.searchKeyword
                )

                val mergedList = if (reset) {
                    result.newsList
                } else {
                    state.newsList + result.newsList
                }

                currentOffset = mergedList.size

                _uiState.update {
                    it.copy(
                        newsList = mergedList,
                        isInitialLoading = false,
                        isRefreshing = false,
                        isLoadingMore = false,
                        showFullScreenError = false,
                        showLoadMoreRetry = false,
                        errorMessage = null,
                        hasMore = result.hasMore,
                        isFromCache = result.fromCache
                    )
                }
            } catch (e: Exception) {
                val oldList = _uiState.value.newsList
                val isLoadMoreError = !reset && oldList.isNotEmpty()
                val isFullScreen = oldList.isEmpty()

                _uiState.update {
                    it.copy(
                        isInitialLoading = false,
                        isRefreshing = false,
                        isLoadingMore = false,
                        showFullScreenError = isFullScreen,
                        showLoadMoreRetry = isLoadMoreError,
                        errorMessage = e.message ?: "未知错误"
                    )
                }
            }
        }
    }
}
