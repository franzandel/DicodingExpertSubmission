package com.franzandel.feature_home.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.franzandel.dicodingexpertsubmission.databinding.ItemHomeBinding
import com.franzandel.feature_home.presentation.diffcallback.HomeDiffCallback
import com.franzandel.feature_home.presentation.model.GamesResultUI
import com.franzandel.feature_home.presentation.vh.HomeVH

/**
 * Created by Franz Andel on 12/05/21.
 * Android Engineer
 */

class HomeAdapter : PagingDataAdapter<GamesResultUI, HomeVH>(HomeDiffCallback()) {

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