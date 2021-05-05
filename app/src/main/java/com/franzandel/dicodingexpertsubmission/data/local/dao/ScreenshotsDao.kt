package com.franzandel.dicodingexpertsubmission.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.franzandel.dicodingexpertsubmission.data.local.model.ScreenshotsDTO

/**
 * Created by Franz Andel on 04/05/21.
 * Android Engineer
 */

@Dao
interface ScreenshotsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertScreenshots(screenshots: ScreenshotsDTO): Long

    @Query("SELECT * FROM tbl_screenshots")
    suspend fun getScreenshots(): ScreenshotsDTO?
}