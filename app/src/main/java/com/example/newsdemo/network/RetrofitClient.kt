package com.example.newsdemo.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Retrofit 单例对象
 * 整个 App 都通过这个对象访问网络接口
 */
object RetrofitClient {

    // Spaceflight News API 的根地址
    private const val BASE_URL = "https://api.spaceflightnewsapi.net/v4/"

    val apiService: NewsApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApiService::class.java)
    }
}
