package com.franzandel.feature_favorite.presentation.diffcallback

import androidx.recyclerview.widget.DiffUtil

/**
 * Created by Franz Andel on 09/05/21.
 * Android Engineer
 */

class DetailFavoriteDiffCallback : DiffUtil.ItemCallback<String>() {

    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean =
        oldItem == newItem
}