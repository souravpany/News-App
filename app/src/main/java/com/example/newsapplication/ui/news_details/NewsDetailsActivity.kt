package com.example.newsapplication.ui.news_details

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapplication.common.Constant
import com.example.newsapplication.data.models.NewsApiResponse
import com.skydoves.landscapist.glide.GlideImage

class NewsDetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                AppBar()
                DisplayNewsDetails()
            }
        }
    }

    @Composable
    fun DisplayNewsDetails() {
        val context = LocalContext.current

        intent.extras?.getParcelable<NewsApiResponse>(Constant.NEWS_DETAILS_KEY)?.let {
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .verticalScroll(rememberScrollState()) // to make the column scrollable
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                it.urlToImage?.let { urlToImage ->
                    GlideImage(
                        imageModel = urlToImage,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(350.dp)
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                it.content?.let { content -> Text(text = content) }
                Spacer(modifier = Modifier.height(10.dp))
                it.description?.let { description ->
                    Text(
                        text = description,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 15.sp
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                it.author?.let { author ->
                    Text(
                        text = "Author -$author",
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                it.url?.let { url ->
                    Text(
                        text = "Source url -> $url",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 15.sp
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                it.source?.let { source ->
                    Text(
                        text = "Source Page -> ${source.name}",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 15.sp
                    )
                }
            }
        } ?: run {
            Toast.makeText(context, "Something went wrong..!!!", Toast.LENGTH_SHORT).show()
        }
    }

    @Composable
    fun AppBar() {
        intent.extras?.getParcelable<NewsApiResponse>(Constant.NEWS_DETAILS_KEY)?.let {
            TopAppBar(title = {
                Text(
                    text = ".${it.title}.", maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            })
        }
    }
}