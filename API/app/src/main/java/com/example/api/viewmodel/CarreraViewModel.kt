package com.example.api

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.*
import com.example.api.models.Carrera
import com.example.api.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CarreraViewModel : ViewModel() {

    private val _carreras = mutableStateOf<List<Carrera>>(emptyList())
    val carreras: State<List<Carrera>> = _carreras

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _errorMessage = mutableStateOf<String?>(null)
    val errorMessage: State<String?> = _errorMessage

    init {
        cargarCarreras()
    }

    fun cargarCarreras() {
        _isLoading.value = true
        _errorMessage.value = null

        RetrofitClient.instance.getCarreras().enqueue(object : Callback<List<Carrera>> {
            override fun onResponse(call: Call<List<Carrera>>, response: Response<List<Carrera>>) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _carreras.value = response.body() ?: emptyList()
                } else {
                    _errorMessage.value = "Error: ${response.code()}"
                }
            }

            override fun onFailure(call: Call<List<Carrera>>, t: Throwable) {
                _isLoading.value = false
                _errorMessage.value = "Fallo de red: ${t.message}"
            }
        })
    }

    // 👇 Agrega esta función justo aquí
    fun agregarCarrera(carrera: Carrera) {
        _isLoading.value = true
        _errorMessage.value = null

        RetrofitClient.instance.agregarCarrera(carrera).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    cargarCarreras()
                } else {
                    _errorMessage.value = "Error al agregar: ${response.code()}"
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                _isLoading.value = false
                _errorMessage.value = "Error: ${t.message}"
            }
        })
    }
}

