package models.personajes

import models.Item
import models.interfaces.Arquero
import models.interfaces.Defensor
import java.time.LocalDateTime
import java.util.*

class Trasgo(
    id: UUID,
    fechaCreacion: LocalDateTime,
    nombre: String,
    vida: Int,
    nivel: Int,
    listaItems: MutableList<Item>,
    var maldad: Int
): Personaje(id, fechaCreacion, nombre, vida, nivel, listaItems), Arquero, Defensor {
    override fun mostrarEstado(): String{
        return "Trasgo(id=$id, fechaCreacion=$fechaCreacion, nombre='$nombre', vida=$vida, nivel=$nivel, maldad=$maldad y listaItems=${listaItems.sortedBy { it.fechaCreacion }})"
    }
}