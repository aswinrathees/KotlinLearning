package com.opensource.samples.activities.unitTests.utils

internal class Calculator : Calculations {

    private val pi: Double = 3.14

    override fun calculateCircumference(radius: Double): Double {
        return 2.0 * pi * radius
    }

    override fun calculateArea(radius: Double): Double {
        return pi * radius * radius
    }
}