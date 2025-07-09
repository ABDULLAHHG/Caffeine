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
fun CaffeRegularText(
    text: String,
    fontSize: Int = 16,
    textAlign: TextAlign = TextAlign.Center,
    fontColor: Color = Color(0xDE1F1F1F),
    modifier: Modifier = Modifier
) {
    Text(
        text,
        fontWeight = FontWeight.W500,
        fontFamily = urbanistFamily,
        fontSize = fontSize.sp,
        letterSpacing = 0.25.sp,
        textAlign = textAlign,
        color = fontColor,
        modifier = modifier
    )
}