package com.sales.cleanarchitecturenoteapp.feature_auth.presentation.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.sales.cleanarchitecturenoteapp.R
import com.sales.cleanarchitecturenoteapp.feature_auth.presentation.SharedAuthViewModel
import com.sales.cleanarchitecturenoteapp.feature_auth.presentation.components.AuthButton
import com.sales.cleanarchitecturenoteapp.feature_auth.presentation.components.AuthCheckbox
import com.sales.cleanarchitecturenoteapp.feature_auth.presentation.components.AuthClickableText
import com.sales.cleanarchitecturenoteapp.feature_auth.presentation.components.AuthTextField
import com.sales.cleanarchitecturenoteapp.feature_auth.presentation.components.DividerText
import com.sales.cleanarchitecturenoteapp.feature_auth.presentation.components.NormalText
import com.sales.cleanarchitecturenoteapp.feature_auth.presentation.components.PasswordTextField
import com.sales.cleanarchitecturenoteapp.navigation.Screen

@Composable
fun RegisterScreen(
    viewModel: SharedAuthViewModel,
    navController: NavHostController
) {
    LaunchedEffect(key1 = viewModel.onRegisterSuccess.value) {
        if (viewModel.onRegisterSuccess.value){
            navController.navigate(Screen.LoginScreen.route)
        }
    }

    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier
            .fillMaxSize()
            .padding(18.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            NormalText(text = stringResource(id = R.string.hey_there))
            NormalText(
                text = stringResource(id = R.string.create_account),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))
            AuthTextField(
                labelValue = stringResource(id = R.string.first_name),
                icon = Icons.Default.AccountCircle,
                errorStatus = viewModel.registrationUIState.value.firstNameError,
                onTextSelected = {
                    viewModel.onRegisterEvent(RegistrationUIEvent.FirstNameChanged(it))
                }
            )
            AuthTextField(
                labelValue = stringResource(id = R.string.last_name),
                icon = Icons.Default.AccountCircle,
                errorStatus = viewModel.registrationUIState.value.lastNameError,
                onTextSelected = {
                    viewModel.onRegisterEvent(RegistrationUIEvent.LastNameChanged(it))
                }
            )
            AuthTextField(
                labelValue = stringResource(id = R.string.email),
                icon = Icons.Default.Email,
                errorStatus = viewModel.registrationUIState.value.emailError,
                onTextSelected = {
                    viewModel.onRegisterEvent(RegistrationUIEvent.EmailChanged(it))
                }
            )
            PasswordTextField(
                labelValue = stringResource(id = R.string.password),
                icon = Icons.Default.Lock,
                errorStatus = viewModel.registrationUIState.value.passwordError,
                onTextSelected = {
                    viewModel.onRegisterEvent(RegistrationUIEvent.PasswordChanged(it))
                }
            )

            AuthCheckbox(
                onCheckedChange = {
                    viewModel.onRegisterEvent(RegistrationUIEvent.TermsAndPolicyCheckBox(it))
                },
                onTextSelected = {
                    navController.navigate("${Screen.TermsAndConditionsScreen.route}/$it")
                }
            )

            Spacer(modifier = Modifier.height(70.dp))

            AuthButton(
                value = stringResource(id = R.string.register),
                isEnabled = viewModel.registerValidationPassed.value,
                onButtonClicked = {
                    viewModel.onRegisterEvent(RegistrationUIEvent.RegisterButtonClicked)
                }
            )

            DividerText()

            AuthClickableText(tryingToLogin = true) {
                navController.navigate(Screen.LoginScreen.route)
            }
        }

    }

}