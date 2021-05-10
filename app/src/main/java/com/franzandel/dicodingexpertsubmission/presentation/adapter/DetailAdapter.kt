package com.franzandel.dicodingexpertsubmission.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.franzandel.dicodingexpertsubmission.core.presentation.BaseAdapter
import com.franzandel.dicodingexpertsubmission.databinding.ItemDetailBinding
import com.franzandel.dicodingexpertsubmission.presentation.diffcallback.DetailDiffCallback
import com.franzandel.dicodingexpertsubmission.presentation.vh.DetailVH

/**
 * Created by Franz Andel on 12/02/21.
 * Android Engineer
 */

class DetailAdapter :
    BaseAdapter<String, DetailVH, ItemDetailBinding>(DetailDiffCallback()) {

    override fun getViewBinding(parent: ViewGroup): ItemDetailBinding =
        ItemDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)

    override fun getViewHolder(viewBinding: ItemDetailBinding): DetailVH =
        DetailVH(viewBinding)

    override fun onBindViewHolder(holder: DetailVH, position: Int) {
        holder.bind(currentList[position])
    }
}