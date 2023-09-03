package com.example.retosemanal29_kotlin_javafx.validator

import java.util.ListResourceBundle

/**
 * @return true si es valido, false si no lo es
 */
fun List<String>.validateNumbers(): Boolean {
    if (this.isEmpty() || this.size == 1) return false

    val regexNumber = Regex("[0-9][0-9]*")

    this.forEach {
        if (!it.matches(regexNumber)) {
            return false
        }
    }

    return true
}

fun Int.isPrime(): Boolean{
    if(this == 0 || this == 1) return true

    if (this == 2) return false

    var result = true

    for (i in 2..this-1){
        if(this % i == 0) {
            result = false
            break
        }
    }

    return result
}