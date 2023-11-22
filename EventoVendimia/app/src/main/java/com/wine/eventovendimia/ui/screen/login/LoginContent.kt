package com.wine.eventovendimia.ui.screen.login

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.wine.eventovendimia.presentation.login.actions.LoginUiEffect
import com.wine.eventovendimia.ui.navigation.NavGo
import com.wine.eventovendimia.ui.screen.login.effects.DisplayUiEffects
import kotlinx.coroutines.flow.SharedFlow

@Composable
internal fun LoginContent(
    navGo: NavGo,
    uiEffects: SharedFlow<LoginUiEffect>
) {
    var textChangedInput by rememberSaveable { mutableStateOf("") }
    val errorInput = remember { mutableStateOf("") }
    val isError = remember { mutableStateOf(false) }

    Passwordnput(
        textPass = textChangedInput,
        errorInput = errorInput
    ){
        textChangedInput = it
    }
    DisplayUiEffects(
        navGo = navGo,
        uiEffects = uiEffects
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Passwordnput(
    textPass: String,
    errorInput: MutableState<String>,
    textChangedInput: (String) -> Unit
) {
    var passwordVisibility by remember { mutableStateOf(false) }
    OutlinedTextField(
        value = textPass,
        onValueChange = { textChangedInput(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { "" },
        label = { "Password" },
        singleLine = true,
        supportingText = { errorInput.value },
        maxLines = 1,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val imagen = if (passwordVisibility) {
                Icons.Filled.VisibilityOff
            } else {
                Icons.Filled.Visibility
            }
            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                Icon(imageVector = imagen, contentDescription = "")
            }
        },
        visualTransformation = if (passwordVisibility) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        }
    )
}
