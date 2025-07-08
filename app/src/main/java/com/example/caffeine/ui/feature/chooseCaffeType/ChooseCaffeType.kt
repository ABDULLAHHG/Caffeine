package com.example.caffeine.ui.feature.chooseCaffeType

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.rememberPagerState
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
import com.example.caffeine.ui.feature.home.component.HomeUpBar
import com.example.caffeine.ui.feature.navigation.LocalNavController
import com.example.caffeine.ui.feature.navigation.Route


@Composable
fun ChooseCaffeType() {
    val navController = LocalNavController.current
    val pagerState = rememberPagerState(3) { 4 }
    LazyColumn(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxWidth(),
    ) {
        item {

            HomeUpBar(Modifier)
            ChooseCaffeTypeGreetings(
                modifier = Modifier.padding(
                    top = 16.dp,
                    start = 16.dp,
                    end = 16.dp
                )
            )
            SelectedCaffeType(pagerState, modifier = Modifier.padding(top = 56.dp))
            ChooseCaffeTypeBottomButton(
                Modifier
                    .padding(top = 32.dp)
                    .navigationBarsPadding(),
                onClick = { navController.navigate(Route.CustomizedCaffeScreen(pagerState.currentPage)) }
            )
        }
    }
}

@Composable
fun ChooseCaffeTypeBottomButton(modifier: Modifier = Modifier, onClick: () -> Unit = {}) {
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



