package com.franzandel.feature_favorite.data.local

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.franzandel.core.mapper.BaseMapper
import com.franzandel.core.mapper.mapLocalResponse
import com.franzandel.core.wrapper.Result
import com.franzandel.core.wrapper.suspendTryCatch
import com.franzandel.feature_favorite.data.local.dao.FavoriteDao
import com.franzandel.feature_favorite.data.local.model.GamesResultEntity
import com.franzandel.feature_favorite.domain.model.local.request.GamesResultRequest
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@ViewModelScoped
class FavoriteLocalDataImpl @Inject constructor(
    private val dao: FavoriteDao,
    private val requestMapper: BaseMapper<GamesResultRequest, GamesResultEntity>,
    private val responseMapper: BaseMapper<GamesResultEntity, GamesResultRequest>
) : FavoriteLocalData {

    companion object {
        private const val ERROR_INSERT_TO_DB = "Error insert to DB"
        private const val ERROR_DELETE_FROM_DB = "Error delete from DB"
        private const val DB_PAGE_SIZE = 3
    }

    override suspend fun insertGamesResults(gamesResultRequest: GamesResultRequest): Result<Unit> =
        suspendTryCatch {
            val gamesResultEntity = requestMapper.map(gamesResultRequest)
            val result = dao.insertGamesResult(gamesResultEntity)
            mapLocalResponse(
                result, Unit,
                ERROR_INSERT_TO_DB
            )
        }

    override suspend fun deleteGamesResults(gamesResultRequest: GamesResultRequest): Result<Unit> =
        suspendTryCatch {
            val gamesResultEntity = requestMapper.map(gamesResultRequest)
            val result = dao.deleteGamesResult(gamesResultEntity)
            mapLocalResponse(
                result, Unit,
                ERROR_DELETE_FROM_DB
            )
        }

    override suspend fun getGamesResults(): Flow<PagingData<GamesResultRequest>> =
        Pager(
            config = PagingConfig(pageSize = DB_PAGE_SIZE, enablePlaceholders = false),
            pagingSourceFactory = { dao.getGamesResult() }
        ).flow.map {
            it.map { gamesResultEntity ->
                responseMapper.map(gamesResultEntity)
            }
        }
}