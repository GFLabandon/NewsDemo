package com.example.newsdemo.ui

import android.animation.ValueAnimator
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.newsdemo.R
import com.example.newsdemo.adapter.NewsAdapter
import com.example.newsdemo.local.AppDatabase
import com.example.newsdemo.network.RetrofitClient
import com.example.newsdemo.repository.NewsRepository
import com.example.newsdemo.viewmodel.NewsViewModel
import com.example.newsdemo.viewmodel.NewsViewModelFactory
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * 新闻列表页（首页）
 * MVVM + StateFlow + 分页 + Room 离线缓存 + 本地搜索
 */
class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var textError: TextView
    private lateinit var buttonRetry: Button
    private lateinit var buttonLoadMoreRetry: Button
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var skeletonContainer: View
    private lateinit var progressLoadMore: ProgressBar
    private lateinit var editSearch: EditText

    private lateinit var newsAdapter: NewsAdapter
    private lateinit var viewModel: NewsViewModel

    private var skeletonAnimator: ValueAnimator? = null
    private var searchJob: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initRecyclerView()
        initViewModel()
        observeUiState()
        initEvents()
    }

    override fun onDestroy() {
        super.onDestroy()
        skeletonAnimator?.cancel()
        searchJob?.cancel()
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerViewNews)
        textError = findViewById(R.id.textError)
        buttonRetry = findViewById(R.id.buttonRetry)
        buttonLoadMoreRetry = findViewById(R.id.buttonLoadMoreRetry)
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout)
        skeletonContainer = findViewById(R.id.skeletonContainer)
        progressLoadMore = findViewById(R.id.progressLoadMore)
        editSearch = findViewById(R.id.editSearch)
    }

    private fun initRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        newsAdapter = NewsAdapter(mutableListOf()) { clickedNews ->
            val intent = Intent(this@MainActivity, DetailActivity::class.java).apply {
                putExtra("title", clickedNews.title)
                putExtra("summary", clickedNews.summary)
                putExtra("imageUrl", clickedNews.imageUrl)
                putExtra("url", clickedNews.url)
            }
            startActivity(intent)
        }
        recyclerView.adapter = newsAdapter

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy <= 0) return

                val totalItemCount = layoutManager.itemCount
                val lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()

                if (lastVisibleItemPosition >= totalItemCount - 4) {
                    viewModel.loadMore()
                }
            }
        })
    }

    private fun initViewModel() {
        val newsDao = AppDatabase.getInstance(applicationContext).newsDao()
        val repository = NewsRepository(RetrofitClient.apiService, newsDao)
        val factory = NewsViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory)[NewsViewModel::class.java]
    }

    private fun initEvents() {
        swipeRefreshLayout.setOnRefreshListener {
            viewModel.refresh()
        }

        buttonRetry.setOnClickListener {
            viewModel.retry()
        }

        buttonLoadMoreRetry.setOnClickListener {
            viewModel.retryLoadMore()
        }

        // 顶部搜索输入防抖：减少频繁查询
        editSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) = Unit

            override fun afterTextChanged(s: Editable?) {
                val keyword = s?.toString().orEmpty()
                searchJob?.cancel()
                searchJob = lifecycleScope.launch {
                    delay(350)
                    viewModel.onSearchKeywordChanged(keyword)
                }
            }
        })
    }

    private fun observeUiState() {
        lifecycleScope.launch {
            repeatOnLifecycle(androidx.lifecycle.Lifecycle.State.STARTED) {
                viewModel.uiState.collect { state ->
                    swipeRefreshLayout.isRefreshing = state.isRefreshing
                    progressLoadMore.visibility = if (state.isLoadingMore) View.VISIBLE else View.GONE
                    buttonLoadMoreRetry.visibility = if (state.showLoadMoreRetry) View.VISIBLE else View.GONE

                    textError.visibility = if (state.showFullScreenError) View.VISIBLE else View.GONE
                    buttonRetry.visibility = if (state.showFullScreenError) View.VISIBLE else View.GONE

                    if (state.showFullScreenError) {
                        textError.text = "加载失败：${state.errorMessage ?: "未知错误"}"
                    }

                    val showSkeleton = state.isInitialLoading && state.newsList.isEmpty()
                    skeletonContainer.visibility = if (showSkeleton) View.VISIBLE else View.GONE
                    if (showSkeleton) startSkeletonAnimation() else stopSkeletonAnimation()

                    newsAdapter.updateData(state.newsList)

                    if (!state.showFullScreenError && state.errorMessage != null) {
                        val suffix = if (state.isFromCache) "（已展示本地缓存）" else ""
                        Toast.makeText(this@MainActivity, "加载失败：${state.errorMessage}$suffix", Toast.LENGTH_SHORT).show()
                        viewModel.clearErrorMessage()
                    }
                }
            }
        }
    }

    private fun startSkeletonAnimation() {
        if (skeletonAnimator != null && skeletonAnimator?.isRunning == true) return

        skeletonAnimator = ValueAnimator.ofFloat(0.5f, 1f).apply {
            duration = 900
            repeatMode = ValueAnimator.REVERSE
            repeatCount = ValueAnimator.INFINITE
            interpolator = LinearInterpolator()
            addUpdateListener { animator ->
                skeletonContainer.alpha = animator.animatedValue as Float
            }
            start()
        }
    }

    private fun stopSkeletonAnimation() {
        skeletonAnimator?.cancel()
        skeletonAnimator = null
        skeletonContainer.alpha = 1f
    }
}
