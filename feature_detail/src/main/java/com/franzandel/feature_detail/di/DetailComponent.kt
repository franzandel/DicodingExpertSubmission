package com.franzandel.feature_detail.di

import android.content.Context
import com.franzandel.dicodingexpertsubmission.di.AppComponent
import com.franzandel.feature_detail.presentation.fragment.DetailFragment
import dagger.BindsInstance
import dagger.Component
import dagger.hilt.android.scopes.ViewModelScoped

/**
 * Created by Franz Andel on 18/05/21.
 * Android Engineer
 */

@ViewModelScoped
@Component(
    modules = [DetailVMModule::class, DetailAbstractVMModule::class],
    dependencies = [AppComponent::class]
)
interface DetailComponent {

    fun inject(fragment: DetailFragment)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appComponent(appComponent: AppComponent): Builder
        fun build(): DetailComponent
    }
}