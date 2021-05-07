package com.franzandel.dicodingexpertsubmission.data.repository

import com.franzandel.dicodingexpertsubmission.core.wrapper.Result
import com.franzandel.dicodingexpertsubmission.data.remote.HomeRemoteData
import com.franzandel.dicodingexpertsubmission.domain.model.remote.response.Games
import com.franzandel.dicodingexpertsubmission.domain.repository.HomeRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class HomeRepositoryImpl @Inject constructor(
    private val remoteData: HomeRemoteData
) : HomeRepository {

    override suspend fun getAllGames(): Result<Games> = remoteData.getAllGames()
}