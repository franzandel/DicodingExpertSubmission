package com.franzandel.dicodingexpertsubmission.core.coroutine

import kotlin.coroutines.CoroutineContext

/**
 * Created by Franz Andel on 04/05/21.
 * Android Engineer
 */

interface CoroutineThread {
    fun main(): CoroutineContext
    fun background(): CoroutineContext
    fun default(): CoroutineContext
}