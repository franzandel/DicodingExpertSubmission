package com.franzandel.dicodingexpertsubmission.presentation.vh

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.franzandel.dicodingexpertsubmission.R
import com.franzandel.dicodingexpertsubmission.databinding.ItemDetailBinding

/**
 * Created by Franz Andel on 09/05/21.
 * Android Engineer
 */

class DetailVH(private val itemDetailBinding: ItemDetailBinding) :
    RecyclerView.ViewHolder(itemDetailBinding.root) {

    fun bind(gamesResult: String) {
        with(itemDetailBinding) {
            Glide.with(itemView.context)
                .load(gamesResult)
                .centerCrop()
                .placeholder(R.drawable.ic_image_not_found)
                .into(ivDetail)
        }
    }
}