package com.example.p5

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    var nama by rememberSaveable { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var alamat by rememberSaveable { mutableStateOf("") }
    var noHP by remember { mutableStateOf("") }
    var selectedGender by remember { mutableStateOf("") }

    val jenisKelamin = listOf("Laki-Laki", "Perempuan")

    var namaUser by rememberSaveable { mutableStateOf("") }
    var emailUser by remember { mutableStateOf("") }
    var alamatUser by rememberSaveable { mutableStateOf("") }
    var noHPUser by remember { mutableStateOf("") }
    var selectedGenderUser by remember { mutableStateOf("") }

    Column (
        Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(text = "Data Diri")

        OutlinedTextField(

            value = nama,
            onValueChange = {nama = it},
            placeholder = { Text("Masukkan Nama Anda")},
            label = {Text("Nama" )},
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)


        )

        Row {
            jenisKelamin.forEach{item ->
                Row (verticalAlignment = Alignment.CenterVertically){
                    RadioButton(
                        selected = selectedGender == item,
                        onClick = {
                            selectedGender = item
                        })
                    Text(item)
                }

            }

        }

        OutlinedTextField(

            value = email,
            onValueChange = {email = it},
            placeholder = { Text("Masukkan Email Anda")},
            label = {Text("Email" )},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)


        )

        OutlinedTextField(

            value = alamat,
            onValueChange = {alamat = it},
            placeholder = { Text("Masukkan Alamat Anda")},
            label = {Text("Alamat" )},
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)


        )

        OutlinedTextField(

            value = noHP,
            onValueChange = {noHP = it},
            placeholder = { Text("Masukkan NoHP Anda")},
            label = {Text("No HP" )},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)


        )

        Button(onClick = {
            namaUser = nama
            selectedGenderUser = selectedGender
            emailUser = email
            alamatUser = alamat
            noHPUser = noHP
        },

            ) {
            Text("Simpan Data")
        }

        Card(modifier = Modifier.size(height = 200.dp, width = 350.dp)) {
            Column {
                CardSection(judulParam = "Nama", isiParam = namaUser)
                CardSection(judulParam = "Jenis Kelamin", isiParam = selectedGenderUser)
                CardSection(judulParam = "Email", isiParam = emailUser)
                CardSection(judulParam = "Alamat", isiParam = alamatUser)
                CardSection(judulParam = "No HP", isiParam = noHPUser)
            }

        }

    }


}


@Composable
fun CardSection(
    judulParam: String,
    isiParam: String

){
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.padding(5.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround

        ) {
            Text(
                text = judulParam,
                modifier = Modifier.weight(0.8f)
            )
            Text(
                text = " : ",
                modifier = Modifier.weight(0.2f)
            )
            Text(
                text = "$isiParam",
                modifier = Modifier.weight(2f)
            )
        }
    }

}