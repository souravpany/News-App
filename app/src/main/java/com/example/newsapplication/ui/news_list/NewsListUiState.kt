package com.example.newsapplication.ui.news_list

import com.example.newsapplication.data.models.BaseResponse
import com.example.newsapplication.data.models.NewsApiResponse

/**
 * UI state for [NewsListActivity] screens
 */
data class NewsListUiState(
    var isLoading: Boolean = false,
    var newsList: BaseResponse<List<NewsApiResponse>>? = null,
    var errorMessage: String = ""
)