package com.example.gradle

import org.junit.Test

import org.junit.Assert.*
import org.threeten.bp.chrono.HijrahDate

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
        var dd =  HijrahDate.now()
    }
}