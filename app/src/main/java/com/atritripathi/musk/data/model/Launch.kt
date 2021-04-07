package com.atritripathi.musk.data.model

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@Entity(tableName = "launch_table")
data class Launch(
    @Json(name = "id")
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: String = "",

    @Json(name = "name")
    @ColumnInfo(name = "name")
    val name: String = "",

    @Json(name = "success")
    @ColumnInfo(name = "success")
    val success: Boolean? = false,

    @Json(name = "details")
    @ColumnInfo(name = "details")
    val details: String? = "",

    @Json(name = "date_unix")
    @ColumnInfo(name = "date_unix")
    val date: Long = 0
) {
    val formattedDate: String?
        @RequiresApi(Build.VERSION_CODES.O)
        get() = Instant.ofEpochSecond(date).atZone(ZoneId.systemDefault()).toLocalDate()
            .format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
}