package models

import models.repository.Cola

data class Equipo(
    val nombre: String,
    val miembros: Cola
)