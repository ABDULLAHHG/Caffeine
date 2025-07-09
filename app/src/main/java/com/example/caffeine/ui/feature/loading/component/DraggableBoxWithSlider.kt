package com.example.caffeine.ui.feature.loading.component

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.caffeine.R
import com.example.caffeine.ui.feature.navigation.Route
import kotlinx.coroutines.delay

@Composable
fun DraggableBoxWithSlider(
    navController: NavController,
    cupWidth: Int,
    cupHeight: Int,
    cupSizeInML: String,
    logoWidth: Int,
    logoHeight: Int
) {
    LaunchedEffect(Unit) {
        delay(5000)
        navController.navigate(
            Route.CoffeeReady(
                cupWidth,
                cupHeight,
                cupSizeInML,
                logoWidth,
                logoHeight
            )
        )
    }

    val infiniteTransition = rememberInfiniteTransition()
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val boxWidth = 160.dp
    val maxOffset = screenWidth - boxWidth
    val offsetX by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = maxOffset.value * 2,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 4000,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Reverse
        ),
        label = "offsetAnimation",
    )
    Box(
        modifier = Modifier
            .height(150.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.line_img),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .offset(x = offsetX.dp, y = 0.dp)
                .height(150.dp)
                .width(400.dp)
                .align(Alignment.CenterStart)
                .background(Color.White)
                .padding(16.dp)
        )
    }
}