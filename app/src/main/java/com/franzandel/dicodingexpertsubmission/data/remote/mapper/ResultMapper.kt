package com.franzandel.dicodingexpertsubmission.data.remote.mapper

import com.franzandel.dicodingexpertsubmission.core.mapper.BaseMapper
import com.franzandel.dicodingexpertsubmission.data.remote.model.ResultDTO
import com.franzandel.dicodingexpertsubmission.domain.model.Result
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

/**
 * Created by Franz Andel on 04/05/21.
 * Android Engineer
 */

@ViewModelScoped
class ResultMapper @Inject constructor() : BaseMapper<ResultDTO, Result>() {

    override fun map(dataModel: ResultDTO): Result =
        with(dataModel) {
            Result(
                height = height,
                id = id,
                image = image,
                is_deleted = is_deleted,
                width = width
            )
        }
}