package com.franzandel.dicodingexpertsubmission.data.remote.network

import com.franzandel.dicodingexpertsubmission.data.remote.model.ScreenshotsResponseDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Franz Andel on 01/05/21.
 * Android Engineer
 */

interface AppService {
    @GET("games/{game_id}/screenshots")
    suspend fun getGameScreenshots(
        @Path("game_id") gameId: String,
        @Query("key") apiKey: String
    ): Response<ScreenshotsResponseDTO>
}