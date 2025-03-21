package com.musinsa.android.interview.pretest.views

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.musinsa.android.interview.pretest.domain.Data
import com.musinsa.android.interview.pretest.repository.ContentsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val contentsRepository: ContentsRepository
) : ViewModel() {

    fun init() {
        viewModelScope.launch(Dispatchers.IO) {
            contentsRepository.getContents()
        }
    }

    fun getContents(): LiveData<List<Data>> = contentsRepository.contents
}