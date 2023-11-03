package com.wine.eventovendimia.data.remote.source

import com.wine.eventovendimia.data.remote.models.RemoteLoginUser
import com.wine.eventovendimia.data.remote.models.RemoteUserRegister

interface WineRemoteSource {
    suspend fun getLoginUser(user: String, pass: String): RemoteLoginUser
    suspend fun registerUserLogin(registerUserLogin: RemoteUserRegister)
}