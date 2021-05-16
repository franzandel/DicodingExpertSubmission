package com.franzandel.dicodingexpertsubmission.data.local

import com.franzandel.core.wrapper.Result
import com.franzandel.dicodingexpertsubmission.domain.model.local.Screenshots

/**
 * Created by Franz Andel on 01/05/21.
 * Android Engineer
 */

interface AppLocalData {
    suspend fun insertScreenshots(screenshots: Screenshots): Result<Unit>
    suspend fun getScreenshots(): Result<Screenshots>
}