package com.franzandel.dicodingexpertsubmission.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_screenshots")
data class ScreenshotsDTO(
    @PrimaryKey(autoGenerate = true)
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<ResultDTO>
)