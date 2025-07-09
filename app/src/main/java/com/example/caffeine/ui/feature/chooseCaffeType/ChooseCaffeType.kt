package com.example.caffeine.ui.feature.chooseCaffeType

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.caffeine.ui.component.ContinueBottomButton
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
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
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

        }
        item {
            ContinueBottomButton(
                Modifier
                    .padding(vertical = 32.dp)
                    .navigationBarsPadding(),
                onClick = { navController.navigate(Route.CustomizedCaffeScreen(pagerState.currentPage)) }
            )
        }
    }
}



