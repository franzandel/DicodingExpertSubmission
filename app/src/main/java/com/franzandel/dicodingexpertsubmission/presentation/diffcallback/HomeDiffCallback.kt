package com.franzandel.dicodingexpertsubmission.presentation.diffcallback

import androidx.recyclerview.widget.DiffUtil
import com.franzandel.dicodingexpertsubmission.presentation.model.GamesResultUI

/**
 * Created by Franz Andel on 09/05/21.
 * Android Engineer
 */

class HomeDiffCallback : DiffUtil.ItemCallback<GamesResultUI>() {

    override fun areItemsTheSame(oldItem: GamesResultUI, newItem: GamesResultUI): Boolean =
        oldItem.name == newItem.name

    override fun areContentsTheSame(oldItem: GamesResultUI, newItem: GamesResultUI): Boolean =
        oldItem == newItem
}