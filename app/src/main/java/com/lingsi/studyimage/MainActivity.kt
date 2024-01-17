package com.lingsi.studyimage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lingsi.studyimage.data.ImageModel
import com.lingsi.studyimage.ui.components.MainPager
import com.lingsi.studyimage.ui.theme.StudyImageTheme
import com.lingsi.studyimage.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val list = arrayListOf<ImageModel>()
        for (i in 0 until 10) {
            val elephant =
                ImageModel(
                    R.string.elephant_pinyin,
                    R.string.elephant,
                    R.drawable.elephant,
                    R.string.elephant_des,
                    R.raw.elephant,
                    R.raw.elephant_story,
                )
            list.add(elephant)
        }
        setContent {
            StudyImageTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainPager(mainViewModel, items = list)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StudyImageTheme {
        Greeting("Android")
    }
}