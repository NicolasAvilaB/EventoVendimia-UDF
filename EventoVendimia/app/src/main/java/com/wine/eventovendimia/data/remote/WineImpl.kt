package com.wine.eventovendimia.data.remote

import com.wine.eventovendimia.data.remote.models.RemoteLoginUser
import com.wine.eventovendimia.data.remote.models.RemoteUserRegister
import com.wine.eventovendimia.data.remote.retrofit.WineWebService
import com.wine.eventovendimia.data.remote.source.WineRemoteSource

internal class WineImpl(
    private val api: WineWebService
) : WineRemoteSource {
    override suspend fun registerUserLogin(registerUser: RemoteUserRegister) =
        api.saveRegisterUserLogin(registerUser)

    override suspend fun getLoginUser(user: String, pass: String): RemoteLoginUser =
        api.getUserLogin(user, pass)
}