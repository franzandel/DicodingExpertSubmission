package com.franzandel.dicodingexpertsubmission.data.local

import com.franzandel.dicodingexpertsubmission.core.mapper.BaseMapper
import com.franzandel.dicodingexpertsubmission.core.mapper.mapLocalResponse
import com.franzandel.dicodingexpertsubmission.core.wrapper.Result
import com.franzandel.dicodingexpertsubmission.core.wrapper.suspendTryCatch
import com.franzandel.dicodingexpertsubmission.data.local.dao.DetailDao
import com.franzandel.dicodingexpertsubmission.data.local.model.GamesResultEntity
import com.franzandel.dicodingexpertsubmission.domain.model.local.request.GamesResultRequest
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class DetailLocalDataImpl @Inject constructor(
    private val dao: DetailDao,
    private val requestMapper: BaseMapper<GamesResultRequest, GamesResultEntity>,
    private val responseMapper: BaseMapper<GamesResultEntity, GamesResultRequest>
) : DetailLocalData {

    companion object {
        private const val ERROR_INSERT_TO_DB = "Error insert to DB"
        private const val ERROR_DELETE_FROM_DB = "Error delete from DB"
        private const val NO_DATA_FOUND = "No data found on DB"
    }

    override suspend fun insertGamesResults(gamesResultRequest: GamesResultRequest): Result<Unit> =
        suspendTryCatch {
            val gamesResultEntity = requestMapper.map(gamesResultRequest)
            val result = dao.insertGamesResult(gamesResultEntity)
            mapLocalResponse(result, Unit, ERROR_INSERT_TO_DB)
        }

    override suspend fun deleteGamesResults(gamesResultRequest: GamesResultRequest): Result<Unit> =
        suspendTryCatch {
            val gamesResultEntity = requestMapper.map(gamesResultRequest)
            val result = dao.deleteGamesResult(gamesResultEntity)
            mapLocalResponse(result, Unit, ERROR_DELETE_FROM_DB)
        }

    override suspend fun getGamesResults(name: String): Result<GamesResultRequest> {
        val gamesResultEntity = dao.getGamesResult(name)
        return if (gamesResultEntity == null)
            Result.Error(Exception(NO_DATA_FOUND))
        else
            Result.Success(responseMapper.map(gamesResultEntity))
    }
}