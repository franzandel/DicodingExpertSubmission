package com.franzandel.feature_home.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.franzandel.core.presentation.adapter.BaseAdapter
import com.franzandel.feature_home.databinding.ItemDetailBinding
import com.franzandel.feature_home.presentation.diffcallback.DetailHomeDiffCallback
import com.franzandel.feature_home.presentation.vh.DetailHomeVH

/**
 * Created by Franz Andel on 12/05/21.
 * Android Engineer
 */

class DetailHomeAdapter :
    BaseAdapter<String, DetailHomeVH, ItemDetailBinding>(DetailHomeDiffCallback()) {

    override fun getViewBinding(parent: ViewGroup): ItemDetailBinding =
        ItemDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)

    override fun getViewHolder(viewBinding: ItemDetailBinding): DetailHomeVH =
        DetailHomeVH(viewBinding)

    override fun onBindViewHolder(holder: DetailHomeVH, position: Int) {
        holder.bind(currentList[position])
    }
}