package com.atritripathi.musk.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "rocket_table")
data class Rocket(
    @Json(name = "id")
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String = "",

    @Json(name = "name")
    @ColumnInfo(name = "name")
    val name: String = "",

    @Json(name = "first_flight")
    @ColumnInfo(name = "first_flight")
    val firstFlight: String = "",

    @Json(name = "wikipedia")
    @ColumnInfo(name = "wiki_url")
    val wikiUrl: String = "",

    @Json(name = "description")
    @ColumnInfo(name = "description")
    val description: String = "",

    @Json(name = "flickr_images")
    @ColumnInfo(name = "images")
    val images: List<String> = emptyList()
)