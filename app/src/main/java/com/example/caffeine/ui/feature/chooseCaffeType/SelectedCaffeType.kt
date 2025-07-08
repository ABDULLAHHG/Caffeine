package com.example.caffeine.ui.feature.chooseCaffeType

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.example.caffeine.R
import kotlin.math.abs

enum class CaffeType(val value: Int) {
    Black(R.drawable.black_coffe),
    Espresso(R.drawable.espresso),
    Latte(R.drawable.latte),
    Macchiato(R.drawable.macchiato)
}

@Composable
fun SelectedCaffeType(state: PagerState, modifier: Modifier = Modifier) {
    HorizontalPager(
        state = state,
        contentPadding = PaddingValues(horizontal = 100.dp),
        pageSpacing = 8.dp,
        flingBehavior = PagerDefaults.flingBehavior(
            state = state,
            snapAnimationSpec = tween(
                durationMillis = 800,
                easing = LinearOutSlowInEasing
            )
        ),
        modifier = modifier
    ) { pageIndex ->
        val pageOffset = (pageIndex - state.currentPage) + state.currentPageOffsetFraction
        val targetScale = lerp(start = 0.65f, stop = 1f, fraction = 1f - abs(pageOffset.coerceIn(-1f, 1f)))
        val animatedScale by animateFloatAsState(
            targetValue = targetScale,
            animationSpec = tween(durationMillis = 300, easing = LinearOutSlowInEasing),
            label = "PageScaleAnimation"
        )

        CoffeeItem(
            pageIndex,
            Modifier
                .fillMaxWidth()
                .graphicsLayer(
                    scaleX = animatedScale,
                    scaleY = animatedScale
                )
        )

    }
}

@Composable
fun CoffeeItem(pageIndex: Int, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth(),

        ) {
        Box(contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = CaffeType.entries[pageIndex].value),
                contentDescription = null,
                modifier = Modifier.size(244.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.the_chance_logo),
                contentDescription = null,
                modifier = Modifier
                    .size(64.dp)
            )
            CaffeTextBold(
                text = CaffeType.entries[pageIndex].name,
                fontColor = Color(0xFF1F1F1F),
                fontSize = 32,
                modifier = Modifier
                    .offset(y = 16.dp)
                    .align(Alignment.BottomCenter)
            )
        }

    }
}
