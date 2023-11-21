package com.wine.eventovendimia.ui.screen.login.di

import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wine.eventovendimia.data.remote.WineRepository

internal class LoginFactory (
    private val repository: WineRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(
            WineRepository::class.java
        ).newInstance(repository)
    }
}

internal inline fun <reified T : ViewModel> getFactoryViewModel(
    activity: ComponentActivity,
    repository: WineRepository
): T {
    return ViewModelProvider(
        activity,
        LoginFactory(
            repository = repository
        )
    )[T::class.java]
}