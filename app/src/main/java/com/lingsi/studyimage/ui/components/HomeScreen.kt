package com.lingsi.studyimage.ui.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.lingsi.studyimage.data.Category
import com.lingsi.studyimage.viewmodel.HomeViewModel

@Composable
fun HomeScreen(homeViewModel: HomeViewModel = viewModel(), navigateToMain: () -> Unit) {
    val categoryList = homeViewModel.categoryList
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(1),
            contentPadding = PaddingValues(16.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            Log.d("HomeScreen", categoryList.size.toString())
            items(categoryList.size) { index ->
                CategoryCard(category = categoryList[index], navigateToMain = navigateToMain)
            }
        }
    }
}

@Composable
fun CategoryCard(category: Category, navigateToMain: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { navigateToMain() },
        elevation = CardDefaults.cardElevation(4.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center,
        ) {
            Image(
                painter = painterResource(id = category.drawableRes),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop // 图片填充方式
            )
            if (category is Category.Unknown) {
                Text(
                    fontFamily = specialFontFamily,
                    fontSize = 30.sp,
                    text = category.name,
                    color = Color(0xFF8B4513)
                )
            }
        }
    }
}

@Composable
@Preview
private fun previewHomeScreen() {
    HomeScreen {}
}