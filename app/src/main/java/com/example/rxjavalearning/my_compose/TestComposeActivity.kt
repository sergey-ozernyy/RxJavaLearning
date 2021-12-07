package com.example.rxjavalearning.my_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Absolute.Center
import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.foundation.lazy.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rxjavalearning.R
import com.example.rxjavalearning.my_compose.ui.theme.RxJavaLearningTheme

class TestComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RxJavaLearningTheme {
                // A surface container using the 'background' color from the theme
                val testPhotoList = getTestPhotoList()
                Surface(color = MaterialTheme.colors.background) {
                    Greeting(testPhotoList)
                }
            }
        }
    }
}


@Composable
fun Greeting(testPhotoList:List<TestPhoto>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        items(testPhotoList){
            MarsImage(image = it.imageFromResource)
        }
    }
}


@Composable
fun MarsImage(image:Int){
    Image(
        painter = painterResource(id = image) ,
        contentDescription = null,
        modifier = Modifier
            //.padding(8.dp)
            .size(150.dp)
    )
}






