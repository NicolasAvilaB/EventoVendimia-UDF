package com.wine.eventovendimia.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun NavController() {
    val startDestination: String = NavRoutes.LoginScreen.routes
    val navController = rememberNavController()
    val navGo = remember(navController) { NavGo(navController)}

    NavHost(
        navController = navController,
        startDestination = startDestination)
    {
        login(navGo)
    }
}