package com.franzandel.feature_home.data.remote.mapper.response

import com.franzandel.core.mapper.BaseMapper
import com.franzandel.feature_home.data.remote.model.response.*
import com.franzandel.feature_home.domain.model.remote.response.*
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

/**
 * Created by Franz Andel on 04/05/21.
 * Android Engineer
 */

@ViewModelScoped
class GamesResultsMapper @Inject constructor(
    private val addedByStatusMapper: BaseMapper<AddedByStatusDTO, AddedByStatus>,
    private val esrbRatingMapper: BaseMapper<EsrbRatingDTO?, EsrbRating?>,
    private val genresMapper: BaseMapper<List<GenreDTO>, List<Genre>>,
    private val parentPlatformsMapper: BaseMapper<List<ParentPlatformDTO>, List<ParentPlatform>>,
    private val resultPlatformsMapper: BaseMapper<List<ResultPlatformDTO>, List<ResultPlatform>>,
    private val ratingsMapper: BaseMapper<List<RatingDTO>, List<Rating>>,
    private val shortScreenshotMapper: BaseMapper<List<ShortScreenshotDTO>, List<ShortScreenshot>>,
    private val resultStoreMapper: BaseMapper<List<ResultStoreDTO>, List<ResultStore>>,
    private val tagsMapper: BaseMapper<List<TagDTO>, List<Tag>>
) : BaseMapper<List<GamesResultDTO>, List<GamesResult>>() {

    override fun map(dataModel: List<GamesResultDTO>): List<GamesResult> =
        with(dataModel) {
            map {
                GamesResult(
                    it.added,
                    addedByStatusMapper.map(it.addedByStatus),
                    it.backgroundImage,
                    it.clip,
                    it.dominantColor,
                    esrbRatingMapper.map(it.esrbRating),
                    genresMapper.map(it.genres),
                    it.id,
                    it.metacritic,
                    it.name,
                    parentPlatformsMapper.map(it.parentPlatforms),
                    resultPlatformsMapper.map(it.platforms),
                    it.playtime,
                    it.rating,
                    it.ratingTop,
                    ratingsMapper.map(it.ratings),
                    it.ratingsCount,
                    it.released,
                    it.reviewsCount,
                    it.reviewsTextCount,
                    it.saturatedColor,
                    shortScreenshotMapper.map(it.shortScreenshots),
                    it.slug,
                    resultStoreMapper.map(it.stores),
                    it.suggestionsCount,
                    tagsMapper.map(it.tags),
                    it.tba,
                    it.updated,
                    it.userGame
                )
            }
        }
}