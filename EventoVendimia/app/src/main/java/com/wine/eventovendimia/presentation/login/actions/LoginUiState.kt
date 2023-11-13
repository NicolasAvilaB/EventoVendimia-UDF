package com.wine.eventovendimia.presentation.login.actions

internal sealed class LoginUiState {
    object LoadingUiState : LoginUiState()
    object ViewUiState : LoginUiState()
    object ErrorUiState : LoginUiState()
}