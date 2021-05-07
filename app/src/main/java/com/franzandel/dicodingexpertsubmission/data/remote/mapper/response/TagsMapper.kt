package com.franzandel.dicodingexpertsubmission.data.remote.mapper.response

import com.franzandel.dicodingexpertsubmission.core.mapper.BaseMapper
import com.franzandel.dicodingexpertsubmission.data.remote.model.response.TagDTO
import com.franzandel.dicodingexpertsubmission.domain.model.remote.response.Tag
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

/**
 * Created by Franz Andel on 04/05/21.
 * Android Engineer
 */

@ViewModelScoped
class TagsMapper @Inject constructor() : BaseMapper<List<TagDTO>, List<Tag>>() {

    override fun map(dataModel: List<TagDTO>): List<Tag> =
        dataModel.map {
            with(it) {
                Tag(
                    gamesCount, id, imageBackground, language, name, slug
                )
            }
        }
}