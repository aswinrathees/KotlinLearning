package com.opensource.samples.activities.unitTests.utils

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class CalculatorTest {

    private lateinit var calculator: Calculator

    @Before
    fun setUp() {
        calculator = Calculator()
    }

    // Format: SubjectUnderTest_actionOrInput_resultState
    @Test
    fun calculateCircumference_radiusGiven_returnsCorrectResult() {
        val result = calculator.calculateCircumference(2.1)
        assertThat(result).isEqualTo(13.188)
    }

    @Test
    fun calculateArea_radiusGiven_returnsCorrectResult() {
        val result = calculator.calculateArea(1.0)
        assertThat(result).isEqualTo(3.14)
    }
}