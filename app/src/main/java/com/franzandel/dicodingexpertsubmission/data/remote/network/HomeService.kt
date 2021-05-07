package com.franzandel.dicodingexpertsubmission.data.remote.network

import com.franzandel.dicodingexpertsubmission.data.remote.model.response.GamesDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Franz Andel on 01/05/21.
 * Android Engineer
 */

interface HomeService {
    @GET("games")
    suspend fun getAllGames(
        @Query("key") apiKey: String
    ): Response<GamesDTO>
}