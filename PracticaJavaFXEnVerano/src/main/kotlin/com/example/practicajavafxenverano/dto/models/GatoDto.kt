package com.example.practicajavafxenverano.dto.models

import java.util.*

data class GatoDto(
    val id: UUID = UUID.randomUUID(),
    val nombre: String,
    val edad: Int,
    val apodo: String
)