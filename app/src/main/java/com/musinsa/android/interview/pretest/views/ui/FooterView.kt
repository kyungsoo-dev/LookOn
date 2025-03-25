package com.musinsa.android.interview.pretest.views.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.musinsa.android.interview.pretest.domain.Footer
import com.musinsa.android.interview.pretest.type.FooterType
import com.musinsa.android.interview.pretest.views.ui.theme.hspace
import timber.log.Timber

@Composable
fun FooterView(
    footer: Footer,
    onClick: (FooterType) -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(
                top = 12.dp,
                start = 16.dp,
                bottom = 4.dp,
                end = 16.dp,
            )
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(24.dp)
            )
            .clickable {
                onClick(footer.type)
            },
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier.padding(vertical = 12.dp)
        ) {
            when(footer.type) {
                FooterType.MORE -> {
                    Text(
                        text = footer.title
                    )
                }
                FooterType.REFRESH -> {
                    footer.iconURL?.let {
                        AsyncImage(
                            modifier = Modifier.padding(vertical = 2.dp),
                            model = it.toString(),
                            contentDescription = "",
                            contentScale = ContentScale.Inside
                        )
                    }
                    hspace(4)
                    Text(
                        text = footer.title
                    )
                }
                else -> {

                }
            }
        }
    }
}