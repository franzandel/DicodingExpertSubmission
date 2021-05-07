package com.franzandel.dicodingexpertsubmission.data.remote.mapper.response

import com.franzandel.dicodingexpertsubmission.core.mapper.BaseMapper
import com.franzandel.dicodingexpertsubmission.data.remote.model.response.ParentPlatformChildDTO
import com.franzandel.dicodingexpertsubmission.domain.model.remote.response.ParentPlatformChild
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

/**
 * Created by Franz Andel on 04/05/21.
 * Android Engineer
 */

@ViewModelScoped
class ParentPlatformsChildMapper @Inject constructor() :
    BaseMapper<ParentPlatformChildDTO, ParentPlatformChild>() {

    override fun map(dataModel: ParentPlatformChildDTO): ParentPlatformChild =
        with(dataModel) {
            ParentPlatformChild(
                id, name, slug
            )
        }
}