package com.wine.eventovendimia.ui.screen.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.wine.eventovendimia.presentation.login.actions.LoginUiEffect
import com.wine.eventovendimia.ui.components.Passwordnput
import com.wine.eventovendimia.ui.components.SimpleButton
import com.wine.eventovendimia.ui.components.TextInput
import com.wine.eventovendimia.ui.navigation.NavGo
import com.wine.eventovendimia.ui.screen.login.effects.DisplayUiEffects
import kotlinx.coroutines.flow.SharedFlow

@Composable
internal fun LoginContent(
    navGo: NavGo,
    intentHandler: LoginIntentHandler,
    uiEffects: SharedFlow<LoginUiEffect>
) {
    var textInputChanged by rememberSaveable { mutableStateOf("") }
    val textInputError = remember { mutableStateOf("") }

    var textPassChanged by rememberSaveable { mutableStateOf("") }
    val textPassError = remember { mutableStateOf("") }

    TextInput(
        textInput = textInputChanged,
        textInputError = textInputError
    ) {
        textInputChanged = it
    }

    Passwordnput(
        textPass = textPassChanged,
        textPassError = textPassError
    ) {
        textPassChanged = it
    }

    SimpleButton(
        onClick = {
            intentHandler.getLogin(
                user = textInputChanged,
                pass = textPassChanged
            )
        }
    )

    DisplayUiEffects(
        navGo = navGo,
        uiEffects = uiEffects,
        textInputError = textInputError,
        textPassError = textPassError
    )
}
