package com.musinsa.android.interview.pretest.views.ui.theme

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.musinsa.android.interview.pretest.utils.formatToKoreanWon

@Composable
fun titleText(
    title: String,
    modifier : Modifier = Modifier
) {
    Text(
        modifier = modifier,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Start,
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
        color = Color.LightGray,
        fontSize = 12.sp,
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
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
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
        fontSize = 12.sp,
        text = rate.toString() + "%"
    )
}