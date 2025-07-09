package com.example.caffeine.ui.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.caffeine.ui.feature.home.component.BottomButton
import com.example.caffeine.ui.feature.home.component.HomeGreetings
import com.example.caffeine.ui.feature.home.component.HomeUpBar
import com.example.caffeine.ui.feature.navigation.LocalNavController
import com.example.caffeine.ui.feature.navigation.Route

@Composable
fun Home(
) {
    val navController = LocalNavController.current
    LazyColumn(
        modifier = Modifier.statusBarsPadding().fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        item() {
            HomeUpBar(Modifier.statusBarsPadding())
            HomeGreetings(Modifier.padding(bottom = 33.dp))
            HomeFlyingGhost()

        }
        item(){
            BottomButton(
                onClick = {
                    navController.navigate(Route.ChooseCaffeTypeScreen)
                },
                modifier = Modifier.navigationBarsPadding().padding(bottom = 32.dp)
            )
        }
    }
}


