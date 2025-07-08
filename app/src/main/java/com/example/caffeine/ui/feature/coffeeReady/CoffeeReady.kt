package com.example.caffeine.ui.feature.coffeeReady

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.caffeine.ui.feature.chooseCaffeType.CaffeTextBold
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
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 16.dp).fillMaxWidth()
            ) {
                CookieSwitch(onClick = {})
                Spacer(Modifier.width(8.dp))
                CaffeTextBold(
                    "Take Away",
                    fontSize = 14,
                    fontColor = Color(0xB21F1F1F)
                )
            }
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


