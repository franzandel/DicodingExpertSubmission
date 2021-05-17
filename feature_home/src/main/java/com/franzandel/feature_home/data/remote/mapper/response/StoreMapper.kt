package com.franzandel.feature_home.data.remote.mapper.response

import com.franzandel.core.mapper.BaseMapper
import com.franzandel.feature_home.data.remote.model.response.StoreDTO
import com.franzandel.feature_home.domain.model.remote.response.Store
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

/**
 * Created by Franz Andel on 04/05/21.
 * Android Engineer
 */

@ViewModelScoped
class StoreMapper @Inject constructor() : BaseMapper<StoreDTO, Store>() {

    override fun map(dataModel: StoreDTO): Store =
        with(dataModel) {
            Store(
                domain, gamesCount, id, imageBackground, name, slug
            )
        }
}