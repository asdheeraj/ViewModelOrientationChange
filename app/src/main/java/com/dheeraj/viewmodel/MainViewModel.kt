package com.dheeraj.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    val count = MutableLiveData(0)
    val finishEvent = MutableLiveData<Void>()

    fun onButtonClicked() {
        count.postValue(count.value?.let { it + 1 } ?: 0)
    }

    fun onFinishClicked() {
        finishEvent.postValue(null)
    }
}