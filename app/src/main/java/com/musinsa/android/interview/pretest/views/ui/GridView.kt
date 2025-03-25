package com.musinsa.android.interview.pretest.views.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.musinsa.android.interview.pretest.domain.Goods
import java.net.URL

@Composable
fun GridView(
    contents: List<Goods>,
    onClick: (URL) -> Unit
) {
    val rowSize = 3

    Column (
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 4.dp)
    ) {
        contents.chunked(rowSize).forEach { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                rowItems.forEach { goods ->
                    GoodsView(goods, Modifier.weight(1f)) { link ->
                        onClick(link)
                    }
                }

                if (rowItems.size < rowSize) {
                    for(i in 1..(rowSize - rowItems.size))
                        Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}