package com.franzandel.feature_favorite.di

import android.content.Context
import androidx.room.Room
import com.franzandel.dicodingexpertsubmission.BuildConfig
import com.franzandel.dicodingexpertsubmission.data.consts.DatabaseConst
import com.franzandel.feature_favorite.data.local.db.FavoriteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory

/**
 * Created by Franz Andel on 08/06/21.
 * Android Engineer
 */

@Module
@InstallIn(ViewModelComponent::class)
object SharedFavoriteVMModule {
    @Provides
    @ViewModelScoped
    fun provideFavoriteDatabase(context: Context): FavoriteDatabase {
        val passphrase = SQLiteDatabase.getBytes(BuildConfig.DB_KEY.toCharArray())
        val supportFactory = SupportFactory(passphrase)

        return Room.databaseBuilder(
            context,
            FavoriteDatabase::class.java,
            DatabaseConst.GAMER_DB_NAME
        ).fallbackToDestructiveMigration()
            .openHelperFactory(supportFactory)
            .build()
    }
}