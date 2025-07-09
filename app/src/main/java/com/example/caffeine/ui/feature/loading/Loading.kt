package com.example.caffeine.ui.feature.loading

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.caffeine.ui.component.CaffeCup
import com.example.caffeine.ui.component.CaffeineUpBar
import com.example.caffeine.designSystem.component.text.CaffeTextBold
import com.example.caffeine.ui.feature.loading.component.CaffeTimeText
import com.example.caffeine.ui.feature.loading.component.DraggableBoxWithSlider
import com.example.caffeine.ui.feature.navigation.LocalNavController

@Composable
fun Loading(
    cupWidth: Int,
    cupHeight: Int,
    cupSizeInML: String,
    logoWidth: Int,
    logoHeight: Int
) {
    val navController = LocalNavController.current


    LazyColumn(verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxSize()) {

        item() {
            CaffeineUpBar {
            }
        }

        item() {

            CaffeCup(
                cupSize = Size(cupWidth.dp.value, cupHeight.dp.value),
                logoSize = Size(logoWidth.dp.value, logoHeight.dp.value),
                cupSizeInML = cupSizeInML,
                modifier = Modifier
                    .height(300.dp)
                    .fillMaxWidth()

            )
            DraggableBoxWithSlider(
                navController = navController,
                cupWidth = cupWidth,
                cupHeight = cupHeight,
                cupSizeInML = cupSizeInML,
                logoWidth = logoWidth,
                logoHeight = logoHeight
            )
        }
        item {


            CaffeTextBold(
                "Almost Done",
                fontColor = Color(0xDE1F1F1F),
                fontSize = 22,
                modifier = Modifier.fillMaxWidth()
            )
            CaffeTextBold(
                "Your coffee will be finish in",
                fontColor = Color(0x991F1F1F),
                fontSize = 16,
                modifier = Modifier.fillMaxWidth()
            )

            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    CaffeTimeText("CO")
                    CaffeTimeText(":", fontColor = Color(0x1F1F1F1F))
                    CaffeTimeText("FF")
                    CaffeTimeText(":", fontColor = Color(0x1F1F1F1F))
                    CaffeTimeText("EE")
                }
            }
            Spacer(Modifier.height(32.dp))
        }
    }

}


