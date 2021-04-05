package com.atritripathi.musk.util

import androidx.room.TypeConverter

object RoomConverters {

    @TypeConverter
    fun toListOfStrings(flatStringList: String?): List<String>? {
        return flatStringList?.split(",")
    }

    @TypeConverter
    fun fromListOfStrings(listOfString: List<String>?): String? {
        return listOfString?.joinToString(",")
    }
}