package com.atritripathi.musk.data.model

import com.google.common.truth.Truth.assertThat
import org.junit.Test


class LaunchTest {

    @Test
    fun `Given epoch in seconds, when converted to date, then returns correct date`() {
        val epochInSeconds = 1617945496L
        val launch = Launch(date = epochInSeconds)

        val dateString = launch.formattedDate

        assertThat(dateString).isEqualTo("09-04-2021")
    }
}