package com.example.api.remote

import com.example.api.models.Carrera
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @GET("carrera/android") // <- Usa el nuevo endpoint
    fun getCarreras(): Call<List<Carrera>>

    @POST("carrera")
    fun agregarCarrera(@Body nuevaCarrera: Carrera): Call<Void>

}