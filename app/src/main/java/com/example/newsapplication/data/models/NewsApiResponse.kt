package com.example.newsapplication.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class NewsApiResponse(
    @SerializedName("source")
    var source: @RawValue NewsSourceApiResponse?,
    @SerializedName("author")
    var author: @RawValue String?,
    @SerializedName("title")
    var title: @RawValue String?,
    @SerializedName("description")
    var description: @RawValue String?,
    @SerializedName("url")
    var url: @RawValue String?,
    @SerializedName("urlToImage")
    var urlToImage: @RawValue String?,
    @SerializedName("publishedAt")
    var publishedAt: @RawValue String?,
    @SerializedName("content")
    var content: @RawValue String?
) : Parcelable