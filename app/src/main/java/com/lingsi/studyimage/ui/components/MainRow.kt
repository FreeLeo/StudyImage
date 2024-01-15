package com.lingsi.studyimage.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lingsi.studyimage.R
import com.lingsi.studyimage.data.ImageModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainPager(items: List<ImageModel>) {
    val pagerState = rememberPagerState()
    HorizontalPager(
        pageCount = 10,
        state = pagerState,
        modifier = Modifier.fillMaxSize()
    ) { page ->
        ImageItem(items[page])
    }
}

@Composable
fun ImageItem(imageModel: ImageModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .background(Color.White)
    ) {
        // 显示全屏图片
        Image(
            painter = painterResource(id = imageModel.drawable),
            contentDescription = null, // 适当的内容描述
            modifier = Modifier
                .weight(1f)
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // 在图片的底部显示文本
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 50.dp, bottom = 50.dp),
            text = stringResource(id = imageModel.name),
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
        )
    }
}

@Preview
@Composable
private fun previewMainRow() {
    val list = arrayListOf<ImageModel>()
    for (i in 0 until 10) {
        val elephant = ImageModel(R.string.elephant, R.drawable.elephant)
        list.add(elephant)
    }
    MainPager(items = list)
}