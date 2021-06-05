package com.franzandel.feature_home.utils

import com.franzandel.feature_home.data.remote.model.response.GamesDTO
import com.franzandel.feature_home.data.remote.model.response.GamesResultDTO
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.StringWriter

/**
 * Created by Franz Andel on 04/06/21.
 * Android Engineer
 */

object RetrofitUtils {

    fun getGamesResultFromJson(): List<GamesResultDTO> {
        val jsonString = getJsonString("games_response.json")
        val dataInMap: Map<String, Any> = jsonString.convertStringToMap()
        val gamesDTO = dataInMap.toDataClass<GamesDTO>()

        return gamesDTO.results
    }

    private fun getJsonString(filePath: String): String {
        val inputStream =
            javaClass.classLoader?.getResourceAsStream(filePath)

        val writer = StringWriter()
        val buffer = CharArray(1024)
        inputStream.use { stream ->
            val reader = BufferedReader(InputStreamReader(stream, "UTF-8"))
            var n: Int
            while (reader.read(buffer).also { n = it } != -1) {
                writer.write(buffer, 0, n)
            }
        }

        return writer.toString()
    }
}