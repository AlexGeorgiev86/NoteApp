package com.sales.cleanarchitecturenoteapp.feature_auth.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sales.cleanarchitecturenoteapp.ui.theme.DarkGray

@Composable
fun DividerText() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = DarkGray.copy(alpha = 0.2f),
            thickness = 1.dp
        )
        Text(
            text = "or",
            fontSize = 14.sp,
            modifier = Modifier.padding(8.dp)
        )

        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = DarkGray.copy(alpha = 0.2f),
            thickness = 1.dp
        )
    }
}