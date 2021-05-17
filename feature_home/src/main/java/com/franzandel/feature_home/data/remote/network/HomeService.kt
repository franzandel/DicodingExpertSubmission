package com.franzandel.feature_home.data.remote.network

import com.franzandel.feature_home.data.remote.model.response.GamesDTO
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Franz Andel on 01/05/21.
 * Android Engineer
 */

interface HomeService {
    @GET("games")
    suspend fun getAllGames(
        @Query("key") apiKey: String,
        @Query("page") page: Int,
        @Query("page_size") pageSize: Int
    ): GamesDTO
}