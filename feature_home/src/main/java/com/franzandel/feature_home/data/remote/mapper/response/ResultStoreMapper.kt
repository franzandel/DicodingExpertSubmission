package com.franzandel.feature_home.data.remote.mapper.response

import com.franzandel.core.mapper.BaseMapper
import com.franzandel.feature_home.data.remote.model.response.ResultStoreDTO
import com.franzandel.feature_home.data.remote.model.response.StoreDTO
import com.franzandel.feature_home.domain.model.remote.response.ResultStore
import com.franzandel.feature_home.domain.model.remote.response.Store
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

/**
 * Created by Franz Andel on 04/05/21.
 * Android Engineer
 */

@ViewModelScoped
class ResultStoreMapper @Inject constructor(
    private val storeMapper: BaseMapper<StoreDTO, Store>
) : BaseMapper<List<ResultStoreDTO>, List<ResultStore>>() {

    override fun map(dataModel: List<ResultStoreDTO>): List<ResultStore> =
        with(dataModel) {
            map {
                ResultStore(
                    it.id, storeMapper.map(it.store)
                )
            }
        }
}