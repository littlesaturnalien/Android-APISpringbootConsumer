package org.example.tuproyecto.services

import org.example.tuproyecto.dataclass.CarreraRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface CarreraApiService {
    @POST("carrera")  // Cambia si tu endpoint es diferente
    suspend fun crearCarrera(@Body request: CarreraRequest): Response<Map<String, Any>>
}
