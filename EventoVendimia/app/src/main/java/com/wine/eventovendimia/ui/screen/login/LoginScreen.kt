package com.wine.eventovendimia.ui.screen.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import com.wine.eventovendimia.presentation.login.actions.LoginUiState
import com.wine.eventovendimia.ui.navigation.NavGo
import com.wine.eventovendimia.ui.screen.login.componentstate.ErrorComponent
import com.wine.eventovendimia.ui.screen.login.componentstate.ErrorState
import com.wine.eventovendimia.ui.screen.login.componentstate.LoadingState

@Composable
fun LoginScreen(
    navGo: NavGo,
    intentHandler: LoginIntentHandler,
    uiState: State<LoginUiState>
) {
    LoginContent(
        navGo = navGo,
        intentHandler = intentHandler,
        uiState = uiState
    )
}

@Composable
private fun LoginContent(
    navGo: NavGo,
    intentHandler: LoginIntentHandler,
    uiState: State<LoginUiState>
) {
    when (uiState.value) {
        LoginUiState.ViewUiState -> {

        }

        LoginUiState.LoadingUiState -> {
            LoadingState()
        }

        LoginUiState.ErrorUiState -> {
            ErrorState()
        }
    }
}
