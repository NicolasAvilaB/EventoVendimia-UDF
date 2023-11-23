package com.wine.eventovendimia.ui.screen.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.wine.eventovendimia.presentation.login.actions.LoginUiEffect
import com.wine.eventovendimia.ui.components.Passwordnput
import com.wine.eventovendimia.ui.navigation.NavGo
import com.wine.eventovendimia.ui.screen.login.effects.DisplayUiEffects
import kotlinx.coroutines.flow.SharedFlow

@Composable
internal fun LoginContent(
    navGo: NavGo,
    uiEffects: SharedFlow<LoginUiEffect>
) {
    var textChangedInput by rememberSaveable { mutableStateOf("") }
    val errorInput = remember { mutableStateOf("") }
    val isError = remember { mutableStateOf(false) }

    Passwordnput(
        textPass = textChangedInput,
        errorInput = errorInput
    ){
        textChangedInput = it
    }
    DisplayUiEffects(
        navGo = navGo,
        uiEffects = uiEffects
    )
}
