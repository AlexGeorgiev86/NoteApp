package com.sales.cleanarchitecturenoteapp.feature_auth.presentation.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sales.cleanarchitecturenoteapp.R
import com.sales.cleanarchitecturenoteapp.feature_auth.presentation.SharedAuthViewModel
import com.sales.cleanarchitecturenoteapp.feature_auth.presentation.components.NormalText

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: SharedAuthViewModel,
    onSuccessfulLogin: () -> Unit
) {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier.fillMaxSize()){
            NormalText(text = stringResource(id = R.string.hey_there))
            NormalText(
                text = stringResource(id = R.string.welcome_back),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}