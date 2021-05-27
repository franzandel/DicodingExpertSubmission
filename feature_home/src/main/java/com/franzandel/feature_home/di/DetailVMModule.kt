package com.franzandel.feature_home.di

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.franzandel.core.coroutine.CoroutineThread
import com.franzandel.core.presentation.vm.ViewModelKey
import com.franzandel.dicodingexpertsubmission.BuildConfig
import com.franzandel.dicodingexpertsubmission.data.consts.DatabaseConsts
import com.franzandel.feature_home.data.local.dao.DetailDao
import com.franzandel.feature_home.data.local.db.DetailDatabase
import com.franzandel.feature_home.domain.usecase.DetailUseCase
import com.franzandel.feature_home.presentation.vm.DetailViewModel
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
object DetailVMModule {

    @Provides
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    fun provideDetailViewModel(
        usecase: DetailUseCase,
        thread: CoroutineThread
    ): ViewModel =
        DetailViewModel(usecase, thread)

    @Provides
    @ViewModelScoped
    fun provideDetailDatabase(context: Context): DetailDatabase {
        val passphrase = SQLiteDatabase.getBytes(BuildConfig.DB_KEY.toCharArray())
        val supportFactory = SupportFactory(passphrase)

        return Room.databaseBuilder(
            context,
            DetailDatabase::class.java,
            DatabaseConsts.GAMER_DB_NAME
        ).fallbackToDestructiveMigration()
            .openHelperFactory(supportFactory)
            .build()
    }

    @Provides
    @ViewModelScoped
    fun provideDetailDao(database: DetailDatabase): DetailDao =
        database.detailDao()
}