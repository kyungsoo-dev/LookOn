package com.musinsa.android.interview.pretest.di

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.musinsa.android.interview.pretest.domain.BannerContents
import com.musinsa.android.interview.pretest.domain.Contents
import com.musinsa.android.interview.pretest.domain.GridContents
import com.musinsa.android.interview.pretest.domain.ScrollContents
import com.musinsa.android.interview.pretest.domain.StyleContents
import com.musinsa.android.interview.pretest.type.ContentsType
import java.lang.reflect.Type

class ContentAdapter : JsonDeserializer<Contents> {
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): Contents {
        val jsonObject = json.asJsonObject
        val type = jsonObject.get("type").asString

        return when (ContentsType.valueOf(type)) {
            ContentsType.BANNER -> context.deserialize<BannerContents>(
                json,
                BannerContents::class.java
            )

            ContentsType.GRID -> context.deserialize<GridContents>(json, GridContents::class.java)
            ContentsType.SCROLL -> context.deserialize<ScrollContents>(
                json,
                ScrollContents::class.java
            )

            ContentsType.STYLE -> context.deserialize<StyleContents>(
                json,
                StyleContents::class.java
            )
        }
    }
}