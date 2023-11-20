package com.wine.eventovendimia.ui.navigation

sealed class NavRoutes(var routes: String){
    object LoginScreen: NavRoutes("LoginScreen")
    object MenuScreen: NavRoutes("MenuScreen")
}