package com.wine.eventovendimia.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun TextInput(
    textInput: String,
    textInputError: MutableState<String>,
    textInputChanged: (String) -> Unit
) {
    OutlinedTextField(
        value = textInput,
        onValueChange = { textInputChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { "Ingrese su usuario..." },
        label = { "Usuario / Email" },
        singleLine = true,
        supportingText = { textInputError.value },
        maxLines = 1,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Ascii),
    )
}