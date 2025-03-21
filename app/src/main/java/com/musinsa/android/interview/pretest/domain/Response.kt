package com.musinsa.android.interview.pretest.domain

import com.google.gson.annotations.SerializedName

data class Response<T>(
    @SerializedName("data")
    val data: T?,
)
