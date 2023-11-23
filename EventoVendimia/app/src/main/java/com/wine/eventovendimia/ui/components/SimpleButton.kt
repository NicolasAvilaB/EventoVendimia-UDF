package com.wine.eventovendimia.ui.components

import androidx.compose.material3.Button
import androidx.compose.runtime.Composable

@Composable
internal fun SimpleButton(onClick: () -> Unit, enabled: Boolean = true) {
    Button(
        onClick = { onClick.invoke() },
        enabled = enabled
    ) { }
}