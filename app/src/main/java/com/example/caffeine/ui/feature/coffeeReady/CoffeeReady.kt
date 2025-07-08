package com.example.caffeine.ui.feature.coffeeReady

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.caffeine.ui.feature.coffeeReady.component.CaffeReadyBottomButton
import com.example.caffeine.ui.feature.coffeeReady.component.CaffeReadyUpBar
import com.example.caffeine.ui.feature.coffeeReady.component.CupWithLid
import com.example.caffeine.ui.feature.coffeeReady.component.SnackBar
import com.example.caffeine.ui.feature.navigation.LocalNavController
import com.example.caffeine.ui.feature.navigation.Route

@Composable
fun CoffeeReady(
    cupWidth: Int,
    cupHeight: Int,
    cupSizeInML: String,
    logoWidth: Int,
    logoHeight: Int
) {
    val navController = LocalNavController.current
    LazyColumn(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize()
    ) {
        item() {
            CaffeReadyUpBar(
                onClick = { navController.navigate(Route.Home) },
                modifier = Modifier
                    .statusBarsPadding()
                    .padding(bottom = 16.dp)
            )
            SnackBar()
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.height((cupHeight.dp.value + logoHeight.dp.value * 2).dp)
            ) {
                CupWithLid(
                    cupWidth,
                    cupHeight,
                    cupSizeInML,
                    logoWidth,
                    logoHeight
                )

            }
        }
        item() {
            CaffeReadyBottomButton(
                onClick = { navController.navigate(Route.Cookies) },
                modifier = Modifier
                    .fillMaxWidth()
                    .navigationBarsPadding()
                    .padding(bottom = 32.dp)
            )
        }
    }
}


