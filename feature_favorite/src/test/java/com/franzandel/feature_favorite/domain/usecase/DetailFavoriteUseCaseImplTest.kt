package com.franzandel.feature_favorite.domain.usecase

import com.franzandel.core.mapper.BaseMapper
import com.franzandel.core.wrapper.Result
import com.franzandel.feature_favorite.domain.model.local.request.GamesResultRequest
import com.franzandel.feature_favorite.domain.repository.DetailFavoriteRepository
import com.franzandel.feature_favorite.presentation.mapper.GamesResultsRequestMapper
import com.franzandel.feature_favorite.presentation.model.GamesResultUI
import com.franzandel.feature_favorite.utils.RoomUtils
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
class DetailFavoriteUseCaseImplTest {

    private val repository: DetailFavoriteRepository = mockk(relaxed = true)

    private lateinit var useCase: DetailFavoriteUseCase

    private val mapper: BaseMapper<GamesResultUI, GamesResultRequest> = GamesResultsRequestMapper()

    @Before
    fun setUp() {
        useCase = DetailFavoriteUseCaseImpl(repository, mapper)
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
            val fakeFailedResponse = RoomUtils.ERROR_DELETE_FROM_DB

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
    fun `get games results found`() {
        runBlockingTest {
            val gameName = "Devil May Cry"
            val fakeGamesResult = RoomUtils.getGamesResultRequest()

            coEvery { repository.getGamesResult(gameName) } returns Result.Success(fakeGamesResult)

            val gamesResult = useCase.getGamesResult(gameName)
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

            coEvery { repository.getGamesResult(gameName) } returns Result.Error(
                Exception(
                    fakeFailedResponse
                )
            )

            val gamesResult = useCase.getGamesResult(gameName)
            val result = gamesResult as Result.Error
            assertNotNull(gamesResult)
            assertEquals(fakeFailedResponse, result.error.message)
        }
    }
}