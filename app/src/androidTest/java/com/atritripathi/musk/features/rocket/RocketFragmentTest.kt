package com.atritripathi.musk.features.rocket

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.MediumTest
import com.atritripathi.musk.R
import com.atritripathi.musk.data.model.Rocket
import com.atritripathi.musk.features.rocket.RocketAdapter.RocketViewHolder
import com.atritripathi.musk.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

@MediumTest
@HiltAndroidTest
class RocketFragmentTest {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        hiltRule.inject()
    }

//    @Test
//    fun clickRocketItem_opensWikipedia() {
//        val rocket = Rocket("1", "Rocket name", wikiUrl = "testUrl")
//        val navController = mock(NavController::class.java)
//        launchFragmentInHiltContainer<RocketFragment> {
//            Navigation.setViewNavController(requireView(), navController)
//            rocketAdapter.submitList(listOf(rocket))
//        }
//
//        onView(withId(R.id.rvRocket)).perform(
//            RecyclerViewActions.actionOnItemAtPosition<RocketViewHolder>(
//                0,
//                click()
//            )
//        )
//
//        verify(navController).navigate(
//            RocketFragmentDirections.actionGlobalWebViewFragment("testUrl")
//        )
//    }

}