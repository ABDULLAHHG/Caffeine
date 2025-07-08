package com.example.caffeine.designSystem.color

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color


data class TextColor(
    val title: Color,
    val body: Color,
    val hint : Color,
    val greetings : Color,
    val username : Color,
)

data class Surface(
    val surfaceHigh: Color,
    val surfaceLow: Color,
    val surfaceBlur: Color,
    val onPrimary: Color,
    val onPrimaryCard: Color,
)

data class Status(
    val brownAccent: Color,
    val brownAccentDark: Color,
    val blackAccent: Color,
)

data class CaffeineColor(
    val text: TextColor,
    val surface: Surface,
    val status: Status,
)

val localCaffeineColor = staticCompositionLocalOf { lightColorTheme() }
