package com.example.ucp2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanForm(
    onSubmitButtonClick: (MutableList<String>) -> Unit,
    onCancelButtonClick: () -> Unit
) {
    var namaTxt by rememberSaveable {
        mutableStateOf("")
    }

    var nimTxt by rememberSaveable {
        mutableStateOf("")
    }

    var konsenTxt by rememberSaveable {
        mutableStateOf("")
    }

    var judulTxt by rememberSaveable {
        mutableStateOf("")
    }

    var listDataTxt: MutableList<String> = mutableListOf(namaTxt, nimTxt, konsenTxt, judulTxt)

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Text(
            text = "Formulir Pengujian Skripsi",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        OutlinedTextField(value = namaTxt, onValueChange = {
            namaTxt = it
        }, label = {
            Text(text = "Nama Mahasiswa")
        })
        OutlinedTextField(value = nimTxt, onValueChange = {
            nimTxt = it
        }, label = {
            Text(text = "Nim")
        })
        OutlinedTextField(value = konsenTxt, onValueChange = {
            konsenTxt = it
        }, label = {
            Text(text = "Konsentrasi")
        })
        OutlinedTextField(value = judulTxt, onValueChange = {
            judulTxt = it
        }, label = {
            Text(text = "JudulSkripsi")
        })

        Spacer(modifier = Modifier.padding(16.dp))

        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.padding_medium))
            .weight(1f, false),
            horizontalArrangement =
            Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
            verticalAlignment = Alignment.Bottom){
            OutlinedButton(modifier = Modifier.weight(1f), onClick =
            onCancelButtonClick) {
                Text(stringResource(R.string.buttonback))
            }
            Button(modifier = Modifier.weight(1f), onClick = { onSubmitButtonClick(listDataTxt) }) {
                Text(text = stringResource(id = R.string.buttonsubmit))
            }
        }
    }
}