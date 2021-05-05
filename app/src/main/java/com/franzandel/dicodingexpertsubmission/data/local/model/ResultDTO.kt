package com.franzandel.dicodingexpertsubmission.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_result")
data class ResultDTO(
    @PrimaryKey
    val id: Int,
    val height: Int,
    val image: String,
    @ColumnInfo(name = "is_deleted")
    val isDeleted: Boolean,
    val width: Int
)