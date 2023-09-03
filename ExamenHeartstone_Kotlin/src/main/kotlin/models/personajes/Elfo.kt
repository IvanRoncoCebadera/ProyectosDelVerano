package models.personajes

import models.interfaces.Arquero
import models.Item
import java.time.LocalDateTime
import java.util.*

class Elfo(
    id: UUID,
    fechaCreacion: LocalDateTime,
    nombre: String,
    vida: Int,
    nivel: Int,
    listaItems: MutableList<Item>,
    var inmortalidad: Int
): Personaje(id, fechaCreacion, nombre, vida, nivel, listaItems), Arquero {
    override fun mostrarEstado(): String{
        return "Elfo(id=$id, fechaCreacion=$fechaCreacion, nombre='$nombre', vida=$vida, nivel=$nivel, inmortalidad=$inmortalidad y listaItems=${listaItems.sortedBy { it.fechaCreacion }})"
    }
}