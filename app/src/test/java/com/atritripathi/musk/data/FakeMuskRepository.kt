package com.atritripathi.musk.data

import com.atritripathi.musk.data.model.Crew
import com.atritripathi.musk.data.model.Launch
import com.atritripathi.musk.data.model.Rocket
import com.atritripathi.musk.getFakeCrew
import com.atritripathi.musk.getFakeLaunches
import com.atritripathi.musk.getFakeRockets
import com.atritripathi.musk.util.Result
import com.atritripathi.musk.util.networkBoundResource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeMuskRepository : MuskRepository {

    private val fakeRockets = getFakeRockets()

    private val fakeCrew = getFakeCrew()

    private val fakeLaunches = getFakeLaunches()

    override fun getRockets(): Flow<Result<List<Rocket>>> = networkBoundResource(
        query = { flowOf(fakeRockets) },
        fetch = { fakeRockets },
        saveFetchResult = { /* NO-OP */ }
    )

    override fun getCrew(): Flow<Result<List<Crew>>> = networkBoundResource(
        query = { flowOf(fakeCrew) },
        fetch = { fakeCrew },
        saveFetchResult = { /* NO-OP */ }
    )

    override fun getLaunches(): Flow<Result<List<Launch>>> = networkBoundResource(
        query = { flowOf(fakeLaunches) },
        fetch = { fakeLaunches },
        saveFetchResult = { /* NO-OP */ }
    )
}