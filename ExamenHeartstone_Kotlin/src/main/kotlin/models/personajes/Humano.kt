package models.personajes

import models.Item
import models.interfaces.Defensor
import java.time.LocalDateTime
import java.util.*

class Humano(
    id: UUID,
    fechaCreacion: LocalDateTime,
    nombre: String,
    vida: Int,
    nivel: Int,
    listaItems: MutableList<Item>,
    var escudo: Int,
    val tieneCaballo: Boolean
): Personaje(id, fechaCreacion, nombre, vida, nivel, listaItems), Defensor {

    companion object{
        val constanteEscudo = 100
    }

    override fun mostrarEstado(): String{
        return "Humano(id=$id, fechaCreacion=$fechaCreacion, nombre='$nombre', vida=$vida, nivel=$nivel, escudo=$escudo, ${if(tieneCaballo) "tiene caballo" else "no tiene caballo"} y listaItems=${listaItems.sortedBy { it.fechaCreacion }})"
    }
}