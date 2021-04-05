package com.atritripathi.musk.util

import kotlinx.coroutines.flow.*

inline fun <ResultType, RequestType> networkBoundResource(
    crossinline query: () -> Flow<ResultType>,  // Local DB query
    crossinline fetch: suspend () -> RequestType,   // Remote network fetch
    crossinline saveFetchResult: suspend (RequestType) -> Unit, // Save the received from network into DB
    crossinline shouldFetch: (ResultType) -> Boolean = { true } // Lambda to make `fetch or not fetch` decision.
) = flow {

    // Only get a single list of Restaurants from the DB,
    // and not the entire flow to decide whether a new
    // network fetch request should be made or not.
    val data = query().first()

    // Check if the existing list of data is stale or not,
    // and create a flow variable to emit the results data.
    val resultFlow = if (shouldFetch(data)) {

        // Display progress bar
        emit(Result.Loading(data))

        try {
            // Save the results in DB after making
            // network request using `fetch()`.
            saveFetchResult(fetch())

            // And emit a Success state with the updated
            // data from the DB as a `Single Source of Truth`.
            query().map { Result.Success(it) }
        } catch (throwable: Throwable) {
            // Emit Error state along with the old cached
            // data from the DB, if something goes wrong.
            query().map { Result.Error(throwable, it) }
        }
    } else {
        // Emit the old cached data otherwise.
        query().map { Result.Success(it) }
    }

    emitAll(resultFlow)
}