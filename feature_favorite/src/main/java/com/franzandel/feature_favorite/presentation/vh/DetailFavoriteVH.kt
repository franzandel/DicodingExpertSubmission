package com.franzandel.feature_favorite.presentation.vh

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.franzandel.dicodingexpertsubmission.R
import com.franzandel.feature_favorite.databinding.ItemDetailFavoriteBinding

/**
 * Created by Franz Andel on 09/05/21.
 * Android Engineer
 */

class DetailFavoriteVH(private val itemDetailFavoriteBinding: ItemDetailFavoriteBinding) :
    RecyclerView.ViewHolder(itemDetailFavoriteBinding.root) {

    fun bind(gamesResult: String) {
        with(itemDetailFavoriteBinding) {
            Glide.with(itemView.context)
                .load(gamesResult)
                .centerCrop()
                .placeholder(R.drawable.ic_image_not_found)
                .into(ivDetail)
        }
    }
}