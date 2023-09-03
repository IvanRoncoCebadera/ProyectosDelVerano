package models.repository

import models.Item

data class Pila(
    val listaItems: MutableList<Item> = mutableListOf()
){
    fun insert(item: Item){
        if(listaItems.size < 200){
            listaItems.add(item)
        }
    }

    fun getOut(): Item{
        return listaItems.removeLastOrNull() ?: throw Exception("No quedan más items.")
    }
}