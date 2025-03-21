package com.musinsa.android.interview.pretest.domain

interface Contents {
    val type: String
}

data class BannerContents(
    override val type: String,
    val banners: List<Banners>
) : Contents

data class GridContents(
    override val type: String,
    val goods: List<Goods>
) : Contents

data class ScrollContents(
    override val type: String,
    val goods: List<Goods>
) : Contents

data class StyleContents(
    override val type: String,
    val styles: List<Styles>
) : Contents
