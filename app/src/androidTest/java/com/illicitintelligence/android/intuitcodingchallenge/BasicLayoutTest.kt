package com.illicitintelligence.android.intuitcodingchallenge

import android.app.PendingIntent.getActivity
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test

class BasicLayoutTest {

    @get: Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testActivity(){
        onView(withText("hi there, this is another test")).check(matches(hasTextColor(R.color.textTestColor)))
        onView(withContentDescription(R.string.leftimagedrawable)).check(matches(isDisplayed()))
        onView(withId(R.id.chevron)).perform(click())
        onView(withText(activityRule.activity .getString(R.string.testOneText)))
            .inRoot(withDecorView(not(activityRule.activity.window.decorView)))
            .check(matches(isDisplayed()))
    }
}