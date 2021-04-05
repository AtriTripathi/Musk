package com.atritripathi.musk.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.atritripathi.musk.data.model.Rocket
import kotlinx.coroutines.flow.Flow

@Dao
interface RocketDao {

    @Query("SELECT * FROM rocket_table")
    fun getRockets(): Flow<List<Rocket>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(rockets: List<Rocket>)

    @Query("DELETE FROM rocket_table")
    suspend fun deleteAllRockets()
}