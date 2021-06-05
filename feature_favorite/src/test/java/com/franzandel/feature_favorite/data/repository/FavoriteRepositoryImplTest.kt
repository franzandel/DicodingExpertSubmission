package com.franzandel.feature_favorite.data.repository

import androidx.paging.PagingData
import androidx.paging.filter
import com.franzandel.core.wrapper.Result
import com.franzandel.feature_favorite.data.local.FavoriteLocalData
import com.franzandel.feature_favorite.domain.model.local.request.GamesResultRequest
import com.franzandel.feature_favorite.domain.repository.FavoriteRepository
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
class FavoriteRepositoryImplTest {

    private val localData: FavoriteLocalData = mockk(relaxed = true)

    private lateinit var repository: FavoriteRepository

    @Before
    fun setUp() {
        repository = FavoriteRepositoryImpl(localData)
    }

    @Test
    fun `insert games results success`() {
        runBlockingTest {
            val gamesResultRequest = RoomUtils.getGamesResultRequest()
            val fakeInsertResponse = Unit

            coEvery { localData.insertGamesResults(gamesResultRequest) } returns Result.Success(
                fakeInsertResponse
            )

            val insertGamesResults = repository.insertGamesResults(gamesResultRequest)
            val result = insertGamesResults as Result.Success
            assertNotNull(insertGamesResults)
            assertEquals(fakeInsertResponse, result.data)
        }
    }

    @Test
    fun `insert games results failed`() {
        runBlockingTest {
            val gamesResultRequest = RoomUtils.getGamesResultRequest()
            val failedResponse = RoomUtils.ERROR_INSERT_TO_DB

            coEvery { localData.insertGamesResults(gamesResultRequest) } returns Result.Error(
                Exception(failedResponse)
            )

            val insertGamesResults = repository.insertGamesResults(gamesResultRequest)
            val result = insertGamesResults as Result.Error
            assertNotNull(insertGamesResults)
            assertEquals(failedResponse, result.error.message)
        }
    }

    @Test
    fun `delete games results success`() {
        runBlockingTest {
            val gamesResultRequest = RoomUtils.getGamesResultRequest()
            val fakeSuccessResponse = Unit

            coEvery { localData.deleteGamesResults(gamesResultRequest) } returns Result.Success(
                fakeSuccessResponse
            )

            val deleteGamesResults = repository.deleteGamesResults(gamesResultRequest)
            val result = deleteGamesResults as Result.Success
            assertNotNull(deleteGamesResults)
            assertEquals(fakeSuccessResponse, result.data)
        }
    }

    @Test
    fun `delete games results failed`() {
        runBlockingTest {
            val gamesResultRequest = RoomUtils.getGamesResultRequest()
            val fakeFailedResponse = RoomUtils.ERROR_INSERT_TO_DB

            coEvery {
                localData.deleteGamesResults(gamesResultRequest)
            } returns Result.Error(Exception(fakeFailedResponse))

            val deleteGamesResults = repository.deleteGamesResults(gamesResultRequest)
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

            coEvery { localData.getGamesResults() } returns flowOf(fakePagingGamesResultRequest)

            val gamesResultsRequest = repository.getGamesResults().first().collectDataForTest()
            val fakePagingGamesResultsRequest = fakePagingGamesResultRequests.collectDataForTest()

            assertNotNull(gamesResultsRequest)
            assertEquals(gamesResultsRequest.size, fakePagingGamesResultsRequest.size)
        }
    }

    @Test
    fun `get empty favorite games`() {
        runBlockingTest {
            val fakePagingGamesResultRequest = PagingData.empty<GamesResultRequest>()

            coEvery { localData.getGamesResults() } returns emptyFlow()

            val gamesResultsRequest = repository.getGamesResults().toList()
            val fakeGamesResultsRequest = fakePagingGamesResultRequest.collectDataForTest()

            assertNotNull(gamesResultsRequest)
            assertEquals(gamesResultsRequest.size, fakeGamesResultsRequest.size)
        }
    }
}