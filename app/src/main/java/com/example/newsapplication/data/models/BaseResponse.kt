package com.example.newsapplication.data.models

import com.google.gson.annotations.SerializedName

data class BaseResponse<T : Any>(
    @SerializedName("status")
    var status: String,
    @SerializedName("totalResults")
    var totalResults: Int,
    @SerializedName("articles")
    var articles: T? = null
)
