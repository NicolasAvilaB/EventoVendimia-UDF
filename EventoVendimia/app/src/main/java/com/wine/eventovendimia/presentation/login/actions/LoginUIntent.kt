package com.wine.eventovendimia.presentation.login.actions

sealed class LoginUIntent {
    data class SendUserLogin(
        val user: String,
        val pass: String
    ) : LoginUIntent()
}