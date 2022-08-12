package com.opensource.viewmodellivedatawithdatabinding.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AddViewModelFactory(private val startingValue: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddViewModel::class.java)) {
            return AddViewModel(startingValue) as T
        }
        throw IllegalArgumentException("Unknown parameter")
    }
}