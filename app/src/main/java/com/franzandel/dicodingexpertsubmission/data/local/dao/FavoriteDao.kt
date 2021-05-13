package com.franzandel.dicodingexpertsubmission.data.local.dao

import androidx.paging.PagingSource
import androidx.room.*
import com.franzandel.dicodingexpertsubmission.data.local.model.GamesResultEntity

/**
 * Created by Franz Andel on 12/05/21.
 * Android Engineer
 */

@Dao
interface FavoriteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGamesResult(gamesResultEntity: GamesResultEntity): Long

    @Delete
    suspend fun deleteGamesResult(gamesResultEntity: GamesResultEntity): Int

    @Query("SELECT * FROM tbl_games_result")
    fun getGamesResult(): PagingSource<Int, GamesResultEntity>
}