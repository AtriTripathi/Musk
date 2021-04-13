package com.atritripathi.musk

import com.atritripathi.musk.data.model.Crew
import com.atritripathi.musk.data.model.Launch
import com.atritripathi.musk.data.model.Rocket

fun getFakeRockets() = listOf(
    Rocket("1", "Rocket 1", "01-01-2020", "wikiUrl1", "Desc 1"),
    Rocket("2", "Rocket 2", "02-01-2020", "wikiUrl2", "Desc 2"),
    Rocket("3", "Rocket 3", "03-01-2020", "wikiUrl3", "Desc 3")
)

fun getFakeCrew() = listOf(
    Crew("1", "Crew 1", "imageUrl1", "wikiUrl1"),
    Crew("2", "Crew 2", "imageUrl2", "wikiUrl2"),
    Crew("3", "Crew 3", "imageUrl3", "wikiUrl3")
)

fun getFakeLaunches() = listOf(
    Launch("1", "Crew 1", true, "Details 1", 12345L),
    Launch("2", "Crew 2", false, "Details 2", 12345L),
    Launch("3", "Crew 3", true, "Details 3", 12345L)
)