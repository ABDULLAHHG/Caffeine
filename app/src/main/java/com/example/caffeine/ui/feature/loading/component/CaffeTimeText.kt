package com.example.caffeine.ui.feature.loading.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.caffeine.designSystem.theme.snigletFamily

@Composable
fun CaffeTimeText(
    text: String,
    fontColor: Color = Color(0xFF7C351B),
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontWeight = FontWeight.W800,
        fontSize = 32.sp,
        letterSpacing = 0.25.sp,
        textAlign = TextAlign.Center,
        fontFamily = snigletFamily,
        color = fontColor
    )

}