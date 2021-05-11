package com.franzandel.dicodingexpertsubmission.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Franz Andel on 11/05/21.
 * Android Engineer
 */

@Entity(tableName = "tbl_games_result")
data class GamesResultEntity(
    @PrimaryKey
    val name: String,
    val rating: Double,
    @ColumnInfo(name = "background_image")
    val backgroundImage: String,
    val released: String,
    val platforms: List<String>,
    val genres: List<String>,
    val stores: List<String>,
    val tags: List<String>,
    @ColumnInfo(name = "short_screenshots")
    val shortScreenshots: List<String>
)