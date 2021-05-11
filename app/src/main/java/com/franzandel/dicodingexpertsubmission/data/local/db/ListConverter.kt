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
    fun fromResultDTOList(value: List<ResultDTO>): String {
        val gson = Gson()
        val type = object : TypeToken<List<ResultDTO>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun fromStringList(value: List<String>): String {
        val gson = Gson()
        val type = object : TypeToken<List<String>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toResultDTOList(value: String): List<ResultDTO> {
        val gson = Gson()
        val type = object : TypeToken<List<ResultDTO>>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun toStringList(value: String): List<String> {
        val gson = Gson()
        val type = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(value, type)
    }
}