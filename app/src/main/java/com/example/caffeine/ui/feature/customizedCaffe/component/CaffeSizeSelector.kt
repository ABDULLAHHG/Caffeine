package com.example.caffeine.ui.feature.customizedCaffe.component

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.caffeine.R
import com.example.caffeine.designSystem.theme.urbanistFamily

enum class CoffeeBeansLevel {
    Low, Medium, High
}

@Composable
fun CaffeSizeSelector(
    onSelected: (CoffeeBeansLevel) -> Unit,
    modifier: Modifier = Modifier,
    selected: CoffeeBeansLevel = CoffeeBeansLevel.Medium
) {
    SelectorBackground(modifier) {
        Crossfade(targetState = selected, label = "CaffeSizeIndicator",) { targetType ->
            val offset = when (targetType) {
                CoffeeBeansLevel.Low -> (-48).dp
                CoffeeBeansLevel.Medium -> 0.dp
                CoffeeBeansLevel.High -> 48.dp
            }

            Indicator(
                Modifier
                    .offset(x = offset)
                    .zIndex(-1f)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.coffee_beans),
                    contentDescription = null,
                    tint = Color(0xDEFFFFFF)
                )
            }
        }

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            CircleButton(onClick = { onSelected(CoffeeBeansLevel.Low) })
            CircleButton(onClick = { onSelected(CoffeeBeansLevel.Medium) })
            CircleButton(onClick = { onSelected(CoffeeBeansLevel.High) })
        }
    }

    Row(modifier = Modifier.size(152.dp, 56.dp).padding(top = 2.dp), horizontalArrangement = Arrangement.SpaceBetween) {
        CaffeRegularText(
            "Low",
            fontSize = 10,
            fontColor = Color(0x991F1F1F)
        )
        CaffeRegularText(
            "Medium",
            fontSize = 10,
            fontColor = Color(0x991F1F1F)
        )
        CaffeRegularText(
            "High",
            fontSize = 10,
            fontColor = Color(0x991F1F1F)
        )
    }
}

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