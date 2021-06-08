package com.franzandel.feature_home.data.repository

import com.franzandel.core.wrapper.Result
import com.franzandel.feature_home.data.local.DetailHomeLocalData
import com.franzandel.feature_home.domain.repository.DetailHomeRepository
import com.franzandel.feature_home.utils.RoomUtils
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
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
class DetailHomeRepositoryImplTest {

    private val localData: DetailHomeLocalData = mockk(relaxed = true)

    private lateinit var repository: DetailHomeRepository

    @Before
    fun setUp() {
        repository = DetailHomeRepositoryImpl(localData)
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
            val fakeFailedResponse = RoomUtils.ERROR_DELETE_FROM_DB

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
    fun `get games results found`() {
        runBlockingTest {
            val gameName = "Devil May Cry"
            val fakeGamesResult = RoomUtils.getGamesResultRequest()

            coEvery { localData.getGamesResults(gameName) } returns Result.Success(fakeGamesResult)

            val gamesResult = repository.getGamesResult(gameName)
            val result = gamesResult as Result.Success
            assertNotNull(gamesResult)
            assertEquals(fakeGamesResult, result.data)
        }
    }

    @Test
    fun `get games results not found`() {
        runBlockingTest {
            val gameName = "Devil May Cry"
            val fakeFailedResponse = RoomUtils.NO_DATA_FOUND

            coEvery { localData.getGamesResults(gameName) } returns Result.Error(
                Exception(
                    fakeFailedResponse
                )
            )

            val gamesResult = repository.getGamesResult(gameName)
            val result = gamesResult as Result.Error
            assertNotNull(gamesResult)
            assertEquals(fakeFailedResponse, result.error.message)
        }
    }
}