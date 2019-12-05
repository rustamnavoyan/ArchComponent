package com.rustamnavoyan.fragmentviewmodel.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import java.lang.NumberFormatException

class MainViewModel : ViewModel() {
    private val stringObservable: MutableLiveData<String> = MutableLiveData<String>()
    val integerMapObservable: LiveData<Int> = Transformations.map(stringObservable) {
        try {
            Integer.valueOf(it)
        } catch (e: NumberFormatException) {
            -1
        }
    }

    private var switchLiveData: MutableLiveData<Int> = MutableLiveData<Int>()

    val integerSwitchMapObservable: LiveData<Int> = Transformations.switchMap(stringObservable) {
        renewSwitchLiveData()
        switchLiveData
    }

    private fun renewSwitchLiveData() {
        switchLiveData  = MutableLiveData<Int>()
    }

    fun addValue(string: String) {
        stringObservable.value = string
    }

    fun changeSwitchLiveData() {
        switchLiveData.value = 10
    }
}
