package com.franzandel.feature_home.di

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.franzandel.core.coroutine.CoroutineThread
import com.franzandel.core.presentation.vm.ViewModelKey
import com.franzandel.dicodingexpertsubmission.BuildConfig
import com.franzandel.dicodingexpertsubmission.data.consts.DatabaseConst
import com.franzandel.feature_home.data.local.dao.DetailHomeDao
import com.franzandel.feature_home.data.local.db.DetailHomeDatabase
import com.franzandel.feature_home.domain.usecase.DetailHomeUseCase
import com.franzandel.feature_home.presentation.vm.DetailHomeViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.multibindings.IntoMap
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory

/**
 * Created by Franz Andel on 11/05/21.
 * Android Engineer
 */

@Module
@InstallIn(ViewModelComponent::class)
object DetailHomeVMModule {

    @Provides
    @IntoMap
    @ViewModelKey(DetailHomeViewModel::class)
    fun provideDetailHomeViewModel(
        useCase: DetailHomeUseCase,
        thread: CoroutineThread
    ): ViewModel =
        DetailHomeViewModel(useCase, thread)

    @Provides
    @ViewModelScoped
    fun provideDetailHomeDatabase(context: Context): DetailHomeDatabase {
        val passphrase = SQLiteDatabase.getBytes(BuildConfig.DB_KEY.toCharArray())
        val supportFactory = SupportFactory(passphrase)

        return Room.databaseBuilder(
            context,
            DetailHomeDatabase::class.java,
            DatabaseConst.GAMER_DB_NAME
        ).fallbackToDestructiveMigration()
            .openHelperFactory(supportFactory)
            .build()
    }

    @Provides
    @ViewModelScoped
    fun provideDetailHomeDao(database: DetailHomeDatabase): DetailHomeDao =
        database.detailDao()
}