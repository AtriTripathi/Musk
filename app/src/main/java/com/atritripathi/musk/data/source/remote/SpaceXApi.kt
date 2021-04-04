package com.atritripathi.musk.data.source.remote

import com.atritripathi.musk.data.model.Rocket
import retrofit2.http.GET

interface SpaceXApi {

    companion object {
        const val BASE_URL = "https://api.spacexdata.com/v4/"
    }

    @GET("rockets")
    suspend fun getRockets(): List<Rocket>

}