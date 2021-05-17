package com.franzandel.feature_home.data.remote.model.response

import com.google.gson.annotations.SerializedName

data class TagDTO(
    @SerializedName("games_count")
    val gamesCount: Int,
    val id: Int,
    @SerializedName("image_background")
    val imageBackground: String,
    val language: String,
    val name: String,
    val slug: String
)