import retrofit2.Response
import retrofit2.http.*

interface CarreraApiService {

    @GET("/api/carrera")
    suspend fun getCarreras(): Response<CarreraResponse>

    @GET("/api/carrera/{id}")
    suspend fun getCarrera(@Path("id") id: Long): Response<CarreraResponse>

    @POST("/api/carrera")
    suspend fun createCarrera(@Body carrera: Carrera): Response<CarreraResponse>

    @PUT("/api/carrera/{id}")
    suspend fun updateCarrera(@Path("id") id: Long, @Body carrera: Carrera): Response<CarreraResponse>

    @DELETE("/api/carrera/{id}")
    suspend fun deleteCarrera(@Path("id") id: Long): Response<CarreraResponse>
}
