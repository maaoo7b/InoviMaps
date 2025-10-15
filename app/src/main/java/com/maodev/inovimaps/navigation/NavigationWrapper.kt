package com.maodev.inovimaps.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.maodev.inovimaps.screens.login.LoginScreen
import com.maodev.inovimaps.screens.map.MapScreen

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = LoginScreen) {
        composable<LoginScreen> {
            LoginScreen(
                navigateToMapScreen = { navController.navigate(MapScreen) }
            )
        }
        composable<MapScreen> {
            MapScreen()
        }
    }

}