package com.musinsa.android.interview.pretest.views.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.musinsa.android.interview.pretest.domain.Header
import com.musinsa.android.interview.pretest.views.ui.theme.titleText
import java.net.URL

@Composable
fun HeaderView(
    header: Header,
    onClick: (URL) -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxWidth()
            .padding(
                top = 16.dp,
                start = 4.dp,
                bottom = 4.dp,
                end = 4.dp,
            )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(
                    horizontal = 16.dp,
                    vertical = 12.dp
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            titleText(header.title, Modifier.widthIn(max = 200.dp))
            header.iconURL?.let {
                AsyncImage(
                    model = it.toString(),
                    contentDescription = ""
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            header.linkURL?.let {
                Text(
                    modifier = Modifier.clickable { onClick(it) },
                    textAlign = TextAlign.End,
                    color = Color.LightGray,
                    text = "전체"
                )
            }
        }
    }
}
