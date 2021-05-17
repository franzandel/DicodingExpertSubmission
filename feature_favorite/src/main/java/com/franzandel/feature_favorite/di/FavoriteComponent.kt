package com.franzandel.feature_favorite.di

import android.content.Context
import com.franzandel.dicodingexpertsubmission.di.AppComponent
import com.franzandel.feature_favorite.presentation.fragment.FavoriteFragment
import dagger.BindsInstance
import dagger.Component
import dagger.hilt.android.scopes.ViewModelScoped

/**
 * Created by Franz Andel on 17/05/21.
 * Android Engineer
 */

@ViewModelScoped
@Component(
    modules = [FavoriteVMModule::class, FavoriteAbstractVMModule::class],
    dependencies = [AppComponent::class]
)
interface FavoriteComponent {

    fun inject(fragment: FavoriteFragment)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appComponent(appComponent: AppComponent): Builder
        fun build(): FavoriteComponent
    }
}