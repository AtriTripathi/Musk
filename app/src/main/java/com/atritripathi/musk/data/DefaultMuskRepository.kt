package com.atritripathi.musk.data

import androidx.room.withTransaction
import com.atritripathi.musk.data.source.local.MuskDatabase
import com.atritripathi.musk.data.source.remote.MuskApi
import com.atritripathi.musk.util.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultMuskRepository @Inject constructor(
    private val api: MuskApi,
    private val db: MuskDatabase
) : MuskRepository {
    private val rocketDao = db.rocketDao()
    private val crewDao = db.crewDao()
    private val launchDao = db.launchDao()

    override fun getRockets() = networkBoundResource(
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
                    deleteRockets()
                    insert(rockets)
                }
            }
        }
    )

    override fun getCrew() = networkBoundResource(
        query = {
            crewDao.getCrew()
        },
        fetch = {
            delay(2000)
            api.getCrew()
        },
        saveFetchResult = { crew ->
            db.withTransaction {
                with(crewDao) {
                    deleteCrew()
                    insert(crew)
                }
            }
        }
    )

    override fun getLaunches() = networkBoundResource(
        query = {
            launchDao.getLaunches()
        },
        fetch = {
            delay(2000)
            api.getLaunches()
        },
        saveFetchResult = { launches ->
            db.withTransaction {
                with(launchDao) {
                    deleteLaunches()
                    insert(launches)
                }
            }
        }
    )
}