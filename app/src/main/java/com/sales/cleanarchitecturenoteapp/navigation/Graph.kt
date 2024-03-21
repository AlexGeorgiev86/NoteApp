package com.sales.cleanarchitecturenoteapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.sales.cleanarchitecturenoteapp.feature_auth.presentation.SharedAuthViewModel
import com.sales.cleanarchitecturenoteapp.feature_auth.presentation.login.LoginScreen
import com.sales.cleanarchitecturenoteapp.feature_auth.presentation.register.RegisterScreen
import com.sales.cleanarchitecturenoteapp.feature_auth.presentation.termsandconditions.TermsAndConditionsScreen
import com.sales.cleanarchitecturenoteapp.feature_note.presentation.add_edit_note.AddEditNoteScreen
import com.sales.cleanarchitecturenoteapp.feature_note.presentation.notes.NotesScreen
import com.sales.cleanarchitecturenoteapp.utilities.sharedViewModel

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "auth"
    ) {
        navigation(
            startDestination = Screen.NotesScreen.route,
            route = "notes"
        ) {
            composable(route = Screen.NotesScreen.route) {
                NotesScreen(navController = navController)
            }
            composable(
                route = Screen.AddEditNoteScreen.route +
                        "?noteId={noteId}&noteColor={noteColor}",
                arguments = listOf(
                    navArgument(
                        name = "noteId"
                    ) {
                        type = NavType.IntType
                        defaultValue = -1
                    },
                    navArgument(
                        name = "noteColor"
                    ) {
                        type = NavType.IntType
                        defaultValue = -1
                    },
                )
            ) {
                val color = it.arguments?.getInt("noteColor") ?: -1
                AddEditNoteScreen(
                    navController = navController,
                    noteColor = color
                )
            }
        }
        navigation(
            startDestination = Screen.RegisterScreen.route,
            route = "auth"
        ) {
            composable(route = Screen.LoginScreen.route) {
                val viewModel =
                    it.sharedViewModel<SharedAuthViewModel>(navController = navController)
                LoginScreen(
                    navController = navController,
                    viewModel = viewModel
                ) {
                    navController.navigate("notes") {
                        popUpTo("auth") { inclusive = true }
                    }
                }
            }
            composable(route = Screen.RegisterScreen.route) {
                val viewModel =
                    it.sharedViewModel<SharedAuthViewModel>(navController = navController)
                RegisterScreen(
                    viewModel = viewModel,
                    navController = navController
                ) {

                }
            }
            composable(
                route = "${Screen.TermsAndConditionsScreen.route}/{clickedValue}",
                arguments = listOf(
                    navArgument(
                        name = "clickedValue"
                    ) {
                        type = NavType.StringType
                        defaultValue = ""
                    }
                )
            ) { backStackEntry ->

                TermsAndConditionsScreen(clickedValue = backStackEntry.arguments?.getString("clickedValue"))
            }
        }
    }
}