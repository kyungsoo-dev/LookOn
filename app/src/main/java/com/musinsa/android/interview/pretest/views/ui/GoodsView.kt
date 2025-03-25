package com.musinsa.android.interview.pretest.views.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.musinsa.android.interview.pretest.R
import com.musinsa.android.interview.pretest.domain.Goods
import com.musinsa.android.interview.pretest.views.ui.theme.Indigo500
import com.musinsa.android.interview.pretest.views.ui.components.BrandNameText
import com.musinsa.android.interview.pretest.views.ui.components.PriceText
import com.musinsa.android.interview.pretest.views.ui.components.RateText
import java.net.URL

@Composable
fun GoodsView(
    goods: Goods,
    modifier: Modifier = Modifier.fillMaxWidth(),
    onClick: (URL) -> Unit,
) {
    Column(
        modifier = modifier.padding(horizontal = 1.dp)
            .clickable { onClick(goods.linkURL) },
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
        ) {
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                model = goods.thumbnailURL.toString(),
                contentDescription = "",
                contentScale = ContentScale.FillWidth,
            )
            if(goods.hasCoupon) {
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .background(Indigo500),
                ) {
                    Text(
                        modifier = Modifier
                            .padding(
                                horizontal = 8.dp,
                                vertical = 0.dp
                            ),
                        color = Color.White,
                        fontSize = 12.sp,
                        text = stringResource(R.string.coupon),
                    )
                }
            }
        }
        BrandNameText(
            goods.brandName,
            Modifier.padding(top = 12.dp, start = 4.dp, bottom = 4.dp, end = 4.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(top = 4.dp, start = 4.dp, bottom = 4.dp, end = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PriceText(goods.price)
            RateText(goods.saleRate)
        }
    }
}