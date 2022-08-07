package com.opensource.viewmodeldemoone.viewmodel

import androidx.lifecycle.ViewModel

class CountViewModel : ViewModel() {
    private var count: Int = 0
    private var total:Int =0

    fun getCurrentCount(): Int {
        return count
    }

    fun getUpdatedCount(): Int {
        return ++count
    }

    fun getTotal(value:Int) : Int {
        total += value
        return total
    }
}