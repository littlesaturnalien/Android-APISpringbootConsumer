package org.example.tuproyecto.services

import org.example.tuproyecto.dataclass.CarreraRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface CarreraApiService {
    @POST("api/carrera")  // Asegúrate que coincida con tu endpoint real
    suspend fun crearCarrera(@Body request: CarreraRequest): Response<Map<String, Any>>
}
// Asegúrate de que el endpoint "/api/carrera" coincida con el que has definido en tu controlador de Spring Boot.
// Este servicio se encargará de hacer la llamada a la API para crear una nueva carrera.
// La respuesta se espera que sea un mapa con claves de tipo String y valores de tipo Any, lo cual es común en respuestas JSON.
// Puedes ajustar el tipo de respuesta según lo que tu API devuelva.

