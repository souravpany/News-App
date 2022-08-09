package com.example.newsapplication.ui.news_list

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.newsapplication.ui.common.DisplayNewsItem
import com.example.newsapplication.util.HomeGridCellEnum
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsListActivity : ComponentActivity() {

    private val viewModel: NewsListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getNewsCategoryAndCallApi()
        setContent {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                AppBar()
                DisplayNews()
            }
        }
    }

    @Composable
    fun AppBar() {
        intent.extras?.getString("news_type")?.let {
            TopAppBar(title = { Text(text = ".$it.") })
        }
    }

    private fun getNewsCategoryAndCallApi() {
        intent.extras?.getString("news_type")?.let {
            when (it) {
                HomeGridCellEnum.TOP_HEADLINES.gridName -> {
                    viewModel.getTopHeadLines()
                }
                HomeGridCellEnum.BUSINESS.gridName -> {
                    viewModel.getCategoryNews(HomeGridCellEnum.BUSINESS.gridName)
                }
                HomeGridCellEnum.SCIENCE.gridName -> {
                    viewModel.getCategoryNews(HomeGridCellEnum.SCIENCE.gridName)
                }
                HomeGridCellEnum.ENTERTAINMENT.gridName -> {
                    viewModel.getCategoryNews(HomeGridCellEnum.ENTERTAINMENT.gridName)
                }
                HomeGridCellEnum.HEALTH.gridName -> {
                    viewModel.getCategoryNews(HomeGridCellEnum.HEALTH.gridName)
                }
                HomeGridCellEnum.SPORTS.gridName -> {
                    viewModel.getCategoryNews(HomeGridCellEnum.SPORTS.gridName)
                }
                HomeGridCellEnum.TECHNOLOGY.gridName -> {
                    viewModel.getCategoryNews(HomeGridCellEnum.TECHNOLOGY.gridName)
                }
            }
        }
    }

    @Composable
    fun DisplayNews() {
        val context = LocalContext.current
        val isLoading = viewModel.state.value.isLoading
        val newsList = viewModel.state.value.newsList
        if (isLoading) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.padding(5.dp)
            ) {
                newsList?.articles?.let { result ->
                    items(result) { item ->
                        DisplayNewsItem(newsApiResponse = item) {
                            Toast.makeText(context, "Not Implemented..!!", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }
            }
        }
    }
}