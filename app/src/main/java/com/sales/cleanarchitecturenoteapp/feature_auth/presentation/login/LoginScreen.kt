package com.sales.cleanarchitecturenoteapp.feature_auth.presentation.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sales.cleanarchitecturenoteapp.R
import com.sales.cleanarchitecturenoteapp.feature_auth.presentation.SharedAuthViewModel
import com.sales.cleanarchitecturenoteapp.feature_auth.presentation.components.AuthButton
import com.sales.cleanarchitecturenoteapp.feature_auth.presentation.components.AuthClickableText
import com.sales.cleanarchitecturenoteapp.feature_auth.presentation.components.AuthTextField
import com.sales.cleanarchitecturenoteapp.feature_auth.presentation.components.DividerText
import com.sales.cleanarchitecturenoteapp.feature_auth.presentation.components.NormalText
import com.sales.cleanarchitecturenoteapp.feature_auth.presentation.components.PasswordTextField
import com.sales.cleanarchitecturenoteapp.feature_auth.presentation.components.UnderlinedText
import com.sales.cleanarchitecturenoteapp.feature_auth.presentation.register.UIEvent
import com.sales.cleanarchitecturenoteapp.navigation.Screen

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: SharedAuthViewModel,
    onSuccessfulLogin: () -> Unit
) {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier
            .fillMaxSize()
            .padding(18.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            NormalText(text = stringResource(id = R.string.hey_there))
            NormalText(
                text = stringResource(id = R.string.welcome_back),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(20.dp))
            AuthTextField(
                labelValue = stringResource(id = R.string.email),
                icon = Icons.Default.Email,
                errorStatus = false,
                onTextSelected = {

                }
            )
            PasswordTextField(
                labelValue = stringResource(id = R.string.password),
                icon = Icons.Default.Lock,
                errorStatus = false,
                onTextSelected = {

                }
            )
            Spacer(modifier = Modifier.height(40.dp))
            UnderlinedText(
                text = stringResource(id = R.string.forgot_password),
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(40.dp))

            AuthButton(stringResource(id = R.string.login)){

            }
            DividerText()

            AuthClickableText(tryingToLogin = false){
                navController.navigate(Screen.RegisterScreen.route)
            }
        }
    }
}