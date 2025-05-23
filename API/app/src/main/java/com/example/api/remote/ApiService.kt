package com.example.api.remote

import com.example.api.models.Carrera
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("carrera/android") // <- Usa el nuevo endpoint
    fun getCarreras(): Call<List<Carrera>>
}