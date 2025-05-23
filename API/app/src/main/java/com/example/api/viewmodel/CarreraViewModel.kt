package com.example.api

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.*
import com.example.api.models.Carrera
import com.example.api.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CarreraViewModel : ViewModel() {

    var carreras by mutableStateOf<List<Carrera>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    init {
        cargarCarreras()
    }

    fun cargarCarreras() {
        isLoading = true
        errorMessage = null

        RetrofitClient.instance.getCarreras().enqueue(object : Callback<List<Carrera>> {
            override fun onResponse(
                call: Call<List<Carrera>>,
                response: Response<List<Carrera>>
            ) {
                isLoading = false
                if (response.isSuccessful) {
                    carreras = response.body() ?: emptyList()
                } else {
                    errorMessage = "Error en respuesta: ${response.code()}"
                }
            }

            override fun onFailure(call: Call<List<Carrera>>, t: Throwable) {
                isLoading = false
                errorMessage = "Error de conexión: ${t.message}"
            }
        })
    }
}
