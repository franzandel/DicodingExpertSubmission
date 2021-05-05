package com.franzandel.dicodingexpertsubmission.data.local.db

import androidx.room.TypeConverter
import com.franzandel.dicodingexpertsubmission.data.local.model.ResultDTO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by Franz Andel on 05/05/21.
 * Android Engineer
 */

class ListConverter {

    @TypeConverter
    fun fromCountryLangList(value: List<ResultDTO>): String {
        val gson = Gson()
        val type = object : TypeToken<List<ResultDTO>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toCountryLangList(value: String): List<ResultDTO> {
        val gson = Gson()
        val type = object : TypeToken<List<ResultDTO>>() {}.type
        return gson.fromJson(value, type)
    }
}