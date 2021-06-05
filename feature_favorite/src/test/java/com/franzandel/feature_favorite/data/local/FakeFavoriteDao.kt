package com.franzandel.feature_favorite.data.local

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.franzandel.feature_favorite.data.local.dao.FavoriteDao
import com.franzandel.feature_favorite.data.local.model.GamesResultEntity

/**
 * Created by Franz Andel on 05/06/21.
 * Android Engineer
 */

class FakeFavoriteDao(
    private val gamesResultsEntity: List<GamesResultEntity>,
    private val throwable: Throwable? = null
) : FavoriteDao {

    override suspend fun insertGamesResult(gamesResultEntity: GamesResultEntity): Long = 1L

    override suspend fun deleteGamesResult(gamesResultEntity: GamesResultEntity): Int = 2

    override fun getGamesResult(): PagingSource<Int, GamesResultEntity> =
        object : PagingSource<Int, GamesResultEntity>() {

            override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GamesResultEntity> =
                if (throwable == null) {
                    LoadResult.Page(
                        data = gamesResultsEntity,
                        prevKey = null,
                        nextKey = null,
                    )
                } else
                    LoadResult.Error(throwable)

            // Ignored in test.
            override fun getRefreshKey(state: PagingState<Int, GamesResultEntity>): Int? = null
        }
}