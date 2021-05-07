package com.franzandel.dicodingexpertsubmission.data.remote.model.response

import com.google.gson.annotations.SerializedName

data class GamesResultDTO(
    val added: Int,
    @SerializedName("added_by_status")
    val addedByStatus: AddedByStatusDTO,
    @SerializedName("background_image")
    val backgroundImage: String,
    val clip: Any?,
    @SerializedName("dominant_color")
    val dominantColor: String,
    @SerializedName("esrb_rating")
    val esrbRating: EsrbRatingDTO?,
    val genres: List<GenreDTO>,
    val id: Int,
    val metacritic: Int,
    val name: String,
    @SerializedName("parent_platforms")
    val parentPlatforms: List<ParentPlatformDTO>,
    val platforms: List<ResultPlatformDTO>,
    val playtime: Int,
    val rating: Double,
    @SerializedName("rating_top")
    val ratingTop: Int,
    val ratings: List<RatingDTO>,
    @SerializedName("ratings_count")
    val ratingsCount: Int,
    val released: String,
    @SerializedName("reviews_count")
    val reviewsCount: Int,
    @SerializedName("reviews_text_count")
    val reviewsTextCount: Int,
    @SerializedName("saturated_color")
    val saturatedColor: String,
    @SerializedName("short_screenshots")
    val shortScreenshots: List<ShortScreenshotDTO>,
    val slug: String,
    val stores: List<ResultStoreDTO>,
    @SerializedName("suggestions_count")
    val suggestionsCount: Int,
    val tags: List<TagDTO>,
    val tba: Boolean,
    val updated: String,
    @SerializedName("user_game")
    val userGame: Any?
)