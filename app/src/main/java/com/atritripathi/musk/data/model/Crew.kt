package com.atritripathi.musk.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "crew_table")
data class Crew(
    @Json(name = "id")
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String = "",

    @Json(name = "name")
    @ColumnInfo(name = "name")
    val name: String = "",

    @Json(name = "image")
    @ColumnInfo(name = "image")
    val image: String = "",

    @Json(name = "wikipedia")
    @ColumnInfo(name = "wikiUrl")
    val wikiUrl: String = ""
)