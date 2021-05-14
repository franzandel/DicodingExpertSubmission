package com.franzandel.dicodingexpertsubmission.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.franzandel.dicodingexpertsubmission.databinding.ItemHomeBinding
import com.franzandel.dicodingexpertsubmission.presentation.diffcallback.HomeDiffCallback
import com.franzandel.dicodingexpertsubmission.presentation.model.GamesResultUI
import com.franzandel.dicodingexpertsubmission.presentation.vh.HomeVH

/**
 * Created by Franz Andel on 12/02/21.
 * Android Engineer
 */

class HomeAdapter :
//    BaseAdapter<GamesResultUI, HomeVH, ItemHomeBinding>(HomeDiffCallback()) {
    PagingDataAdapter<GamesResultUI, HomeVH>(HomeDiffCallback()) {

//    override fun getViewBinding(parent: ViewGroup): ItemHomeBinding =
//        ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//
//    override fun getViewHolder(viewBinding: ItemHomeBinding): HomeVH =
//        HomeVH(viewBinding)
//
//    override fun onBindViewHolder(holder: HomeVH, position: Int) {
//        holder.bind(currentList[position])
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeVH {
        val itemHomeBinding =
            ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeVH(itemHomeBinding)
    }

    override fun onBindViewHolder(holder: HomeVH, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }
}