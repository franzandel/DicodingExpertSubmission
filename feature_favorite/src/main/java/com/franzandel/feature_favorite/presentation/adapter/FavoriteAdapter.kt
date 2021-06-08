package com.franzandel.feature_favorite.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.franzandel.feature_favorite.databinding.ItemFavoriteBinding
import com.franzandel.feature_favorite.presentation.diffcallback.FavoriteDiffCallback
import com.franzandel.feature_favorite.presentation.model.GamesResultUI
import com.franzandel.feature_favorite.presentation.vh.FavoriteVH

/**
 * Created by Franz Andel on 12/05/21.
 * Android Engineer
 */

class FavoriteAdapter(
    private val onItemClick: (gamesResult: GamesResultUI) -> Unit,
    private val onDeleteClick: (gamesResult: GamesResultUI) -> Unit
) : PagingDataAdapter<GamesResultUI, FavoriteVH>(FavoriteDiffCallback()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavoriteVH {
        val itemFavoriteBinding =
            ItemFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteVH(itemFavoriteBinding)
    }

    override fun onBindViewHolder(holder: FavoriteVH, position: Int) {
        getItem(position)?.let {
            holder.bind(it, onItemClick, onDeleteClick)
        }
    }
}