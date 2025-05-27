package com.example.api

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.api.screen.ListaCarreraScreen
import com.example.api.screen.AgregarCarreraScreen
import com.example.api.ui.theme.APITheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            APITheme {
                val viewModel = viewModel<CarreraViewModel>()
                var pantallaActual by remember { mutableStateOf("lista") }

                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text("Carreras") },
                            actions = {
                                TextButton(onClick = {
                                    pantallaActual = if (pantallaActual == "lista") "agregar" else "lista"
                                }) {
                                    Text(
                                        if (pantallaActual == "lista") "Agregar" else "Volver",
                                        color = MaterialTheme.colorScheme.onPrimary
                                    )
                                }
                            }
                        )
                    }
                ) { padding ->
                    Surface(modifier = Modifier.padding(padding)) {
                        if (pantallaActual == "lista") {
                            ListaCarreraScreen(viewModel)
                        } else {
                            AgregarCarreraScreen(viewModel)
                        }
                    }
                }
            }
        }
    }
}
