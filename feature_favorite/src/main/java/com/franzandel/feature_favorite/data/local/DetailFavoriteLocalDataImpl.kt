package com.franzandel.feature_favorite.data.local

import com.franzandel.core.mapper.BaseMapper
import com.franzandel.core.mapper.mapLocalResponse
import com.franzandel.core.wrapper.Result
import com.franzandel.core.wrapper.suspendTryCatch
import com.franzandel.feature_favorite.data.local.dao.DetailFavoriteDao
import com.franzandel.feature_favorite.data.local.model.GamesResultEntity
import com.franzandel.feature_favorite.domain.model.local.request.GamesResultRequest
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class DetailFavoriteLocalDataImpl @Inject constructor(
    private val dao: DetailFavoriteDao,
    private val requestMapper: BaseMapper<GamesResultRequest, GamesResultEntity>,
    private val responseMapper: BaseMapper<GamesResultEntity, GamesResultRequest>
) : DetailFavoriteLocalData {

    companion object {
        private const val ERROR_INSERT_TO_DB = "Error insert to DB"
        private const val ERROR_DELETE_FROM_DB = "Error delete from DB"
        private const val NO_DATA_FOUND = "No data found on DB"
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

    override suspend fun getGamesResults(name: String): Result<GamesResultRequest> {
        val gamesResultEntity = dao.getGamesResult(name)
        return if (gamesResultEntity == null)
            Result.Error(Exception(NO_DATA_FOUND))
        else
            Result.Success(responseMapper.map(gamesResultEntity))
    }
}