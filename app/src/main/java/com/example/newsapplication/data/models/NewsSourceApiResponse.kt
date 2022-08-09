package com.example.newsapplication.data.models

import com.google.gson.annotations.SerializedName

data class NewsSourceApiResponse(
    @SerializedName("id")
    var id: String?,
    @SerializedName("name")
    var name: String?
)