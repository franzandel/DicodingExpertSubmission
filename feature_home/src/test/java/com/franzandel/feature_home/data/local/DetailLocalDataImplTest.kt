package com.franzandel.feature_home.data.local

import com.franzandel.core.mapper.BaseMapper
import com.franzandel.core.wrapper.Result
import com.franzandel.feature_home.data.local.dao.DetailDao
import com.franzandel.feature_home.data.local.mapper.GamesResultRequestEntityMapper
import com.franzandel.feature_home.data.local.model.GamesResultEntity
import com.franzandel.feature_home.domain.mapper.GamesResultsEntityMapper
import com.franzandel.feature_home.domain.model.local.request.GamesResultRequest
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
class DetailLocalDataImplTest {

    private val dao: DetailDao = mockk(relaxed = true)

    private lateinit var localData: DetailLocalData

    private val requestMapper: BaseMapper<GamesResultRequest, GamesResultEntity> =
        GamesResultsEntityMapper()
    private val responseMapper: BaseMapper<GamesResultEntity, GamesResultRequest> =
        GamesResultRequestEntityMapper()

    @Before
    fun setUp() {
        localData = DetailLocalDataImpl(dao, requestMapper, responseMapper)
    }

    @Test
    fun `insert games results success`() {
        runBlockingTest {
            val gamesResultRequest = RoomUtils.getGamesResultRequest()
            val gamesResultEntity = RoomUtils.getGamesResultEntity()
            val fakeInsertResponse = 3L
            val fakeSuccessResponse = Unit

            coEvery { dao.insertGamesResult(gamesResultEntity) } returns fakeInsertResponse

            val insertGamesResults = localData.insertGamesResults(gamesResultRequest)
            val result = insertGamesResults as Result.Success
            assertNotNull(insertGamesResults)
            assertEquals(fakeSuccessResponse, result.data)
        }
    }

    @Test
    fun `insert games results failed`() {
        runBlockingTest {
            val gamesResultRequest = RoomUtils.getGamesResultRequest()
            val gamesResultEntity = RoomUtils.getGamesResultEntity()
            val fakeInsertResponse = -1L
            val fakeErrorResponse = RoomUtils.ERROR_INSERT_TO_DB

            coEvery { dao.insertGamesResult(gamesResultEntity) } returns fakeInsertResponse

            val insertGamesResults = localData.insertGamesResults(gamesResultRequest)
            val result = insertGamesResults as Result.Error
            assertNotNull(insertGamesResults)
            assertEquals(fakeErrorResponse, result.error.message)
        }
    }

    @Test
    fun `delete games results success`() {
        runBlockingTest {
            val gamesResultRequest = RoomUtils.getGamesResultRequest()
            val gamesResultEntity = RoomUtils.getGamesResultEntity()
            val fakeDeleteResponse = 3
            val fakeSuccessResponse = Unit

            coEvery { dao.deleteGamesResult(gamesResultEntity) } returns fakeDeleteResponse

            val deleteGamesResults = localData.deleteGamesResults(gamesResultRequest)
            val result = deleteGamesResults as Result.Success
            assertNotNull(deleteGamesResults)
            assertEquals(fakeSuccessResponse, result.data)
        }
    }

    @Test
    fun `delete games results failed`() {
        runBlockingTest {
            val gamesResultRequest = RoomUtils.getGamesResultRequest()
            val gamesResultEntity = RoomUtils.getGamesResultEntity()
            val fakeDeleteResponse = -1
            val fakeErrorResponse = RoomUtils.ERROR_DELETE_FROM_DB

            coEvery {
                dao.deleteGamesResult(gamesResultEntity)
            } returns fakeDeleteResponse

            val deleteGamesResults = localData.deleteGamesResults(gamesResultRequest)
            val result = deleteGamesResults as Result.Error
            assertNotNull(deleteGamesResults)
            assertEquals(fakeErrorResponse, result.error.message)
        }
    }

    @Test
    fun `get games results found`() {
        runBlockingTest {
            val gameName = "Devil May Cry"
            val fakeGamesResultRequest = RoomUtils.getGamesResultRequest()
            val gamesResultEntity = RoomUtils.getGamesResultEntity()

            coEvery { dao.getGamesResult(gameName) } returns gamesResultEntity

            val gamesResult = localData.getGamesResults(gameName)
            val result = gamesResult as Result.Success
            assertNotNull(gamesResult)
            assertEquals(fakeGamesResultRequest, result.data)
        }
    }

    @Test
    fun `get games results not found`() {
        runBlockingTest {
            val gameName = "Devil May Cry"
            val fakeFailedResponse = RoomUtils.NO_DATA_FOUND

            coEvery { dao.getGamesResult(gameName) } returns null

            val gamesResult = localData.getGamesResults(gameName)
            val result = gamesResult as Result.Error
            assertNotNull(gamesResult)
            assertEquals(fakeFailedResponse, result.error.message)
        }
    }
}