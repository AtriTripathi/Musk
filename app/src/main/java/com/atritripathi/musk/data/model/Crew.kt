package com.atritripathi.musk.data.model

import com.squareup.moshi.Json

data class Crew(
    @Json(name = "id") val id: String = "",
    @Json(name = "name") val name: String = "",
    @Json(name = "image") val image: String = "",
    @Json(name = "wikipedia") val wikiUrl: String = ""
)