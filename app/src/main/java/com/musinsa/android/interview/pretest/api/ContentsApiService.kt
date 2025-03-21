package com.musinsa.android.interview.pretest.api

import com.musinsa.android.interview.pretest.domain.Data
import com.musinsa.android.interview.pretest.domain.Response
import retrofit2.http.GET

interface ContentsApiService {

    @GET("/interview/list.json")
    suspend fun getContents(): Response<List<Data>>

}