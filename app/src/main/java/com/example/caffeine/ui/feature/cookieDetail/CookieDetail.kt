package com.example.caffeine.ui.feature.cookieDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.designSystem.component.PrimaryButton
import com.example.caffeine.designSystem.theme.snigletFamily
import com.example.caffeine.ui.feature.chooseCaffeType.CaffeTextBold
import com.example.caffeine.ui.feature.coffeeReady.component.CaffeReadyUpBar
import com.example.caffeine.ui.feature.cookies.cookiesType
import com.example.caffeine.ui.feature.navigation.LocalNavController
import com.example.caffeine.ui.feature.navigation.Route

@Composable
fun CookieDetail(
    cookie: cookiesType
) {
    val navController = LocalNavController.current
    LazyColumn(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    )
    {
        item {
            Column() {
                CaffeReadyUpBar(
                    onClick = { navController.navigate(Route.Home) },
                    modifier = Modifier.statusBarsPadding()
                )

                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(top = 24.dp)
                        .fillMaxWidth()
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.coffee_beans),
                        contentDescription = null,
                        modifier = Modifier.size(32.dp),
                        tint = Color(0xFF7C351B)
                    )
                    Spacer(Modifier.width(6.dp))
                    Text(
                        "More Espresso, Less Depresso",
                        fontWeight = FontWeight.W400,
                        fontSize = 20.sp,
                        letterSpacing = 0.25.sp,
                        textAlign = TextAlign.Center,
                        fontFamily = snigletFamily,
                        color = Color(0xFF7C351B),
                    )
                    Spacer(Modifier.width(6.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.coffee_beans),
                        contentDescription = null,
                        modifier = Modifier.size(32.dp),
                        tint = Color(0xFF7C351B)
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = cookie.value),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 24.dp)
                            .size(300.dp)
                    )
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(top = 24.dp)
                    ) {

                        CaffeTextBold(
                            "Bon appétit",
                            fontSize = 22,
                            fontColor = Color(0xDE1F1F1F),
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.icon_magic),
                            contentDescription = null,
                            tint = Color(0xCC1F1F1F),
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }

            }
        }
        item() {
            CookieDetailBottomButton(
                modifier = Modifier
                    .navigationBarsPadding().padding(bottom = 32.dp)
                    .fillMaxWidth(),
                onClick = { navController.navigate(Route.Home) }

            )
        }

    }


}


@Composable
fun CookieDetailBottomButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        PrimaryButton(onClick = { onClick() }) {
            CaffeTextBold(
                "Thank youuu",
                fontSize = 16,
                fontColor = Color(0xDEFFFFFF)
            )
            Icon(
                painter = painterResource(id = R.drawable.icon_right_arrow),
                contentDescription = null,
                tint = Color(0xDEFFFFFF),
                modifier = Modifier
                    .padding(start = 8.dp)
                    .size(24.dp)
            )
        }
    }
}