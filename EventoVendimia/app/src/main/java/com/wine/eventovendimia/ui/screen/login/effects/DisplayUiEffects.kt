package com.wine.eventovendimia.ui.screen.login.effects

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import com.wine.eventovendimia.presentation.login.actions.LoginUiEffect
import com.wine.eventovendimia.presentation.login.actions.LoginUiEffect.InvalidUserPass
import com.wine.eventovendimia.presentation.login.actions.LoginUiEffect.NavigateMenu
import com.wine.eventovendimia.ui.navigation.NavGo
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collectLatest

@Composable
internal fun DisplayUiEffects(
    navGo: NavGo,
    uiEffects: SharedFlow<LoginUiEffect>,
    textInputError: MutableState<String>,
    textPassError: MutableState<String>,
){
    LaunchedEffect(uiEffects){
        uiEffects.collectLatest { uiEffects ->
            when(uiEffects){
                NavigateMenu -> {
                    navGo.menuScreen.invoke()
                }
                InvalidUserPass -> {
                    textPassError.value = "Ups!, que onda, no pudiste logearte, escribe tu user/pass denuevo y que sea correctamente"
                }
            }
        }
    }
}