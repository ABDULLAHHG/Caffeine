package com.example.caffeine.ui.feature.navigation

import com.example.caffeine.ui.feature.cookies.cookiesType
import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object Home : Route

    @Serializable
    data object ChooseCaffeTypeScreen : Route

    @Serializable
    data class CustomizedCaffeScreen(
        val index: Int
    ) : Route

    @Serializable
    data class CoffeeLoadingScreen(
        val cupWidth: Int,
        val cupHeight: Int,
        val cupSizeInML: String,
        val logoWidth: Int ,
        val logoHeight: Int
    ) : Route

    @Serializable
    data class CoffeeReady(
        val cupWidth: Int,
        val cupHeight: Int,
        val cupSizeInML: String,
        val logoWidth: Int ,
        val logoHeight: Int
    ): Route

    @Serializable
    data object Cookies : Route

    @Serializable
    data class CookieDetail(
        val cookie : cookiesType
    ) : Route


}