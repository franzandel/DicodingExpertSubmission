package com.franzandel.feature_favorite.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.franzandel.dicodingexpertsubmission.data.local.ListConverter
import com.franzandel.feature_favorite.data.local.dao.FavoriteDao
import com.franzandel.feature_favorite.data.local.model.GamesResultEntity

/**
 * Created by Franz Andel on 04/05/21.
 * Android Engineer
 */

@Database(
    entities = [GamesResultEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(ListConverter::class)
abstract class FavoriteDatabase : RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao
}