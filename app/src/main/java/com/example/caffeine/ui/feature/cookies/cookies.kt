package com.example.caffeine.ui.feature.cookies

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import androidx.compose.ui.zIndex
import com.example.caffeine.R
import com.example.caffeine.ui.feature.coffeeReady.component.CaffeReadyUpBar
import com.example.caffeine.ui.feature.navigation.LocalNavController
import com.example.caffeine.ui.feature.navigation.Route
import kotlin.math.abs

enum class cookiesType(val value: Int) {
    Oreo(R.drawable.oreo),
    Cake(R.drawable.cake),
    Chocolate(R.drawable.chocolate),
    Crwason(R.drawable.crwason),
    Cupcake(R.drawable.cupcake),
    Cookies(R.drawable.cookies)
}

@Composable
fun Cookies() {
    val navController = LocalNavController.current
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { 6 }
    )
    CaffeReadyUpBar(
        onClick = { navController.navigate(Route.Home) },
        modifier = Modifier.statusBarsPadding()
    )
    VerticalPager(
        state = pagerState,
        pageSpacing = (-400).dp,
        flingBehavior = PagerDefaults.flingBehavior(
            state = pagerState,
            snapAnimationSpec = tween(600)
        ),
        modifier = Modifier.fillMaxWidth()
    ) { currentPage ->
        CookiesCard(
            painter = painterResource(id = cookiesType.entries[currentPage].value),
            modifier = Modifier,
            onClick = {
                navController.navigate(Route.CookieDetail(cookiesType.entries[currentPage]))
            }
        )
    }
}

@Composable
fun CookiesCard(painter: Painter, onClick: () -> Unit = {}, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(200.dp)
            .background(
                Color(0xFFF5F5F5),
                shape = RoundedCornerShape(topEnd = 32.dp, bottomEnd = 32.dp)
            )
            .clickable(
                onClick = { onClick() }
            ),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier.size(150.dp)
        )

    }

}