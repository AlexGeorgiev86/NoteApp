package com.sales.cleanarchitecturenoteapp.feature_auth.presentation

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.sales.cleanarchitecturenoteapp.feature_auth.presentation.login.LoginUIEvent
import com.sales.cleanarchitecturenoteapp.feature_auth.presentation.login.LoginUIState
import com.sales.cleanarchitecturenoteapp.feature_auth.presentation.register.RegistrationUIState
import com.sales.cleanarchitecturenoteapp.feature_auth.presentation.register.RegistrationUIEvent
import com.sales.cleanarchitecturenoteapp.utilities.Validator

class SharedAuthViewModel : ViewModel() {

    //register region
    val registrationUIState = mutableStateOf(RegistrationUIState())
    var registerValidationPassed = mutableStateOf(false)
    var onRegisterSuccess = mutableStateOf(false)

    fun onRegisterEvent(event: RegistrationUIEvent) {
        when (event) {
            is RegistrationUIEvent.FirstNameChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    firstName = event.firstName,
                    firstNameError = Validator.validateFirstName(
                        firstName = event.firstName
                    ).status
                )
            }

            is RegistrationUIEvent.LastNameChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    lastName = event.lastName,
                    lastNameError = Validator.validateLastName(
                        lastName = event.lastName
                    ).status
                )
            }

            is RegistrationUIEvent.EmailChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    email = event.email,
                    emailError = Validator.validateEmail(
                        email = event.email
                    ).status
                )
            }

            is RegistrationUIEvent.PasswordChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    password = event.password,
                    passwordError = Validator.validatePassword(
                        password = event.password
                    ).status
                )
            }

            is RegistrationUIEvent.TermsAndPolicyCheckBox -> {
                registrationUIState.value = registrationUIState.value.copy(
                    termsAndPolicyAccepted = event.status,
                    termsAndPolicyError = Validator.validateTermsAndPolicy(
                        status = event.status
                    ).status
                )
            }

            is RegistrationUIEvent.RegisterButtonClicked -> {
                register()
            }
        }
        registerValidationStatus()
    }

    private fun register() {
        createUserInFirebase(
            email = registrationUIState.value.email,
            password = registrationUIState.value.password
        )
    }

    private fun createUserInFirebase(email: String, password: String) {
        FirebaseAuth.getInstance()
            .createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                Log.d(
                    TAG,
                    "inside createUserWithEmailAndPassword addOnCompleteListener, is successful: ${it.isSuccessful}"
                )
                onRegisterSuccess.value = true
            }
            .addOnFailureListener {
                Log.d(
                    TAG,
                    "inside createUserWithEmailAndPassword addOnFailureListener, exception: ${it.message}"
                )
            }
    }

    private fun registerValidationStatus() {
        registerValidationPassed.value = with(registrationUIState.value) {
            emailError && lastNameError && firstNameError && passwordError && termsAndPolicyError
        }
    }
    //end register region

    //login region
    val loginUIState = mutableStateOf(LoginUIState())
    var onLoginSuccess = mutableStateOf(false)
    var loginValidationPassed = mutableStateOf(false)

    fun onLoginEvent(event: LoginUIEvent) {
        when (event) {
            is LoginUIEvent.EmailChanged -> {
                loginUIState.value = loginUIState.value.copy(
                    email = event.email,
                    emailError = Validator.validateEmail(
                        email = event.email
                    ).status
                )
            }

            is LoginUIEvent.PasswordChanged -> {
                loginUIState.value = loginUIState.value.copy(
                    password = event.password,
                    passwordError = Validator.validatePassword(
                        password = event.password
                    ).status
                )
            }

            is LoginUIEvent.LoginButtonClicked -> {
                login()
            }
        }
        loginValidationStatus()
    }

    private fun loginValidationStatus() {
        loginValidationPassed.value = with(loginUIState.value) {
            emailError && passwordError
        }
    }

    private fun login() {
        val email = loginUIState.value.email
        val password = loginUIState.value.password
        FirebaseAuth
            .getInstance()
            .signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                Log.d(
                    TAG,
                    "inside signInWithEmailAndPassword addOnCompleteListener, is successful: ${it.isSuccessful}"
                )
                onLoginSuccess.value = true
            }
            .addOnFailureListener {
                Log.d(
                    TAG,
                    "inside signInWithEmailAndPassword addOnFailureListener, exception: ${it.message}"
                )
            }
    }

    //end login region

    companion object {
        private val TAG = SharedAuthViewModel::class.java.simpleName
    }
}