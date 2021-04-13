package com.atritripathi.musk.data

import com.atritripathi.musk.data.model.Crew
import com.atritripathi.musk.data.model.Launch
import com.atritripathi.musk.data.model.Rocket
import com.atritripathi.musk.util.Result
import kotlinx.coroutines.flow.Flow

interface MuskRepository {
    fun getRockets(): Flow<Result<List<Rocket>>>

    fun getCrew(): Flow<Result<List<Crew>>>

    fun getLaunches(): Flow<Result<List<Launch>>>
}