package com.musinsa.android.interview.pretest.views.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.musinsa.android.interview.pretest.domain.Styles
import java.net.URL

@Composable
fun StyleView(
    contents: List<Styles>,
    onClick: (URL) -> Unit
) {
    val cells = 3

    var items = ArrayList<GridItem>()

    contents.forEachIndexed { index, style ->
        val gridSpan = if(index == 0)
            GridSpan(2,2)
        else
            GridSpan(1,1)

        items.add(GridItem(style, gridSpan))
    }

    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 4.dp)
    ) {
        items.chunked(cells).forEachIndexed { index, rowItems ->

            if(index == 0) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    GridItemCard(rowItems[0], Modifier.weight(2f)) { link ->
                        onClick(link)
                    }

                    Column (
                        modifier = Modifier.weight(1f)
                    ) {
                        GridItemCard(rowItems[1]) { link ->
                            onClick(link)
                        }
                        GridItemCard(rowItems[2]) { link ->
                            onClick(link)
                        }
                    }
                }

                return@forEachIndexed
            }

            Row (
                modifier = Modifier.fillMaxWidth()
            ) {
                rowItems.forEach { item ->
                    GridItemCard(item, Modifier.weight(1f)) { link ->
                        onClick(link)
                    }
                }

                if(rowItems.size < cells) {
                    for(i in 1..(cells - rowItems.size))
                        Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

@Composable
fun GridItemCard(
    item: GridItem,
    modifier: Modifier = Modifier.fillMaxWidth(),
    onClick: (URL) -> Unit
) {
    Card(
        modifier = modifier
            .padding(2.dp)
            .aspectRatio(item.span.colSpan.toFloat() / item.span.rowSpan.toFloat())
            .clickable { onClick(item.style.linkURL) },
        shape = RoundedCornerShape(1.dp)
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .weight(item.span.rowSpan.toFloat())
        ) {
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                model = item.style.thumbnailURL.toString(),
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
            )
        }
    }
}

data class GridItem(val style: Styles, val span: GridSpan)

data class GridSpan(val rowSpan: Int, val colSpan: Int)