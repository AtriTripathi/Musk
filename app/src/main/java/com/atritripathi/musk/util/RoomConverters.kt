package com.atritripathi.musk.util

import androidx.room.TypeConverter

object RoomConverters {
//    private val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
//    private val link: ParameterizedType = Types.newParameterizedType(String::class.java, Link::class.java)
//    private val jsonAdapter: JsonAdapter<Link> = moshi.adapter(link)
//
//    @TypeConverter
//    fun linkToJsonString(link: Link?): String? {
//        return link?.let { jsonAdapter.toJson(link) }
//    }
//
//    @TypeConverter
//    fun jsonStringToLink(jsonString: String?): Link? {
//        return jsonString?.let { jsonAdapter.fromJson(jsonString) }
//    }

    @TypeConverter
    fun toListOfStrings(flatStringList: String?): List<String>? {
        return flatStringList?.split(",")
    }

    @TypeConverter
    fun fromListOfStrings(listOfString: List<String>?): String? {
        return listOfString?.joinToString(",")
    }
}