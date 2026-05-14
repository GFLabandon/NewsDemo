package com.example.newsdemo.ui;

/**
 * 新闻列表页（首页）
 * MVVM + StateFlow + 分页 + Room 离线缓存 + 本地搜索
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u001bH\u0002J\b\u0010\u001f\u001a\u00020\u001bH\u0002J\u0012\u0010 \u001a\u00020\u001b2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014J\b\u0010#\u001a\u00020\u001bH\u0014J\b\u0010$\u001a\u00020\u001bH\u0002J\b\u0010%\u001a\u00020\u001bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/example/newsdemo/ui/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "buttonLoadMoreRetry", "Landroid/widget/Button;", "buttonRetry", "editSearch", "Landroid/widget/EditText;", "newsAdapter", "Lcom/example/newsdemo/adapter/NewsAdapter;", "progressLoadMore", "Landroid/widget/ProgressBar;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "searchJob", "Lkotlinx/coroutines/Job;", "skeletonAnimator", "Landroid/animation/ValueAnimator;", "skeletonContainer", "Landroid/view/View;", "swipeRefreshLayout", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "textError", "Landroid/widget/TextView;", "viewModel", "Lcom/example/newsdemo/viewmodel/NewsViewModel;", "initEvents", "", "initRecyclerView", "initViewModel", "initViews", "observeUiState", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "startSkeletonAnimation", "stopSkeletonAnimation", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    private android.widget.TextView textError;
    private android.widget.Button buttonRetry;
    private android.widget.Button buttonLoadMoreRetry;
    private androidx.swiperefreshlayout.widget.SwipeRefreshLayout swipeRefreshLayout;
    private android.view.View skeletonContainer;
    private android.widget.ProgressBar progressLoadMore;
    private android.widget.EditText editSearch;
    private com.example.newsdemo.adapter.NewsAdapter newsAdapter;
    private com.example.newsdemo.viewmodel.NewsViewModel viewModel;
    @org.jetbrains.annotations.Nullable()
    private android.animation.ValueAnimator skeletonAnimator;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job searchJob;
    
    public MainActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    private final void initViews() {
    }
    
    private final void initRecyclerView() {
    }
    
    private final void initViewModel() {
    }
    
    private final void initEvents() {
    }
    
    private final void observeUiState() {
    }
    
    private final void startSkeletonAnimation() {
    }
    
    private final void stopSkeletonAnimation() {
    }
}