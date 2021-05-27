package com.franzandel.feature_home.data.remote.model.response

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class GenreDTO(
    @SerializedName("games_count")
    val gamesCount: Int,
    val id: Int,
    @SerializedName("image_background")
    val imageBackground: String,
    val name: String,
    val slug: String
)