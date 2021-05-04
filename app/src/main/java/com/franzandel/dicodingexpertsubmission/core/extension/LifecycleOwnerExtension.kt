package com.franzandel.dicodingexpertsubmission.core.extension

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

/**
 * Created by Franz Andel on 04/05/21.
 * Android Engineer
 */

inline fun <AllType> LifecycleOwner.observe(
    liveData: LiveData<AllType>,
    crossinline action: (allType: AllType) -> Unit
) {
    liveData.observe(this, Observer {
        it?.let {
            action(it)
        }
    })
}