package com.atritripathi.musk.data.model

import com.squareup.moshi.Json

data class Rocket(
    @Json(name = "id") val id: String = "",
    @Json(name = "name") val name: String = "",
    @Json(name = "first_flight") val firstFlight: String = "",
    @Json(name = "wikipedia") val wikiUrl: String = "",
    @Json(name = "description") val description: String = "",
    @Json(name = "flickr_images") val images: List<String> = emptyList()
)