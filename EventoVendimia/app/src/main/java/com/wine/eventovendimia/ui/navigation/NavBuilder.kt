package com.wine.eventovendimia.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.wine.eventovendimia.ui.screen.login.LoginScreen

internal fun NavGraphBuilder.login(
    navGo: NavGo
) = composable(
    route = NavRoutes.LoginScreen.routes
){
    LoginScreen(
        navGo = navGo
    )
}