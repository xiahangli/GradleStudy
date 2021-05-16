package com.example.gradle

//import androidx.test.runner.AndroidJUnit4

import android.app.Application
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.jakewharton.threetenabp.AndroidThreeTen
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
        assertThat("com.example.gradle",CoreMatchers.equalTo("com.example.gradle1111"));
        //使用android.testVariants,通过TestVariantImpl的getCompileConfiguration().exclude(group:"xxx",module:"xxx")
        //来让这里的AndroidThreeTen不可访问
        AndroidThreeTen.init(appContext as Application);
//        assertEquals("com.example.gradle", appContext.packageName)
    }

    @Test
//    @Throws(Exception::class)
    fun testAssertThat() {
//        assertThat("xxxx", `is`(equalTo("xxxx")))
        assertThat(
            "auiehaeiueahuiheauihaeuieahuiaehuieahuaiehiaueheauihaeuihaeuiaehuiaehuiaehuiaehaeuihaei",
            CoreMatchers.equalTo("auiehaeiueahuiheauihaeuieahuiaehuieaheaiehiaueheauihaeuihaeuiaehuiaehuiaehuiaehaeuihaei")
        )
    }

    @Test
//    @Throws(Exception::class)
    fun testAssertEquals() {
        assertEquals(
            "auiehaeiueahuiheauihaeuieahuiaehuieahuaiehiaueheauihaeuihaeuiaehuiaehuiaehuiaehaeuihaei",
            "auiehaeiueahuiheauihaeuieahuiaehuieaheaiehiaueheauihaeuihaeuiaehuiaehuiaehuiaehaeuihaei"
        )
    }
}