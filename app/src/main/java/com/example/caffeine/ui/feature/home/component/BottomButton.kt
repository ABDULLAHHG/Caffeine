package com.example.caffeine.ui.feature.home.component

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.designSystem.component.PrimaryButton
import com.example.caffeine.designSystem.theme.Theme
import com.example.caffeine.designSystem.theme.urbanistFamily

@Composable
fun BottomButton(modifier: Modifier = Modifier, onClick: () -> Unit = {}) {
    PrimaryButton(
        modifier = modifier,
        onClick = {
            onClick()
        }) {
        Text(
            "bring my coffee",
            fontSize = 16.sp,
            fontWeight = FontWeight.W700,
            fontFamily = urbanistFamily,
            textAlign = TextAlign.Center,
            modifier = Modifier,
            color = Theme.color.surface.onPrimary
        )
        Icon(
            painter = painterResource(R.drawable.ic_coffee),
            contentDescription = null,
            Modifier.size(24.dp),
            tint = Theme.color.surface.onPrimary
        )
    }
}

