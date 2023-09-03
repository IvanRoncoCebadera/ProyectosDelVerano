package models.personajes

import models.Item
import java.time.LocalDateTime
import java.util.*

open class Personaje(
    val id: UUID,
    val fechaCreacion: LocalDateTime,
    val nombre: String,
    var vida: Int,
    val nivel: Int,
    val listaItems: MutableList<Item>
){
    open fun mostrarEstado(): String {
        return "Personaje(id=$id, fechaCreacion=$fechaCreacion, nombre='$nombre', vida=$vida, nivel=$nivel y listaItems=${listaItems.sortedBy { it.fechaCreacion }})"
    }
}