package factories

import models.Item
import models.personajes.Elfo
import models.personajes.Humano
import models.personajes.Personaje
import models.personajes.Trasgo
import java.time.LocalDateTime
import java.util.UUID

object PersonajesFactory {

    fun getRandomCaracter(): Personaje {
        val rng = (1..99).random()
        return when(rng){
            in 1..33 -> {
                val nombres = arrayOf("Abrahamm Alcolädor", "Robertöl Pavonnerl", "Bëatrisz Sénchezrl")
                Elfo(
                    id = UUID.randomUUID(),
                    fechaCreacion = LocalDateTime.now(),
                    nombre = nombres.random(),
                    vida = 50,
                    nivel = 1,
                    listaItems = mutableListOf<Item>(),
                    inmortalidad = 10
                )
            }
            in 34..66 -> {
                val nombres = arrayOf("Jessussr Benaventntad", "Albortonnf Ruizrd")
                Trasgo(
                    id = UUID.randomUUID(),
                    fechaCreacion = LocalDateTime.now(),
                    nombre = nombres.random(),
                    vida = 40,
                    nivel = 1,
                    listaItems = mutableListOf<Item>(),
                    maldad = 15
                )
            }
            else -> {
                val nombres = arrayOf("Gemarr de Jowicorre", "Kevyn Valdeswyn", "Victoref Fernandezred")
                Humano(
                    id = UUID.randomUUID(),
                    fechaCreacion = LocalDateTime.now(),
                    nombre = nombres.random(),
                    vida = 60,
                    nivel = 1,
                    listaItems = mutableListOf<Item>(),
                    escudo = (1..Humano.constanteEscudo).random(),
                    tieneCaballo = (1..2).random() == 1
                )
            }
        }
    }

}