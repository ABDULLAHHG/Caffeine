package com.example.caffeine.ui.feature.coffeeReady.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.caffeine.R
import com.example.caffeine.ui.component.CaffeCup

@Composable
fun CupWithCover(
    cupWidth: Int,
    cupHeight: Int,
    cupSizeInML: String,
    logoWidth: Int,
    logoHeight: Int
) {
    var lidVisible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        lidVisible = true
    }

    CaffeCup(
        cupSize = Size(cupWidth.dp.value, cupHeight.dp.value),
        logoSize = Size(logoWidth.dp.value, logoHeight.dp.value),
        cupSizeInML = cupSizeInML,
        modifier = Modifier
            .height(300.dp)
            .fillMaxWidth()
    )

    val configuration = LocalConfiguration.current
    val screenHeightDp = configuration.screenHeightDp

    AnimatedVisibility(
        visible = lidVisible,
        enter = slideInVertically(
            initialOffsetY = { fullHeight -> -screenHeightDp },
            animationSpec = tween(durationMillis = 700)
        ),
        exit = ExitTransition.None
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.height((cupHeight.dp.value + logoHeight.dp.value * 2).dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.coffee_cover),
                contentDescription = null,
                modifier = Modifier
                    .size((cupWidth * 1.05).dp, (logoHeight.dp.value * 2).dp)
                    .zIndex(1f)
                    .offset(y = 15.dp)
                    .align(Alignment.TopCenter)
                    .graphicsLayer {
                        transformOrigin = TransformOrigin(0.5f, 1f)
                    }
            )
        }
    }
}