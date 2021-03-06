package com.franzandel.feature_home.data.remote.model.response

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class ResultPlatformChildDTO(
    @SerializedName("games_count")
    val gamesCount: Int,
    val id: Int,
    val image: Any?,
    @SerializedName("image_background")
    val imageBackground: String,
    val name: String,
    val slug: String,
    @SerializedName("year_end")
    val yearEnd: Any?,
    @SerializedName("year_start")
    val yearStart: Int?
)