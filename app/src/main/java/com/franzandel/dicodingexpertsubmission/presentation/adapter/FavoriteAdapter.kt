package com.franzandel.dicodingexpertsubmission.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.franzandel.dicodingexpertsubmission.databinding.ItemFavoriteBinding
import com.franzandel.dicodingexpertsubmission.presentation.diffcallback.FavoriteDiffCallback
import com.franzandel.dicodingexpertsubmission.presentation.model.GamesResultUI
import com.franzandel.dicodingexpertsubmission.presentation.vh.FavoriteVH

/**
 * Created by Franz Andel on 12/05/21.
 * Android Engineer
 */

class FavoriteAdapter :
//    BaseAdapter<String, FavoriteVH, ItemDetailBinding>(FavoriteDiffCallback()) {
    PagingDataAdapter<GamesResultUI, FavoriteVH>(FavoriteDiffCallback()) {

//    override fun getViewBinding(parent: ViewGroup): ItemDetailBinding =
//        ItemDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//
//    override fun getViewHolder(viewBinding: ItemDetailBinding): FavoriteVH =
//        FavoriteVH(viewBinding)

    override fun onBindViewHolder(holder: FavoriteVH, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteVH {
        val itemFavoriteBinding =
            ItemFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteVH(itemFavoriteBinding)
    }
}