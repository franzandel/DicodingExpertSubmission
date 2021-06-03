package com.franzandel.feature_home.presentation.vm

import androidx.paging.PagingData
import androidx.paging.filter
import androidx.paging.map
import com.franzandel.core.mapper.BaseMapper
import com.franzandel.feature_home.domain.model.remote.response.GamesResult
import com.franzandel.feature_home.domain.usecase.HomeUseCase
import com.franzandel.feature_home.presentation.mapper.GamesResultUIMapper
import com.franzandel.feature_home.presentation.model.GamesResultUI
import com.franzandel.feature_home.utils.RoomUtils
import com.franzandel.testing_utils.collectDataForTest
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
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
class HomeViewModelTest {

    private val useCase: HomeUseCase = mockk(relaxed = true)

    private val testDispatcher = TestCoroutineDispatcher()
    private val testScope = TestCoroutineScope(testDispatcher)
    private lateinit var viewModel: HomeViewModel

    private val mapper: BaseMapper<GamesResult, GamesResultUI> = GamesResultUIMapper()

    @Before
    fun setUp() {
        viewModel = HomeViewModel(useCase, mapper, testScope)
    }

    @Test
    fun `get filled games`() {
        runBlockingTest {
            val fakePagingGamesResults = PagingData.from(RoomUtils.getGamesResults())
            val fakePagingGamesResult = fakePagingGamesResults.filter { true }

            coEvery { useCase.getAllGames() } returns flowOf(fakePagingGamesResult)

            val pagingGamesResultUI = viewModel.getAllGames().first().collectDataForTest()
            val fakeGamesResultsUI = fakePagingGamesResults.map { gamesResult ->
                mapper.map(gamesResult)
            }.collectDataForTest()

            assertNotNull(pagingGamesResultUI)
            assertEquals(pagingGamesResultUI.size, fakeGamesResultsUI.size)
        }
    }

    @Test
    fun `get empty games`() {
        runBlockingTest {
            val fakePagingGamesResultUI = PagingData.empty<GamesResultUI>()

            coEvery { useCase.getAllGames() } returns emptyFlow()

            val pagingGamesResultUI = viewModel.getAllGames().toList()
            val fakeGamesResultsUI = fakePagingGamesResultUI.collectDataForTest()

            assertNotNull(pagingGamesResultUI)
            assertEquals(pagingGamesResultUI.size, fakeGamesResultsUI.size)
        }
    }
}