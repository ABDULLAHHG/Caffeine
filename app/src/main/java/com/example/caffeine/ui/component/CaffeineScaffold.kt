package com.example.caffeine.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.caffeine.designSystem.component.PrimaryButton

@Composable
fun CaffeineScaffold(
    upBarContent: @Composable () -> Unit = {},
    content: @Composable () -> Unit = {},
    buttonContent: @Composable () -> Unit = {},
    buttonOnClick: () -> Unit = {}
) {
    Box(Modifier.fillMaxSize()) {
        Box(Modifier.align(Alignment.TopCenter)) {
            CaffeineUpBar(Modifier.statusBarsPadding()) {
                upBarContent()
            }
        }
        Box(Modifier.fillMaxSize()) {
            content()
        }
        Box(Modifier.align(Alignment.BottomCenter)) {
            PrimaryButton(
                Modifier.navigationBarsPadding(),
                onClick = {
                    buttonOnClick()
                }) {
                buttonContent()
            }
        }

    }
}