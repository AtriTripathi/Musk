package com.atritripathi.musk.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.atritripathi.musk.data.model.Crew
import kotlinx.coroutines.flow.Flow

@Dao
interface CrewDao {

    @Query("SELECT * FROM crew_table")
    fun getCrew(): Flow<List<Crew>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(crew: List<Crew>)

    @Query("DELETE FROM crew_table")
    suspend fun deleteCrew()
}