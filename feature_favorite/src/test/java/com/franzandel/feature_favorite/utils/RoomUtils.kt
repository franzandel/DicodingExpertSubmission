package com.franzandel.feature_favorite.utils

import com.franzandel.feature_favorite.data.local.model.GamesResultEntity
import com.franzandel.feature_favorite.domain.model.local.request.GamesResultRequest
import com.franzandel.feature_favorite.presentation.model.GamesResultUI

/**
 * Created by Franz Andel on 02/06/21.
 * Android Engineer
 */

object RoomUtils {

    const val ERROR_INSERT_TO_DB = "Error insert to DB"
    const val ERROR_DELETE_FROM_DB = "Error delete from DB"
    const val NO_DATA_FOUND = "No data found on DB"

    fun getGamesResultUI(): GamesResultUI =
        GamesResultUI(
            name = "Grand Theft Auto V",
            rating = 4.48,
            backgroundImage = "https://media.rawg.io/media/games/84d/84da2ac3fdfc6507807a1808595afb12.jpg",
            released = "2013-09-17",
            platforms = listOf(
                "PlayStation 5",
                "PlayStation 4",
                "PlayStation 3",
                "Xbox 360",
                "PC",
                "Xbox One",
                "Xbox Series S/X"
            ),
            genres = listOf("Action", "Adventure"),
            stores = listOf(
                "PlayStation Store",
                "Epic Games",
                "Steam",
                "Xbox 360 Store",
                "Xbox Store"
            ),
            tags = listOf(
                "Singleplayer",
                "Steam Achievements",
                "Multiplayer",
                "Atmospheric",
                "Full controller support",
                "Great Soundtrack",
                "RPG",
                "Co-op",
                "Open World",
                "cooperative",
                "First-Person",
                "Third Person",
                "Funny",
                "Sandbox",
                "Comedy",
                "Third-Person Shooter",
                "Moddable",
                "Crime",
                "vr mod"
            ),
            shortScreenshots = listOf(
                "https://media.rawg.io/media/games/84d/84da2ac3fdfc6507807a1808595afb12.jpg",
                "https://media.rawg.io/media/screenshots/a7c/a7c43871a54bed6573a6a429451564ef.jpg",
                "https://media.rawg.io/media/screenshots/cf4/cf4367daf6a1e33684bf19adb02d16d6.jpg",
                "https://media.rawg.io/media/screenshots/f95/f9518b1d99210c0cae21fc09e95b4e31.jpg",
                "https://media.rawg.io/media/screenshots/a5c/a5c95ea539c87d5f538763e16e18fb99.jpg",
                "https://media.rawg.io/media/screenshots/a7e/a7e990bc574f4d34e03b5926361d1ee7.jpg",
                "https://media.rawg.io/media/screenshots/592/592e2501d8734b802b2a34fee2df59fa.jpg"
            )
        )

    fun getGamesResultRequest(): GamesResultRequest =
        GamesResultRequest(
            name = "Grand Theft Auto V",
            rating = 4.48,
            backgroundImage = "https://media.rawg.io/media/games/84d/84da2ac3fdfc6507807a1808595afb12.jpg",
            released = "2013-09-17",
            platforms = listOf(
                "PlayStation 5",
                "PlayStation 4",
                "PlayStation 3",
                "Xbox 360",
                "PC",
                "Xbox One",
                "Xbox Series S/X"
            ),
            genres = listOf("Action", "Adventure"),
            stores = listOf(
                "PlayStation Store",
                "Epic Games",
                "Steam",
                "Xbox 360 Store",
                "Xbox Store"
            ),
            tags = listOf(
                "Singleplayer",
                "Steam Achievements",
                "Multiplayer",
                "Atmospheric",
                "Full controller support",
                "Great Soundtrack",
                "RPG",
                "Co-op",
                "Open World",
                "cooperative",
                "First-Person",
                "Third Person",
                "Funny",
                "Sandbox",
                "Comedy",
                "Third-Person Shooter",
                "Moddable",
                "Crime",
                "vr mod"
            ),
            shortScreenshots = listOf(
                "https://media.rawg.io/media/games/84d/84da2ac3fdfc6507807a1808595afb12.jpg",
                "https://media.rawg.io/media/screenshots/a7c/a7c43871a54bed6573a6a429451564ef.jpg",
                "https://media.rawg.io/media/screenshots/cf4/cf4367daf6a1e33684bf19adb02d16d6.jpg",
                "https://media.rawg.io/media/screenshots/f95/f9518b1d99210c0cae21fc09e95b4e31.jpg",
                "https://media.rawg.io/media/screenshots/a5c/a5c95ea539c87d5f538763e16e18fb99.jpg",
                "https://media.rawg.io/media/screenshots/a7e/a7e990bc574f4d34e03b5926361d1ee7.jpg",
                "https://media.rawg.io/media/screenshots/592/592e2501d8734b802b2a34fee2df59fa.jpg"
            )
        )

    fun getGamesResultEntity(): GamesResultEntity =
        GamesResultEntity(
            name = "Grand Theft Auto V",
            rating = 4.48,
            backgroundImage = "https://media.rawg.io/media/games/84d/84da2ac3fdfc6507807a1808595afb12.jpg",
            released = "2013-09-17",
            platforms = listOf(
                "PlayStation 5",
                "PlayStation 4",
                "PlayStation 3",
                "Xbox 360",
                "PC",
                "Xbox One",
                "Xbox Series S/X"
            ),
            genres = listOf("Action", "Adventure"),
            stores = listOf(
                "PlayStation Store",
                "Epic Games",
                "Steam",
                "Xbox 360 Store",
                "Xbox Store"
            ),
            tags = listOf(
                "Singleplayer",
                "Steam Achievements",
                "Multiplayer",
                "Atmospheric",
                "Full controller support",
                "Great Soundtrack",
                "RPG",
                "Co-op",
                "Open World",
                "cooperative",
                "First-Person",
                "Third Person",
                "Funny",
                "Sandbox",
                "Comedy",
                "Third-Person Shooter",
                "Moddable",
                "Crime",
                "vr mod"
            ),
            shortScreenshots = listOf(
                "https://media.rawg.io/media/games/84d/84da2ac3fdfc6507807a1808595afb12.jpg",
                "https://media.rawg.io/media/screenshots/a7c/a7c43871a54bed6573a6a429451564ef.jpg",
                "https://media.rawg.io/media/screenshots/cf4/cf4367daf6a1e33684bf19adb02d16d6.jpg",
                "https://media.rawg.io/media/screenshots/f95/f9518b1d99210c0cae21fc09e95b4e31.jpg",
                "https://media.rawg.io/media/screenshots/a5c/a5c95ea539c87d5f538763e16e18fb99.jpg",
                "https://media.rawg.io/media/screenshots/a7e/a7e990bc574f4d34e03b5926361d1ee7.jpg",
                "https://media.rawg.io/media/screenshots/592/592e2501d8734b802b2a34fee2df59fa.jpg"
            )
        )

    fun getGamesResultsEntity(): List<GamesResultEntity> =
        listOf(
            GamesResultEntity(
                name = "Grand Theft Auto V",
                rating = 4.48,
                backgroundImage = "https://media.rawg.io/media/games/84d/84da2ac3fdfc6507807a1808595afb12.jpg",
                released = "2013-09-17",
                platforms = listOf(
                    "PlayStation 5",
                    "PlayStation 4",
                    "PlayStation 3",
                    "Xbox 360",
                    "PC",
                    "Xbox One",
                    "Xbox Series S/X"
                ),
                genres = listOf("Action", "Adventure"),
                stores = listOf(
                    "PlayStation Store",
                    "Epic Games",
                    "Steam",
                    "Xbox 360 Store",
                    "Xbox Store"
                ),
                tags = listOf(
                    "Singleplayer",
                    "Steam Achievements",
                    "Multiplayer",
                    "Atmospheric",
                    "Full controller support",
                    "Great Soundtrack",
                    "RPG",
                    "Co-op",
                    "Open World",
                    "cooperative",
                    "First-Person",
                    "Third Person",
                    "Funny",
                    "Sandbox",
                    "Comedy",
                    "Third-Person Shooter",
                    "Moddable",
                    "Crime",
                    "vr mod"
                ),
                shortScreenshots = listOf(
                    "https://media.rawg.io/media/games/84d/84da2ac3fdfc6507807a1808595afb12.jpg",
                    "https://media.rawg.io/media/screenshots/a7c/a7c43871a54bed6573a6a429451564ef.jpg",
                    "https://media.rawg.io/media/screenshots/cf4/cf4367daf6a1e33684bf19adb02d16d6.jpg",
                    "https://media.rawg.io/media/screenshots/f95/f9518b1d99210c0cae21fc09e95b4e31.jpg",
                    "https://media.rawg.io/media/screenshots/a5c/a5c95ea539c87d5f538763e16e18fb99.jpg",
                    "https://media.rawg.io/media/screenshots/a7e/a7e990bc574f4d34e03b5926361d1ee7.jpg",
                    "https://media.rawg.io/media/screenshots/592/592e2501d8734b802b2a34fee2df59fa.jpg"
                )
            ),
            GamesResultEntity(
                name = "Final Fantasy XV",
                rating = 4.79,
                backgroundImage = "https://media.rawg.io/media/games/84d/84da2ac3fdfc6507807a1808595afb12.jpg",
                released = "2016-11-29",
                platforms = listOf(
                    "PlayStation 5",
                    "Xbox 360",
                    "PC",
                    "Xbox One"
                ),
                genres = listOf("Action", "Adventure", "RPG"),
                stores = listOf(
                    "PlayStation Store",
                    "Xbox 360 Store",
                    "Xbox Store"
                ),
                tags = listOf(
                    "Singleplayer",
                    "Steam Achievements",
                    "Multiplayer",
                    "Atmospheric",
                    "Full controller support",
                    "Great Soundtrack",
                    "RPG",
                    "Open World",
                    "cooperative",
                    "Funny",
                    "Sandbox"
                ),
                shortScreenshots = listOf(
                    "https://media.rawg.io/media/games/84d/84da2ac3fdfc6507807a1808595afb12.jpg",
                    "https://media.rawg.io/media/screenshots/a7c/a7c43871a54bed6573a6a429451564ef.jpg",
                    "https://media.rawg.io/media/screenshots/cf4/cf4367daf6a1e33684bf19adb02d16d6.jpg",
                    "https://media.rawg.io/media/screenshots/f95/f9518b1d99210c0cae21fc09e95b4e31.jpg",
                    "https://media.rawg.io/media/screenshots/a5c/a5c95ea539c87d5f538763e16e18fb99.jpg",
                    "https://media.rawg.io/media/screenshots/a7e/a7e990bc574f4d34e03b5926361d1ee7.jpg",
                    "https://media.rawg.io/media/screenshots/592/592e2501d8734b802b2a34fee2df59fa.jpg"
                )
            )
        )

    fun getGamesResultRequests(): List<GamesResultRequest> =
        listOf(
            GamesResultRequest(
                name = "Grand Theft Auto V",
                rating = 4.48,
                backgroundImage = "https://media.rawg.io/media/games/84d/84da2ac3fdfc6507807a1808595afb12.jpg",
                released = "2013-09-17",
                platforms = listOf(
                    "PlayStation 5",
                    "PlayStation 4",
                    "PlayStation 3",
                    "Xbox 360",
                    "PC",
                    "Xbox One",
                    "Xbox Series S/X"
                ),
                genres = listOf("Action", "Adventure"),
                stores = listOf(
                    "PlayStation Store",
                    "Epic Games",
                    "Steam",
                    "Xbox 360 Store",
                    "Xbox Store"
                ),
                tags = listOf(
                    "Singleplayer",
                    "Steam Achievements",
                    "Multiplayer",
                    "Atmospheric",
                    "Full controller support",
                    "Great Soundtrack",
                    "RPG",
                    "Co-op",
                    "Open World",
                    "cooperative",
                    "First-Person",
                    "Third Person",
                    "Funny",
                    "Sandbox",
                    "Comedy",
                    "Third-Person Shooter",
                    "Moddable",
                    "Crime",
                    "vr mod"
                ),
                shortScreenshots = listOf(
                    "https://media.rawg.io/media/games/84d/84da2ac3fdfc6507807a1808595afb12.jpg",
                    "https://media.rawg.io/media/screenshots/a7c/a7c43871a54bed6573a6a429451564ef.jpg",
                    "https://media.rawg.io/media/screenshots/cf4/cf4367daf6a1e33684bf19adb02d16d6.jpg",
                    "https://media.rawg.io/media/screenshots/f95/f9518b1d99210c0cae21fc09e95b4e31.jpg",
                    "https://media.rawg.io/media/screenshots/a5c/a5c95ea539c87d5f538763e16e18fb99.jpg",
                    "https://media.rawg.io/media/screenshots/a7e/a7e990bc574f4d34e03b5926361d1ee7.jpg",
                    "https://media.rawg.io/media/screenshots/592/592e2501d8734b802b2a34fee2df59fa.jpg"
                )
            ),
            GamesResultRequest(
                name = "Final Fantasy XV",
                rating = 4.79,
                backgroundImage = "https://media.rawg.io/media/games/84d/84da2ac3fdfc6507807a1808595afb12.jpg",
                released = "2016-11-29",
                platforms = listOf(
                    "PlayStation 5",
                    "Xbox 360",
                    "PC",
                    "Xbox One"
                ),
                genres = listOf("Action", "Adventure", "RPG"),
                stores = listOf(
                    "PlayStation Store",
                    "Xbox 360 Store",
                    "Xbox Store"
                ),
                tags = listOf(
                    "Singleplayer",
                    "Steam Achievements",
                    "Multiplayer",
                    "Atmospheric",
                    "Full controller support",
                    "Great Soundtrack",
                    "RPG",
                    "Open World",
                    "cooperative",
                    "Funny",
                    "Sandbox"
                ),
                shortScreenshots = listOf(
                    "https://media.rawg.io/media/games/84d/84da2ac3fdfc6507807a1808595afb12.jpg",
                    "https://media.rawg.io/media/screenshots/a7c/a7c43871a54bed6573a6a429451564ef.jpg",
                    "https://media.rawg.io/media/screenshots/cf4/cf4367daf6a1e33684bf19adb02d16d6.jpg",
                    "https://media.rawg.io/media/screenshots/f95/f9518b1d99210c0cae21fc09e95b4e31.jpg",
                    "https://media.rawg.io/media/screenshots/a5c/a5c95ea539c87d5f538763e16e18fb99.jpg",
                    "https://media.rawg.io/media/screenshots/a7e/a7e990bc574f4d34e03b5926361d1ee7.jpg",
                    "https://media.rawg.io/media/screenshots/592/592e2501d8734b802b2a34fee2df59fa.jpg"
                )
            )
        )
}