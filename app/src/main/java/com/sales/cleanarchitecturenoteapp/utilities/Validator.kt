package com.sales.cleanarchitecturenoteapp.utilities

object Validator {

    fun validateFirstName(firstName: String): ValidationResult {
        return ValidationResult(
            !firstName.isNullOrEmpty() && firstName.length >= 2
        )
    }

    fun validateLastName(lastName: String): ValidationResult {
        return ValidationResult(
            !lastName.isNullOrEmpty() && lastName.length >= 2
        )
    }
//TODO add email regex
    fun validateEmail(email: String): ValidationResult {
        return ValidationResult(
            !email.isNullOrEmpty() && email.length >= 2
        )
    }

    fun validatePassword(password: String): ValidationResult {
        return ValidationResult(
            !password.isNullOrEmpty() && password.length >= 6
        )
    }
    fun validateTermsAndPolicy(status: Boolean): ValidationResult {
        return ValidationResult(
            status
        )
    }

    data class ValidationResult(
        val status: Boolean = false
    )
}