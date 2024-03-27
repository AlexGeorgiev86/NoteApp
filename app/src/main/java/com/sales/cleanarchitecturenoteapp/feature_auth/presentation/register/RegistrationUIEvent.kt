package com.sales.cleanarchitecturenoteapp.feature_auth.presentation.register

sealed class RegistrationUIEvent {

    data class FirstNameChanged(val firstName: String): RegistrationUIEvent()
    data class LastNameChanged(val lastName: String): RegistrationUIEvent()
    data class EmailChanged(val email: String): RegistrationUIEvent()
    data class PasswordChanged(val password: String): RegistrationUIEvent()
    data class TermsAndPolicyCheckBox(val status: Boolean): RegistrationUIEvent()

    data object RegisterButtonClicked: RegistrationUIEvent()
}