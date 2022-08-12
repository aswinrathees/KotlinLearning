package com.opensource.viewmodellivedatawithdatabinding.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddViewModel(startingValue: Int) : ViewModel() {
    private var total = MutableLiveData<Int>()
    val totalValue: LiveData<Int> get() = total

    init {
        total.value = startingValue
    }

    fun getUpdatedValue() {
        total.value = (total.value)?.plus(1)
    }
}