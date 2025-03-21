package com.musinsa.android.interview.pretest.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.musinsa.android.interview.pretest.domain.BannerContents
import com.musinsa.android.interview.pretest.domain.GridContents
import com.musinsa.android.interview.pretest.domain.ScrollContents
import com.musinsa.android.interview.pretest.domain.StyleContents
import com.musinsa.android.interview.pretest.extension.observeLiveData
import com.musinsa.android.interview.pretest.type.ContentsType
import com.musinsa.android.interview.pretest.views.ui.theme.LookOnTheme
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LookOnTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        init()
    }

    private fun init() {
        observeLiveData(viewModel.getContents()) { result ->
            result.forEach { data ->

                val contents = data.contents

                when(ContentsType.valueOf(contents.type)) {
                    ContentsType.BANNER -> {
                        val banners = (contents as BannerContents).banners
                    }
                    ContentsType.GRID -> {
                        val goods = (contents as GridContents).goods
                    }
                    ContentsType.SCROLL -> {
                        val goods = (contents as ScrollContents).goods
                    }
                    ContentsType.STYLE -> {
                        val styles = (contents as StyleContents).styles
                   }
                }
            }
        }

        viewModel.init()
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
    LookOnTheme {
        Greeting("Android")
    }
}