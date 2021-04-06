package com.atritripathi.musk.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "launch_table")
data class Launch(
    @Json(name = "id")
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,

    @Json(name = "name")
    @ColumnInfo(name = "name")
    val name: String,

    @Json(name = "success")
    @ColumnInfo(name = "success")
    val success: Boolean,

    @Json(name = "date_unix")
    @ColumnInfo(name = "date_unix")
    val date: Long,

    @Json(name = "links")
    @ColumnInfo(name = "link")
    val link: Link
) {
    data class Link(
        @Json(name = "wikipedia")
        val wikiUrl: String,

        @Json(name = "flickr")
        val flickr: Flickr
    )

    data class Flickr(
        @Json(name = "original")
        val url: List<String>
    )
}