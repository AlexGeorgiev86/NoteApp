package com.sales.cleanarchitecturenoteapp.feature_auth.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sales.cleanarchitecturenoteapp.ui.theme.Active
import com.sales.cleanarchitecturenoteapp.ui.theme.BabyBlue

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
            containerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = Color.Transparent,
            contentColor = Color.Transparent
        ),
        shape = RoundedCornerShape(50.dp),
        enabled = isEnabled
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(50.dp)
                .background(
                    brush = Brush.horizontalGradient(listOf(BabyBlue, Active)),
                    shape = RoundedCornerShape(50.dp)
                )
        ) {
            Text(
                text = value,
                fontSize = 18.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )

        }
    }
}
