package com.franzandel.dicodingexpertsubmission.data.remote.mapper.response

import com.franzandel.core.mapper.BaseMapper
import com.franzandel.dicodingexpertsubmission.data.remote.model.response.ParentPlatformChildDTO
import com.franzandel.dicodingexpertsubmission.data.remote.model.response.ParentPlatformDTO
import com.franzandel.dicodingexpertsubmission.domain.model.remote.response.ParentPlatform
import com.franzandel.dicodingexpertsubmission.domain.model.remote.response.ParentPlatformChild
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

/**
 * Created by Franz Andel on 04/05/21.
 * Android Engineer
 */

@ViewModelScoped
class ParentPlatformsMapper @Inject constructor(
    private val parentPlatformChildMapper: BaseMapper<ParentPlatformChildDTO, ParentPlatformChild>
) : BaseMapper<List<ParentPlatformDTO>, List<ParentPlatform>>() {

    override fun map(dataModel: List<ParentPlatformDTO>): List<ParentPlatform> =
        with(dataModel) {
            map {
                ParentPlatform(
                    parentPlatformChildMapper.map(it.platform)
                )
            }
        }
}