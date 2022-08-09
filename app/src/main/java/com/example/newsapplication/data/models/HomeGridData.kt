package com.example.newsapplication.data.models

import androidx.annotation.DrawableRes
import com.example.newsapplication.util.HomeGridCellEnum

data class HomeGridData(
    val name: HomeGridCellEnum,
    @DrawableRes val photoId: Int,
    @DrawableRes val photoColorId: Int,
)