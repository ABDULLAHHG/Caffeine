package com.example.caffeine.ui.feature.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.caffeine.ui.feature.chooseCaffeType.ChooseCaffeType
import com.example.caffeine.ui.feature.coffeeReady.CoffeeReady
import com.example.caffeine.ui.feature.cookies.Cookies
import com.example.caffeine.ui.feature.cookieDetail.CookieDetail
import com.example.caffeine.ui.feature.customizedCaffe.CustomizedCaffe
import com.example.caffeine.ui.feature.home.Home
import com.example.caffeine.ui.feature.loading.Loading

@Composable
fun CoffeeNavHost(
    navController: NavHostController,
    startDestination: Route,
    modifier: Modifier = Modifier,
) {
    CompositionLocalProvider(
        LocalNavController provides navController
    ) {
        NavHost(
            modifier = modifier,
            startDestination = startDestination,
            navController = navController
        ) {
            composable<Route.Home> {
                Home()
            }

            composable<Route.ChooseCaffeTypeScreen> {
                ChooseCaffeType()
            }

            composable<Route.CustomizedCaffeScreen> {
                val index = it.toRoute<Route.CustomizedCaffeScreen>().index
                CustomizedCaffe(index)
            }

            composable<Route.CoffeeLoadingScreen> {
                val data = it.toRoute<Route.CoffeeLoadingScreen>()
                Loading(
                    data.cupWidth,
                    data.cupHeight,
                    data.cupSizeInML,
                    data.logoWidth,
                    data.logoHeight
                )
            }
            composable<Route.CoffeeReady> {
                val data = it.toRoute<Route.CoffeeReady>()

                CoffeeReady(
                    data.cupWidth,
                    data.cupHeight,
                    data.cupSizeInML,
                    data.logoWidth,
                    data.logoHeight
                )
            }
            composable<Route.Cookies> {
                Cookies()
            }

            composable<Route.CookieDetail> {
                val cookie = it.toRoute<Route.CookieDetail>().cookie
                CookieDetail(cookie)
            }

        }
    }
}

val LocalNavController = staticCompositionLocalOf<NavHostController> {
    error("No NavigationController provided")
}