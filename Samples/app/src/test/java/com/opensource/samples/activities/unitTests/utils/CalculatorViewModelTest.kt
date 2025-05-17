package com.opensource.samples.activities.unitTests.utils

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class CalculatorViewModelTest {

    private lateinit var calculatorViewModel: CalculatorViewModel
    private lateinit var calculations: Calculations

    @get: Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        calculations = Mockito.mock(Calculations::class.java)
        Mockito.`when`(calculations.calculateArea(2.1)).thenReturn(13.8474)
        Mockito.`when`(calculations.calculateCircumference(1.0)).thenReturn(6.28)
        calculatorViewModel = CalculatorViewModel(calculations)
    }

    @Test
    fun calculateArea_radiusSent_updateLiveData() {
        calculatorViewModel.calculateArea(2.1)
        val result = calculatorViewModel.areaValue.value
        assertThat(result).isEqualTo("13.8474")
    }

    @Test
    fun calculateCircumference_radiusSent_updateLiveData() {
        calculatorViewModel.calculateCircumference(1.0)
        val result = calculatorViewModel.circumferenceValue.value
        assertThat(result).isEqualTo("6.28")
    }
}