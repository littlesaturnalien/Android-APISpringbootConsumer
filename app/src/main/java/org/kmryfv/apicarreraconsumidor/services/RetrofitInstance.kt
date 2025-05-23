package org.kmryfv.apicarreraconsumidor.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: CarreraAPIService by lazy {
        Retrofit.Builder()
            .baseUrl("https://localhost:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CarreraAPIService::class.java)
    }
}