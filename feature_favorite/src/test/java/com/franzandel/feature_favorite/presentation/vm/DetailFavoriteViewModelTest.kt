package com.franzandel.feature_favorite.presentation.vm

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.franzandel.core.coroutine.CoroutineThread
import com.franzandel.core.wrapper.Result
import com.franzandel.feature_favorite.domain.usecase.DetailFavoriteUseCase
import com.franzandel.feature_favorite.utils.RoomUtils
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.ObsoleteCoroutinesApi
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
class DetailFavoriteViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val useCase: DetailFavoriteUseCase = mockk(relaxed = true)
    private val coroutineThread: CoroutineThread = mockk(relaxed = true)
    private val successObserver: Observer<Unit> = mockk(relaxed = true)
    private val failedObserver: Observer<String> = mockk(relaxed = true)
    private val getFoundObserver: Observer<Boolean> = mockk(relaxed = true)

    private lateinit var viewModel: DetailFavoriteViewModel

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    fun setUp() {
        viewModel = DetailFavoriteViewModel(useCase, coroutineThread)
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
    }

    @Test
    fun `insert games results success`() {
        runBlockingTest {
            val gamesResultUI = RoomUtils.getGamesResultUI()
            val fakeSuccessResponse = Unit

            coEvery { useCase.insertGamesResults(gamesResultUI) } returns Result.Success(Unit)
            coEvery { coroutineThread.background() } returns Dispatchers.Unconfined

            viewModel.insertGamesResults.observeForever(successObserver)
            viewModel.insertGamesResults(gamesResultUI)

            verify {
                val insertGamesResults = viewModel.insertGamesResults.value
                successObserver.onChanged(insertGamesResults)
                Assert.assertNotNull(insertGamesResults)
                Assert.assertEquals(fakeSuccessResponse, insertGamesResults)
            }
        }
    }

    @Test
    fun `insert games results failed`() {
        runBlockingTest {
            val gamesResultUI = RoomUtils.getGamesResultUI()
            val fakeFailedResponse = RoomUtils.ERROR_INSERT_TO_DB

            coEvery {
                useCase.insertGamesResults(gamesResultUI)
            } returns Result.Error(Exception(fakeFailedResponse))
            coEvery { coroutineThread.background() } returns Dispatchers.Unconfined

            viewModel.errorResult.observeForever(failedObserver)
            viewModel.insertGamesResults(gamesResultUI)

            verify {
                val errorResult = viewModel.errorResult.value
                failedObserver.onChanged(errorResult)
                Assert.assertNotNull(errorResult)
                Assert.assertEquals(fakeFailedResponse, errorResult)
            }
        }
    }

    @Test
    fun `delete games results success`() {
        runBlockingTest {
            val gamesResultUI = RoomUtils.getGamesResultUI()
            val fakeSuccessResponse = Unit

            coEvery { useCase.deleteGamesResults(gamesResultUI) } returns Result.Success(Unit)
            coEvery { coroutineThread.background() } returns Dispatchers.Unconfined

            viewModel.deleteGamesResults.observeForever(successObserver)
            viewModel.deleteGamesResults(gamesResultUI)

            verify {
                val deleteGamesResults = viewModel.deleteGamesResults.value
                successObserver.onChanged(deleteGamesResults)
                Assert.assertNotNull(deleteGamesResults)
                Assert.assertEquals(fakeSuccessResponse, deleteGamesResults)
            }
        }
    }

    @Test
    fun `delete games results failed`() {
        runBlockingTest {
            val gamesResultUI = RoomUtils.getGamesResultUI()
            val fakeFailedResponse = RoomUtils.ERROR_DELETE_FROM_DB

            coEvery {
                useCase.deleteGamesResults(gamesResultUI)
            } returns Result.Error(Exception(fakeFailedResponse))
            coEvery { coroutineThread.background() } returns Dispatchers.Unconfined

            viewModel.errorResult.observeForever(failedObserver)
            viewModel.deleteGamesResults(gamesResultUI)

            verify {
                val errorResult = viewModel.errorResult.value
                failedObserver.onChanged(errorResult)
                Assert.assertNotNull(errorResult)
                Assert.assertEquals(fakeFailedResponse, errorResult)
            }
        }
    }

    @Test
    fun `get games results found`() {
        runBlockingTest {
            val gameName = "Devil May Cry"
            val gamesResultRequest = RoomUtils.getGamesResultRequest()
            val isFavorite = true

            coEvery { useCase.getGamesResult(gameName) } returns Result.Success(gamesResultRequest)
            coEvery { coroutineThread.background() } returns Dispatchers.Unconfined

            viewModel.isFavoriteGamesResults.observeForever(getFoundObserver)
            viewModel.getGamesResults(gameName)

            verify {
                val isFavoriteGamesResults = viewModel.isFavoriteGamesResults.value
                getFoundObserver.onChanged(isFavoriteGamesResults)
                Assert.assertNotNull(isFavoriteGamesResults)
                Assert.assertEquals(isFavorite, isFavoriteGamesResults)
            }
        }
    }

    @Test
    fun `get games results not found`() {
        runBlockingTest {
            val gameName = "Devil May Cry"
            val fakeFailedResponse = RoomUtils.NO_DATA_FOUND

            coEvery {
                useCase.getGamesResult(gameName)
            } returns Result.Error(Exception(fakeFailedResponse))
            coEvery { coroutineThread.background() } returns Dispatchers.Unconfined

            viewModel.errorResult.observeForever(failedObserver)
            viewModel.getGamesResults(gameName)

            verify {
                val errorResult = viewModel.errorResult.value
                failedObserver.onChanged(errorResult)
                Assert.assertNotNull(errorResult)
                Assert.assertEquals(fakeFailedResponse, errorResult)
            }
        }
    }
}