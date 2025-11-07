package com.example.tugaspraktikum.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.tugaspraktikum.R


@Composable
fun TampilData(navController: NavHostController, viewModel: Any){
    val pesertaList = stringResource(id = R.array.data_peserta)
    val gradient = Brush.verticalGradient(
        colors = listOf(Color(0xFF313647), Color(0xFF1A3D64))
    )

}