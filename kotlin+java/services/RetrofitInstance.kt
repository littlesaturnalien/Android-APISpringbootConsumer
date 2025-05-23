package org.example.tuproyecto.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: CarreraApiService by lazy {
        Retrofit.Builder()
            .baseUrl("http://IP_LOCAL:PUERTO/")  // Ej: http://192.168.0.10:8080/
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CarreraApiService::class.java)
    }
}
