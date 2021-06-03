package com.franzandel.feature_home.utils

import com.franzandel.feature_home.data.local.model.GamesResultEntity
import com.franzandel.feature_home.domain.model.local.request.GamesResultRequest
import com.franzandel.feature_home.domain.model.remote.response.*
import com.franzandel.feature_home.presentation.model.GamesResultUI

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

    fun getGamesResults(): List<GamesResult> =
        listOf(
            GamesResult(
                added = 14985,
                addedByStatus = AddedByStatus(
                    beaten = 3979,
                    dropped = 727,
                    owned = 8950,
                    playing = 543,
                    toplay = 408,
                    yet = 378
                ),
                backgroundImage = "https://media.rawg.io/media/games/84d/84da2ac3fdfc6507807a1808595afb12.jpg",
                clip = null,
                dominantColor = "0f0f0f",
                esrbRating = EsrbRating(id = 4, name = "Mature", slug = "mature"),
                genres = listOf(
                    Genre(
                        gamesCount = 117633,
                        id = 4,
                        imageBackground = "https://media.rawg.io/media/games/b7d/b7d3f1715fa8381a4e780173a197a615.jpg",
                        name = "Action",
                        slug = "action"
                    ),
                    Genre(
                        gamesCount = 86221,
                        id = 3,
                        imageBackground = "https://media.rawg.io/media/games/995/9951d9d55323d08967640f7b9ab3e342.jpg",
                        name = "Adventure",
                        slug = "adventure"
                    )
                ),
                id = 3498,
                metacritic = 97,
                name = "Grand Theft Auto V",
                parentPlatforms = listOf(
                    ParentPlatform(
                        platform = ParentPlatformChild(
                            id = 1,
                            name = "PC",
                            slug = "pc"
                        )
                    ),
                    ParentPlatform(
                        platform = ParentPlatformChild(
                            id = 2,
                            name = "PlayStation",
                            slug = "playstation"
                        )
                    ),
                    ParentPlatform(
                        platform = ParentPlatformChild(
                            id = 3,
                            name = "Xbox",
                            slug = "xbox"
                        )
                    )
                ),
                platforms = listOf(
                    ResultPlatform(
                        platform = ResultPlatformChild(
                            gamesCount = 213,
                            id = 187,
                            image = null,
                            imageBackground = "https://media.rawg.io/media/screenshots/6e1/6e13d9acb4e7a6e184f24892f52c4544.jpg",
                            name = "PlayStation 5",
                            slug = "playstation5",
                            yearEnd = null,
                            yearStart = 2020
                        ), releasedAt = "2013-09-17", requirementsEn = null, requirementsRu = null
                    ),
                    ResultPlatform(
                        platform = ResultPlatformChild(
                            gamesCount = 5913,
                            id = 18,
                            image = null,
                            imageBackground = "https://media.rawg.io/media/games/c4b/c4b0cab189e73432de3a250d8cf1c84e.jpg",
                            name = "PlayStation 4",
                            slug = "playstation4",
                            yearEnd = null,
                            yearStart = null
                        ), releasedAt = "2013-09-17", requirementsEn = null, requirementsRu = null
                    ),
                    ResultPlatform(
                        platform = ResultPlatformChild(
                            gamesCount = 3624,
                            id = 16,
                            image = null,
                            imageBackground = "https://media.rawg.io/media/games/15c/15c95a4915f88a3e89c821526afe05fc.jpg",
                            name = "PlayStation 3",
                            slug = "playstation3",
                            yearEnd = null,
                            yearStart = null
                        ), releasedAt = "2013-09-17", requirementsEn = null, requirementsRu = null
                    ),
                    ResultPlatform(
                        platform = ResultPlatformChild(
                            gamesCount = 2714,
                            id = 14,
                            image = null,
                            imageBackground = "https://media.rawg.io/media/games/490/49016e06ae2103881ff6373248843069.jpg",
                            name = "Xbox 360",
                            slug = "xbox360",
                            yearEnd = null,
                            yearStart = null
                        ), releasedAt = "2013-09-17", requirementsEn = null, requirementsRu = null
                    ),
                    ResultPlatform(
                        platform = ResultPlatformChild(
                            gamesCount = 329868,
                            id = 4,
                            image = null,
                            imageBackground = "https://media.rawg.io/media/games/736/73619bd336c894d6941d926bfd563946.jpg",
                            name = "PC",
                            slug = "pc",
                            yearEnd = null,
                            yearStart = null
                        ),
                        releasedAt = "2013-09-17",
                        requirementsEn = "{minimum=Minimum:OS: Windows 10 64 Bit, Windows 8.1 64 Bit, Windows 8 64 Bit, Windows 7 64 Bit Service Pack 1, Windows Vista 64 Bit Service Pack 2* (*NVIDIA video card recommended if running Vista OS)Processor: Intel Core 2 Quad CPU Q6600 @ 2.40GHz (4 CPUs) / AMD Phenom 9850 Quad-Core Processor (4 CPUs) @ 2.5GHzMemory: 4 GB RAMGraphics: NVIDIA 9800 GT 1GB / AMD HD 4870 1GB (DX 10, 10.1, 11)Storage: 72 GB available spaceSound Card: 100% DirectX 10 compatibleAdditional Notes: Over time downloadable content and programming changes will change the system requirements for this game.  Please refer to your hardware manufacturer and www.rockstargames.com/support for current compatibility information. Some system components such as mobile chipsets, integrated, and AGP graphics cards may be incompatible. Unlisted specifications may not be supported by publisher.     Other requirements:  Installation and online play requires log-in to Rockstar Games Social Club (13+) network; internet connection required for activation, online play, and periodic entitlement verification; software installations required including Rockstar Games Social Club platform, DirectX , Chromium, and Microsoft Visual C++ 2008 sp1 Redistributable Package, and authentication software that recognizes certain hardware attributes for entitlement, digital rights management, system, and other support purposes.     SINGLE USE SERIAL CODE REGISTRATION VIA INTERNET REQUIRED; REGISTRATION IS LIMITED TO ONE ROCKSTAR GAMES SOCIAL CLUB ACCOUNT (13+) PER SERIAL CODE; ONLY ONE PC LOG-IN ALLOWED PER SOCIAL CLUB ACCOUNT AT ANY TIME; SERIAL CODE(S) ARE NON-TRANSFERABLE ONCE USED; SOCIAL CLUB ACCOUNTS ARE NON-TRANSFERABLE.  Partner Requirements:  Please check the terms of service of this site before purchasing this software., recommended=Recommended:OS: Windows 10 64 Bit, Windows 8.1 64 Bit, Windows 8 64 Bit, Windows 7 64 Bit Service Pack 1Processor: Intel Core i5 3470 @ 3.2GHz (4 CPUs) / AMD X8 FX-8350 @ 4GHz (8 CPUs)Memory: 8 GB RAMGraphics: NVIDIA GTX 660 2GB / AMD HD 7870 2GBStorage: 72 GB available spaceSound Card: 100% DirectX 10 compatibleAdditional Notes:}",
                        requirementsRu = null
                    ),
                    ResultPlatform(
                        platform = ResultPlatformChild(
                            gamesCount = 4556,
                            id = 1,
                            image = null,
                            imageBackground = "https://media.rawg.io/media/games/bc0/bc06a29ceac58652b684deefe7d56099.jpg",
                            name = "Xbox One",
                            slug = "xbox-one",
                            yearEnd = null,
                            yearStart = null
                        ), releasedAt = "2013-09-17", requirementsEn = null, requirementsRu = null
                    ),
                    ResultPlatform(
                        platform = ResultPlatformChild(
                            gamesCount = 186,
                            id = 186,
                            image = null,
                            imageBackground = "https://media.rawg.io/media/games/cd9/cd90cbe0868a2a3bbde2a9c245cb32b0.jpg",
                            name = "Xbox Series S/X",
                            slug = "xbox-series-x",
                            yearEnd = null,
                            yearStart = 2020
                        ), releasedAt = "2013-09-17", requirementsEn = null, requirementsRu = null
                    )
                ),
                playtime = 70,
                rating = 4.48,
                ratingTop = 5,
                ratings = listOf(
                    Rating(count = 2861, id = 5, percent = 59.21, title = "exceptional"),
                    Rating(count = 1586, id = 4, percent = 32.82, title = "recommended"),
                    Rating(count = 305, id = 3, percent = 6.31, title = "meh"),
                    Rating(count = 80, id = 1, percent = 1.66, title = "skip")
                ),
                ratingsCount = 4779,
                released = "2013-09-17",
                reviewsCount = 4832,
                reviewsTextCount = 31,
                saturatedColor = "0f0f0f",
                shortScreenshots = listOf(
                    ShortScreenshot(
                        id = -1,
                        image = "https://media.rawg.io/media/games/84d/84da2ac3fdfc6507807a1808595afb12.jpg"
                    ),
                    ShortScreenshot(
                        id = 1827221,
                        image = "https://media.rawg.io/media/screenshots/a7c/a7c43871a54bed6573a6a429451564ef.jpg"
                    ),
                    ShortScreenshot(
                        id = 1827222,
                        image = "https://media.rawg.io/media/screenshots/cf4/cf4367daf6a1e33684bf19adb02d16d6.jpg"
                    ),
                    ShortScreenshot(
                        id = 1827223,
                        image = "https://media.rawg.io/media/screenshots/f95/f9518b1d99210c0cae21fc09e95b4e31.jpg"
                    ),
                    ShortScreenshot(
                        id = 1827225,
                        image = "https://media.rawg.io/media/screenshots/a5c/a5c95ea539c87d5f538763e16e18fb99.jpg"
                    ),
                    ShortScreenshot(
                        id = 1827226,
                        image = "https://media.rawg.io/media/screenshots/a7e/a7e990bc574f4d34e03b5926361d1ee7.jpg"
                    ),
                    ShortScreenshot(
                        id = 1827227,
                        image = "https://media.rawg.io/media/screenshots/592/592e2501d8734b802b2a34fee2df59fa.jpg"
                    )
                ),
                slug = "grand-theft-auto-v",
                stores = listOf(
                    ResultStore(
                        id = 290375,
                        store = Store(
                            domain = "store.playstation.com",
                            gamesCount = 7589,
                            id = 3,
                            imageBackground = "https://media.rawg.io/media/games/4be/4be6a6ad0364751a96229c56bf69be59.jpg",
                            name = "PlayStation Store",
                            slug = "playstation-store"
                        )
                    ),
                    ResultStore(
                        id = 438095,
                        store = Store(
                            domain = "epicgames.com",
                            gamesCount = 529,
                            id = 11,
                            imageBackground = "https://media.rawg.io/media/games/25c/25c4776ab5723d5d735d8bf617ca12d9.jpg",
                            name = "Epic Games",
                            slug = "epic-games"
                        )
                    ),
                    ResultStore(
                        id = 290376,
                        store = Store(
                            domain = "store.steampowered.com",
                            gamesCount = 51553,
                            id = 1,
                            imageBackground = "https://media.rawg.io/media/games/73e/73eecb8909e0c39fb246f457b5d6cbbe.jpg",
                            name = "Steam",
                            slug = "steam"
                        )
                    ),
                    ResultStore(
                        id = 290377,
                        store = Store(
                            domain = "marketplace.xbox.com",
                            gamesCount = 1908,
                            id = 7,
                            imageBackground = "https://media.rawg.io/media/games/3cf/3cff89996570cf29a10eb9cd967dcf73.jpg",
                            name = "Xbox 360 Store",
                            slug = "xbox360"
                        )
                    ),
                    ResultStore(
                        id = 290378,
                        store = Store(
                            domain = "microsoft.com",
                            gamesCount = 4139,
                            id = 2,
                            imageBackground = "https://media.rawg.io/media/games/84d/84da2ac3fdfc6507807a1808595afb12.jpg",
                            name = "Xbox Store",
                            slug = "xbox-store"
                        )
                    )
                ),
                suggestionsCount = 412,
                tags = listOf(
                    Tag(
                        gamesCount = 115040,
                        id = 31,
                        imageBackground = "https://media.rawg.io/media/games/f87/f87457e8347484033cb34cde6101d08d.jpg",
                        language = "eng",
                        name = "Singleplayer",
                        slug = "singleplayer"
                    ),
                    Tag(
                        gamesCount = 21773,
                        id = 40847,
                        imageBackground = "https://media.rawg.io/media/games/120/1201a40e4364557b124392ee50317b99.jpg",
                        language = "eng",
                        name = "Steam Achievements",
                        slug = "steam-achievements"
                    ),
                    Tag(
                        gamesCount = 25360,
                        id = 7,
                        imageBackground = "https://media.rawg.io/media/games/490/49016e06ae2103881ff6373248843069.jpg",
                        language = "eng",
                        name = "Multiplayer",
                        slug = "multiplayer"
                    ),
                    Tag(
                        gamesCount = 13437,
                        id = 13,
                        imageBackground = "https://media.rawg.io/media/games/328/3283617cb7d75d67257fc58339188742.jpg",
                        language = "eng",
                        name = "Atmospheric",
                        slug = "atmospheric"
                    ),
                    Tag(
                        gamesCount = 10125,
                        id = 40836,
                        imageBackground = "https://media.rawg.io/media/games/157/15742f2f67eacff546738e1ab5c19d20.jpg",
                        language = "eng",
                        name = "Full controller support",
                        slug = "full-controller-support"
                    ),
                    Tag(
                        gamesCount = 3134,
                        id = 42,
                        imageBackground = "https://media.rawg.io/media/games/84d/84da2ac3fdfc6507807a1808595afb12.jpg",
                        language = "eng",
                        name = "Great Soundtrack",
                        slug = "great-soundtrack"
                    ),
                    Tag(
                        gamesCount = 11808,
                        id = 24,
                        imageBackground = "https://media.rawg.io/media/games/ebd/ebdbb7eb52bd58b0e7fa4538d9757b60.jpg",
                        language = "eng",
                        name = "RPG",
                        slug = "rpg"
                    ),
                    Tag(
                        gamesCount = 6685,
                        id = 18,
                        imageBackground = "https://media.rawg.io/media/games/46d/46d98e6910fbc0706e2948a7cc9b10c5.jpg",
                        language = "eng",
                        name = "Co-op",
                        slug = "co-op"
                    ),
                    Tag(
                        gamesCount = 3745,
                        id = 36,
                        imageBackground = "https://media.rawg.io/media/games/588/588c6bdff3d4baf66ec36b1c05b793bf.jpg",
                        language = "eng",
                        name = "Open World",
                        slug = "open-world"
                    ),
                    Tag(
                        gamesCount = 2798,
                        id = 411,
                        imageBackground = "https://media.rawg.io/media/games/a3c/a3c529a12c896c0ef02db5b4741de2ba.jpg",
                        language = "eng",
                        name = "cooperative",
                        slug = "cooperative"
                    ),
                    Tag(
                        gamesCount = 12852,
                        id = 8,
                        imageBackground = "https://media.rawg.io/media/games/fc1/fc1307a2774506b5bd65d7e8424664a7.jpg",
                        language = "eng",
                        name = "First-Person",
                        slug = "first-person"
                    ),
                    Tag(
                        gamesCount = 4308,
                        id = 149,
                        imageBackground = "https://media.rawg.io/media/games/d1a/d1a2e99ade53494c6330a0ed945fe823.jpg",
                        language = "eng",
                        name = "Third Person",
                        slug = "third-person"
                    ),
                    Tag(
                        gamesCount = 13276,
                        id = 4,
                        imageBackground = "https://media.rawg.io/media/games/46d/46d98e6910fbc0706e2948a7cc9b10c5.jpg",
                        language = "eng",
                        name = "Funny",
                        slug = "funny"
                    ),
                    Tag(
                        gamesCount = 3495,
                        id = 37,
                        imageBackground = "https://media.rawg.io/media/games/713/713269608dc8f2f40f5a670a14b2de94.jpg",
                        language = "eng",
                        name = "Sandbox",
                        slug = "sandbox"
                    ),
                    Tag(
                        gamesCount = 6416,
                        id = 123,
                        imageBackground = "https://media.rawg.io/media/screenshots/8f0/8f0b94922ad5e59968852649697b2643.jpg",
                        language = "eng",
                        name = "Comedy",
                        slug = "comedy"
                    ),
                    Tag(
                        gamesCount = 1510,
                        id = 150,
                        imageBackground = "https://media.rawg.io/media/games/a6c/a6ccd34125c594abf1a9c9821b9a715d.jpg",
                        language = "eng",
                        name = "Third-Person Shooter",
                        slug = "third-person-shooter"
                    ),
                    Tag(
                        gamesCount = 544,
                        id = 62,
                        imageBackground = "https://media.rawg.io/media/games/1bb/1bb86c35ffa3eb0d299b01a7c65bf908.jpg",
                        language = "eng",
                        name = "Moddable",
                        slug = "moddable"
                    ),
                    Tag(
                        gamesCount = 1809,
                        id = 144,
                        imageBackground = "https://media.rawg.io/media/games/d69/d69810315bd7e226ea2d21f9156af629.jpg",
                        language = "eng",
                        name = "Crime",
                        slug = "crime"
                    ),
                    Tag(
                        gamesCount = 19,
                        id = 62349,
                        imageBackground = "https://media.rawg.io/media/games/bda/bdab2603c0dc67268d0610449bc7df16.jpg",
                        language = "eng",
                        name = "vr mod",
                        slug = "vr-mod"
                    )
                ),
                tba = false,
                updated = "2021-03-03T20:31:29",
                userGame = null
            ),
            GamesResult(
                added = 14985,
                addedByStatus = AddedByStatus(
                    beaten = 3979,
                    dropped = 727,
                    owned = 8950,
                    playing = 543,
                    toplay = 408,
                    yet = 378
                ),
                backgroundImage = "https://media.rawg.io/media/games/84d/84da2ac3fdfc6507807a1808595afb12.jpg",
                clip = null,
                dominantColor = "0f0f0f",
                esrbRating = EsrbRating(id = 4, name = "Mature", slug = "mature"),
                genres = listOf(
                    Genre(
                        gamesCount = 117633,
                        id = 4,
                        imageBackground = "https://media.rawg.io/media/games/b7d/b7d3f1715fa8381a4e780173a197a615.jpg",
                        name = "Action",
                        slug = "action"
                    ),
                    Genre(
                        gamesCount = 86221,
                        id = 3,
                        imageBackground = "https://media.rawg.io/media/games/995/9951d9d55323d08967640f7b9ab3e342.jpg",
                        name = "Adventure",
                        slug = "adventure"
                    )
                ),
                id = 3498,
                metacritic = 97,
                name = "Grand Theft Auto V",
                parentPlatforms = listOf(
                    ParentPlatform(
                        platform = ParentPlatformChild(
                            id = 1,
                            name = "PC",
                            slug = "pc"
                        )
                    ),
                    ParentPlatform(
                        platform = ParentPlatformChild(
                            id = 2,
                            name = "PlayStation",
                            slug = "playstation"
                        )
                    ),
                    ParentPlatform(
                        platform = ParentPlatformChild(
                            id = 3,
                            name = "Xbox",
                            slug = "xbox"
                        )
                    )
                ),
                platforms = listOf(
                    ResultPlatform(
                        platform = ResultPlatformChild(
                            gamesCount = 213,
                            id = 187,
                            image = null,
                            imageBackground = "https://media.rawg.io/media/screenshots/6e1/6e13d9acb4e7a6e184f24892f52c4544.jpg",
                            name = "PlayStation 5",
                            slug = "playstation5",
                            yearEnd = null,
                            yearStart = 2020
                        ), releasedAt = "2013-09-17", requirementsEn = null, requirementsRu = null
                    ),
                    ResultPlatform(
                        platform = ResultPlatformChild(
                            gamesCount = 5913,
                            id = 18,
                            image = null,
                            imageBackground = "https://media.rawg.io/media/games/c4b/c4b0cab189e73432de3a250d8cf1c84e.jpg",
                            name = "PlayStation 4",
                            slug = "playstation4",
                            yearEnd = null,
                            yearStart = null
                        ), releasedAt = "2013-09-17", requirementsEn = null, requirementsRu = null
                    ),
                    ResultPlatform(
                        platform = ResultPlatformChild(
                            gamesCount = 3624,
                            id = 16,
                            image = null,
                            imageBackground = "https://media.rawg.io/media/games/15c/15c95a4915f88a3e89c821526afe05fc.jpg",
                            name = "PlayStation 3",
                            slug = "playstation3",
                            yearEnd = null,
                            yearStart = null
                        ), releasedAt = "2013-09-17", requirementsEn = null, requirementsRu = null
                    ),
                    ResultPlatform(
                        platform = ResultPlatformChild(
                            gamesCount = 2714,
                            id = 14,
                            image = null,
                            imageBackground = "https://media.rawg.io/media/games/490/49016e06ae2103881ff6373248843069.jpg",
                            name = "Xbox 360",
                            slug = "xbox360",
                            yearEnd = null,
                            yearStart = null
                        ), releasedAt = "2013-09-17", requirementsEn = null, requirementsRu = null
                    ),
                    ResultPlatform(
                        platform = ResultPlatformChild(
                            gamesCount = 329868,
                            id = 4,
                            image = null,
                            imageBackground = "https://media.rawg.io/media/games/736/73619bd336c894d6941d926bfd563946.jpg",
                            name = "PC",
                            slug = "pc",
                            yearEnd = null,
                            yearStart = null
                        ),
                        releasedAt = "2013-09-17",
                        requirementsEn = "{minimum=Minimum:OS: Windows 10 64 Bit, Windows 8.1 64 Bit, Windows 8 64 Bit, Windows 7 64 Bit Service Pack 1, Windows Vista 64 Bit Service Pack 2* (*NVIDIA video card recommended if running Vista OS)Processor: Intel Core 2 Quad CPU Q6600 @ 2.40GHz (4 CPUs) / AMD Phenom 9850 Quad-Core Processor (4 CPUs) @ 2.5GHzMemory: 4 GB RAMGraphics: NVIDIA 9800 GT 1GB / AMD HD 4870 1GB (DX 10, 10.1, 11)Storage: 72 GB available spaceSound Card: 100% DirectX 10 compatibleAdditional Notes: Over time downloadable content and programming changes will change the system requirements for this game.  Please refer to your hardware manufacturer and www.rockstargames.com/support for current compatibility information. Some system components such as mobile chipsets, integrated, and AGP graphics cards may be incompatible. Unlisted specifications may not be supported by publisher.     Other requirements:  Installation and online play requires log-in to Rockstar Games Social Club (13+) network; internet connection required for activation, online play, and periodic entitlement verification; software installations required including Rockstar Games Social Club platform, DirectX , Chromium, and Microsoft Visual C++ 2008 sp1 Redistributable Package, and authentication software that recognizes certain hardware attributes for entitlement, digital rights management, system, and other support purposes.     SINGLE USE SERIAL CODE REGISTRATION VIA INTERNET REQUIRED; REGISTRATION IS LIMITED TO ONE ROCKSTAR GAMES SOCIAL CLUB ACCOUNT (13+) PER SERIAL CODE; ONLY ONE PC LOG-IN ALLOWED PER SOCIAL CLUB ACCOUNT AT ANY TIME; SERIAL CODE(S) ARE NON-TRANSFERABLE ONCE USED; SOCIAL CLUB ACCOUNTS ARE NON-TRANSFERABLE.  Partner Requirements:  Please check the terms of service of this site before purchasing this software., recommended=Recommended:OS: Windows 10 64 Bit, Windows 8.1 64 Bit, Windows 8 64 Bit, Windows 7 64 Bit Service Pack 1Processor: Intel Core i5 3470 @ 3.2GHz (4 CPUs) / AMD X8 FX-8350 @ 4GHz (8 CPUs)Memory: 8 GB RAMGraphics: NVIDIA GTX 660 2GB / AMD HD 7870 2GBStorage: 72 GB available spaceSound Card: 100% DirectX 10 compatibleAdditional Notes:}",
                        requirementsRu = null
                    ),
                    ResultPlatform(
                        platform = ResultPlatformChild(
                            gamesCount = 4556,
                            id = 1,
                            image = null,
                            imageBackground = "https://media.rawg.io/media/games/bc0/bc06a29ceac58652b684deefe7d56099.jpg",
                            name = "Xbox One",
                            slug = "xbox-one",
                            yearEnd = null,
                            yearStart = null
                        ), releasedAt = "2013-09-17", requirementsEn = null, requirementsRu = null
                    ),
                    ResultPlatform(
                        platform = ResultPlatformChild(
                            gamesCount = 186,
                            id = 186,
                            image = null,
                            imageBackground = "https://media.rawg.io/media/games/cd9/cd90cbe0868a2a3bbde2a9c245cb32b0.jpg",
                            name = "Xbox Series S/X",
                            slug = "xbox-series-x",
                            yearEnd = null,
                            yearStart = 2020
                        ), releasedAt = "2013-09-17", requirementsEn = null, requirementsRu = null
                    )
                ),
                playtime = 70,
                rating = 4.48,
                ratingTop = 5,
                ratings = listOf(
                    Rating(count = 2861, id = 5, percent = 59.21, title = "exceptional"),
                    Rating(count = 1586, id = 4, percent = 32.82, title = "recommended"),
                    Rating(count = 305, id = 3, percent = 6.31, title = "meh"),
                    Rating(count = 80, id = 1, percent = 1.66, title = "skip")
                ),
                ratingsCount = 4779,
                released = "2013-09-17",
                reviewsCount = 4832,
                reviewsTextCount = 31,
                saturatedColor = "0f0f0f",
                shortScreenshots = listOf(
                    ShortScreenshot(
                        id = -1,
                        image = "https://media.rawg.io/media/games/84d/84da2ac3fdfc6507807a1808595afb12.jpg"
                    ),
                    ShortScreenshot(
                        id = 1827221,
                        image = "https://media.rawg.io/media/screenshots/a7c/a7c43871a54bed6573a6a429451564ef.jpg"
                    ),
                    ShortScreenshot(
                        id = 1827222,
                        image = "https://media.rawg.io/media/screenshots/cf4/cf4367daf6a1e33684bf19adb02d16d6.jpg"
                    ),
                    ShortScreenshot(
                        id = 1827223,
                        image = "https://media.rawg.io/media/screenshots/f95/f9518b1d99210c0cae21fc09e95b4e31.jpg"
                    ),
                    ShortScreenshot(
                        id = 1827225,
                        image = "https://media.rawg.io/media/screenshots/a5c/a5c95ea539c87d5f538763e16e18fb99.jpg"
                    ),
                    ShortScreenshot(
                        id = 1827226,
                        image = "https://media.rawg.io/media/screenshots/a7e/a7e990bc574f4d34e03b5926361d1ee7.jpg"
                    ),
                    ShortScreenshot(
                        id = 1827227,
                        image = "https://media.rawg.io/media/screenshots/592/592e2501d8734b802b2a34fee2df59fa.jpg"
                    )
                ),
                slug = "grand-theft-auto-v",
                stores = listOf(
                    ResultStore(
                        id = 290375,
                        store = Store(
                            domain = "store.playstation.com",
                            gamesCount = 7589,
                            id = 3,
                            imageBackground = "https://media.rawg.io/media/games/4be/4be6a6ad0364751a96229c56bf69be59.jpg",
                            name = "PlayStation Store",
                            slug = "playstation-store"
                        )
                    ),
                    ResultStore(
                        id = 438095,
                        store = Store(
                            domain = "epicgames.com",
                            gamesCount = 529,
                            id = 11,
                            imageBackground = "https://media.rawg.io/media/games/25c/25c4776ab5723d5d735d8bf617ca12d9.jpg",
                            name = "Epic Games",
                            slug = "epic-games"
                        )
                    ),
                    ResultStore(
                        id = 290376,
                        store = Store(
                            domain = "store.steampowered.com",
                            gamesCount = 51553,
                            id = 1,
                            imageBackground = "https://media.rawg.io/media/games/73e/73eecb8909e0c39fb246f457b5d6cbbe.jpg",
                            name = "Steam",
                            slug = "steam"
                        )
                    ),
                    ResultStore(
                        id = 290377,
                        store = Store(
                            domain = "marketplace.xbox.com",
                            gamesCount = 1908,
                            id = 7,
                            imageBackground = "https://media.rawg.io/media/games/3cf/3cff89996570cf29a10eb9cd967dcf73.jpg",
                            name = "Xbox 360 Store",
                            slug = "xbox360"
                        )
                    ),
                    ResultStore(
                        id = 290378,
                        store = Store(
                            domain = "microsoft.com",
                            gamesCount = 4139,
                            id = 2,
                            imageBackground = "https://media.rawg.io/media/games/84d/84da2ac3fdfc6507807a1808595afb12.jpg",
                            name = "Xbox Store",
                            slug = "xbox-store"
                        )
                    )
                ),
                suggestionsCount = 412,
                tags = listOf(
                    Tag(
                        gamesCount = 115040,
                        id = 31,
                        imageBackground = "https://media.rawg.io/media/games/f87/f87457e8347484033cb34cde6101d08d.jpg",
                        language = "eng",
                        name = "Singleplayer",
                        slug = "singleplayer"
                    ),
                    Tag(
                        gamesCount = 21773,
                        id = 40847,
                        imageBackground = "https://media.rawg.io/media/games/120/1201a40e4364557b124392ee50317b99.jpg",
                        language = "eng",
                        name = "Steam Achievements",
                        slug = "steam-achievements"
                    ),
                    Tag(
                        gamesCount = 25360,
                        id = 7,
                        imageBackground = "https://media.rawg.io/media/games/490/49016e06ae2103881ff6373248843069.jpg",
                        language = "eng",
                        name = "Multiplayer",
                        slug = "multiplayer"
                    ),
                    Tag(
                        gamesCount = 13437,
                        id = 13,
                        imageBackground = "https://media.rawg.io/media/games/328/3283617cb7d75d67257fc58339188742.jpg",
                        language = "eng",
                        name = "Atmospheric",
                        slug = "atmospheric"
                    ),
                    Tag(
                        gamesCount = 10125,
                        id = 40836,
                        imageBackground = "https://media.rawg.io/media/games/157/15742f2f67eacff546738e1ab5c19d20.jpg",
                        language = "eng",
                        name = "Full controller support",
                        slug = "full-controller-support"
                    ),
                    Tag(
                        gamesCount = 3134,
                        id = 42,
                        imageBackground = "https://media.rawg.io/media/games/84d/84da2ac3fdfc6507807a1808595afb12.jpg",
                        language = "eng",
                        name = "Great Soundtrack",
                        slug = "great-soundtrack"
                    ),
                    Tag(
                        gamesCount = 11808,
                        id = 24,
                        imageBackground = "https://media.rawg.io/media/games/ebd/ebdbb7eb52bd58b0e7fa4538d9757b60.jpg",
                        language = "eng",
                        name = "RPG",
                        slug = "rpg"
                    ),
                    Tag(
                        gamesCount = 6685,
                        id = 18,
                        imageBackground = "https://media.rawg.io/media/games/46d/46d98e6910fbc0706e2948a7cc9b10c5.jpg",
                        language = "eng",
                        name = "Co-op",
                        slug = "co-op"
                    ),
                    Tag(
                        gamesCount = 3745,
                        id = 36,
                        imageBackground = "https://media.rawg.io/media/games/588/588c6bdff3d4baf66ec36b1c05b793bf.jpg",
                        language = "eng",
                        name = "Open World",
                        slug = "open-world"
                    ),
                    Tag(
                        gamesCount = 2798,
                        id = 411,
                        imageBackground = "https://media.rawg.io/media/games/a3c/a3c529a12c896c0ef02db5b4741de2ba.jpg",
                        language = "eng",
                        name = "cooperative",
                        slug = "cooperative"
                    ),
                    Tag(
                        gamesCount = 12852,
                        id = 8,
                        imageBackground = "https://media.rawg.io/media/games/fc1/fc1307a2774506b5bd65d7e8424664a7.jpg",
                        language = "eng",
                        name = "First-Person",
                        slug = "first-person"
                    ),
                    Tag(
                        gamesCount = 4308,
                        id = 149,
                        imageBackground = "https://media.rawg.io/media/games/d1a/d1a2e99ade53494c6330a0ed945fe823.jpg",
                        language = "eng",
                        name = "Third Person",
                        slug = "third-person"
                    ),
                    Tag(
                        gamesCount = 13276,
                        id = 4,
                        imageBackground = "https://media.rawg.io/media/games/46d/46d98e6910fbc0706e2948a7cc9b10c5.jpg",
                        language = "eng",
                        name = "Funny",
                        slug = "funny"
                    ),
                    Tag(
                        gamesCount = 3495,
                        id = 37,
                        imageBackground = "https://media.rawg.io/media/games/713/713269608dc8f2f40f5a670a14b2de94.jpg",
                        language = "eng",
                        name = "Sandbox",
                        slug = "sandbox"
                    ),
                    Tag(
                        gamesCount = 6416,
                        id = 123,
                        imageBackground = "https://media.rawg.io/media/screenshots/8f0/8f0b94922ad5e59968852649697b2643.jpg",
                        language = "eng",
                        name = "Comedy",
                        slug = "comedy"
                    ),
                    Tag(
                        gamesCount = 1510,
                        id = 150,
                        imageBackground = "https://media.rawg.io/media/games/a6c/a6ccd34125c594abf1a9c9821b9a715d.jpg",
                        language = "eng",
                        name = "Third-Person Shooter",
                        slug = "third-person-shooter"
                    ),
                    Tag(
                        gamesCount = 544,
                        id = 62,
                        imageBackground = "https://media.rawg.io/media/games/1bb/1bb86c35ffa3eb0d299b01a7c65bf908.jpg",
                        language = "eng",
                        name = "Moddable",
                        slug = "moddable"
                    ),
                    Tag(
                        gamesCount = 1809,
                        id = 144,
                        imageBackground = "https://media.rawg.io/media/games/d69/d69810315bd7e226ea2d21f9156af629.jpg",
                        language = "eng",
                        name = "Crime",
                        slug = "crime"
                    ),
                    Tag(
                        gamesCount = 19,
                        id = 62349,
                        imageBackground = "https://media.rawg.io/media/games/bda/bdab2603c0dc67268d0610449bc7df16.jpg",
                        language = "eng",
                        name = "vr mod",
                        slug = "vr-mod"
                    )
                ),
                tba = false,
                updated = "2021-03-03T20:31:29",
                userGame = null
            )
        )
}