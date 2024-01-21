package com.lingsi.studyimage.ui.components

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Counter() {
    // 为计数定义一个状态变量
    val count = remember { mutableStateOf(0) }

    // 使用 SideEffect 记录计数的当前值
    SideEffect {
        // 在每次重组时调用
        Log.d("lizhen", "Count is ${count.value} ")
    }

    Column {
        Button(onClick = { count.value++ }) {
//            Text("Increase Count")
            Log.d("lizhen", "Button  Count is ${count.value} ")
            Text("Increase Count ${count.value}")
        }

        ClickableText(text = AnnotatedString(""), onClick = {})

        // 每次状态更新时，文本都会更改并触发重组
//        Text(color = Color.White, text = "Counter ${count.value} ")
    }
}

@Preview
@Composable
fun previewCounter() {
    Counter()
}