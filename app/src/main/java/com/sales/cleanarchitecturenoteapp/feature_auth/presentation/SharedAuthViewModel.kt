package com.sales.cleanarchitecturenoteapp.feature_auth.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.sales.cleanarchitecturenoteapp.feature_auth.presentation.register.RegistrationUIState
import com.sales.cleanarchitecturenoteapp.feature_auth.presentation.register.UIEvent
import com.sales.cleanarchitecturenoteapp.utilities.Validator

class SharedAuthViewModel : ViewModel() {

    val registrationUIState = mutableStateOf(RegistrationUIState())

    fun onEvent(event: UIEvent) {
        when (event) {
            is UIEvent.FirstNameChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    firstName = event.firstName,
                    firstNameError = Validator.validateFirstName(
                        firstName = event.firstName
                    ).status
                )
            }

            is UIEvent.LastNameChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    lastName = event.lastName,
                    lastNameError = Validator.validateLastName(
                        lastName = event.lastName
                    ).status
                )
            }

            is UIEvent.EmailChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    email = event.email,
                    emailError = Validator.validateEmail(
                        email = event.email
                    ).status
                )
            }

            is UIEvent.PasswordChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    password = event.password,
                    passwordError = Validator.validatePassword(
                        password = event.password
                    ).status
                )
            }

            is UIEvent.RegisterButtonClicked -> {
                register()
            }
        }
    }

    private fun register() {

    }

/*    private fun validateData() {
        val firstNameValid = Validator.validateFirstName(
            firstName = registrationUIState.value.firstName
        )
        val lastNameValid = Validator.validateLastName(
            lastName = registrationUIState.value.lastName
        )
        val emailValid = Validator.validateEmail(
            email = registrationUIState.value.email
        )
        val passwordValid = Validator.validatePassword(
            password = registrationUIState.value.password
        )

        registrationUIState.value = registrationUIState.value.copy(
            firstNameError = firstNameValid.status,
            lastNameError = lastNameValid.status,
            emailError = emailValid.status,
            passwordError = passwordValid.status,
        )
    }*/
}