package com.opensource.samples.activities.unitTests.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel(private val calculations: Calculations): ViewModel() {

    var radius = MutableLiveData<String>()

    var area = MutableLiveData<String?>()
    val areaValue: LiveData<String?> get() = area

    var circumference = MutableLiveData<String?>()
    val circumferenceValue: LiveData<String?> get() = circumference

    fun calculate() {
        try {
            val radiusDoubleValue = radius.value?.toDouble()
            when (radiusDoubleValue != null) {
                true -> {
                    calculateArea(radiusDoubleValue)
                    calculateCircumference(radiusDoubleValue)
                }
                false -> {
                    area.value = null
                    circumference.value = null
                }
            }
        } catch (t: Exception) {
            area.value = null
            circumference.value = null
        }
    }

    fun calculateArea(radius: Double) {
        val calculatedArea = calculations.calculateArea(radius)
        area.value = calculatedArea.toString()
    }

    fun calculateCircumference(radius: Double) {
        val calculatedCircumference = calculations.calculateCircumference(radius)
        circumference.value = calculatedCircumference.toString()
    }
}