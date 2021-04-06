package com.atritripathi.musk.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.atritripathi.musk.data.model.Crew
import com.atritripathi.musk.data.model.Rocket
import com.atritripathi.musk.util.RoomConverters

@Database(
    entities = [Rocket::class, Crew::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(RoomConverters::class)
abstract class MuskDatabase : RoomDatabase() {

    abstract fun rocketDao(): RocketDao

    abstract fun crewDao(): CrewDao

    companion object {
        const val DATABASE_NAME = "musk_database"
    }
}