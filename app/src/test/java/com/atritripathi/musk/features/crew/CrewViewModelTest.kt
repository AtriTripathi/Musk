package com.atritripathi.musk.features.crew

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.atritripathi.musk.MainCoroutineRule
import com.atritripathi.musk.data.FakeMuskRepository
import com.atritripathi.musk.getFakeCrew
import com.atritripathi.musk.getOrAwaitValueTest
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CrewViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: CrewViewModel

    @Before
    fun setup() {
        viewModel = CrewViewModel(FakeMuskRepository())
    }

    @Test
    fun `Given observed crew, matches sample test crew`() {
        val crew = viewModel.crew.getOrAwaitValueTest()

        assertThat(crew.data).isEqualTo(getFakeCrew())
    }
}