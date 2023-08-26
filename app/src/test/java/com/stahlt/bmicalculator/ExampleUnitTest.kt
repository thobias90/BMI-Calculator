package com.stahlt.bmicalculator

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun testBmiInterval() {
        val bmiCalculator = BMICalculator()
        assertTrue("BMI Check", bmiCalculator.calculate(1.9, 90.0) == "24,9")
    }
}