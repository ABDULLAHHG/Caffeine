package com.example.caffeine.ui.feature.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.caffeine.R
import com.example.caffeine.ui.component.CaffeineUpBar

@Composable
fun HomeUpBar(modifier: Modifier = Modifier, onClick: () -> Unit = {}) {
    CaffeineUpBar(
        modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.ghost),
            contentDescription = null,
        )
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(Color(0xFFF5F5F5))
                .clickable { onClick() }
                .padding(12.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.icon_add),
                tint = Color(0xDE1F1F1F),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        }
    }

}