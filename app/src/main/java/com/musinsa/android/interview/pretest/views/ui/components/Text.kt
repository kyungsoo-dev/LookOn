package com.musinsa.android.interview.pretest.views.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.musinsa.android.interview.pretest.utils.formatToKoreanWon
import com.musinsa.android.interview.pretest.views.ui.theme.BlueGray700
import com.musinsa.android.interview.pretest.views.ui.theme.Gray500

@Composable
fun titleText(
    title: String,
    modifier : Modifier = Modifier
) {
    Text(
        modifier = modifier,
        style = MaterialTheme.typography.titleMedium,
        fontStyle = FontStyle.Normal,
        textAlign = TextAlign.Justify,
        color = BlueGray700,
        text = title
    )
}

@Composable
fun footerText(
    title: String,
    modifier : Modifier = Modifier
) {
    Text(
        style = MaterialTheme.typography.labelMedium,
        text = title
    )
}

@Composable
fun BrandNameText(
    brandName: String,
    modifier : Modifier = Modifier
) {
    Text(
        modifier = modifier.fillMaxWidth(),
        color = Gray500,
        style = MaterialTheme.typography.bodyMedium,
        text = brandName
    )
}

@Composable
fun PriceText(
    price: Int,
    textAlign: TextAlign = TextAlign.Start,
    modifier : Modifier = Modifier
) {
    Text(
        modifier = modifier,
        textAlign = textAlign,
        style = MaterialTheme.typography.labelMedium,
        text = formatToKoreanWon(price)
    )
}

@Composable
fun RateText(
    rate: Int,
    textAlign: TextAlign = TextAlign.End,
    modifier : Modifier = Modifier
) {
    Text(
        modifier = modifier,
        textAlign = textAlign,
        color = Color.Red,
        style = MaterialTheme.typography.bodySmall,
        text = rate.toString() + "%"
    )
}