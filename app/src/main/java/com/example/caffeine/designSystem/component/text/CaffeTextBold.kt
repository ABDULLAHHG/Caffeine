package com.example.caffeine.designSystem.component.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.caffeine.designSystem.theme.urbanistFamily

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