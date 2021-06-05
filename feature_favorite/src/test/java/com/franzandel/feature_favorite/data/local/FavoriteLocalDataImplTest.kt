package com.franzandel.feature_favorite.data.local

import androidx.paging.PagingSource
import com.franzandel.core.mapper.BaseMapper
import com.franzandel.core.wrapper.Result
import com.franzandel.feature_favorite.data.local.dao.FavoriteDao
import com.franzandel.feature_favorite.data.local.mapper.GamesResultRequestEntityMapper
import com.franzandel.feature_favorite.data.local.model.GamesResultEntity
import com.franzandel.feature_favorite.domain.mapper.GamesResultsEntityMapper
import com.franzandel.feature_favorite.domain.model.local.request.GamesResultRequest
import com.franzandel.feature_favorite.utils.RoomUtils
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
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
class FavoriteLocalDataImplTest {

    private val dao: FavoriteDao = mockk(relaxed = true)

    private lateinit var localData: FavoriteLocalData

    private val requestMapper: BaseMapper<GamesResultRequest, GamesResultEntity> =
        GamesResultsEntityMapper()
    private val responseMapper: BaseMapper<GamesResultEntity, GamesResultRequest> =
        GamesResultRequestEntityMapper()

    @Before
    fun setUp() {
        localData = FavoriteLocalDataImpl(dao, requestMapper, responseMapper)
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
        runBlocking {
            val fakeGamesResultsEntity = RoomUtils.getGamesResultsEntity()
            val fakeFavoriteDao = FakeFavoriteDao(fakeGamesResultsEntity)
            val expected = PagingSource.LoadResult.Page(
                data = fakeGamesResultsEntity,
                prevKey = null,
                nextKey = null
            )
            val actual = fakeFavoriteDao.getGamesResult().load(
                PagingSource.LoadParams.Refresh(
                    key = null,
                    loadSize = 2,
                    placeholdersEnabled = false
                )
            )
            assertEquals(expected, actual)
        }
    }

    @Test
    fun `get games results not found`() {
        runBlocking {
            val fakeGamesResultsEntity = RoomUtils.getGamesResultsEntity()
            val fakeThrowable = Throwable("games results not found")
            val fakeFavoriteDao = FakeFavoriteDao(fakeGamesResultsEntity, fakeThrowable)
            val expected = PagingSource.LoadResult.Error<Int, GamesResultEntity>(fakeThrowable)
            val actual = fakeFavoriteDao.getGamesResult().load(
                PagingSource.LoadParams.Refresh(
                    key = null,
                    loadSize = 1,
                    placeholdersEnabled = false
                )
            )
            assertEquals(expected, actual)
        }
    }
}