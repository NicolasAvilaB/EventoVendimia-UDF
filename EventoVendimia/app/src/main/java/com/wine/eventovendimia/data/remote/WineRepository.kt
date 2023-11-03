package com.wine.eventovendimia.data.remote

import com.wine.eventovendimia.data.remote.models.RemoteUserRegister
import com.wine.eventovendimia.data.remote.source.WineRemoteSource
import kotlinx.coroutines.flow.flow

internal class WineRepository(
    private val remote: WineRemoteSource
) {
    fun getUserLogin(user: String, pass: String) =
        flow {
            val remUserLogin = remote.getLoginUser(user = user, pass = pass)
            emit(remUserLogin)
        }

    fun saveRegisterUser(userRegister: RemoteUserRegister) =
        flow {
            val remUserLogin = remote.registerUserLogin(registerUserLogin = userRegister)
            emit(remUserLogin)
        }
}