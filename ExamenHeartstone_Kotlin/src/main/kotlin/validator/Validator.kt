package validator

import models.Equipo
import kotlin.system.exitProcess

private val RED = "\u001b[31m"

/**
 * Importante, devuelve primero el tamaño y despues el tiempo
 */
fun validarArgumentosDelPrograma(args: Array<String>): Pair<Int, Int>{
    //Si no hay cuatro parametros, está mal, se sale del programa y se indica al usuario
    if(args.size != 4){
        println(RED+"""Has introducido los argumentos de forma erronea, vuelve a probar con algo como esto, 'java -jar ~\ExamenHeartstone_Kotlin-1.0-SNAPSHOT.jar -size 8 -time 100'""")
        exitProcess(0)
    }

    val size = args[1].toIntOrNull()

    val time = args[3].toIntOrNull()

    if (size != null) {
        if(
            size !in (6..10) ||
            size % 2 != 0
        ){
            println(RED+"El tamaño debe ser 6, 8 o 10.")
            exitProcess(0)
        }
    }else{
        println(RED+"El tamaño debe ser un número.")
        exitProcess(0)
    }

    if (time != null) {
        if(
            time !in (30..100)
        ){
            println(RED+"El tiempo debe estar entre 30 y 100.")
            exitProcess(0)
        }
    }else{
        println(RED+"El tiempo debe ser un número")
        exitProcess(0)
    }

    return Pair(size, time)
}

fun comprobarVictoria(equipos: Pair<Equipo, Equipo>): Boolean {
    val primerEquipo = equipos.first.miembros.listaPersonajes.map { it.listaItems.size }
    val segundoEquipo = equipos.second.miembros.listaPersonajes.map { it.listaItems.size }

    var ganaPrimerEquipo = true
    var ganaSegundoEquipo = true

    for(i in 0..2){
        if(primerEquipo[i] < 5){
            ganaPrimerEquipo = false
        }
        if(segundoEquipo[i] < 5){
            ganaSegundoEquipo = false
        }
        if(!ganaPrimerEquipo && !ganaSegundoEquipo) break
    }

    return ganaPrimerEquipo || ganaSegundoEquipo
}