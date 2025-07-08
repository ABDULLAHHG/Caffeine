package com.example.caffeine.ui.feature.home

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.caffeine.R
import com.example.caffeine.ui.feature.home.component.BottomButton
import com.example.caffeine.ui.feature.home.component.HomeGreetings
import com.example.caffeine.ui.feature.home.component.HomeUpBar
import com.example.caffeine.ui.feature.navigation.LocalNavController
import com.example.caffeine.ui.feature.navigation.Route

@Composable
fun Home(
) {
    val navController = LocalNavController.current
    LazyColumn(
        modifier = Modifier.statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item() {
            HomeUpBar(Modifier.statusBarsPadding())
            HomeGreetings(Modifier.padding(bottom = 33.dp))
            HomeFlyingGhost()
            BottomButton(
                onClick = {
                    navController.navigate(Route.ChooseCaffeTypeScreen)
                },
                modifier = Modifier.navigationBarsPadding()
            )
        }
    }
}

@Composable
fun HomeFlyingGhost(modifier: Modifier = Modifier) {
    val infiniteTransition = rememberInfiniteTransition()
    val animatedOffset by infiniteTransition.animateFloat(
        0f,
        20f,
        infiniteRepeatable(
            animation = tween(1500),
            repeatMode = androidx.compose.animation.core.RepeatMode.Reverse
        )
    )

    Image(
        painter = painterResource(R.drawable.flying_ghost),
        contentDescription = null,
        modifier = Modifier.size(244.dp).offset(y = (animatedOffset * -1).dp)
    )
    GhostShape(
        modifier = Modifier
            .padding(bottom = 59.dp)
            .size(width = (244 * 0.726).dp, height = 27.dp)
            .offset(y = (animatedOffset).dp )
    )
}


@Composable
fun GhostShape(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier) {
        val width = size.width
        val height = size.height

        val path = Path().apply {
            moveTo(0f, height / 2)
            cubicTo(0f, 0f, width, 0f, width, height / 2) // Top bulge
            cubicTo(width, height, 0f, height, 0f, height / 2) // Bottom bulge
            close()
        }

        drawPath(
            path = path,
            color = Color(0x241F1F1F)
        )
    }
}

