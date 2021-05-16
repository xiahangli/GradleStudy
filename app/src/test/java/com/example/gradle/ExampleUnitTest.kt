package com.example.gradle

import org.junit.Assert.assertEquals
import org.junit.Test
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
//        val a = AbsListViewBindingAdapter()
    }
}