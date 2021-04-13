package com.atritripathi.musk.features.launch

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.atritripathi.musk.MainCoroutineRule
import com.atritripathi.musk.data.FakeMuskRepository
import com.atritripathi.musk.getFakeLaunches
import com.atritripathi.musk.getOrAwaitValueTest
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LaunchViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: LaunchViewModel

    @Before
    fun setUp() {
        viewModel = LaunchViewModel(FakeMuskRepository())
    }

    @Test
    fun `Given observed launches, matches sample test launches`() {
        val launches = viewModel.launches.getOrAwaitValueTest()

        assertThat(launches.data).isEqualTo(getFakeLaunches())
    }
}