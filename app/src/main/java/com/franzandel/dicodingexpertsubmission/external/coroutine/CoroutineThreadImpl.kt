package com.franzandel.dicodingexpertsubmission.external.coroutine

import com.franzandel.core.coroutine.CoroutineThread
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class CoroutineThreadImpl @Inject constructor() :
    CoroutineThread {
    override fun main(): CoroutineContext = Dispatchers.Main

    override fun background(): CoroutineContext = Dispatchers.IO

    override fun default(): CoroutineContext = Dispatchers.Default
}