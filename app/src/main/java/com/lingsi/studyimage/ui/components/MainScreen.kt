package com.lingsi.studyimage.ui.components

import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.lingsi.studyimage.R
import com.lingsi.studyimage.data.ImageModel
import com.lingsi.studyimage.viewmodel.MainViewModel

// https://developer.android.com/jetpack/compose/text/fonts?hl=zh-cn
val specialFontFamily = FontFamily(
    Font(R.font.san_ji_kai_ti, FontWeight(950))
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen(mainViewModel: MainViewModel = viewModel()) {
    val pagerState = rememberPagerState()
    var shouldShowDialog by remember { mutableStateOf(false) }
    var selectedPageIndex by remember { mutableStateOf(0) }
    Box(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(
            modifier = Modifier.fillMaxSize(),
            pageCount = mainViewModel.dataList.size,
            state = pagerState,
            reverseLayout = false
        ) { page ->
            ImageItem(mainViewModel.dataList[page],
                { context, soundResId -> mainViewModel.play(context, soundResId) },
                { mainViewModel.stop() })
        }
        Text(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(8.dp)
                .background(Color(0xFFFF6100), shape = RoundedCornerShape(8.dp))
                .clip(RoundedCornerShape(8.dp))
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple(bounded = true),
                    onClick = { shouldShowDialog = true },
                )
                .padding(8.dp),
            text = "预览",
            fontFamily = specialFontFamily,
            color = Color.White,
            fontSize = 20.sp
        )
        if (shouldShowDialog) {
            PreviewAllDialog(
                data = mainViewModel.dataList,
                onDismissRequest = { shouldShowDialog = false },
                onDismiss = { index -> selectedPageIndex = index })
        }
    }
    LaunchedEffect(pagerState.currentPage) {
        mainViewModel.stop()
    }
    LaunchedEffect(selectedPageIndex) {
        pagerState.animateScrollToPage(selectedPageIndex)
    }
}

@Composable
fun ImageItem(
    imageModel: ImageModel,
    onPlaySound: (Context, Int) -> Unit,
    onStopSound: () -> Unit
) {
    val state = remember { imageModel }
    state.aa()
    SideEffect {
        state.aa()
    }
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
                .padding(top = 0.dp, bottom = 0.dp)
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

    MainScreen()
}