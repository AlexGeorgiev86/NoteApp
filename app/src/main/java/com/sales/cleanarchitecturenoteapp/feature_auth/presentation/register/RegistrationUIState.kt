package com.sales.cleanarchitecturenoteapp.feature_auth.presentation.register

data class RegistrationUIState(
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val password: String = "",
    val termsAndPolicyAccepted: Boolean = false,

    val firstNameError: Boolean = false,
    val lastNameError: Boolean = false,
    val emailError: Boolean = false,
    val passwordError: Boolean = false,
    val termsAndPolicyError: Boolean = false,

    )
