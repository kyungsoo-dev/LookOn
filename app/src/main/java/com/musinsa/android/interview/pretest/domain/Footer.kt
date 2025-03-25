package com.musinsa.android.interview.pretest.domain

import com.musinsa.android.interview.pretest.type.FooterType
import java.net.URL

data class Footer(
    val type: FooterType,
    val title: String,
    val iconURL: URL?,
    val linkURL: URL?,
)
