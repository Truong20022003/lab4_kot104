package com.example.lab4_kot104_ph41980



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab4_kot104_ph41980.ui.theme.Lab4_kot104_ph41980Theme

class Bai2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab4_kot104_ph41980Theme {
                val images = listOf(
                    R.drawable.logo,
                    R.drawable.aaa,
                    R.drawable.aaa2
                )
                Column {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_launcher_foreground),
                        contentDescription = "Logo",
                        modifier = Modifier.padding(16.dp)
                    )
                    HorizontalImageList(images)
                    VerticalImageList(images)
                }
            }
        }
    }
}

@Composable
fun HorizontalImageList(imageList: List<Int>) {
    val scrollState = rememberScrollState()
    Row(modifier = Modifier
        .horizontalScroll(scrollState)
        .padding(16.dp)) {
        imageList.forEachIndexed { index, image ->
            Image(
                painter = painterResource(id = image),
                contentDescription = "Image Description",
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .size(200.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .padding(
                        start = if (index == 0) 0.dp else 8.dp,
                        end = 8.dp
                    )
            )
        }
    }
}

@Composable
fun VerticalImageList(imageList: List<Int>) {
    val scrollState = rememberScrollState()
    Column(modifier = Modifier
        .verticalScroll(scrollState)
        .padding(16.dp)) {
        imageList.forEachIndexed { index, image ->
            Image(
                painter = painterResource(id = image),
                contentDescription = "Image Description",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .padding(
                        top = if (index == 0) 0.dp else 8.dp,
                        bottom = 8.dp
                    )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHorizontalImageList() {
    HorizontalImageList(listOf(R.drawable.logo, R.drawable.aaa, R.drawable.aaa2))
}

@Preview(showBackground = true)
@Composable
fun PreviewVerticalImageList() {
    VerticalImageList(listOf(R.drawable.logo, R.drawable.aaa, R.drawable.aaa2))
}
