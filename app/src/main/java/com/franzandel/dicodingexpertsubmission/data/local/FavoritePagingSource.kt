package com.franzandel.dicodingexpertsubmission.data.local

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.franzandel.dicodingexpertsubmission.data.local.dao.FavoriteDao
import com.franzandel.dicodingexpertsubmission.data.local.model.GamesResultEntity
import retrofit2.HttpException
import java.io.IOException

/**
 * Created by Franz Andel on 12/05/21.
 * Android Engineer
 */

private const val GITHUB_STARTING_PAGE_INDEX = 1
const val NETWORK_PAGE_SIZE = 3

class FavoritePagingSource(
    private val dao: FavoriteDao
) : PagingSource<Int, GamesResultEntity>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GamesResultEntity> {
        val position = params.key ?: GITHUB_STARTING_PAGE_INDEX
//        val apiQuery = query + IN_QUALIFIER
        return try {
            val response = dao.getGamesResult()
//            val repos = response.items
            val nextKey = if (response.isEmpty()) {
                null
            } else {
                // initial load size = 3 * NETWORK_PAGE_SIZE
                // ensure we're not requesting duplicating items, at the 2nd request
                position + (params.loadSize / NETWORK_PAGE_SIZE)
            }
            LoadResult.Page(
                data = response,
                prevKey = if (position == GITHUB_STARTING_PAGE_INDEX) null else position - 1,
                nextKey = nextKey
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    // The refresh key is used for the initial load of the next PagingSource, after invalidation
    override fun getRefreshKey(state: PagingState<Int, GamesResultEntity>): Int? {
        // We need to get the previous key (or next key if previous is null) of the page
        // that was closest to the most recently accessed index.
        // Anchor position is the most recently accessed index
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}