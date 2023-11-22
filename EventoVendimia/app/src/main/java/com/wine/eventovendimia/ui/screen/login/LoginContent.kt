package com.wine.eventovendimia.ui.screen.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.wine.eventovendimia.presentation.login.actions.LoginUiEffect
import com.wine.eventovendimia.ui.navigation.NavGo
import com.wine.eventovendimia.ui.screen.login.effects.DisplayUiEffects
import kotlinx.coroutines.flow.SharedFlow

@Composable
internal fun LoginContent(
    navGo: NavGo,
    uiEffects: SharedFlow<LoginUiEffect>
) {
    val textInput by remember { mutableStateOf("") }
    val errorInput by remember { mutableStateOf("") }

    InputName(textInput = textInput, errorInput = errorInput)

    DisplayUiEffects(
        navGo = navGo,
        uiEffects = uiEffects
    )
}

@Composable
private fun InputName(
    textInput: String,
    errorInput: String
) {

}