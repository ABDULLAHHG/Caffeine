package com.example.caffeine.ui.feature.chooseCaffeType

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.caffeine.designSystem.component.text.CaffeTextBold

@Composable
fun ChooseCaffeTypeGreetings(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        CaffeTextBold(
            "Good Morning"
        )
        CaffeTextBold(
            "Hamsa ☀",
            fontColor = Color(0xFF3B3B3B)
        )

        CaffeTextBold(
            "What would you like to drink today?",
            fontColor = Color(0xCC1F1F1F),
            fontSize = 16
        )
    }
}

