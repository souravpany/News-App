package com.example.newsapplication.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class NewsSourceApiResponse(
    @SerializedName("id")
    var id: @RawValue String?,
    @SerializedName("name")
    var name: @RawValue String?
) : Parcelable