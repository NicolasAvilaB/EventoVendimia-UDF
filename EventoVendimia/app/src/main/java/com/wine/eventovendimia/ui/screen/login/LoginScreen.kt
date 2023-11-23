package com.wine.eventovendimia.ui.screen.login

import androidx.compose.runtime.Composable
import com.wine.eventovendimia.presentation.login.actions.LoginUiState
import com.wine.eventovendimia.ui.screen.login.stateComponent.ErrorState
import com.wine.eventovendimia.ui.screen.login.stateComponent.LoadingState
import com.wine.eventovendimia.ui.screen.models.LoginViewParams

@Composable
internal fun LoginScreen(
    params: LoginViewParams
) {
    LoginState(
        params = LoginViewParams(
            navGo = params.navGo,
            uiState = params.uiState,
            uiEffects = params.uiEffects,
            intentHandler = params.intentHandler
        )
    )
}

@Composable
private fun LoginState(
    params: LoginViewParams
) {
    when (params.uiState.value) {
        LoginUiState.ViewUiState -> {
            LoginContent(
                navGo = params.navGo,
                uiEffects = params.uiEffects,
            )
        }

        LoginUiState.LoadingUiState -> {
            LoadingState()
        }

        LoginUiState.ErrorUiState -> {
            ErrorState()
        }
    }
}
