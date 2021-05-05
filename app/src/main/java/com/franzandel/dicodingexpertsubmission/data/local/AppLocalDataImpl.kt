package com.franzandel.dicodingexpertsubmission.data.local

import com.franzandel.dicodingexpertsubmission.core.mapper.BaseMapper
import com.franzandel.dicodingexpertsubmission.core.mapper.mapLocalResponse
import com.franzandel.dicodingexpertsubmission.core.wrapper.Result
import com.franzandel.dicodingexpertsubmission.core.wrapper.suspendTryCatch
import com.franzandel.dicodingexpertsubmission.data.local.dao.ScreenshotsDao
import com.franzandel.dicodingexpertsubmission.data.local.model.ScreenshotsDTO
import com.franzandel.dicodingexpertsubmission.domain.model.local.Screenshots
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class AppLocalDataImpl @Inject constructor(
    private val dao: ScreenshotsDao,
    private val requestMapper: BaseMapper<Screenshots, ScreenshotsDTO>,
    private val responseMapper: BaseMapper<ScreenshotsDTO, Screenshots>
) : AppLocalData {

    companion object {
        private const val ERROR_INSERT_TO_DB = "Error insert to DB"
        private const val NO_DATA_FOUND = "No data found on DB"
    }

    override suspend fun insertScreenshots(screenshots: Screenshots): Result<Unit> =
        suspendTryCatch {
            val screenshotsDTO = requestMapper.map(screenshots)
            val result = dao.insertScreenshots(screenshotsDTO)
            mapLocalResponse(result, Unit, ERROR_INSERT_TO_DB)
        }

    override suspend fun getScreenshots(): Result<Screenshots> =
        suspendTryCatch {
            val screenshotsDTO = dao.getScreenshots()
            if (screenshotsDTO != null)
                Result.Success(responseMapper.map(screenshotsDTO))
            else
                Result.Error(Exception(NO_DATA_FOUND))
        }
}