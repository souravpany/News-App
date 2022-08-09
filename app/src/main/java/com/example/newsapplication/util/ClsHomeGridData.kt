package com.example.newsapplication.util

import com.example.newsapplication.R
import com.example.newsapplication.data.models.HomeGridData

object ClsHomeGridData {
    fun loadData(): List<HomeGridData> {
        return listOf(
            HomeGridData(HomeGridCellEnum.TOP_HEADLINES, com.google.android.material.R.drawable.ic_clock_black_24dp, R.color.teal_300),
            HomeGridData(HomeGridCellEnum.BUSINESS, R.drawable.ic_business, R.color.light_blue_700),
            HomeGridData(
                HomeGridCellEnum.ENTERTAINMENT,
                R.drawable.ic_entertainment,
                R.color.pink_300
            ),
            HomeGridData(HomeGridCellEnum.HEALTH, R.drawable.ic_health, R.color.light_green_300),
            HomeGridData(HomeGridCellEnum.SCIENCE, R.drawable.ic_science, R.color.purple_300),
            HomeGridData(HomeGridCellEnum.SPORTS, R.drawable.ic_sports, R.color.red_300),
            HomeGridData(HomeGridCellEnum.TECHNOLOGY, R.drawable.ic_technology, R.color.orange_300)
        )
    }
}