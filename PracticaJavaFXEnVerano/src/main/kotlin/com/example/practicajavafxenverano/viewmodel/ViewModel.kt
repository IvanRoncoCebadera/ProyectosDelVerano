package com.example.practicajavafxenverano.viewmodel

import com.example.practicajavafxenverano.models.Gato
import com.example.practicajavafxenverano.repository.GatosRepositoryImpl
import com.example.practicajavafxenverano.services.storage.GatosStorageServiceJsonImpl
import com.github.michaelbull.result.onSuccess
import javafx.beans.property.SimpleObjectProperty

class ViewModel(
    val repository: GatosRepositoryImpl,
    val storage: GatosStorageServiceJsonImpl
) {
    fun hacerPruebaDeLosFicheros() {
        val gatos = listOf<Gato>(
            Gato(nombre = "nefer", edad = 4, apodo = "Gorda"),
            Gato(nombre = "Max", edad = 1, apodo = "Guapo")
        )

        storage.exportData(repository.getAll())

        storage.importData().onSuccess { println(it.joinToString(separator = "|")) }

        gatos.forEach { repository.save(it) }

        state.value = state.value.copy(
            gatos = repository.getAll()
        )
    }

    fun onSelectedUpdateGatoReference(gato: Gato) {
        state.value = state.value.copy(
            gatoReference = gato
        )
    }

    fun filtrarTabla(nombre: String): List<Gato> {
        return state.value.gatos
            .filter { it.nombre.lowercase().contains(nombre.lowercase()) }
    }

    val state: SimpleObjectProperty<SharedState> = SimpleObjectProperty(SharedState())

    init {
        state.value = state.value.copy(
            gatos = repository.getAll()
        )
    }
}

data class SharedState(
    val gatos: List<Gato> = emptyList(),
    val gatoReference: Gato? = null
)