package com.example.caffeine.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.caffeine.R
import com.example.caffeine.designSystem.component.PrimaryButton
import com.example.caffeine.designSystem.component.text.CaffeTextBold

@Composable
fun ContinueBottomButton(modifier: Modifier = Modifier, onClick: () -> Unit = {}) {
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        PrimaryButton(onClick = onClick) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                CaffeTextBold(
                    "Continue", fontSize = 16, fontColor = Color(0xDEFFFFFF),
                )
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.icon_right_arrow),
                    contentDescription = null,
                    tint = Color(0xDEFFFFFF)
                )
            }
        }
    }
}