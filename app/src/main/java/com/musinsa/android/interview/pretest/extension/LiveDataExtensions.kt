package com.musinsa.android.interview.pretest.extension

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.activity.ComponentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

fun <T> ComponentActivity.observeLiveData(liveData: LiveData<T>, observer: (T) -> (Unit)) {
    liveData.observe(this, Observer {
        observer.invoke(it)
    })
}

fun <T> FragmentActivity.observeLiveData(liveData: LiveData<T>, observer: (T) -> (Unit)) {
    liveData.observe(this, Observer {
        observer.invoke(it)
    })
}

fun <T> Fragment.observeLiveData(liveData: LiveData<T>, observer: (T) -> Unit) {
    liveData.observe(viewLifecycleOwner, Observer {
        observer.invoke(it)
    })
}

fun <T> MutableLiveData<T>.asLiveData() = this as LiveData<T>