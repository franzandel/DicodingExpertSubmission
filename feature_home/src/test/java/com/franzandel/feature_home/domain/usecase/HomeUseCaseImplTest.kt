package com.franzandel.feature_home.domain.usecase

import androidx.paging.PagingData
import androidx.paging.filter
import com.franzandel.feature_home.domain.model.remote.response.GamesResult
import com.franzandel.feature_home.domain.repository.HomeRepository
import com.franzandel.feature_home.utils.RoomUtils
import com.franzandel.testing_utils.collectDataForTest
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

/**
 * Created by Franz Andel on 03/06/21.
 * Android Engineer
 */

@ExperimentalCoroutinesApi
class HomeUseCaseImplTest {

    private val repository: HomeRepository = mockk(relaxed = true)

    private lateinit var useCase: HomeUseCase

    @Before
    fun setUp() {
        useCase = HomeUseCaseImpl(repository)
    }

    @Test
    fun `get filled games`() {
        runBlockingTest {
            val fakePagingGamesResults = PagingData.from(RoomUtils.getGamesResults())
            val fakePagingGamesResult = fakePagingGamesResults.filter { true }

            coEvery { repository.getAllGames() } returns flowOf(fakePagingGamesResult)

            val gamesResults = useCase.getAllGames().first().collectDataForTest()
            val fakeGamesResults = fakePagingGamesResults.collectDataForTest()

            assertNotNull(gamesResults)
            assertEquals(gamesResults.size, fakeGamesResults.size)
        }
    }

    @Test
    fun `get empty games`() {
        runBlockingTest {
            val fakePagingGamesResult = PagingData.empty<GamesResult>()

            coEvery { repository.getAllGames() } returns emptyFlow()

            val gamesResults = useCase.getAllGames().toList()
            val fakeGamesResults = fakePagingGamesResult.collectDataForTest()

            assertNotNull(gamesResults)
            assertEquals(gamesResults.size, fakeGamesResults.size)
        }
    }
}