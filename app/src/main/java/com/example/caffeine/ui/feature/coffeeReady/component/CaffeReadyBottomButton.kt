package com.example.caffeine.ui.feature.coffeeReady.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
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
import com.example.caffeine.ui.feature.chooseCaffeType.CaffeTextBold

@Composable
fun CaffeReadyBottomButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        PrimaryButton(onClick = { onClick() }) {
            CaffeTextBold(
                "Take snack",
                fontColor = Color(0xDEFFFFFF),
                fontSize = 16,
                modifier = Modifier.padding(end = 8.dp)
            )
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.icon_right_arrow),
                contentDescription = null,
                tint = Color(0xDEFFFFFF)
            )

        }
    }
}