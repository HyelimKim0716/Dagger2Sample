package com.example.dagger2sample

import android.support.test.InstrumentationRegistry
import android.support.test.filters.SmallTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.widget.Button
import android.widget.TextView
import com.example.dagger2sample.di.DaggerCafeComponent
import com.example.dagger2sample.di.NewCoffeeComponent
import org.hamcrest.CoreMatchers.`is`

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@SmallTest
class ExampleInstrumentedTest {
   @get:Rule
    public val mActivityRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    private val mainActivity: MainActivity by lazy {
        mActivityRule.activity
    }
    lateinit var cafeComponent: NewCoffeeComponent


    @Before
    fun setUp() {
//        cafeComponent = DaggerCafeComponent.create().coffeeComponent().build()

    }


    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.example.dagger2sample", appContext.packageName)

        val myName = mActivityRule.activity.getString(R.string.my_name)
        assertThat("HiHi", `is`(myName))
//        cafeComponent.coffeeMaker()

        mainActivity.runOnUiThread({
            mainActivity.findViewById<Button>(R.id.btnTest).performClick()
        })

        Thread.sleep(1000)

        assertEquals("text should be refreshed", "TEST", mainActivity.findViewById<TextView>(R.id.tvTest).text)


    }
}
