package com.example.ucp2

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Ucp2AppBar(
    bisaNavigasiBack: Boolean,
    navigasiUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text (stringResource (id = R.string.app_name)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors (
            containerColor =
            MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (bisaNavigasiBack) {
                IconButton(onClick = navigasiUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription =
                        stringResource(R.string.buttonback)
                    )
                }
            }
        }
    )
}

@Composable
fun Ucp2App(
    viewModel: FormViewModel = viewModel(),
    navController: NavController = rememberNavController()
){
    Scaffold(
        topBar = {
            Ucp2AppBar(
                bisaNavigasiBack = false,
                navigasiUp = { /* TODO: implement back navigation */
                }
            )
        }
    ){ innerPadding ->
        val uiState by viewModel.stateUI.collectAsState()
        NavHost(
            navController = navController as NavHostController,
            startDestination = HalamanHome.name,
            modifier = Modifier.padding(innerPadding)
        )
        {
            composable(route = HalamanSatu.Home.name) {
                HalamanHome(
                    onNextButtonClicked = { navController.navigate(PengelolaHalaman.Formulir.name) })
            }
            composable(route = PengelolaHalaman.Formulir.name) {
                HalamanForm(
                    onSubmitButtonClick = {
                        viewModel.setContact(it)
                        navController.navigate(PengelolaHalaman.Rasa.name)
                    },
                )
            }



private fun cancelOrderAndNavigateToHome (
    viewModel: FormViewModel,
    navController: NavController
){
    navController.popBackStack (PengelolaHalaman.Home.name, inclusive = false)
}

private fun cancelOrderAndNavigateToForm(
    viewModel: FormViewModel,
    navController: NavHostController
) {
    navController.popBackStack(PengelolaHalaman.Formulir.name, inclusive = false)
}
private fun cancelOrderAndNavigateToRasa (
    navController: NavController
) {
    navController.popBackStack(PengelolaHalaman.Rasa.name, inclusive = false)
}