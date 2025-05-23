package com.example.api.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.api.CarreraViewModel
import com.example.api.models.Carrera
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ListaCarrerasScreen(viewModel: CarreraViewModel = viewModel()) {
    val carreras = viewModel.carreras
    val isLoading = viewModel.isLoading
    val error = viewModel.errorMessage

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Text("Carreras Disponibles", style = MaterialTheme.typography.headlineSmall)

        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.padding(16.dp))
        } else if (error != null) {
            Text("Error: $error", color = MaterialTheme.colorScheme.error)
        } else {
            LazyColumn {
                items(carreras) { carrera ->
                    CarreraCard(carrera)
                }
            }
        }
    }
}

@Composable
fun CarreraCard(carrera: Carrera) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("ID: ${carrera.id}")
            Text("Nombre: ${carrera.nombre}")
            Text("Descripción: ${carrera.descripcion}")
        }
    }
}
