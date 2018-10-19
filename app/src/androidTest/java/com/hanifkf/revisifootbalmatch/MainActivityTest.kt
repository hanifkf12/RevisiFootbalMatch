package com.hanifkf.revisifootbalmatch

import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import com.hanifkf.revisifootbalmatch.R.id.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest{
    @Rule
    @JvmField var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testRecyclerViewBehaviour() {
        Thread.sleep(3000 /*Or any other time*/)
        Espresso.onView(ViewMatchers.withId(recycle_prev))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(recycle_prev)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(20))
        Espresso.onView(ViewMatchers.withId(recycle_prev)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(12, ViewActions.click()))
    }

    @Test
    fun testAppBehaviour(){
        Espresso.onView(ViewMatchers.withId(navigation))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(nav_next)).perform(ViewActions.click())

        Thread.sleep(3000)

        Espresso.onView(ViewMatchers.withId(recycle_next)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(recycle_next)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(12))
        Espresso.onView(ViewMatchers.withId(recycle_next)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(12, ViewActions.click()))

        Thread.sleep(3000)

        Espresso.onView(ViewMatchers.withId(R.id.add_to_favorite))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.add_to_favorite)).perform(ViewActions.click())

        Espresso.pressBack()


        Espresso.onView(ViewMatchers.withId(navigation))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(nav_prev)).perform(ViewActions.click())

        Thread.sleep(3000)
        Espresso.onView(ViewMatchers.withId(recycle_prev)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(recycle_prev)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(12))
        Espresso.onView(ViewMatchers.withId(recycle_prev)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(12, ViewActions.click()))
        Thread.sleep(3000)

        Espresso.pressBack()
        Espresso.onView(ViewMatchers.withId(navigation))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(nav_fav)).perform(ViewActions.click())
        Thread.sleep(3000)
    }
}