package com.musinsa.android.interview.pretest.views

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.musinsa.android.interview.pretest.type.ContentsType
import com.musinsa.android.interview.pretest.views.ui.ContentsView
import com.musinsa.android.interview.pretest.views.ui.theme.LookOnTheme
import com.musinsa.android.interview.pretest.views.ui.components.vspace
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    private val context by lazy {
        this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LookOnTheme {
                mainView(context, viewModel)
            }
        }
        init()
    }

    private fun init() {
        viewModel.init()
    }
}

@Composable
private fun mainView(
    context: Context,
    viewModel: MainViewModel
) {
    val result by viewModel.getContents().observeAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
                .fillMaxSize()
        ) {
            val scrollState = rememberScrollState()

            Column (
                modifier = Modifier.fillMaxSize()
                    .verticalScroll(scrollState),
            ) {
                result?.forEach { data ->
                    when(
                        ContentsType.valueOf(data.contents.type)
                    ) {
                        ContentsType.BANNER -> viewModel.setBannerData(data)
                        ContentsType.GRID -> viewModel.setGridData(data)
                        ContentsType.SCROLL -> viewModel.setScrollData(data)
                        ContentsType.STYLE -> viewModel.setStyleData(data)
                    }

                    ContentsView(context, viewModel, data)
                }
                vspace(24)
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
    LookOnTheme {
        Greeting("Android")
    }
}