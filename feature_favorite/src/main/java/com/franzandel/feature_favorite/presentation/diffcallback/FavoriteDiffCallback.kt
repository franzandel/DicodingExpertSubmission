package com.franzandel.feature_favorite.presentation.diffcallback

import androidx.recyclerview.widget.DiffUtil
import com.franzandel.feature_favorite.presentation.model.GamesResultUI

/**
 * Created by Franz Andel on 12/05/21.
 * Android Engineer
 */

class FavoriteDiffCallback : DiffUtil.ItemCallback<GamesResultUI>() {

    override fun areItemsTheSame(oldItem: GamesResultUI, newItem: GamesResultUI): Boolean =
        oldItem.name == newItem.name

    override fun areContentsTheSame(oldItem: GamesResultUI, newItem: GamesResultUI): Boolean =
        oldItem == newItem
}