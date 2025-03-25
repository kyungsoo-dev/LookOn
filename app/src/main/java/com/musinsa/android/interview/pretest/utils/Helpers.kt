package com.musinsa.android.interview.pretest.utils

import android.content.Context
import android.content.Intent
import androidx.core.net.toUri
import java.text.DecimalFormat

fun openLink(context: Context, link: String) {
    val intent = Intent(Intent.ACTION_VIEW, link.toUri())

    context.startActivity(intent)
}

fun formatToKoreanWon(amount: Int): String {
    val formatter = DecimalFormat("#,###")
    return "${formatter.format(amount)}원"
}