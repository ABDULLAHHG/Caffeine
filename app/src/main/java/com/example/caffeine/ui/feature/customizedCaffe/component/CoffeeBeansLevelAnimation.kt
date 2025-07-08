package com.example.caffeine.ui.feature.customizedCaffe.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.zIndex
import com.example.caffeine.R
import kotlinx.coroutines.delay

@Composable
fun CoffeeBeansLevelAnimation(
    coffeeBeansLevel: CoffeeBeansLevel,
    modifier: Modifier = Modifier
) {
    var isVisible by remember { mutableStateOf(false) }
    var lastLevel by remember { mutableStateOf(coffeeBeansLevel) }
    var slideDirection by remember { mutableStateOf(true) }

    LaunchedEffect(coffeeBeansLevel) {
        if (coffeeBeansLevel != lastLevel) {
            slideDirection = (coffeeBeansLevel.ordinal > lastLevel.ordinal)
            isVisible = true
            lastLevel = coffeeBeansLevel
            delay(300)
            isVisible = false
        }
    }

    AnimatedVisibility(
        visible = isVisible,
        enter = slideInVertically(
            animationSpec = tween(durationMillis = 800)
        ) { fullHeight -> if (slideDirection) (fullHeight) * -1 else (fullHeight/2) } +
                fadeIn(animationSpec = tween(durationMillis = 800)) + if (slideDirection) scaleIn(initialScale = 0.5f) else scaleIn(initialScale = 1f),
        exit = fadeOut(),
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .zIndex(-999f),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.beans),
                contentDescription = null
            )
        }
    }
}