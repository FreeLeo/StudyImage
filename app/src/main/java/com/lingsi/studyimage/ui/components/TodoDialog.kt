package com.lingsi.studyimage.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Composable
fun TodoDialog(onDismissRequest: () -> Unit) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp),
                verticalArrangement = Arrangement.Top, // 将元素置顶
                horizontalAlignment = Alignment.CenterHorizontally, // 水平居中
            ) {
                Text(
                    modifier = Modifier.padding(top = 16.dp),
                    text = "致各位奶爸奶妈的一封信",
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    fontFamily = specialFontFamily,
                )
                Text(
                    modifier = Modifier.padding(top = 16.dp),
                    text = "\t\t\t\t奶爸/奶妈大家好，我们是一家AIGC人工智能早教公司，致力于宝宝教育，了解生活常识和提前接触教育课程。 \n\t\t\t\t大千物语，目前有动物、瓜果、蔬菜三个品类，后续即将增加品类，以及补充每个品类的数量，请大家耐心等待，谢谢。",
                    textAlign = TextAlign.Start,
                    fontFamily = specialFontFamily,
                )
            }
        }
    }
}

@Composable
@Preview
fun previewTodoDialog() {
    TodoDialog {}
}