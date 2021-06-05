package com.franzandel.feature_favorite.domain.usecase

import androidx.paging.PagingData
import androidx.paging.filter
import com.franzandel.core.mapper.BaseMapper
import com.franzandel.core.wrapper.Result
import com.franzandel.feature_favorite.domain.model.local.request.GamesResultRequest
import com.franzandel.feature_favorite.domain.repository.FavoriteRepository
import com.franzandel.feature_favorite.presentation.mapper.GamesResultsRequestMapper
import com.franzandel.feature_favorite.presentation.model.GamesResultUI
import com.franzandel.feature_favorite.utils.RoomUtils
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
class FavoriteUseCaseImplTest {

    private val repository: FavoriteRepository = mockk(relaxed = true)

    private lateinit var useCase: FavoriteUseCase

    private val mapper: BaseMapper<GamesResultUI, GamesResultRequest> = GamesResultsRequestMapper()

    @Before
    fun setUp() {
        useCase = FavoriteUseCaseImpl(repository, mapper)
    }

    @Test
    fun `insert games results success`() {
        runBlockingTest {
            val gamesResultRequest = RoomUtils.getGamesResultRequest()
            val gamesResultUI = RoomUtils.getGamesResultUI()
            val fakeInsertResponse = Unit

            coEvery { repository.insertGamesResults(gamesResultRequest) } returns Result.Success(
                fakeInsertResponse
            )

            val insertGamesResults = useCase.insertGamesResults(gamesResultUI)
            val result = insertGamesResults as Result.Success
            assertNotNull(insertGamesResults)
            assertEquals(fakeInsertResponse, result.data)
        }
    }

    @Test
    fun `insert games results failed`() {
        runBlockingTest {
            val gamesResultRequest = RoomUtils.getGamesResultRequest()
            val gamesResultUI = RoomUtils.getGamesResultUI()
            val failedResponse = RoomUtils.ERROR_INSERT_TO_DB

            coEvery { repository.insertGamesResults(gamesResultRequest) } returns Result.Error(
                Exception(failedResponse)
            )

            val insertGamesResults = useCase.insertGamesResults(gamesResultUI)
            val result = insertGamesResults as Result.Error
            assertNotNull(insertGamesResults)
            assertEquals(failedResponse, result.error.message)
        }
    }

    @Test
    fun `delete games results success`() {
        runBlockingTest {
            val gamesResultRequest = RoomUtils.getGamesResultRequest()
            val gamesResultUI = RoomUtils.getGamesResultUI()
            val fakeSuccessResponse = Unit

            coEvery { repository.deleteGamesResults(gamesResultRequest) } returns Result.Success(
                fakeSuccessResponse
            )

            val deleteGamesResults = useCase.deleteGamesResults(gamesResultUI)
            val result = deleteGamesResults as Result.Success
            assertNotNull(deleteGamesResults)
            assertEquals(fakeSuccessResponse, result.data)
        }
    }

    @Test
    fun `delete games results failed`() {
        runBlockingTest {
            val gamesResultRequest = RoomUtils.getGamesResultRequest()
            val gamesResultUI = RoomUtils.getGamesResultUI()
            val fakeFailedResponse = RoomUtils.ERROR_INSERT_TO_DB

            coEvery {
                repository.deleteGamesResults(gamesResultRequest)
            } returns Result.Error(Exception(fakeFailedResponse))

            val deleteGamesResults = useCase.deleteGamesResults(gamesResultUI)
            val result = deleteGamesResults as Result.Error
            assertNotNull(deleteGamesResults)
            assertEquals(fakeFailedResponse, result.error.message)
        }
    }

    @Test
    fun `get filled favorite games`() {
        runBlockingTest {
            val fakePagingGamesResultRequests = PagingData.from(RoomUtils.getGamesResultRequests())
            val fakePagingGamesResultRequest = fakePagingGamesResultRequests.filter { true }

            coEvery { repository.getGamesResults() } returns flowOf(fakePagingGamesResultRequest)

            val gamesResultsRequest = useCase.getGamesResults().first().collectDataForTest()
            val fakePagingGamesResultsRequest = fakePagingGamesResultRequests.collectDataForTest()

            assertNotNull(gamesResultsRequest)
            assertEquals(gamesResultsRequest.size, fakePagingGamesResultsRequest.size)
        }
    }

    @Test
    fun `get empty favorite games`() {
        runBlockingTest {
            val fakePagingGamesResultRequest = PagingData.empty<GamesResultRequest>()

            coEvery { repository.getGamesResults() } returns emptyFlow()

            val gamesResultsRequest = useCase.getGamesResults().toList()
            val fakeGamesResultsRequest = fakePagingGamesResultRequest.collectDataForTest()

            assertNotNull(gamesResultsRequest)
            assertEquals(gamesResultsRequest.size, fakeGamesResultsRequest.size)
        }
    }
}