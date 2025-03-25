package com.musinsa.android.interview.pretest.views.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.musinsa.android.interview.pretest.domain.Footer
import com.musinsa.android.interview.pretest.type.FooterType
import com.musinsa.android.interview.pretest.views.ui.components.footerText
import com.musinsa.android.interview.pretest.views.ui.theme.DeepOrange300
import com.musinsa.android.interview.pretest.views.ui.components.hspace

@Composable
fun FooterView(
    footer: Footer,
    onClick: (FooterType) -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

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
                color = if(isPressed) DeepOrange300 else Color.LightGray,
                shape = RoundedCornerShape(28.dp)
            )
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) {
                onClick(footer.type)
            },
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier.padding(vertical = if(footer.type == FooterType.REFRESH) 12.dp else 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            when(footer.type) {
                FooterType.MORE -> {
                    footerText(footer.title)
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
                    footerText(footer.title)
                }
                else -> {

                }
            }
        }
    }
}