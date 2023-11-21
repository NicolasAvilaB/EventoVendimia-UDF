package com.wine.eventovendimia.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.fragment.app.FragmentActivity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.wine.eventovendimia.ui.screen.login.di.LoginProvider

@Composable
fun NavController(fragmentActivity: FragmentActivity) {
    val startDestination: String = NavRoutes.LoginScreen.routes
    val navController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    val navGo = remember(navController) { NavGo(navController) }

    val loginProvider = LoginProvider()
    val loginViewModel = loginProvider.getViewModel(fragmentActivity)
    val loginIntentHandler = loginProvider.getIntentHandler().apply {
        this.coroutineScope = coroutineScope
    }

    NavHost(
        navController = navController,
        startDestination = startDestination
    )
    {
        login(navGo, loginIntentHandler, loginViewModel)
    }
}