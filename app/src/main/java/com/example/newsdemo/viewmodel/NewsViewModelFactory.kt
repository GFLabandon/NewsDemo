package com.example.newsdemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newsdemo.repository.NewsRepository

/**
 * ViewModel 工厂：
 * 因为 NewsViewModel 有构造参数（Repository），
 * 不能直接用默认方式创建，所以要提供一个 Factory。
 */
class NewsViewModelFactory(
    private val repository: NewsRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewsViewModel::class.java)) {
            return NewsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
