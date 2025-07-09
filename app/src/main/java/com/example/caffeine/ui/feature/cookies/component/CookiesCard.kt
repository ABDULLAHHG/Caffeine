package com.example.caffeine.ui.feature.cookies.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

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