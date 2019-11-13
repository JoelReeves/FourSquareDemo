package net.joelreeves.foursquaredemo.ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import net.joelreeves.foursquaredemo.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class VenuesActivityTests {

    @get:Rule
    var activityRule: ActivityScenarioRule<VenuesActivity> = ActivityScenarioRule(VenuesActivity::class.java)

    @Test
    fun recyclerViewIsVisible() {
        onView(withId(R.id.venue_recycler_view)).check(matches(isDisplayed()))
    }

    @Test
    fun locationToolbarButtonIsVisible() {
        onView(withId(R.id.venue_location)).check(matches(isDisplayed()))
    }

    @Test
    fun searchToolbarButtonIsVisible() {
        onView(withId(R.id.venue_search)).check(matches(isDisplayed()))
    }
}