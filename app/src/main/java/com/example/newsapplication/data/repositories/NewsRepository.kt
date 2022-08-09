package com.example.newsapplication.data.repositories

import com.example.newsapplication.network.ApiService
import javax.inject.Inject

/**
 * Repository class
 */
class NewsRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getTopHeadlines() = apiService.getTopHeadlines()

    suspend fun getCategoryNews(category: String) = apiService.getCategoryNews(category = category)
}