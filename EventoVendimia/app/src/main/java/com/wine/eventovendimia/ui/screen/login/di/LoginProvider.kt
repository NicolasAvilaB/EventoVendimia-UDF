package com.wine.eventovendimia.ui.screen.login.di

import androidx.fragment.app.FragmentActivity
import com.wine.eventovendimia.data.remote.WineImpl
import com.wine.eventovendimia.data.remote.WineRepository
import com.wine.eventovendimia.data.remote.retrofit.Retrofit
import com.wine.eventovendimia.data.remote.retrofit.WineWebService
import com.wine.eventovendimia.data.remote.source.WineRemoteSource
import com.wine.eventovendimia.presentation.login.LoginViewModel
import com.wine.eventovendimia.ui.screen.login.LoginIntentHandler

internal class LoginProvider() {
    fun getIntentHandler() = LoginIntentHandler()

    internal fun getViewModel(
        activity: FragmentActivity
    ): LoginViewModel = getFactoryViewModel(
        activity = activity,
        repository = getWineRepository()
    )

    private fun getWineRepository():
            WineRepository = WineRepository(remote = getRemoteImpl())

    private fun getRemoteImpl():
            WineRemoteSource = WineImpl(api = wineWebService)

    private val wineWebService: WineWebService
    init {
        val retrofit = Retrofit.provideRetrofit()
        wineWebService = retrofit.create(WineWebService::class.java)
    }
}