package com.sales.cleanarchitecturenoteapp.feature_auth.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AuthCheckbox(textValue: String, onTextSelected: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(40.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val checkedState by remember { mutableStateOf(false) }

        Checkbox(checked = checkedState, onCheckedChange = { checkedState != checkedState })

        AuthClickableText(text = textValue, onTextSelected = onTextSelected)
    }
}