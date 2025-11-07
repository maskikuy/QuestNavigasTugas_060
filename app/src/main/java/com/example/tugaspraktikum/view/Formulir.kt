package com.example.tugaspraktikum.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.tugaspraktikum.navigasi

@Composable
fun Formulir(
    navController: NavHostController,
    onTambahData: (nama: String, jk: String, status: String, alamat: String) -> Unit
) {
    var nama by remember { mutableStateOf("") }
    var jenisKelamin by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }

    val genderOptions = listOf("Laki-laki", "Perempuan")
    val statusOptions = listOf("Janda", "Lajang", "Duda")
    val LightPurple = Color(0xFFF3E5F5)

    val DarkPurple = Color(0xFF673AB7)
    val AccentPurple = Color(0xFFB39DDB)

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(LightPurple) // <-- Latar belakang baru
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text(
                text = "List Daftar Peserta",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(DarkPurple) // <-- Header ungu cerah
                    .padding(vertical = 16.dp),
                textAlign = TextAlign.Center
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // NAMA LENGKAP
                Text(
                    text = "NAMA LENGKAP",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = DarkPurple, // <-- Label ungu cerah
                    modifier = Modifier.align(Alignment.Start)
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = nama,
                    onValueChange = { nama = it },
                    label = { Text("Nama Lengkap") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedTextColor = DarkPurple,
                        unfocusedTextColor = DarkPurple,
                        focusedBorderColor = DarkPurple,
                        unfocusedBorderColor = AccentPurple,
                        cursorColor = DarkPurple,
                        focusedLabelColor = DarkPurple,
                        unfocusedLabelColor = AccentPurple,
                        errorBorderColor = Color(0xFFD32F2F),
                        errorLabelColor = Color(0xFFD32F2F)
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "JENIS KELAMIN",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = DarkPurple,
                    modifier = Modifier.align(Alignment.Start)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(modifier = Modifier.fillMaxWidth()) {
                    genderOptions.forEach { item ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .selectable(
                                    selected = jenisKelamin == item,
                                    onClick = { jenisKelamin = item }
                                )
                                .weight(1f)
                        ) {
                            RadioButton(
                                selected = jenisKelamin == item,
                                onClick = { jenisKelamin = item },
                                colors = RadioButtonDefaults.colors(
                                    selectedColor = DarkPurple, // <-- Radio terpilih ungu cerah
                                    unselectedColor = AccentPurple
                                )
                            )
                            Text(text = item, color = DarkPurple)
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "STATUS PERKAWINAN",
                    // ... (styling sama seperti "JENIS KELAMIN")
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = DarkPurple,
                    modifier = Modifier.align(Alignment.Start)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(modifier = Modifier.fillMaxWidth()) {
                    statusOptions.forEach { item ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .selectable(
                                    selected = status == item,
                                    onClick = { status = item }
                                )
                                .weight(1f)
                        ) {
                            RadioButton(
                                selected = status == item,
                                onClick = { status = item },
                                colors = RadioButtonDefaults.colors(
                                    selectedColor = DarkPurple,
                                    unselectedColor = AccentPurple
                                )
                            )
                            Text(text = item, color = DarkPurple)
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))

                // ALAMAT
                Text(
                    text = "ALAMAT",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = DarkPurple,
                    modifier = Modifier.align(Alignment.Start)
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = alamat,
                    onValueChange = { alamat = it },
                    label = { Text("Alamat") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedTextColor = DarkPurple,
                        unfocusedTextColor = DarkPurple,
                        focusedBorderColor = DarkPurple,
                        unfocusedBorderColor = AccentPurple,
                        cursorColor = DarkPurple,
                        focusedLabelColor = DarkPurple,
                        unfocusedLabelColor = AccentPurple,
                        errorBorderColor = Color(0xFFD32F2F),
                        errorLabelColor = Color(0xFFD32F2F)
                    )
                )
                Spacer(modifier = Modifier.height(24.dp))

                // Tombol Submit
                Button(
                    onClick = {
                        onTambahData(nama, jenisKelamin, status, alamat)
                        navController.navigate(navigasi.TampilData.name)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = DarkPurple) // <-- Tombol ungu cerah
                ) {
                    Text("Next", fontSize = 18.sp, color = Color.White)
                }

                Spacer(modifier = Modifier.height(12.dp))
                Button(
                    onClick = { navController.navigate(navigasi.Formulir.name) },
                    colors = ButtonDefaults.buttonColors(containerColor = AccentPurple), // <-- Tombol aksen
                    modifier = Modifier.fillMaxWidth().height(50.dp),
                    shape = RoundedCornerShape(10.dp),
                ) {
                    Text("Formulir Pendaftaran", color = Color.White)
                }
            }
        }
    }
}