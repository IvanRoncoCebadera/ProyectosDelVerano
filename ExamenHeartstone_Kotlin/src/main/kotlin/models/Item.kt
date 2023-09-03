package models

import java.time.LocalDateTime

data class Item(
    val id: Long,
    val fechaCreacion: LocalDateTime,
    val nivel: Int,
    val tipoItem: TipoItem
){
    override fun toString(): String {
        return "Item(id=$id, fechaCreacion=$fechaCreacion, nivel=$nivel, tipoItem=$tipoItem)"
    }
}

enum class TipoItem {
    Comida, Material, Hechizo, Pocion
}
