package com.lingsi.studyimage.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.lingsi.studyimage.data.ImageModel

@Composable
fun PreviewAllDialog(
    data: List<ImageModel>,
    onDismissRequest: () -> Unit,
    onDismiss: (Int) -> Unit
) {
    Dialog(onDismissRequest = onDismissRequest) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(600.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            LazyVerticalGrid(
                modifier = Modifier.padding(16.dp),
                columns = GridCells.Fixed(2), // 设置为两列
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                itemsIndexed(items = data) { index, imageModel ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .height(100.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .clickable {
                                onDismissRequest()
                                onDismiss(index)
                            },
                        contentAlignment = Alignment.Center,
                    ) {
                        Image(
                            painter = painterResource(id = imageModel.drawable),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop // 图片填充方式
                        )
                        Text(
                            modifier = Modifier
                                .background(Color(0xFFFFEBCD), shape = RoundedCornerShape(8.dp))
                                .padding(8.dp),
                            fontFamily = specialFontFamily,
                            text = stringResource(id = imageModel.name),
                            color = Color(0xFF8B4513)
                        )
                    }
                }
            }
        }
    }
}