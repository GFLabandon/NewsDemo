package com.example.newsdemo.viewmodel;

/**
 * ViewModel：分页 + 刷新 + 搜索 + 本地缓存回退
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0012\u001a\u00020\u0010J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0010J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0006\u0010\u001a\u001a\u00020\u0010J\u0006\u0010\u001b\u001a\u00020\u0010R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001c"}, d2 = {"Lcom/example/newsdemo/viewmodel/NewsViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/newsdemo/repository/NewsRepository;", "(Lcom/example/newsdemo/repository/NewsRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/newsdemo/viewmodel/NewsUiState;", "currentOffset", "", "pageSize", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "clearErrorMessage", "", "loadInitial", "loadMore", "onSearchKeywordChanged", "keyword", "", "refresh", "requestPage", "reset", "", "retry", "retryLoadMore", "app_debug"})
public final class NewsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.newsdemo.repository.NewsRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.newsdemo.viewmodel.NewsUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.newsdemo.viewmodel.NewsUiState> uiState = null;
    private final int pageSize = 20;
    private int currentOffset = 0;
    
    public NewsViewModel(@org.jetbrains.annotations.NotNull()
    com.example.newsdemo.repository.NewsRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.newsdemo.viewmodel.NewsUiState> getUiState() {
        return null;
    }
    
    public final void loadInitial() {
    }
    
    public final void refresh() {
    }
    
    public final void loadMore() {
    }
    
    public final void retry() {
    }
    
    public final void retryLoadMore() {
    }
    
    /**
     * 顶部搜索：
     * 这里用 Room 做本地搜索，支持离线。
     */
    public final void onSearchKeywordChanged(@org.jetbrains.annotations.NotNull()
    java.lang.String keyword) {
    }
    
    public final void clearErrorMessage() {
    }
    
    private final void requestPage(boolean reset) {
    }
}