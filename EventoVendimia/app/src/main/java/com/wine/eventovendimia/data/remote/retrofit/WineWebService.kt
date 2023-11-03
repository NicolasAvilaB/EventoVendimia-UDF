package com.wine.eventovendimia.data.remote.retrofit

import com.wine.eventovendimia.data.remote.models.RemoteLoginUser
import com.wine.eventovendimia.data.remote.models.RemoteUserRegister
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface WineWebService {
    @GET("api/lo")
    suspend fun getUserLogin(
        @Query("user") user : String,
        @Query("pass") pass : String
    ): RemoteLoginUser
    @POST("api/register_user")
    suspend fun saveRegisterUserLogin(@Body registerUserParams: RemoteUserRegister)
}