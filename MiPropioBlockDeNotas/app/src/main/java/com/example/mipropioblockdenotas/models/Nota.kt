package com.example.mipropioblockdenotas.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Nota(
    val id: Long = giveNextId(), //Será un id autonumérico que se le dará a la nota dependiendo de cual haya sido el último id
    val titulo: String = "", //Va a ser único por lo que no puede estar vacio ni repetido (No importa si cambia alguna mayuscula, no se puede repetir)
    var isChecked: Boolean = false
) : Parcelable {
    companion object{
        var contador = 0L
        fun giveNextId(): Long{
            return contador++
        }
    }
}