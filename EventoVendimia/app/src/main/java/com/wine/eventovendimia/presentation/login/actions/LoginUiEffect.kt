package com.wine.eventovendimia.presentation.login.actions

internal sealed class LoginUiEffect {
    object InvalidUserPass: LoginUiEffect()
    object NavigateMenu: LoginUiEffect()
}