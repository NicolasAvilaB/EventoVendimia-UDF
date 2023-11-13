package com.wine.eventovendimia.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wine.eventovendimia.data.remote.WineRepository
import com.wine.eventovendimia.presentation.login.actions.LoginUIntent
import com.wine.eventovendimia.presentation.login.actions.LoginUIntent.SendUserLogin
import com.wine.eventovendimia.presentation.login.actions.LoginUiEffect.InvalidUserPass
import com.wine.eventovendimia.presentation.login.actions.LoginUiEffect.NavigateMenu
import com.wine.eventovendimia.presentation.login.actions.LoginUiState
import com.wine.eventovendimia.presentation.login.actions.LoginUiState.ErrorUiState
import com.wine.eventovendimia.presentation.login.actions.LoginUiState.LoadingUiState
import com.wine.eventovendimia.presentation.login.actions.LoginUiState.ViewUiState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

internal class LoginViewModel(
    private val repository: WineRepository
) : ViewModel() {
    val defaultUiState = ViewUiState
    private val _uiState = MutableStateFlow<LoginUiState>(defaultUiState)

    fun processUIntents(
        intentsUi: Flow<LoginUIntent>,
        coroutineScope: CoroutineScope = viewModelScope
    ) {
        intentsUi.buffer()
            .onEach { uIntent ->
                uIntent.handleUserIntent()
            }.launchIn(coroutineScope)
    }

    private suspend fun LoginUIntent.handleUserIntent() {
        when (this) {
            is SendUserLogin -> getUserLogin(user = user, pass = pass)
        }
    }

    private suspend fun getUserLogin(user: String, pass: String) {
        _uiState.value = LoadingUiState
        kotlin.runCatching {
            repository.getUserLogin(user = user, pass = pass)
                .collect { response ->
                    if (response.user != user && response.pass != pass){
                        InvalidUserPass
                    }else{
                        NavigateMenu
                    }
                }
        }.onFailure {
            _uiState.value = ErrorUiState
        }
    }

    fun uiState(): StateFlow<LoginUiState> = _uiState
}