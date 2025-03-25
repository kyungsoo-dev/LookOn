package com.musinsa.android.interview.pretest.domain

import java.net.URL

data class Goods(
    val linkURL: URL,
    val thumbnailURL: URL,
    val brandName: String,
    val price: Int,
    val saleRate: Int,
    val hasCoupon: Boolean,
)
