package com.example.caffeine.ui.feature.loading

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.caffeine.R
import com.example.caffeine.ui.feature.customizedCaffe.component.CaffeRegularText

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