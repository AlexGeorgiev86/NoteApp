package com.sales.cleanarchitecturenoteapp.feature_auth.presentation.login

sealed class LoginUIEvent {
    data class EmailChanged(val email: String) : LoginUIEvent()
    data class PasswordChanged(val password: String) : LoginUIEvent()

    data object LoginButtonClicked : LoginUIEvent()
}
