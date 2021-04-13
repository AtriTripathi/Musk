package com.atritripathi.musk.data.source.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.filters.SmallTest
import com.atritripathi.musk.data.model.Rocket
import com.google.common.truth.Truth
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import javax.inject.Named

@SmallTest
@HiltAndroidTest
class RocketDaoTest {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Inject
    @Named("test_db")
    lateinit var database: MuskDatabase
    private lateinit var dao: RocketDao

    @Before
    fun setup() {
        hiltRule.inject()
        dao = database.rocketDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    /**
     * Unable to test Fragments currently due to issues wrt Room db and its incompatibility
     * with `launchFragmentInHiltContainer`.
     */
//    @Test
//    fun testLaunchFragmentInHiltContainer() {
//        launchFragmentInHiltContainer<RocketFragment> {
//        }
//    }

    @Test
    fun insertRockets() = runBlockingTest {
        val rocketList = getRocketsForTest()

        dao.insert(rocketList)
        val allRockets = dao.getRockets().take(1).toList().first()

        Truth.assertThat(allRockets).isEqualTo(rocketList)
    }

    @Test
    fun deleteRockets() = runBlockingTest {
        val rocketList = getRocketsForTest()

        dao.insert(rocketList)
        dao.deleteRockets()

        val allRockets = dao.getRockets().take(1).toList().first()

        Truth.assertThat(allRockets).isEmpty()
    }

    private fun getRocketsForTest(): List<Rocket> {
        val rocketOne = Rocket(
            id = "1",
            name = "Rocket 1",
            firstFlight = "01-01-2020",
            wikiUrl = "https://wikipedia.com/rocket1",
            description = "Rocket 1 description",
            images = listOf("image1", "image2")
        )
        val rocketTwo = Rocket(
            id = "2",
            name = "Rocket 2",
            firstFlight = "02-01-2020",
            wikiUrl = "https://wikipedia.com/rocket2",
            description = "Rocket 2 description",
            images = listOf("image3", "image4")
        )
        return listOf(rocketOne, rocketTwo)
    }
}