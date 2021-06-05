package com.franzandel.feature_home.data.remote

import androidx.paging.PagingSource
import com.franzandel.core.mapper.BaseMapper
import com.franzandel.feature_home.data.remote.mapper.response.*
import com.franzandel.feature_home.data.remote.model.response.*
import com.franzandel.feature_home.data.remote.network.HomeService
import com.franzandel.feature_home.domain.model.remote.response.*
import com.franzandel.feature_home.utils.RetrofitUtils
import com.franzandel.feature_home.utils.enqueueResponse
import kotlinx.coroutines.runBlocking
import okhttp3.internal.EMPTY_RESPONSE
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.HttpException
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by Franz Andel on 04/06/21.
 * Android Engineer
 */

class HomeRemoteDataImplTest {

    private val mockWebServer = MockWebServer()
    private val service = Retrofit.Builder()
        .baseUrl(mockWebServer.url(""))
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(HomeService::class.java)

    private lateinit var remoteData: HomeRemoteData

    private val addedByStatusMapper: BaseMapper<AddedByStatusDTO, AddedByStatus> =
        AddedByStatusMapper()
    private val esrbRatingMapper: BaseMapper<EsrbRatingDTO?, EsrbRating?> =
        EsrbRatingMapper()
    private val genresMapper: BaseMapper<List<GenreDTO>, List<Genre>> =
        GenresMapper()
    private val parentPlatformsChildMapper: BaseMapper<ParentPlatformChildDTO, ParentPlatformChild> =
        ParentPlatformsChildMapper()
    private val parentPlatformsMapper: BaseMapper<List<ParentPlatformDTO>, List<ParentPlatform>> =
        ParentPlatformsMapper(parentPlatformsChildMapper)
    private val resultPlatformChildMapper: BaseMapper<ResultPlatformChildDTO, ResultPlatformChild> =
        ResultPlatformChildMapper()
    private val resultPlatformsMapper: BaseMapper<List<ResultPlatformDTO>, List<ResultPlatform>> =
        ResultPlatformsMapper(resultPlatformChildMapper)
    private val ratingsMapper: BaseMapper<List<RatingDTO>, List<Rating>> =
        RatingsMapper()
    private val shortScreenshotMapper: BaseMapper<List<ShortScreenshotDTO>, List<ShortScreenshot>> =
        ShortScreenshotMapper()
    private val storeMapper: BaseMapper<StoreDTO, Store> =
        StoreMapper()
    private val resultStoreMapper: BaseMapper<List<ResultStoreDTO>, List<ResultStore>> =
        ResultStoreMapper(storeMapper)
    private val tagsMapper: BaseMapper<List<TagDTO>, List<Tag>> =
        TagsMapper()
    private val gamesResultMapper: BaseMapper<GamesResultDTO, GamesResult> =
        GamesResultMapper(
            addedByStatusMapper,
            esrbRatingMapper,
            genresMapper,
            parentPlatformsMapper,
            resultPlatformsMapper,
            ratingsMapper,
            shortScreenshotMapper,
            resultStoreMapper,
            tagsMapper
        )

    @Before
    fun setUp() {
        remoteData = HomeRemoteDataImpl(service, gamesResultMapper)
    }

    @Test
    fun `get games response success`() {
        runBlocking {
            mockWebServer.enqueueResponse("games_response.json")
            val pagingSource = HomePagingSource(service)
            val mockPosts = RetrofitUtils.getGamesResultFromJson()
            val expected = PagingSource.LoadResult.Page(
                data = mockPosts,
                prevKey = null,
                nextKey = 1
            )
            val actual = pagingSource.load(
                PagingSource.LoadParams.Refresh(
                    key = null,
                    loadSize = 1,
                    placeholdersEnabled = false
                )
            )
            assertEquals(expected, actual)
        }
    }

    @Test
    fun `get games response failed`() {
        runBlocking {
            val fakeErrorCode = 404
            mockWebServer.enqueueResponse(
                fileName = "error_response.json",
                responseCode = fakeErrorCode
            )
            val pagingSource = HomePagingSource(service)
            val httpException = HttpException(
                Response.error<HttpException>(fakeErrorCode, EMPTY_RESPONSE)
            )
            val expected = PagingSource.LoadResult.Error<Int, GamesResultDTO>(httpException)
            val actual = pagingSource.load(
                PagingSource.LoadParams.Refresh(
                    key = null,
                    loadSize = 1,
                    placeholdersEnabled = false
                )
            )
            val expectedCode = (expected.throwable as HttpException).code()
            val actualCode =
                ((actual as PagingSource.LoadResult.Error).throwable as HttpException).code()
            assertEquals(expectedCode, actualCode)
        }
    }
}