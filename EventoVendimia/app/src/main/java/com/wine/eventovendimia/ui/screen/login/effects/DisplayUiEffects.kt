package com.wine.eventovendimia.ui.screen.login.effects

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
){
    LaunchedEffect(uiEffects){
        uiEffects.collectLatest { uiEffects ->
            when(uiEffects){
                InvalidUserPass -> {

                }
                NavigateMenu -> {
                    navGo.menuScreen.invoke()
                }
            }
        }
    }
}