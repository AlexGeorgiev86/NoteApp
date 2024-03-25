package com.sales.cleanarchitecturenoteapp.feature_auth.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import com.sales.cleanarchitecturenoteapp.ui.theme.Active
import com.sales.cleanarchitecturenoteapp.ui.theme.LightGray

@Composable
fun AuthTextField(
    labelValue: String,
    icon: ImageVector,
    errorStatus: Boolean,
    onTextSelected: (String) -> Unit
) {

    var textValue by remember { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = textValue,
        label = { Text(text = labelValue) },
        onValueChange = {
            textValue = it
            onTextSelected(it)
        },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        leadingIcon = { Icon(imageVector = icon, contentDescription = "") },
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = LightGray,
            unfocusedContainerColor = LightGray,
            focusedBorderColor = Active,
            focusedLabelColor = Active,
            cursorColor = Active
        ),
        singleLine = true,
        maxLines = 1,
        isError = !errorStatus
    )
}