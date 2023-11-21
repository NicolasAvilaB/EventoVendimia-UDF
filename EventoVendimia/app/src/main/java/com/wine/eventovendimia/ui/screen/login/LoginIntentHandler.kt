package com.wine.eventovendimia.ui.screen.login

import com.wine.eventovendimia.presentation.login.actions.LoginUIntent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class LoginIntentHandler {
    var coroutineScope: CoroutineScope? = null

    val userIntents = MutableSharedFlow<LoginUIntent>()

    internal fun userIntents(): Flow<LoginUIntent> = userIntents.asSharedFlow()

    internal fun getLogin(user: String, pass: String) =
        coroutineScope?.launch{
            userIntents.emit(LoginUIntent.SendUserLogin(user = "", pass= ""))
        }
}