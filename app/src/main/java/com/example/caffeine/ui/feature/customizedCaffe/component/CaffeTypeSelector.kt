package com.example.caffeine.ui.feature.customizedCaffe.component

import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.caffeine.designSystem.theme.urbanistFamily
import com.example.caffeine.ui.component.Indicator

enum class CupSizeType {
    Small, Medium, Large
}

@Composable
fun CaffeTypeSelector(
    onSelected: (CupSizeType) -> Unit,
    modifier: Modifier = Modifier,
    selected: CupSizeType = CupSizeType.Medium
) {
    val offset = remember { mutableStateOf(0.dp) }
    SelectorBackground(modifier) {
        Crossfade(
            targetState = selected,
            label = "CaffeTypeIndicator",
            animationSpec = tween(300)
        ) { targetType ->
            offset.value =
                when (targetType) {
                    CupSizeType.Small -> (-48).dp
                    CupSizeType.Medium -> 0.dp
                    CupSizeType.Large -> 48.dp
                }


            Indicator(
                Modifier
                    .offset(x = offset.value)
                    .zIndex(-1f)
            )
        }

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            OneCharacterText(
                "S",
                onClick = { onSelected(CupSizeType.Small) },
                isSelected = selected == CupSizeType.Small,
            )
            OneCharacterText(
                "M",
                onClick = { onSelected(CupSizeType.Medium) },
                isSelected = selected == CupSizeType.Medium
            )
            OneCharacterText(
                "L",
                onClick = { onSelected(CupSizeType.Large) },
                isSelected = selected == CupSizeType.Large
            )
        }
    }
}


@Composable
private fun OneCharacterText(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false
) {
    val animatedColor by animateColorAsState(
        if (isSelected) Color(0xDEFFFFFF) else Color(0x991F1F1F),
        animationSpec = tween(600)
    )
    CircleButton(
        onClick = { onClick() }
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.W700,
            fontSize = 20.sp,
            fontFamily = urbanistFamily,
            color = animatedColor,
            modifier = modifier,
            letterSpacing = 0.25.sp,
            textAlign = TextAlign.Center
        )
    }
}



@Composable
fun SelectorBackground(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(152.dp, 56.dp)
            .background(Color(0xFFF5F5F5), shape = RoundedCornerShape(100.dp))
            .padding(8.dp)
    ) {
        content()
    }
}




