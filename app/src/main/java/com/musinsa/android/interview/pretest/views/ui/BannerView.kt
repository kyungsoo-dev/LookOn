package com.musinsa.android.interview.pretest.views.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.musinsa.android.interview.pretest.domain.Banners
import com.musinsa.android.interview.pretest.views.ui.components.vspace
import com.musinsa.android.interview.pretest.views.ui.theme.DeepOrange200
import kotlinx.coroutines.delay
import java.net.URL

@Composable
fun BannerView(
    contents: List<Banners>,
    onClick: (URL) -> Unit
) {
    var pagerState = rememberPagerState(pageCount = {Int.MAX_VALUE}, initialPage = contents.size * 100)

    val pageInteractionSource = remember { MutableInteractionSource() }
    val pageIsPressed by pageInteractionSource.collectIsPressedAsState()
    val pagerIsDragged by pagerState.interactionSource.collectIsDraggedAsState()

    // Stop auto-advancing when pager is dragged or one of the pages is pressed
    val autoAdvance = !pagerIsDragged && !pageIsPressed

    if(autoAdvance) {
        LaunchedEffect(pagerState, pageInteractionSource) {
            while (true) {
                delay(3000)
                pagerState.animateScrollToPage(pagerState.currentPage+1)
            }
        }
    }

    Box(

    ) {
        HorizontalPager(
            state = pagerState
        ) { page ->
            bannerUI(contents[page % contents.size]) { link ->
                onClick(link)
            }
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .background(Color.DarkGray),
        ) {
            val indicator = String.format("%d / %d", 1 + (pagerState.currentPage % contents.size), contents.size)

            Text(
                modifier = Modifier
                    .padding(
                        horizontal = 24.dp,
                        vertical = 0.dp
                    ),
                color = Color.White,
                fontSize = 12.sp,
                text =  indicator
            )
        }
    }
}

@Composable
private fun bannerUI(
    banners: Banners,
    onClick: (URL) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick(banners.linkURL) },
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxWidth(),
            model = banners.thumbnailURL.toString(),
            contentDescription = "",
            contentScale = ContentScale.FillWidth
        )
        if(banners.keyword.isNotEmpty()) {
            Text(
                modifier = Modifier.align(Alignment.BottomStart).padding(horizontal = 16.dp, vertical = 8.dp),
                style = MaterialTheme.typography.labelLarge,
                fontStyle = FontStyle.Normal,
                fontSize = 18.sp,
                color = DeepOrange200,
                text = banners.keyword
            )
        }
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(
                    horizontal = 24.dp,
                    vertical = 56.dp
                ),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = banners.title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White,
                textAlign = TextAlign.Center,
            )
            vspace(12)
            Text(
                text = banners.description,
                fontSize = 16.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
            )
        }
    }
}