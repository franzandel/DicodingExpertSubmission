package com.franzandel.dicodingexpertsubmission.domain.repository.mapper

import com.franzandel.dicodingexpertsubmission.core.mapper.BaseMapper
import com.franzandel.dicodingexpertsubmission.domain.model.local.Result
import com.franzandel.dicodingexpertsubmission.domain.model.remote.ResultResponse
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

/**
 * Created by Franz Andel on 05/05/21.
 * Android Engineer
 */

@ViewModelScoped
class ResultResponseResultMapper @Inject constructor() : BaseMapper<ResultResponse, Result>() {

    override fun map(dataModel: ResultResponse): Result =
        with(dataModel) {
            Result(
                height = height,
                id = id,
                image = image,
                isDeleted = isDeleted,
                width = width
            )
        }
}