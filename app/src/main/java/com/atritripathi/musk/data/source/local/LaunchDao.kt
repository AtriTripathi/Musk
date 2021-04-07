package com.atritripathi.musk.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.atritripathi.musk.data.model.Launch
import kotlinx.coroutines.flow.Flow

@Dao
interface LaunchDao {

    @Query("SELECT * FROM launch_table")
    fun getLaunches(): Flow<List<Launch>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(launches: List<Launch>)

    @Query("DELETE FROM launch_table")
    suspend fun deleteLaunches()
}