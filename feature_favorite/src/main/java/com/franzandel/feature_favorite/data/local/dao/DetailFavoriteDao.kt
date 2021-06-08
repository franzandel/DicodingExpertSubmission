package com.franzandel.feature_favorite.data.local.dao

import androidx.room.*
import com.franzandel.feature_favorite.data.local.model.GamesResultEntity

/**
 * Created by Franz Andel on 11/05/21.
 * Android Engineer
 */

@Dao
interface DetailFavoriteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGamesResult(gamesResultEntity: GamesResultEntity): Long

    @Delete
    suspend fun deleteGamesResult(gamesResultEntity: GamesResultEntity): Int

    @Query("SELECT * FROM tbl_games_result WHERE name = :name")
    suspend fun getGamesResult(name: String): GamesResultEntity?
}