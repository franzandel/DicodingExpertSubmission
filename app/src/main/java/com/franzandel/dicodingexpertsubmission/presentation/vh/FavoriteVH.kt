package com.franzandel.dicodingexpertsubmission.presentation.vh

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.franzandel.dicodingexpertsubmission.R
import com.franzandel.dicodingexpertsubmission.core.extension.toCommaString
import com.franzandel.dicodingexpertsubmission.databinding.ItemFavoriteBinding
import com.franzandel.dicodingexpertsubmission.presentation.model.GamesResultUI

/**
 * Created by Franz Andel on 12/05/21.
 * Android Engineer
 */

class FavoriteVH(private val itemFavoriteBinding: ItemFavoriteBinding) :
    RecyclerView.ViewHolder(itemFavoriteBinding.root) {

    fun bind(
        gamesResult: GamesResultUI,
        onDeleteClick: (gamesResult: GamesResultUI) -> Unit
    ) {
        with(itemFavoriteBinding) {
            Glide.with(itemView.context)
                .load(gamesResult.backgroundImage)
                .centerCrop()
                .placeholder(R.drawable.ic_image_not_found)
                .into(ivFavorite)

            tvTitle.text = gamesResult.name
            tvRelease.text = gamesResult.released
            tvPlatforms.text = gamesResult.platforms.toCommaString()
            tvGenres.text = gamesResult.genres.toCommaString()
            tvRatings.text = gamesResult.rating.toString()
            cpiRatings.progress = gamesResult.rating.toInt()

            ivDelete.setOnClickListener {
                onDeleteClick.invoke(gamesResult)
            }
//
//            cvHome.setOnClickListener {
//                val navDirections =
//                    HomeFragmentDirections.actionNavigationHomeToDetailFragment()
////                navDirections.movies = movies.toTypedArray()
////                navDirections.currentPosition = adapterPosition
//                findNavController(root).navigate(navDirections)
//            }
        }
    }
}