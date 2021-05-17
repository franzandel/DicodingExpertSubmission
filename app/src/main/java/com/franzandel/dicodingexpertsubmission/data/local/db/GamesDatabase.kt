package com.franzandel.dicodingexpertsubmission.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.franzandel.dicodingexpertsubmission.data.local.dao.DetailDao
import com.franzandel.dicodingexpertsubmission.data.local.dao.ScreenshotsDao
import com.franzandel.dicodingexpertsubmission.data.local.model.GamesResultEntity
import com.franzandel.dicodingexpertsubmission.data.local.model.ScreenshotsDTO

/**
 * Created by Franz Andel on 04/05/21.
 * Android Engineer
 */

@Database(
    entities = [ScreenshotsDTO::class, GamesResultEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(ListConverter::class)
abstract class GamesDatabase : RoomDatabase() {
    abstract fun screenshotsDao(): ScreenshotsDao
    abstract fun detailDao(): DetailDao
}