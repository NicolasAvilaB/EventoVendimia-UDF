package com.wine.eventovendimia.data.remote.retrofit

import com.wine.eventovendimia.data.remote.models.RemoteUserRegister
import retrofit2.http.Body
import retrofit2.http.POST

interface WineWebService {
    @POST("api/register_user")
    suspend fun saveRegisterUserLogin(@Body registerUserParams: RemoteUserRegister)
}