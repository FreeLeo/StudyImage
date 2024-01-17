package com.lingsi.studyimage.ui.components

import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lingsi.studyimage.R
import com.lingsi.studyimage.data.ImageModel
import com.lingsi.studyimage.viewmodel.MainViewModel

// https://developer.android.com/jetpack/compose/text/fonts?hl=zh-cn
val specialFontFamily = FontFamily(
    Font(R.font.san_ji_kai_ti, FontWeight(950))
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainPager(mainViewModel: MainViewModel, items: List<ImageModel>) {
    val pagerState = rememberPagerState()
    HorizontalPager(
        pageCount = 10,
        state = pagerState,
        modifier = Modifier.fillMaxSize()
    ) { page ->
        ImageItem(items[page],
            { context, soundResId -> mainViewModel.play(context, soundResId) },
            { mainViewModel.stop() })
    }
    LaunchedEffect(pagerState.currentPage) {
        mainViewModel.stop()
    }
}

@Composable
fun ImageItem(
    imageModel: ImageModel,
    onPlaySound: (Context, Int) -> Unit,
    onStopSound: () -> Unit
) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth()
            .fillMaxSize()
            .widthIn(max = 1080.dp)
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = imageModel.drawable),
            contentDescription = null, // 适当的内容描述
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )

        Text(
            fontFamily = specialFontFamily,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 20.dp, bottom = 0.dp)
                .clickable {
                    onPlaySound(context, imageModel.nameAudio)
                },
            text = stringResource(id = imageModel.namePinYin),
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
        )

        Text(
            fontFamily = specialFontFamily,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 10.dp, bottom = 0.dp)
                .clickable {
                    onPlaySound(context, imageModel.nameAudio)
                },
            text = stringResource(id = imageModel.name),
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
        )

        Text(
            fontFamily = specialFontFamily,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 10.dp, bottom = 20.dp, start = 10.dp, end = 10.dp)
                .clickable {
                    onPlaySound(context, imageModel.storyAudio)
                },
            text = stringResource(id = imageModel.description),
            color = Color.Black,
            fontSize = 20.sp,
            textAlign = TextAlign.Start,
        )
    }
}

@Preview
@Composable
private fun previewMainPage() {
    val list = arrayListOf<ImageModel>()
    for (i in 0 until 10) {
        val elephant = ImageModel(
            R.string.elephant_pinyin,
            R.string.elephant,
            R.drawable.elephant,
            R.string.elephant_des,
            R.raw.elephant,
            R.raw.elephant_story,
        )
        list.add(elephant)
    }
    MainPager(MainViewModel(), items = list)
}