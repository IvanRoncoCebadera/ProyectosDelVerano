package com.example.practicajavafxenverano.models

import java.util.*

data class Gato(
    val id: UUID = UUID.randomUUID(),
    val nombre: String,
    val edad: Int,
    val apodo: String
)