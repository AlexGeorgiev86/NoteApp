package com.sales.cleanarchitecturenoteapp.feature_auth.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sales.cleanarchitecturenoteapp.ui.theme.Active

@Composable
fun AuthButton(
    value: String,
    isEnabled: Boolean = false,
    onButtonClicked: () -> Unit
) {
    Button(
        onClick = { onButtonClicked() },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(50.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Active,
            disabledContainerColor = Active,
            disabledContentColor = Active,
            contentColor = Active
        ),
        shape = RoundedCornerShape(50.dp),
        enabled = isEnabled
    ) {
        Text(
            text = value,
            fontSize = 18.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )

    }
}
