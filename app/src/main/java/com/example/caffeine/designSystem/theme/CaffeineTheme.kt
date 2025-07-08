package com.example.caffeine.designSystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.caffeine.R
import com.example.caffeine.designSystem.color.lightColorTheme
import com.example.caffeine.designSystem.color.localCaffeineColor


@Composable
fun CaffeineTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val theme = if (isDarkTheme) lightColorTheme() else lightColorTheme()

    CompositionLocalProvider(
        localCaffeineColor provides theme,
    ) {
        content()
    }
}

val urbanistFamily = FontFamily(
    Font(R.font.urbanist_regular, FontWeight.Normal),
    Font(R.font.urbanist_medium, FontWeight.Medium),
    Font(R.font.urbanist_semibold, FontWeight.SemiBold),
)

val snigletFamily = FontFamily(
    Font(R.font.sniglet_regular, FontWeight.Normal),
    Font(R.font.sniglet_extrabold, FontWeight.ExtraBold),
)