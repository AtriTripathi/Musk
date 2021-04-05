package com.atritripathi.musk.data

import androidx.room.withTransaction
import com.atritripathi.musk.data.source.local.MuskDatabase
import com.atritripathi.musk.data.source.remote.MuskApi
import com.atritripathi.musk.util.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MuskRepository @Inject constructor(
    private val api: MuskApi,
    private val db: MuskDatabase
) {
    private val rocketDao = db.rocketDao()

    fun getRockets() = networkBoundResource(
        query = {

            rocketDao.getRockets()
        },
        fetch = {
            delay(2000)
            api.getRockets()
        },
        saveFetchResult = { rockets ->
            db.withTransaction {
                with(rocketDao) {
                    deleteAllRockets()
                    insert(rockets)
                }
            }
        }
    )
}