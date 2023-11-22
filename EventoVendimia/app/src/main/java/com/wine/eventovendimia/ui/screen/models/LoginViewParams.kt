package com.wine.eventovendimia.ui.screen.models

import androidx.compose.runtime.State
import com.wine.eventovendimia.presentation.login.actions.LoginUiEffect
import com.wine.eventovendimia.presentation.login.actions.LoginUiState
import com.wine.eventovendimia.ui.navigation.NavGo
import com.wine.eventovendimia.ui.screen.login.LoginIntentHandler
import kotlinx.coroutines.flow.SharedFlow

data class LoginViewParams(
    internal val navGo: NavGo,
    internal val uiState: State<LoginUiState>,
    internal val uiEffects: SharedFlow<LoginUiEffect>,
    internal val intentHandler: LoginIntentHandler
)
