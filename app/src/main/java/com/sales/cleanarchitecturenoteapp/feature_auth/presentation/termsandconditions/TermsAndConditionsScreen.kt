package com.sales.cleanarchitecturenoteapp.feature_auth.presentation.termsandconditions

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sales.cleanarchitecturenoteapp.R
import com.sales.cleanarchitecturenoteapp.feature_auth.presentation.components.NormalText

@Composable
fun TermsAndConditionsScreen(clickedValue: String?) {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier
            .fillMaxSize()
            .padding(18.dp)
    ) {
        NormalText(
            text = clickedValue ?: stringResource(id = R.string.terms_and_conditions),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
    }
}