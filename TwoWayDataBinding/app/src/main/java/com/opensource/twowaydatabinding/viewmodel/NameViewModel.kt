package com.opensource.twowaydatabinding.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NameViewModel: ViewModel() {

    val name = MutableLiveData<String>()

    init {
        name.value = "Aswin"
    }
}