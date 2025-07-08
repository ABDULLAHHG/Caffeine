package com.example.caffeine.ui.feature.chooseCaffeType

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.caffeine.designSystem.theme.urbanistFamily

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

@Composable
fun CaffeTextBold(
    text: String,
    modifier: Modifier = Modifier,
    fontColor: Color = Color(0xFFB3B3B3),
    fontSize: Int = 36
) {
    Text(
        text = text,
        fontWeight = FontWeight.W700,
        fontFamily = urbanistFamily,
        fontSize = fontSize.sp,
        letterSpacing = 0.25.sp,
        textAlign = TextAlign.Center,
        color = fontColor,
        modifier = modifier
    )
}