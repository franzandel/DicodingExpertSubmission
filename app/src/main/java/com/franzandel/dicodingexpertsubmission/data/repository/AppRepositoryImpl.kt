package com.franzandel.dicodingexpertsubmission.data.repository

import com.franzandel.core.mapper.BaseMapper
import com.franzandel.core.wrapper.Result
import com.franzandel.core.wrapper.result
import com.franzandel.dicodingexpertsubmission.data.local.AppLocalData
import com.franzandel.dicodingexpertsubmission.data.remote.AppRemoteData
import com.franzandel.dicodingexpertsubmission.domain.model.local.Screenshots
import com.franzandel.dicodingexpertsubmission.domain.model.remote.ScreenshotsResponse
import com.franzandel.dicodingexpertsubmission.domain.repository.AppRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class AppRepositoryImpl @Inject constructor(
    private val remoteData: AppRemoteData,
    private val localData: AppLocalData,
    private val mapper: BaseMapper<ScreenshotsResponse, Screenshots>
) : AppRepository {

    companion object {
        private const val ERROR_HIT_API = "error hit api"
        private const val ERROR_SAVING_TO_DB = "error saving to DB"
    }

    override suspend fun getGameScreenshots(gameId: String): Result<Screenshots> =
        when (val result = localData.getScreenshots()) {
            is Result.Success -> result
            is Result.Error -> getScreenshotsFromAPI(gameId)
        }

    private suspend fun getScreenshotsFromAPI(gameId: String): Result<Screenshots> =
        when (val result = remoteData.getGameScreenshots(gameId)) {
            is Result.Success -> saveScreenshotsToDB(result)
            is Result.Error -> throw Exception(ERROR_HIT_API)
        }

    private suspend fun saveScreenshotsToDB(result: Result.Success<ScreenshotsResponse>): Result<Screenshots> {
        val screenshots = mapper.map(result.result)
        return when (localData.insertScreenshots(screenshots)) {
            is Result.Success -> localData.getScreenshots()
            is Result.Error -> throw Exception(ERROR_SAVING_TO_DB)
        }
    }
}