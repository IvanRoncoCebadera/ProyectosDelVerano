package models.repository

import models.personajes.Personaje

data class Cola(
    val listaPersonajes: MutableList<Personaje> = mutableListOf()
){
    fun insert(personaje: Personaje){
        if(listaPersonajes.size < 3){
            listaPersonajes.add(personaje)
        }
    }

    fun getOut(): Personaje {
        return listaPersonajes.removeFirstOrNull() ?: throw Exception("No quedan más personajes.")
    }
}