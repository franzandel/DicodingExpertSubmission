package com.franzandel.feature_detail.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.franzandel.dicodingexpertsubmission.data.local.db.ListConverter
import com.franzandel.feature_detail.data.local.dao.DetailDao
import com.franzandel.feature_detail.data.local.model.GamesResultEntity

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
abstract class DetailDatabase : RoomDatabase() {
    abstract fun detailDao(): DetailDao
}