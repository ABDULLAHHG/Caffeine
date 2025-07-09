package com.example.caffeine.ui.feature.cookies

import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.example.caffeine.R
import com.example.caffeine.designSystem.component.text.CaffeTextBold
import com.example.caffeine.ui.feature.coffeeReady.component.CaffeReadyUpBar
import com.example.caffeine.ui.feature.cookies.component.CookiesCard
import com.example.caffeine.ui.feature.navigation.LocalNavController
import com.example.caffeine.ui.feature.navigation.Route
import kotlin.math.absoluteValue
import kotlin.math.pow

enum class CookiesType(val value: Int) {
    Oreo(R.drawable.oreo),
    Cake(R.drawable.cake),
    Chocolate(R.drawable.chocolate),
    Croissant(R.drawable.crwason), // Fixed typo: Crwason -> Croissant
    Cupcake(R.drawable.cupcake),
    Cookies(R.drawable.cookies)
}

@Composable
fun Cookies() {
    val navController = LocalNavController.current
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { CookiesType.entries.size }
    )

    Column {
        CaffeReadyUpBar(
            onClick = { navController.navigate(Route.Home) },
            modifier = Modifier.statusBarsPadding()
        )

            CaffeTextBold(
                text = "Take your snack",
                fontSize = 22,
                fontColor = Color(0xDE1F1F1F),
                modifier = Modifier.padding(top = 24.dp , bottom = 24.dp ,start = 16.dp)
            )

        VerticalPager(
            state = pagerState,
            pageSpacing = (-350).dp,
            beyondViewportPageCount = 5,
            flingBehavior = PagerDefaults.flingBehavior(
                state = pagerState,
                snapPositionalThreshold = 0.2f,
                snapAnimationSpec = tween(
                    durationMillis = 600,
                    easing = EaseOut
                )
            ),
            modifier = Modifier.fillMaxWidth()
        ) { currentPage ->
            val pageOffsetFraction =
                (pagerState.currentPage - currentPage) + pagerState.currentPageOffsetFraction

            val transformations = calculatePageTransformations(pageOffsetFraction)

            CookiesCard(
                painter = painterResource(id = CookiesType.entries[currentPage].value),
                modifier = Modifier
                    .scale(transformations.scale)
                    .rotate(transformations.rotate)
                    .offset(x = transformations.offsetX.dp, y = transformations.offsetY.dp),
                onClick = {
                    navController.navigate(Route.CookieDetail(CookiesType.entries[currentPage]))
                }
            )
        }
    }
}

private data class PageTransformations(
    val rotate: Float,
    val offsetX: Float,
    val offsetY: Float,
    val scale: Float
)

private fun calculatePageTransformations(pageOffsetFraction: Float): PageTransformations {
    val absOffset = pageOffsetFraction.absoluteValue
    val clampedOffset = pageOffsetFraction.coerceIn(-1f, 1f)
    val clampedAbsOffset = absOffset.coerceIn(-1f, 1f)

    val rotate = lerp(
        start = if (pageOffsetFraction != 0f) -8f else 0f,
        stop = 0f,
        fraction = 1f - pageOffsetFraction.coerceIn(-2f, 1f)
    )

    val offsetX = lerp(
        start = when {
            pageOffsetFraction < 0f -> -(absOffset.pow(2) * 50f)
            pageOffsetFraction > 0f -> -(absOffset.pow(2) * 50f)
            else -> -24f
        },
        stop = -32f,
        fraction = 1f - clampedAbsOffset
    )

    val offsetY = lerp(
        start = absOffset.pow(2) * 40f,
        stop = 0f,
        fraction = 1f - clampedAbsOffset
    )

    val scale = lerp(
        start = 0.75f,
        stop = 1f,
        fraction = 1f - clampedOffset
    )

    return PageTransformations(rotate, offsetX, offsetY, scale)
}