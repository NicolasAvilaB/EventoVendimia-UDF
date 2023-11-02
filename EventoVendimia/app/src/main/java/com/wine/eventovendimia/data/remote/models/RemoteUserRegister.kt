package com.wine.eventovendimia.data.remote.models

import com.google.gson.annotations.SerializedName
import com.wine.eventovendimia.data.remote.models.Constants.EMAIL
import com.wine.eventovendimia.data.remote.models.Constants.PASS
import com.wine.eventovendimia.data.remote.models.Constants.RUT
import com.wine.eventovendimia.data.remote.models.Constants.USER

data class RemoteUserRegister(
    @SerializedName(RUT) val rut: String,
    @SerializedName(USER) val user: String,
    @SerializedName(PASS) val pass: String,
    @SerializedName(EMAIL) val email: String
)
