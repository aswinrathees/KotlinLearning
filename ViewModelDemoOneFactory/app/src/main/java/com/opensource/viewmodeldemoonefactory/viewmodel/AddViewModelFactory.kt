package com.opensource.viewmodeldemoonefactory.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.opensource.viewmodeldemoone.viewmodel.AddViewModel

class AddViewModelFactory(private val startingValue: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddViewModel::class.java)) {
            return AddViewModel(startingValue) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}