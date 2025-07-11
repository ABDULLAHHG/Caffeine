package com.example.caffeine.ui.feature.customizedCaffe.component

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.caffeine.R
import com.example.caffeine.designSystem.component.text.CaffeRegularText
import com.example.caffeine.ui.component.Indicator

enum class CoffeeBeansLevel {
    Low, Medium, High
}

@Composable
fun CaffeSizeSelector(
    onSelected: (CoffeeBeansLevel) -> Unit,
    modifier: Modifier = Modifier,
    selected: CoffeeBeansLevel = CoffeeBeansLevel.Medium
) {
    val offset = remember { mutableStateOf(0.dp) }
    SelectorBackground(modifier) {
        Crossfade(targetState = selected, label = "CaffeSizeIndicator", animationSpec = tween(300)) { targetType ->
            offset.value = when (targetType) {
                CoffeeBeansLevel.Low -> (-48).dp
                CoffeeBeansLevel.Medium -> 0.dp
                CoffeeBeansLevel.High -> 48.dp
            }

            Indicator(
                Modifier
                    .offset(x = offset.value)
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

