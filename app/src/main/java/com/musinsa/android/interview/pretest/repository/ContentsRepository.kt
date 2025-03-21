package com.musinsa.android.interview.pretest.repository

import androidx.lifecycle.MutableLiveData
import com.musinsa.android.interview.pretest.api.ContentsApiService
import com.musinsa.android.interview.pretest.domain.Data
import com.musinsa.android.interview.pretest.extension.asLiveData
import timber.log.Timber
import javax.inject.Inject

class ContentsRepository @Inject constructor(
    private val contentsApiService: ContentsApiService
) {
    private val _contentsLiveData = MutableLiveData<List<Data>>()
    val contents = _contentsLiveData.asLiveData()

    suspend fun getContents() {
        contentsApiService.getContents().data?.let { data ->
            _contentsLiveData.postValue(data)
        } ?: run {

        }
    }
}