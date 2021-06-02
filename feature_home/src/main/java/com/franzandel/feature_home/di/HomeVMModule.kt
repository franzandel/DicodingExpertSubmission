package com.franzandel.feature_home.di

import androidx.lifecycle.ViewModel
import com.franzandel.core.mapper.BaseMapper
import com.franzandel.core.presentation.vm.ViewModelKey
import com.franzandel.feature_home.data.remote.mapper.response.*
import com.franzandel.feature_home.data.remote.model.response.*
import com.franzandel.feature_home.data.remote.network.HomeService
import com.franzandel.feature_home.domain.mapper.GamesResultsUIMapper
import com.franzandel.feature_home.domain.model.remote.response.*
import com.franzandel.feature_home.domain.usecase.HomeUseCase
import com.franzandel.feature_home.presentation.model.GamesResultUI
import com.franzandel.feature_home.presentation.vm.HomeViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.multibindings.IntoMap
import retrofit2.Retrofit

/**
 * Created by Franz Andel on 07/05/21.
 * Android Engineer
 */

@Module
@InstallIn(ViewModelComponent::class)
object HomeVMModule {

    @Provides
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun provideHomeViewModel(
        useCase: HomeUseCase,
        mapper: BaseMapper<GamesResult, GamesResultUI>
    ): ViewModel =
        HomeViewModel(useCase, mapper)

    @Provides
    fun provideGamesResultsUIMapper(): BaseMapper<List<GamesResult>, List<GamesResultUI>> =
        GamesResultsUIMapper()

    @Provides
    fun provideTagsMapper(): BaseMapper<List<TagDTO>, List<Tag>> = TagsMapper()

    @Provides
    fun provideGamesResultsMapper(
        addedByStatusMapper: BaseMapper<AddedByStatusDTO, AddedByStatus>,
        esrbRatingMapper: BaseMapper<EsrbRatingDTO?, EsrbRating?>,
        genresMapper: BaseMapper<List<GenreDTO>, List<Genre>>,
        parentPlatformsMapper: BaseMapper<List<ParentPlatformDTO>, List<ParentPlatform>>,
        resultPlatformChildMapper: BaseMapper<List<ResultPlatformDTO>, List<ResultPlatform>>,
        ratingsMapper: BaseMapper<List<RatingDTO>, List<Rating>>,
        shortScreenshotMapper: BaseMapper<List<ShortScreenshotDTO>, List<ShortScreenshot>>,
        resultStoreMapper: BaseMapper<List<ResultStoreDTO>, List<ResultStore>>,
        tagsMapper: BaseMapper<List<TagDTO>, List<Tag>>
    ): BaseMapper<List<GamesResultDTO>, List<GamesResult>> =
        GamesResultsMapper(
            addedByStatusMapper,
            esrbRatingMapper,
            genresMapper,
            parentPlatformsMapper,
            resultPlatformChildMapper,
            ratingsMapper,
            shortScreenshotMapper,
            resultStoreMapper,
            tagsMapper
        )

    @Provides
    fun provideParentPlatformsMapper(parentPlatformsChildMapper: BaseMapper<ParentPlatformChildDTO, ParentPlatformChild>): BaseMapper<List<ParentPlatformDTO>, List<ParentPlatform>> =
        ParentPlatformsMapper(parentPlatformsChildMapper)

    @Provides
    fun provideResultPlatformsMapper(
        resultPlatformChildMapper: BaseMapper<ResultPlatformChildDTO, ResultPlatformChild>
    ): BaseMapper<List<ResultPlatformDTO>, List<ResultPlatform>> =
        ResultPlatformsMapper(resultPlatformChildMapper)

    @Provides
    fun provideRatingsMapper(): BaseMapper<List<RatingDTO>, List<Rating>> =
        RatingsMapper()

    @Provides
    fun provideShortScreenshotMapper(): BaseMapper<List<ShortScreenshotDTO>, List<ShortScreenshot>> =
        ShortScreenshotMapper()

    @Provides
    fun provideResultStoreMapper(storeMapper: BaseMapper<StoreDTO, Store>): BaseMapper<List<ResultStoreDTO>, List<ResultStore>> =
        ResultStoreMapper(storeMapper)

    @Provides
    fun provideGenresMapper(): BaseMapper<List<GenreDTO>, List<Genre>> =
        GenresMapper()

    @Provides
    fun provideFiltersYearMapper(
        filtersYearChildMapper: BaseMapper<List<FiltersYearChildDTO>, List<FiltersYearChild>>
    ): BaseMapper<List<FiltersYearDTO>, List<FiltersYear>> =
        FiltersYearMapper(filtersYearChildMapper)

    @Provides
    fun provideFiltersYearChildMapper(): BaseMapper<List<FiltersYearChildDTO>, List<FiltersYearChild>> =
        FiltersYearChildMapper()

    @Provides
    @ViewModelScoped
    fun provideHomeService(retrofit: Retrofit): HomeService =
        retrofit.create(HomeService::class.java)
}