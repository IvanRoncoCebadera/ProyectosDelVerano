package mapper

import dto.Personas
import models.Persona

fun List<Persona>.toPersonas(): Personas{
    return Personas(
        this
    )
}

fun Personas.toListaPersonas(): List<Persona>{
    return this.personas
}