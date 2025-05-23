package org.kmryfv.apicarreraconsumidor.services

import org.kmryfv.apicarreraconsumidor.dataclass.CarreraAPIResponse
import org.kmryfv.apicarreraconsumidor.dataclass.CarreraRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface CarreraAPIService {
    @POST("/api/carrera")
    fun crearCarrera(@Body carrera: CarreraRequest): Call<CarreraAPIResponse>

    @GET("/api/carrera")
    suspend fun obtenerCarrera(): CarreraAPIResponse
}