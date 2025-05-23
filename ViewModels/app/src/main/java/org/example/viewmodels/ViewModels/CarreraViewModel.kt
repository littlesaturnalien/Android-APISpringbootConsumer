import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CarreraViewModel(private val apiService: CarreraApiService) : ViewModel() {

    private val _carreras = MutableStateFlow<List<Carrera>>(emptyList())
    val carreras: StateFlow<List<Carrera>> = _carreras

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun fetchCarreras() {
        viewModelScope.launch {
            _loading.value = true
            try {
                val response = apiService.getCarreras()
                if (response.isSuccessful) {
                    response.body()?.let { carreraResponse ->
                        _carreras.value = carreraResponse.data
                    } ?: run {
                        _error.value = "Respuesta vacía del servidor"
                    }
                } else {
                    _error.value = "Error en la petición: ${response.code()}"
                }
            } catch (e: Exception) {
                _error.value = "Excepción: ${e.message}"
            } finally {
                _loading.value = false
            }
        }
    }
}
