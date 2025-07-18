package com.example.caffeine.ui.feature.customizedCaffe

import androidx.compose.animation.core.animateSizeAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.caffeine.R
import com.example.caffeine.ui.feature.chooseCaffeType.CaffeType
import com.example.caffeine.ui.component.ContinueBottomButton
import com.example.caffeine.designSystem.component.text.CaffeRegularText
import com.example.caffeine.ui.feature.customizedCaffe.component.CaffeSizeSelector
import com.example.caffeine.ui.feature.customizedCaffe.component.CaffeTypeSelector
import com.example.caffeine.ui.feature.customizedCaffe.component.CoffeeBeansLevel
import com.example.caffeine.ui.feature.customizedCaffe.component.CoffeeBeansLevelAnimation
import com.example.caffeine.ui.feature.customizedCaffe.component.CupSizeType
import com.example.caffeine.ui.feature.customizedCaffe.component.CustomizedCaffeUpBar
import com.example.caffeine.ui.feature.navigation.LocalNavController
import com.example.caffeine.ui.feature.navigation.Route

@Composable
fun CustomizedCaffe(
    index: Int
) {
    val navController = LocalNavController.current
    var selectedCoffeeSizeType by remember { mutableStateOf(CupSizeType.Medium) }
    var selectedBeansLevel by remember { mutableStateOf(CoffeeBeansLevel.Low) }
    val caffeType = CaffeType.entries[index].name

    val animatedCupSize by animateSizeAsState(
        targetValue = when (selectedCoffeeSizeType) {
            CupSizeType.Small -> Size(160f, 190f)
            CupSizeType.Medium -> Size(200f, 250f)
            CupSizeType.Large -> Size(250f, 300f)
        }
    )
    val animateLogoSize by animateSizeAsState(
        when (selectedCoffeeSizeType) {
            CupSizeType.Small -> Size(40f, 40f)
            CupSizeType.Medium -> Size(66f, 66f)
            CupSizeType.Large -> Size(66f, 66f)
        }
    )
    val cupSizeInML = when (selectedCoffeeSizeType) {
        CupSizeType.Small -> "150 ML"
        CupSizeType.Medium -> "200 ML"
        CupSizeType.Large -> "400 ML"
    }


    LazyColumn(
        Modifier
            .background(Color.White)
            .fillMaxSize()
            .statusBarsPadding(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        item {

            Box() {
                Box(modifier = Modifier.matchParentSize()) {
                    CoffeeBeansLevelAnimation(selectedBeansLevel)
                }
                Column() {

                    CustomizedCaffeUpBar(
                        modifier = Modifier
                            .padding(bottom = 77.dp),
                        onClick = { navController.navigate(Route.ChooseCaffeTypeScreen) },
                        label = caffeType
                    )
                    CaffeCup(
                        cupSize = animatedCupSize,
                        logoSize = animateLogoSize,
                        modifier = Modifier
                            .height(300.dp)
                            .fillMaxWidth(),
                        cupSizeInML = cupSizeInML
                    )

                }

            }
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {


                CaffeTypeSelector(
                    modifier = Modifier.padding(top = 19.dp),
                    selected = selectedCoffeeSizeType,
                    onSelected = {
                        selectedCoffeeSizeType = when (it) {
                            CupSizeType.Small -> {
                                CupSizeType.Small
                            }

                            CupSizeType.Medium -> {
                                CupSizeType.Medium
                            }

                            CupSizeType.Large -> {
                                CupSizeType.Large
                            }
                        }
                    }
                )

                CaffeSizeSelector(
                    selected = selectedBeansLevel,
                    modifier = Modifier.padding(top = 16.dp),
                    onSelected = {
                        selectedBeansLevel = when (it) {
                            CoffeeBeansLevel.Low -> {
                                CoffeeBeansLevel.Low
                            }

                            CoffeeBeansLevel.Medium -> {
                                CoffeeBeansLevel.Medium
                            }

                            CoffeeBeansLevel.High -> {
                                CoffeeBeansLevel.High
                            }
                        }
                    }
                )
            }
        }
        item() {

            ContinueBottomButton(
                modifier = Modifier
                    .navigationBarsPadding()
                    .padding(vertical = 32.dp)
            ) {
                navController.navigate(
                    Route.CoffeeLoadingScreen(
                        animatedCupSize.width.toInt(),
                        animatedCupSize.height.toInt(),
                        cupSizeInML,
                        animateLogoSize.width.toInt(),
                        animateLogoSize.height.toInt()
                    )
                )
            }
        }
    }


}


@Composable
fun CaffeCup(
    cupSize: Size,
    logoSize: Size,
    cupSizeInML: String,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {

        CaffeRegularText(
            cupSizeInML,
            fontSize = 14,
            fontColor = Color(0x99000000),
            modifier = Modifier
                .padding(start = 16.dp)
                .offset(y = 40.dp)
                .align(Alignment.TopStart)
        )
        Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {

            Image(
                painter = painterResource(R.drawable.empty_cup), contentDescription = null,
                modifier = Modifier.size(cupSize.width.dp, cupSize.height.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.the_chance_logo),
                contentDescription = null,
                modifier = Modifier
                    .size(logoSize.width.dp, logoSize.height.dp)
            )
        }
    }


}