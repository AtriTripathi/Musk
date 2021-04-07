package com.atritripathi.musk.data.source.remote

import com.atritripathi.musk.data.model.Crew
import com.atritripathi.musk.data.model.Launch
import com.atritripathi.musk.data.model.Rocket
import retrofit2.http.GET

interface MuskApi {

    companion object {
        const val BASE_URL = "https://api.spacexdata.com/v4/"
    }

    @GET("rockets")
    suspend fun getRockets(): List<Rocket>

    @GET("crew")
    suspend fun getCrew(): List<Crew>

    @GET("launches")
    suspend fun getLaunches(): List<Launch>
}