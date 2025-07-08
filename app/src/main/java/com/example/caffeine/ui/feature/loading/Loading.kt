package com.example.caffeine.ui.feature.loading

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.designSystem.theme.snigletFamily
import com.example.caffeine.ui.component.CaffeineUpBar
import com.example.caffeine.ui.feature.chooseCaffeType.CaffeTextBold
import com.example.caffeine.ui.feature.customizedCaffe.component.CaffeRegularText
import com.example.caffeine.ui.feature.navigation.LocalNavController
import com.example.caffeine.ui.feature.navigation.Route
import kotlinx.coroutines.delay

@Composable
fun Loading(
    cupWidth: Int,
    cupHeight: Int,
    cupSizeInML: String,
    logoWidth: Int,
    logoHeight: Int
) {
    val navController = LocalNavController.current
    LaunchedEffect(Unit) {
        delay(5000)
        navController.navigate(
            Route.CoffeeReady(
                cupWidth,
                cupHeight,
                cupSizeInML,
                logoWidth,
                logoHeight
            )
        )
    }
    LazyColumn(verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxSize()) {

        item() {
            CaffeineUpBar {

            }
            CaffeCup(
                cupSize = Size(cupWidth.dp.value, cupHeight.dp.value),
                logoSize = Size(logoWidth.dp.value, logoHeight.dp.value),
                cupSizeInML = cupSizeInML,
                modifier = Modifier
                    .height(300.dp)
                    .fillMaxWidth()

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
                CaffeTimeText("CO")
                Spacer(Modifier.width(12.dp))
                CaffeTimeText(":", fontColor = Color(0x1F1F1F1F))
                Spacer(Modifier.width(12.dp))
                CaffeTimeText("FF")
                Spacer(Modifier.width(12.dp))
                CaffeTimeText(":", fontColor = Color(0x1F1F1F1F))
                Spacer(Modifier.width(12.dp))
                CaffeTimeText("EE")
            }
            Spacer(Modifier.height(32.dp))
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
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

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

@Composable
fun CaffeTimeText(
    text: String,
    fontColor: Color = Color(0xFF7C351B),
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontWeight = FontWeight.W800,
        fontSize = 32.sp,
        letterSpacing = 0.25.sp,
        textAlign = TextAlign.Center,
        fontFamily = snigletFamily,
        color = fontColor
    )

}