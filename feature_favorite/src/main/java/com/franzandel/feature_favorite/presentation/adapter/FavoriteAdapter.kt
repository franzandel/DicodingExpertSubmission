package com.franzandel.feature_favorite.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.franzandel.dicodingexpertsubmission.databinding.ItemFavoriteBinding
import com.franzandel.feature_favorite.presentation.model.GamesResultUI

/**
 * Created by Franz Andel on 12/05/21.
 * Android Engineer
 */

class FavoriteAdapter(
    private val onDeleteClick: (gamesResult: GamesResultUI) -> Unit
) : PagingDataAdapter<GamesResultUI, com.franzandel.feature_favorite.presentation.vh.FavoriteVH>(
    com.franzandel.feature_favorite.presentation.diffcallback.FavoriteDiffCallback()
) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): com.franzandel.feature_favorite.presentation.vh.FavoriteVH {
        val itemFavoriteBinding =
            ItemFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return com.franzandel.feature_favorite.presentation.vh.FavoriteVH(
            itemFavoriteBinding
        )
    }

    override fun onBindViewHolder(
        holder: com.franzandel.feature_favorite.presentation.vh.FavoriteVH,
        position: Int
    ) {
        getItem(position)?.let {
            holder.bind(it, onDeleteClick)
        }
    }
}