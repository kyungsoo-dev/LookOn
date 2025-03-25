package com.musinsa.android.interview.pretest.views

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.musinsa.android.interview.pretest.domain.Data
import com.musinsa.android.interview.pretest.extension.asLiveData
import com.musinsa.android.interview.pretest.repository.ContentsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val contentsRepository: ContentsRepository
) : ViewModel() {

    private val _bannerLiveData = MutableLiveData<Data>()
    val banner = _bannerLiveData.asLiveData()

    private val _gridLiveData = MutableLiveData<Data>()
    val grid = _gridLiveData.asLiveData()

    private val _scrollLiveData = MutableLiveData<Data>()
    val scroll = _scrollLiveData.asLiveData()

    private val _styleLiveData = MutableLiveData<Data>()
    val style = _styleLiveData.asLiveData()

    fun init() {
        viewModelScope.launch(Dispatchers.IO) {
            contentsRepository.getContents()
        }
    }

    fun getContents(): LiveData<List<Data>> = contentsRepository.contents

    fun setBannerData(data: Data) { _bannerLiveData.value = data }
    fun getBannerData(): LiveData<Data> = banner

    fun setGridData(data: Data) { _gridLiveData.value = data }
    fun getGridData(): LiveData<Data> = grid

    fun setScrollData(data: Data) { _scrollLiveData.value = data }
    fun getScrollData(): LiveData<Data> = scroll

    fun setStyleData(data: Data) { _styleLiveData.value = data }
    fun getStyleData(): LiveData<Data> = style
}