package com.wine.eventovendimia.data.remote.models

import com.google.gson.annotations.SerializedName
import com.wine.eventovendimia.data.remote.models.Constants.PASS
import com.wine.eventovendimia.data.remote.models.Constants.USER

data class RemoteLoginUser(
    @SerializedName(USER) val user: String,
    @SerializedName(PASS) val pass: String
)