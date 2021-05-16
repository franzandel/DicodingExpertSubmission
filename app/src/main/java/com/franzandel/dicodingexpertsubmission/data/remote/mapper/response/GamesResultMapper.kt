package com.franzandel.dicodingexpertsubmission.data.remote.mapper.response

import com.franzandel.core.mapper.BaseMapper
import com.franzandel.dicodingexpertsubmission.data.remote.model.response.*
import com.franzandel.dicodingexpertsubmission.domain.model.remote.response.*
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

/**
 * Created by Franz Andel on 14/05/21.
 * Android Engineer
 */

@ViewModelScoped
class GamesResultMapper @Inject constructor(
    private val addedByStatusMapper: BaseMapper<AddedByStatusDTO, AddedByStatus>,
    private val esrbRatingMapper: BaseMapper<EsrbRatingDTO?, EsrbRating?>,
    private val genresMapper: BaseMapper<List<GenreDTO>, List<Genre>>,
    private val parentPlatformsMapper: BaseMapper<List<ParentPlatformDTO>, List<ParentPlatform>>,
    private val resultPlatformsMapper: BaseMapper<List<ResultPlatformDTO>, List<ResultPlatform>>,
    private val ratingsMapper: BaseMapper<List<RatingDTO>, List<Rating>>,
    private val shortScreenshotMapper: BaseMapper<List<ShortScreenshotDTO>, List<ShortScreenshot>>,
    private val resultStoreMapper: BaseMapper<List<ResultStoreDTO>, List<ResultStore>>,
    private val tagsMapper: BaseMapper<List<TagDTO>, List<Tag>>
) : BaseMapper<GamesResultDTO, GamesResult>() {

    override fun map(dataModel: GamesResultDTO): GamesResult =
        with(dataModel) {
            GamesResult(
                added,
                addedByStatusMapper.map(addedByStatus),
                backgroundImage,
                clip,
                dominantColor,
                esrbRatingMapper.map(esrbRating),
                genresMapper.map(genres),
                id,
                metacritic,
                name,
                parentPlatformsMapper.map(parentPlatforms),
                resultPlatformsMapper.map(platforms),
                playtime,
                rating,
                ratingTop,
                ratingsMapper.map(ratings),
                ratingsCount,
                released,
                reviewsCount,
                reviewsTextCount,
                saturatedColor,
                shortScreenshotMapper.map(shortScreenshots),
                slug,
                resultStoreMapper.map(stores),
                suggestionsCount,
                tagsMapper.map(tags),
                tba,
                updated,
                userGame
            )
        }

}