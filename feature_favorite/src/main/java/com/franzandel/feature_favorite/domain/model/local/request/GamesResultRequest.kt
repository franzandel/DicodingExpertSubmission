package com.franzandel.feature_favorite.domain.model.local.request

/**
 * Created by Franz Andel on 11/05/21.
 * Android Engineer
 */

data class GamesResultRequest(
    val name: String,
    val rating: Double,
    val backgroundImage: String,
    val released: String,
    val platforms: List<String>,
    val genres: List<String>,
    val stores: List<String>,
    val tags: List<String>,
    val shortScreenshots: List<String>
)