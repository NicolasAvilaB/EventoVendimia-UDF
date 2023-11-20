package com.wine.eventovendimia.ui.navigation

import androidx.navigation.NavHostController

class NavGo(navHostController: NavHostController) {
    val menuScreen: () -> Unit = {
        navHostController.navigate(NavRoutes.MenuScreen.routes)
    }
}