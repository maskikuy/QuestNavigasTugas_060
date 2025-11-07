package com.example.tugaspraktikum

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tugaspraktikum.view.Formulir

enum class navigasi {
    WelcomeScreen,
    Formulir,
    TampilData
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController()
){
    NavHost(
        navController = navController,
        startDestination = navigasi.WelcomeScreen.name
    ) {
        composable(route = navigasi.WelcomeScreen.name) {
            WelcomeScreen(navController = navController)
        }
        composable(route = navigasi.Formulir.name) {
            Formulir(navController = navController, viewModel = viewModel())
        }
        composable(route = navigasi.TampilData.name) {
            navigasi.TampilData(navController = navController, viewModel = viewModel())
        }
    }
}