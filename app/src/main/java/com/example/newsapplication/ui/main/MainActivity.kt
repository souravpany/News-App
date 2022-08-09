package com.example.newsapplication.ui.main

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.newsapplication.R
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapplication.util.ClsHomeGridData
import com.example.newsapplication.data.models.HomeGridData
import androidx.compose.foundation.Image
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.platform.LocalContext
import com.example.newsapplication.ui.news_list.NewsListActivity
import com.example.newsapplication.util.HomeGridCellEnum

class MainActivity : ComponentActivity() {
    private val gridData = ClsHomeGridData.loadData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                AppBar()
                GridView(gridData)
            }
        }
    }
}

@Composable
fun AppBar() {
    TopAppBar(title = { Text(text = ".N E W S.") })
}

@Composable
fun GridView(gridData: List<HomeGridData>) {
    val context = LocalContext.current
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 250.dp),
        contentPadding = PaddingValues(8.dp),
        content = {
            items(items = gridData) { item ->
                GridCell(item) { onClickedItem ->
                    when (onClickedItem.name) {
                        HomeGridCellEnum.BUSINESS,
                        HomeGridCellEnum.SCIENCE,
                        HomeGridCellEnum.ENTERTAINMENT,
                        HomeGridCellEnum.HEALTH,
                        HomeGridCellEnum.SPORTS,
                        HomeGridCellEnum.TECHNOLOGY,
                        HomeGridCellEnum.TOP_HEADLINES -> navigateToNewListScreen(
                            context,
                            onClickedItem.name
                        )
                    }
                }
            }
        }
    )
}

/**
 * Start an new activity with help of [context] and [name]
 * */
fun navigateToNewListScreen(context: Context?, name: HomeGridCellEnum) {
    val intent = Intent(context, NewsListActivity::class.java)
    intent.putExtra("news_type", name.gridName)
    context?.startActivity(intent)
}

@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("ResourceType")
@Composable
fun GridCell(item: HomeGridData, gridCells: (HomeGridData) -> Unit) {
    Card(
        modifier = Modifier.padding(4.dp),
        backgroundColor = colorResource(id = item.photoColorId),
        onClick = { gridCells.invoke(item) }
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 9.dp)
        ) {
            Image(
                painter = painterResource(id = item.photoId),
                contentDescription = item.name.gridName,
                modifier = Modifier
                    .height(40.dp)
                    .width(40.dp)
                    .background(colorResource(id = R.color.white), CircleShape)
                    .clip(CircleShape),
                colorFilter = ColorFilter.tint(colorResource(id = item.photoColorId)),
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = item.name.gridName,
                color = Color.White,
                fontSize = 16.sp,
            )
        }
    }
}
