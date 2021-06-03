package com.franzandel.feature_favorite.presentation.vm

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.paging.PagingData
import androidx.paging.filter
import androidx.paging.map
import com.franzandel.core.coroutine.CoroutineThread
import com.franzandel.core.mapper.BaseMapper
import com.franzandel.core.wrapper.Result
import com.franzandel.feature_favorite.domain.mapper.GamesResultUIMapper
import com.franzandel.feature_favorite.domain.model.local.request.GamesResultRequest
import com.franzandel.feature_favorite.domain.usecase.FavoriteUseCase
import com.franzandel.feature_favorite.presentation.model.GamesResultUI
import com.franzandel.feature_favorite.utils.RoomUtils
import com.franzandel.testing_utils.collectDataForTest
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.*

/**
 * Created by Franz Andel on 02/06/21.
 * Android Engineer
 */

@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
class FavoriteViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val useCase: FavoriteUseCase = mockk(relaxed = true)
    private val coroutineThread: CoroutineThread = mockk(relaxed = true)
    private val successInsertObserver: Observer<Unit> = mockk(relaxed = true)
    private val successDeleteObserver: Observer<GamesResultUI> = mockk(relaxed = true)
    private val failedObserver: Observer<String> = mockk(relaxed = true)

    private lateinit var viewModel: FavoriteViewModel

    private val mapper: BaseMapper<GamesResultRequest, GamesResultUI> = GamesResultUIMapper()

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    fun setUp() {
        viewModel = FavoriteViewModel(useCase, coroutineThread, mapper)
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
    }

    @Test
    fun `get filled favorite games`() {
        runBlockingTest {
            val fakePagingGamesResultRequests = PagingData.from(RoomUtils.getGamesResultRequests())
            val fakePagingGamesResultRequest = fakePagingGamesResultRequests.filter { true }

            coEvery { useCase.getGamesResults() } returns flowOf(fakePagingGamesResultRequest)

            val pagingGamesResultUI = viewModel.getFavoriteGames().first().collectDataForTest()
            val fakePagingGamesResultUI = fakePagingGamesResultRequests.map { gamesResultRequest ->
                mapper.map(gamesResultRequest)
            }.collectDataForTest()

            Assert.assertNotNull(pagingGamesResultUI)
            Assert.assertEquals(pagingGamesResultUI.size, fakePagingGamesResultUI.size)
        }
    }

    @Test
    fun `get empty favorite games`() {
        runBlockingTest {
            val fakePagingGamesResultUI = PagingData.empty<GamesResultUI>()

            coEvery { useCase.getGamesResults() } returns emptyFlow()

            val pagingGamesResultUI = viewModel.getFavoriteGames().toList()
            val fakeGamesResultsUI = fakePagingGamesResultUI.collectDataForTest()

            Assert.assertNotNull(pagingGamesResultUI)
            Assert.assertEquals(pagingGamesResultUI.size, fakeGamesResultsUI.size)
        }
    }

    @Test
    fun `insert games results success`() {
        runBlockingTest {
            val gamesResultUI = RoomUtils.getGamesResultUI()
            val successResponse = Unit

            coEvery { useCase.insertGamesResults(gamesResultUI) } returns Result.Success(Unit)
            coEvery { coroutineThread.background() } returns Dispatchers.Unconfined

            viewModel.insertGamesResults.observeForever(successInsertObserver)
            viewModel.insertGamesResults(gamesResultUI)

            verify {
                val insertGamesResults = viewModel.insertGamesResults.value
                successInsertObserver.onChanged(insertGamesResults)
                Assert.assertNotNull(insertGamesResults)
                Assert.assertEquals(successResponse, insertGamesResults)
            }
        }
    }

    @Test
    fun `insert games results failed`() {
        runBlockingTest {
            val gamesResultUI = RoomUtils.getGamesResultUI()
            val failedResponse = RoomUtils.INSERT_FAILED_RESPONSE

            coEvery {
                useCase.insertGamesResults(gamesResultUI)
            } returns Result.Error(Exception(failedResponse))
            coEvery { coroutineThread.background() } returns Dispatchers.Unconfined

            viewModel.errorResult.observeForever(failedObserver)
            viewModel.insertGamesResults(gamesResultUI)

            verify {
                val errorResult = viewModel.errorResult.value
                failedObserver.onChanged(errorResult)
                Assert.assertNotNull(errorResult)
                Assert.assertEquals(failedResponse, errorResult)
            }
        }
    }

    @Test
    fun `delete games results success`() {
        runBlockingTest {
            val gamesResultUI = RoomUtils.getGamesResultUI()

            coEvery { useCase.deleteGamesResults(gamesResultUI) } returns Result.Success(Unit)
            coEvery { coroutineThread.background() } returns Dispatchers.Unconfined

            viewModel.deleteGamesResults.observeForever(successDeleteObserver)
            viewModel.deleteGamesResults(gamesResultUI)

            verify {
                val deleteGamesResults = viewModel.deleteGamesResults.value
                successDeleteObserver.onChanged(deleteGamesResults)
                Assert.assertNotNull(deleteGamesResults)
                Assert.assertEquals(gamesResultUI, deleteGamesResults)
            }
        }
    }

    @Test
    fun `delete games results failed`() {
        runBlockingTest {
            val gamesResultUI = RoomUtils.getGamesResultUI()
            val failedResponse = RoomUtils.INSERT_FAILED_RESPONSE

            coEvery {
                useCase.deleteGamesResults(gamesResultUI)
            } returns Result.Error(Exception(failedResponse))
            coEvery { coroutineThread.background() } returns Dispatchers.Unconfined

            viewModel.errorResult.observeForever(failedObserver)
            viewModel.deleteGamesResults(gamesResultUI)

            verify {
                val errorResult = viewModel.errorResult.value
                failedObserver.onChanged(errorResult)
                Assert.assertNotNull(errorResult)
                Assert.assertEquals(failedResponse, errorResult)
            }
        }
    }
}