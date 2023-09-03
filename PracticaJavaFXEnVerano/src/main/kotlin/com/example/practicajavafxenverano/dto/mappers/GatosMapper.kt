package com.example.practicajavafxenverano.dto.mappers

import com.example.practicajavafxenverano.dto.models.GatoDto
import com.example.practicajavafxenverano.dto.models.ListaGatosDto
import com.example.practicajavafxenverano.models.Gato

fun Gato.toDto(): GatoDto{
    return GatoDto(
        id = this.id,
        nombre = this.nombre,
        edad = this.edad,
        apodo = this.apodo
    )
}

fun GatoDto.toGato(): Gato{
    return Gato(
        id = this.id,
        nombre = this.nombre,
        edad = this.edad,
        apodo = this.apodo
    )
}

fun List<Gato>.toDto(): ListaGatosDto{
    return ListaGatosDto(
        this.map { it.toDto() }
    )
}

fun ListaGatosDto.toGatos(): List<Gato>{
    return this.gatos.map{it.toGato()}
}