package com.example.newsapplication.domain

import com.example.newsapplication.common.ApiResult
import com.example.newsapplication.data.models.BaseResponse
import com.example.newsapplication.data.models.NewsApiResponse
import com.example.newsapplication.data.repositories.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCategoryNewsUseCase @Inject constructor(
    private val repository: NewsRepository,
) {
    operator fun invoke(category: String): Flow<ApiResult<BaseResponse<List<NewsApiResponse>>>> =
        flow {
            try {
                emit(ApiResult.Loading())
                val newsHeadLines = repository.getCategoryNews(category.lowercase())
                emit(ApiResult.Success(newsHeadLines))
            } catch (e: HttpException) {
                emit(ApiResult.Error(e.localizedMessage ?: "An Unexpected error occured"))
            } catch (e: IOException) {
                emit(ApiResult.Error("Couldn't reach server. Check your internet connection"))
            }
        }
}
