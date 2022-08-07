package com.opensource.viewmodeldemoone.viewmodel

import androidx.lifecycle.ViewModel

class AddViewModel(startingValue: Int) : ViewModel() {
    private var total: Int = 0

    init {
        total = startingValue
    }

    fun getTotal(value: Int): Int {
        total += value
        return total
    }
}