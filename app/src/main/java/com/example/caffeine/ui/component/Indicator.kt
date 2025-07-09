package com.example.caffeine.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

@Composable
fun Indicator(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}) {
    Box(
        modifier = modifier
    ) {
        Box(
            Modifier
                .background(Color(0xFF7C351B), shape = CircleShape)
                .size(40.dp),
            contentAlignment = Alignment.Center
        ) {

            Blur(Modifier.zIndex(-999f))
            content()


        }
    }
}

@Composable
fun Blur(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .offset(y = 6.dp)
            .size(45.dp)
            .clip(CircleShape)
            .background(
                brush = Brush.radialGradient(
                    listOf(
                        Color(0x80B94B23).copy(
                            alpha = 0.5f
                        ),
                        Color(0x80B94B23).copy(alpha = 0.5f * 0.7f),
                        Color(0x80B94B23).copy(alpha = 0.5f * 0.01f)
                    )
                )
            )
            .blur(radius = 16.dp)
    )
}
