package com.sales.cleanarchitecturenoteapp.navigation

sealed class Screen(val route: String) {
    data object NotesScreen: Screen("notes_screen")
    data object AddEditNoteScreen: Screen("add_edit_note_screen")
    data object LoginScreen: Screen("login_screen")
    data object RegisterScreen: Screen("register_screen")
    data object TermsAndConditionsScreen: Screen("terms_and_conditions_screen")
}