package com.example.gradle

//import androidx.test.runner.AndroidJUnit4

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        Assert.assertThat("com.example.gradle",CoreMatchers.equalTo("com.example.gradle1111"));
//        assertEquals("com.example.gradle", appContext.packageName)
    }

    @Test
    @Throws(Exception::class)
    fun testAssertThat() {
//        assertThat("xxxx", `is`(equalTo("xxxx")))
        assertThat(
            "auiehaeiueahuiheauihaeuieahuiaehuieahuaiehiaueheauihaeuihaeuiaehuiaehuiaehuiaehaeuihaei",
            CoreMatchers.equalTo("auiehaeiueahuiheauihaeuieahuiaehuieaheaiehiaueheauihaeuihaeuiaehuiaehuiaehuiaehaeuihaei")
        )
    }

    @Test
    @Throws(Exception::class)
    fun testAssertEquals() {
        assertEquals(
            "auiehaeiueahuiheauihaeuieahuiaehuieahuaiehiaueheauihaeuihaeuiaehuiaehuiaehuiaehaeuihaei",
            "auiehaeiueahuiheauihaeuieahuiaehuieaheaiehiaueheauihaeuihaeuiaehuiaehuiaehuiaehaeuihaei"
        )
    }
}