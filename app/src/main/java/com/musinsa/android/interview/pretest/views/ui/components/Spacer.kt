package com.musinsa.android.interview.pretest.views.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun hspace(value: Int) {
    Spacer(
        modifier = Modifier.width(value.dp)
    )
}

@Composable
fun vspace(value: Int) {
    Spacer(
        modifier = Modifier.height(value.dp)
    )
}
