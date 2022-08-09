package com.example.newsapplication.ui.news_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapplication.common.ApiResult
import com.example.newsapplication.domain.use_case.GetCategoryNewsUseCase
import com.example.newsapplication.domain.use_case.GetTopHeadlineUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * A [ViewModel] class for [NewsListActivity]
 * */

@HiltViewModel
class NewsListViewModel @Inject constructor(
    private val getTopHeadlineUseCase: GetTopHeadlineUseCase,
    private val getCategoryNewsUseCase: GetCategoryNewsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(NewsListUiState())
    val state: State<NewsListUiState> = _state

    fun getTopHeadLines() {
        getTopHeadlineUseCase().onEach { apiResult ->
            when (apiResult) {
                is ApiResult.Error -> {
                    _state.value = NewsListUiState(isLoading = false)
                    _state.value = NewsListUiState(
                        errorMessage = apiResult.message ?: "An Unexpected Error occured"
                    )
                }
                is ApiResult.Loading -> {
                    _state.value = NewsListUiState(isLoading = true)
                }
                is ApiResult.Success -> {
                    _state.value = NewsListUiState(isLoading = false)
                    _state.value = NewsListUiState(newsList = apiResult.data)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun getCategoryNews(categoryType: String) {
        getCategoryNewsUseCase(category = categoryType).onEach { apiResult ->
            when (apiResult) {
                is ApiResult.Error -> {
                    _state.value = NewsListUiState(isLoading = false)
                    _state.value = NewsListUiState(
                        errorMessage = apiResult.message ?: "An Unexpected Error occured"
                    )
                }
                is ApiResult.Loading -> {
                    _state.value = NewsListUiState(isLoading = true)
                }
                is ApiResult.Success -> {
                    _state.value = NewsListUiState(isLoading = false)
                    _state.value = NewsListUiState(newsList = apiResult.data)
                }
            }
        }.launchIn(viewModelScope)
    }

}