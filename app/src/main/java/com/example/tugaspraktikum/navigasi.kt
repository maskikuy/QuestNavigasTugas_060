package com.example.tugaspraktikum

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tugaspraktikum.view.Formulir
import com.example.tugaspraktikum.view.TampilData
import com.example.tugaspraktikum.view.WelcomeScreen



data class DataPeserta(
    val nama: String,
    val jenisKelamin: String,
    val status: String,
    val alamat: String
)

enum class navigasi {
    WelcomeScreen,
    Formulir,
    TampilData
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController()
) {
    // 2. Buat "database" sementara di sini.
    // Ini akan menyimpan daftar peserta Anda.
    val pesertaList = remember { mutableStateListOf<DataPeserta>() }

    NavHost(
        navController = navController,
        startDestination = navigasi.WelcomeScreen.name
    ) {
        composable(route = navigasi.WelcomeScreen.name) {
            WelcomeScreen(navController = navController)
        }
        composable(route = navigasi.Formulir.name) {
            Formulir(
                navController = navController,
                onTambahData = { nama, jk, status, alamat ->
                    pesertaList.add(DataPeserta(nama, jk, status, alamat))
                }
            )
        }
        composable(route = navigasi.TampilData.name) {
            TampilData(
                navController = navController,
                pesertaList = pesertaList // Oper list-nya
            )
        }
    }
}