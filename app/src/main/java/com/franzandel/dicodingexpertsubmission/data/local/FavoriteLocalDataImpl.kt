package com.franzandel.dicodingexpertsubmission.data.local

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.franzandel.dicodingexpertsubmission.core.mapper.BaseMapper
import com.franzandel.dicodingexpertsubmission.core.wrapper.Result
import com.franzandel.dicodingexpertsubmission.data.local.dao.FavoriteDao
import com.franzandel.dicodingexpertsubmission.data.local.model.GamesResultEntity
import com.franzandel.dicodingexpertsubmission.domain.model.local.request.GamesResultRequest
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@ViewModelScoped
class FavoriteLocalDataImpl @Inject constructor(
    private val dao: FavoriteDao,
    private val mapper: BaseMapper<GamesResultEntity, GamesResultRequest>
) : FavoriteLocalData {

    override suspend fun insertGamesResults(gamesResultRequest: GamesResultRequest): Result<Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteGamesResults(gamesResultRequest: GamesResultRequest): Result<Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun getGamesResults(): Flow<PagingData<GamesResultRequest>> {
//        val dataSource = dao.getGamesResult()
//        val mappedDataSource = responsesMapper.map(dataSource)
//        val config = PagedList.Config.Builder()
//            .setEnablePlaceholders(false)
//            .setInitialLoadSizeHint(25)
//            .setPageSize(25)
//            .build()
//
//        return LivePagedListBuilder(dataSource, config).build().asFlow()

        return Pager(
            config = PagingConfig(pageSize = NETWORK_PAGE_SIZE, enablePlaceholders = false),
            pagingSourceFactory = { FavoritePagingSource(dao) }
        ).flow.map {
            it.map { gamesResultEntity ->
                mapper.map(gamesResultEntity)
            }
        }
    }
}