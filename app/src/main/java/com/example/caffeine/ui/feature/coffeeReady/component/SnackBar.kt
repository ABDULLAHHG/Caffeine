package com.example.caffeine.ui.feature.coffeeReady.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.caffeine.R
import com.example.caffeine.designSystem.component.text.CaffeTextBold
import com.example.caffeine.ui.component.Indicator

@Composable
fun SnackBar(modifier: Modifier = Modifier) {
    var lidVisible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        lidVisible = true
    }
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
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Indicator() {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.icon_tick),
                    contentDescription = null,
                    tint = Color(0xDEFFFFFF),
                    modifier = Modifier.size(32.dp)
                )
            }
            Spacer(Modifier.padding(top = 24.dp))
            CaffeTextBold(
                "Your coffee is ready,\n" +
                        "Enjoy",
                fontSize = 22,
                fontColor = Color(0xDE1F1F1F)
            )
        }
    }
}