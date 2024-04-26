package com.example.todoapp.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CustomTextField(
    text: String,
    onValueChange: (String) -> Unit,
    label: String,
    keyBoardAction: KeyboardOptions
) {
    OutlinedTextField(
        value = text,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        singleLine = true,
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = keyBoardAction
    )
}