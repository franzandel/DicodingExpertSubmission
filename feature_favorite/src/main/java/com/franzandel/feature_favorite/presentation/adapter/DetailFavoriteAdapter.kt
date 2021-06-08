package com.franzandel.feature_favorite.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.franzandel.core.presentation.adapter.BaseAdapter
import com.franzandel.feature_favorite.databinding.ItemDetailFavoriteBinding
import com.franzandel.feature_favorite.presentation.diffcallback.DetailFavoriteDiffCallback
import com.franzandel.feature_favorite.presentation.vh.DetailFavoriteVH

/**
 * Created by Franz Andel on 12/05/21.
 * Android Engineer
 */

class DetailFavoriteAdapter : BaseAdapter<String, DetailFavoriteVH, ItemDetailFavoriteBinding>(
    DetailFavoriteDiffCallback()
) {

    override fun getViewBinding(parent: ViewGroup): ItemDetailFavoriteBinding =
        ItemDetailFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)

    override fun getViewHolder(viewBinding: ItemDetailFavoriteBinding): DetailFavoriteVH =
        DetailFavoriteVH(viewBinding)

    override fun onBindViewHolder(holder: DetailFavoriteVH, position: Int) {
        holder.bind(currentList[position])
    }
}