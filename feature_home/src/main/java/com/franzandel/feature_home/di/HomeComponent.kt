package com.franzandel.feature_home.di

import android.content.Context
import com.franzandel.dicodingexpertsubmission.di.AppComponent
import com.franzandel.dicodingexpertsubmission.presentation.activity.DashboardActivity
import com.franzandel.feature_home.presentation.fragment.DetailFragment
import com.franzandel.feature_home.presentation.fragment.HomeFragment
import dagger.BindsInstance
import dagger.Component
import dagger.hilt.android.scopes.ViewModelScoped

/**
 * Created by Franz Andel on 16/05/21.
 * Android Engineer
 */

@ViewModelScoped
@Component(
    modules = [HomeVMModule::class, HomeAbstractVMModule::class, DetailVMModule::class, DetailAbstractVMModule::class],
    dependencies = [AppComponent::class]
)
interface HomeComponent {

    fun inject(activity: DashboardActivity)
    fun inject(fragment: HomeFragment)
    fun inject(fragment: DetailFragment)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appComponent(appComponent: AppComponent): Builder
        fun build(): HomeComponent
    }
}