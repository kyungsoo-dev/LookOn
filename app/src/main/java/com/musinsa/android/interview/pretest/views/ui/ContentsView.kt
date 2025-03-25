package com.musinsa.android.interview.pretest.views.ui

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.musinsa.android.interview.pretest.domain.BannerContents
import com.musinsa.android.interview.pretest.domain.Banners
import com.musinsa.android.interview.pretest.domain.Contents
import com.musinsa.android.interview.pretest.domain.Data
import com.musinsa.android.interview.pretest.domain.Goods
import com.musinsa.android.interview.pretest.domain.GridContents
import com.musinsa.android.interview.pretest.domain.ScrollContents
import com.musinsa.android.interview.pretest.domain.StyleContents
import com.musinsa.android.interview.pretest.domain.Styles
import com.musinsa.android.interview.pretest.type.ContentsType
import com.musinsa.android.interview.pretest.type.FooterType
import com.musinsa.android.interview.pretest.utils.openLink
import com.musinsa.android.interview.pretest.views.MainViewModel
import timber.log.Timber
import java.net.URL

@Composable
fun ContentsView(
    context: Context,
    viewModel: MainViewModel,
    data: Data,
) {
    var footerType by remember { mutableStateOf(FooterType.NULL) }
    var forceUpdate by remember { mutableStateOf(false) }
    var default by remember { mutableStateOf(6) }

    val moreCount = 3

    Timber.w("forceUpdate is $forceUpdate / default is $default")

    val contents = processContents(data.contents, footerType, default)

    Column(modifier = Modifier.fillMaxWidth()) {
        data.header?.let {
            HeaderView(it) { link ->
                openLink(context, link.toString())
            }
        }

        renderContentsView(data.contents.type, contents) { link ->
            openLink(context, link.toString())
        }

        data.footer?.takeIf { contents.size >= default }?.let {
            FooterView(it) { type ->
                footerType = type

                when(type) {
                    FooterType.REFRESH -> forceUpdate = !forceUpdate
                    FooterType.MORE -> default += moreCount
                    else -> { }
                }
            }
        }
    }
}

@Composable
private fun renderContentsView(type: String, contents: List<Any>, onClick: (URL) -> Unit) {
    when (ContentsType.valueOf(type)) {
        ContentsType.BANNER -> BannerView(contents as List<Banners>, onClick)
        ContentsType.GRID -> GridView(contents as List<Goods>, onClick)
        ContentsType.SCROLL -> ScrollView(contents as List<Goods>, onClick)
        ContentsType.STYLE -> StyleView(contents as List<Styles>, onClick)
    }
}

private fun processContents(
    contents: Contents,
    footerType: FooterType,
    default: Int
): List<Any> {
    return when (ContentsType.valueOf(contents.type)) {
        ContentsType.BANNER -> (contents as BannerContents).banners
        ContentsType.GRID -> processListContents((contents as GridContents).goods, footerType, default)
        ContentsType.SCROLL -> processListContents((contents as ScrollContents).goods, footerType, default)
        ContentsType.STYLE -> processListContents((contents as StyleContents).styles, footerType, default)
    }
}

private fun <T> processListContents(
    contents: List<T>,
    footerType: FooterType,
    default: Int
): List<T> {
    return when (footerType) {
        FooterType.MORE -> contents.take(default.coerceAtMost(contents.size))
        FooterType.REFRESH -> contents.take(default).shuffled()
        else -> contents.take(default)
    }
}
