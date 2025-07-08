package com.example.caffeine.designSystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import com.example.caffeine.designSystem.color.CaffeineColor
import com.example.caffeine.designSystem.color.localCaffeineColor

object Theme {
    val color: CaffeineColor
        @Composable @ReadOnlyComposable get() = localCaffeineColor.current
//    val typography: CaffeineTextStyle
//        @Composable @ReadOnlyComposable get() = localCaffeineTextStyle.current
}