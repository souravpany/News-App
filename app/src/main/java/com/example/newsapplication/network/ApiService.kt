package com.example.newsapplication.network

import com.example.newsapplication.Keys
import com.example.newsapplication.data.models.BaseResponse
import com.example.newsapplication.data.models.NewsApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(EndPoints.TOP_HEADLINES)
    suspend fun getTopHeadlines(
        @Query("country") country: String = EndPoints.COUNTRY_ID,
        @Query("apiKey") apiKey: String = Keys.apiKey()
    ): BaseResponse<List<NewsApiResponse>>

    @GET(EndPoints.TOP_HEADLINES)
    suspend fun getCategoryNews(
        @Query("country") country: String = EndPoints.COUNTRY_ID,
        @Query("category") category: String,
        @Query("apiKey") apiKey: String = Keys.apiKey()
    ): BaseResponse<List<NewsApiResponse>>

}