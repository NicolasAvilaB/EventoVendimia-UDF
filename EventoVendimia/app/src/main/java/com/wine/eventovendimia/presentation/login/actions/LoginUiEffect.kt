package com.wine.eventovendimia.presentation.login.actions

sealed class LoginUiEffect {
    object InvalidUserPass: LoginUiEffect()
    object NavigateMenu: LoginUiEffect()
}