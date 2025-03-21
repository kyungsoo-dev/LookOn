package com.musinsa.android.interview.pretest.di

import com.google.gson.GsonBuilder
import com.musinsa.android.interview.pretest.api.ContentsApiService
import com.musinsa.android.interview.pretest.domain.Contents
import com.musinsa.android.interview.pretest.http.EnumConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @LookOnApi
    @Singleton
    @Provides
    fun provideRetrofitByLookOnApi(@LookOnHttp okHttpClient: OkHttpClient): Retrofit {
        val gson = GsonBuilder()
            .registerTypeAdapter(Contents::class.java, ContentAdapter()) // Content 타입 변환기 추가
            .create()

        return Retrofit.Builder()
            .baseUrl("https://meta.musinsa.com")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addConverterFactory(EnumConverterFactory())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideContentsApiService(@LookOnApi retrofit: Retrofit): ContentsApiService = retrofit.create(ContentsApiService::class.java)
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LookOnApi