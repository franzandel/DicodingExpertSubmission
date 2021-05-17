package com.franzandel.feature_home.data.remote

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.franzandel.core.mapper.BaseMapper
import com.franzandel.dicodingexpertsubmission.data.consts.PaginationConsts.NETWORK_PAGE_SIZE
import com.franzandel.feature_home.data.remote.model.response.GamesResultDTO
import com.franzandel.feature_home.data.remote.network.HomeService
import com.franzandel.feature_home.domain.model.remote.response.GamesResult
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@ViewModelScoped
class HomeRemoteDataImpl @Inject constructor(
    private val service: HomeService,
    private val mapper: BaseMapper<GamesResultDTO, GamesResult>
) : HomeRemoteData {

    override suspend fun getAllGames(): Flow<PagingData<GamesResult>> =
        Pager(
            config = PagingConfig(pageSize = NETWORK_PAGE_SIZE, enablePlaceholders = false),
            pagingSourceFactory = {
                HomePagingSource(
                    service
                )
            }
        ).flow.map {
            it.map { gamesResultDTO ->
                mapper.map(gamesResultDTO)
            }
        }
}