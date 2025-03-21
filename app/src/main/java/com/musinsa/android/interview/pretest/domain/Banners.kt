package com.musinsa.android.interview.pretest.domain

import java.net.URL

data class Banners(
    val linkURL: URL,
    val thumbnailURL: URL,
    val title: String,
    val description: String,
    val keyword: String,
)
