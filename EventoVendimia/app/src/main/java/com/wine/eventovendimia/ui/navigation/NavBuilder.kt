package com.wine.eventovendimia.ui.navigation

import androidx.compose.runtime.remember
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.wine.eventovendimia.presentation.login.LoginViewModel
import com.wine.eventovendimia.ui.screen.login.LoginIntentHandler
import com.wine.eventovendimia.ui.screen.login.LoginScreen

internal fun NavGraphBuilder.login(
    navGo: NavGo,
    intentHandler: LoginIntentHandler,
    viewModel: LoginViewModel
) = composable(
    route = NavRoutes.LoginScreen.routes
) {
    val uiState = remember {
        viewModel.processUIntents(
            intentsUi = intentHandler.userIntents()
        )
    }.collectAsState(initial = viewModel.defaultUiState)
    LoginScreen(
        navGo = navGo,
        uiState = uiState,
        intentHandler = intentHandler
    )
}