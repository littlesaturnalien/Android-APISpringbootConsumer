package com.example.api.models

data class Carrera(
    val id: Long,
    val nombre: String,
    val descripcion: String // <-- si tu entidad en el backend tiene este campo
)