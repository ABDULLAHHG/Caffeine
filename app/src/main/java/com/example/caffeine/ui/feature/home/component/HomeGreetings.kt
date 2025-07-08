package com.example.caffeine.ui.feature.home.component

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.InfiniteRepeatableSpec
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.designSystem.theme.snigletFamily

@Composable
fun HomeGreetings(modifier: Modifier = Modifier) {
    Box(modifier) {
        val animatedStar = rememberInfiniteTransition()
        val animateColor by animatedStar.animateColor(
            Color(0xDE000000),
            Color(0x00000000),
            animationSpec = InfiniteRepeatableSpec(tween(500), repeatMode = RepeatMode.Reverse)
        )
        Icon(
            painter = painterResource(R.drawable.ic_star),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopEnd),
            tint = animateColor,

            )
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_star),
            contentDescription = null,
            modifier = Modifier.offset(y = (-27).dp)
                .align(Alignment.CenterStart),
            tint = animateColor,

            )
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_star),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.BottomEnd),
            tint = animateColor,

            )

        Text(
            "Hocus\n" +
                    "Pocus\n" +
                    "I Need Coffee\n" +
                    "to Focus",
            fontSize = 32.sp,
            lineHeight = 50.sp,
            letterSpacing = 0.25.sp,
            fontWeight = FontWeight.W400,
            fontFamily = snigletFamily,
            textAlign = TextAlign.Center
        )
    }

}