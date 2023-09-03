package com.example.retosemanal29_kotlin_javafx.viewModel

import com.example.retosemanal29_kotlin_javafx.validator.isPrime
import com.example.retosemanal29_kotlin_javafx.validator.validateNumbers
import javafx.beans.property.SimpleObjectProperty

class ViewModel {

    val sharedState: SimpleObjectProperty<SharedState> = SimpleObjectProperty(SharedState())

    fun botonAscendenteSelected(numbers: String): String {
        sharedState.value = sharedState.value.copy(
            botonSelected = true
        )
        return writeTheResultArray(numbers)
    }

    fun botonDescendenteSelected(numbers: String): String {
        sharedState.value = sharedState.value.copy(
            botonSelected = false
        )
        return writeTheResultArray(numbers)
    }

    private fun writeTheResultArray(numbers: String): String {
        val array = numbers.split(",").map { it.trim() }
        return if(array.validateNumbers()){
            val arrayNumbers = array.map { it.toInt() }
            if (sharedState.value.botonSelected){
                arrayNumbers.sorted().joinToString(separator = " , ")
            }else{
                arrayNumbers.sortedDescending().joinToString(separator = " , ")
            }
        }else{
            "No has introducido números,\nhas introducido solo un número o\nlos has introducido de forma invalida\n(coloquelos separdos por comas)."
        }
    }

    fun botonCalcularNumerosPerdidosSelected(numbers: String): String {
        val array = numbers.split(",").map { it.trim() }
        return if(array.validateNumbers()){
            val arrayNumbers = array.map { it.toInt() }.sorted()
            val arrayLostsNumbers = mutableListOf<Int>()

            for (i in arrayNumbers.first()+1 until arrayNumbers.last()){
                if (i !in arrayNumbers) arrayLostsNumbers.add(i)
            }

            return arrayLostsNumbers.joinToString(" , ")
        }else{
            "No has introducido números,\nhas introducido solo un número o\nlos has introducido de forma invalida\n(coloquelos separdos por comas)."
        }
    }

    fun botonSacarNumerosPrimosSelected(numbers: String): String {
        val array = numbers.split(",").map { it.trim() }
        return if(array.validateNumbers()){
            val arrayNumbers = array.map { it.toInt() }.sorted()
            val arrayPrimeNumbers = mutableListOf<Int>()

            arrayNumbers.forEach {
                if(it.isPrime()){
                    arrayPrimeNumbers.add(it)
                }
            }

            return arrayPrimeNumbers.joinToString(" , ")
        }else{
            "No has introducido números,\nhas introducido solo un número o\nlos has introducido de forma invalida\n(coloquelos separdos por comas)."
        }
    }
}

data class SharedState(
    val numbers: String = "",
    val result: String = "",
    val botonSelected: Boolean = true
)