package com.franzandel.dicodingexpertsubmission.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.franzandel.dicodingexpertsubmission.BuildConfig
import com.franzandel.dicodingexpertsubmission.data.consts.PaginationConsts.NETWORK_PAGE_SIZE
import com.franzandel.dicodingexpertsubmission.data.remote.model.response.GamesResultDTO
import com.franzandel.dicodingexpertsubmission.data.remote.network.HomeService
import retrofit2.HttpException
import java.io.IOException

/**
 * Created by Franz Andel on 14/05/21.
 * Android Engineer
 */

class HomePagingSource(
    private val service: HomeService
) : PagingSource<Int, GamesResultDTO>() {

    companion object {
        private const val STARTING_PAGE_INDEX = 1
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GamesResultDTO> {
        val position = params.key ?: STARTING_PAGE_INDEX
        return try {
            val response = service.getAllGames(BuildConfig.GAMES_API_KEY, position, params.loadSize)
            val repos = response.results
            val nextKey = if (repos.isEmpty()) {
                null
            } else {
                // initial load size = 3 * NETWORK_PAGE_SIZE
                // ensure we're not requesting duplicating items, at the 2nd request
                position + (params.loadSize / NETWORK_PAGE_SIZE)
            }
            LoadResult.Page(
                data = repos,
                prevKey = if (position == STARTING_PAGE_INDEX) null else position - 1,
                nextKey = nextKey
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    // The refresh key is used for the initial load of the next PagingSource, after invalidation
    override fun getRefreshKey(state: PagingState<Int, GamesResultDTO>): Int? {
        // We need to get the previous key (or next key if previous is null) of the page
        // that was closest to the most recently accessed index.
        // Anchor position is the most recently accessed index
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}