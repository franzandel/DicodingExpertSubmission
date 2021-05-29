package com.franzandel.feature_settings.di

import android.content.Context
import com.franzandel.dicodingexpertsubmission.di.AppComponent
import com.franzandel.feature_settings.presentation.fragment.SettingsFragment
import dagger.BindsInstance
import dagger.Component

/**
 * Created by Franz Andel on 17/05/21.
 * Android Engineer
 */

@Component(
    dependencies = [AppComponent::class]
)
interface SettingsComponent {

    fun inject(fragment: SettingsFragment)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appComponent(appComponent: AppComponent): Builder
        fun build(): SettingsComponent
    }
}