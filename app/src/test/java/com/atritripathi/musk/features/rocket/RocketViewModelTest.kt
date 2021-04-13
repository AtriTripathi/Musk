package com.atritripathi.musk.features.rocket

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.atritripathi.musk.MainCoroutineRule
import com.atritripathi.musk.data.FakeMuskRepository
import com.atritripathi.musk.getFakeRockets
import com.atritripathi.musk.getOrAwaitValueTest
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class RocketViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: RocketViewModel

    @Before
    fun setup() {
        viewModel = RocketViewModel(FakeMuskRepository())
    }

    @Test
    fun `Given observed rockets, matches sample test rockets`() {
        val rockets = viewModel.rockets.getOrAwaitValueTest()

        assertThat(rockets.data).isEqualTo(getFakeRockets())
    }
}