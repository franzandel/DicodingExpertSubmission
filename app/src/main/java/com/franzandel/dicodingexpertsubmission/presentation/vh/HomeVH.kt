package com.franzandel.dicodingexpertsubmission.presentation.vh

import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.franzandel.dicodingexpertsubmission.R
import com.franzandel.dicodingexpertsubmission.databinding.ItemHomeBinding
import com.franzandel.dicodingexpertsubmission.presentation.fragment.HomeFragmentDirections
import com.franzandel.dicodingexpertsubmission.presentation.model.GamesResultUI

/**
 * Created by Franz Andel on 09/05/21.
 * Android Engineer
 */

class HomeVH(private val itemHomeBinding: ItemHomeBinding) :
    RecyclerView.ViewHolder(itemHomeBinding.root) {

    fun bind(gamesResult: GamesResultUI) {
        with(itemHomeBinding) {
            Glide.with(itemView.context)
                .load(gamesResult.backgroundImage)
                .centerCrop()
                .placeholder(R.drawable.ic_image_not_found)
                .into(ivHome)

            tvTitle.text = gamesResult.name
            tvRatings.text = gamesResult.rating.toString()
            cpiRatings.progress = gamesResult.rating.toInt()

            cvHome.setOnClickListener {
                val navDirections =
                    HomeFragmentDirections.actionNavigationHomeToDetailFragment(gamesResult)
                findNavController(root).navigate(navDirections)
            }
        }
    }
}