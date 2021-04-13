package com.atritripathi.musk.features.crew

import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.filters.MediumTest
import com.atritripathi.musk.R
import com.atritripathi.musk.features.rocket.RocketFragment
import com.atritripathi.musk.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

@MediumTest
@HiltAndroidTest
class CrewFragmentTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun setup() {
        hiltRule.inject()
    }

//    @Test
//    fun someFun() {
//        val navController = Mockito.mock(NavController::class.java)
//        launchFragmentInHiltContainer<RocketFragment> {
//            Navigation.setViewNavController(requireView(), navController)
//            navController.navigate(R.id.crewFragment)
//        }
//    }
}