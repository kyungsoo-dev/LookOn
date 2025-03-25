package com.musinsa.android.interview.pretest.views.ui

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.musinsa.android.interview.pretest.domain.Goods
import timber.log.Timber
import java.net.URL

@Composable
fun ScrollView(
    contents: List<Goods>,
    onClick: (URL) -> Unit
) {
    val scrollState = rememberScrollState()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp)
            .horizontalScroll(scrollState),
    ) {
        contents.forEach { goods ->
            GoodsView(goods, Modifier.width(IntrinsicSize.Max)) { link ->
                onClick(link)
            }
        }
    }
}
