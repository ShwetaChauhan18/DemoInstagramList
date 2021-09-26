package com.shweta.app.ui.fragment

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.shweta.app.R
import com.shweta.app.ui.activity.SampleActivity
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeFragmentTest {
    @Test
    fun testNewsFragment() {

        // launch desired activity
        val firstActivity: ActivityTestRule<SampleActivity> = ActivityTestRule(SampleActivity::class.java)
        firstActivity.launchActivity(Intent())

        onView(withId(R.id.news_dest)).perform(click())
        onView(withId(R.id.txtViewSecond)).check(matches(isDisplayed()))
    }
}