package com.example.caffeine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.example.caffeine.designSystem.theme.CaffeineTheme
import com.example.caffeine.ui.feature.cookies.Cookies
import com.example.caffeine.ui.feature.navigation.CoffeeNavHost
import com.example.caffeine.ui.feature.navigation.Route

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            CaffeineTheme() {
                CoffeeNavHost(
                    navController = navController,
                    startDestination = Route.Home,
                    modifier = Modifier.background(Color.White)
                )

            }
        }
    }
}

