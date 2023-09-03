import factories.ItemsFactory
import factories.PersonajesFactory
import models.Equipo
import models.Item
import models.TipoItem
import models.personajes.Elfo
import models.personajes.Humano
import models.personajes.Personaje
import models.personajes.Trasgo
import models.repository.Cola
import models.repository.Pila
import validator.comprobarVictoria
import validator.validarArgumentosDelPrograma
import java.lang.StringBuilder

fun main(args: Array<String>){

    //Filtramos los argumentos de entrada
    val argumentosDelPrograma = validarArgumentosDelPrograma(args)

    //Aplicamos la desestructuración
    val (size, time) = argumentosDelPrograma

    //Iniciamos la cuadricula, los items y los equipos
    val cuadricula: Array<Array<Item?>> = Array(size){ Array(size){ null } }

    val repositoryItems: Pila = Pila()

    val equipos: Pair<Equipo, Equipo> =
        Pair(
            Equipo(nombre = "Caballeros de Elrond", miembros = Cola()),
            Equipo(nombre = "Amazonas de Isengard", miembros = Cola())
        )

    iniciarPreparativos(cuadricula, repositoryItems, equipos)

    var tiempoSimulacion = 0

    println("Al principio de la simulación, la cuadricula de los items se ve así:")
    mostrarMatriz(cuadricula)

    println()

    println("Y los equipos se ven así:")
    println("Equipo 1:")
    println(equipos.first.nombre+": "+equipos.first.miembros.listaPersonajes.map { it.mostrarEstado() })

    println()

    println("Equipo 2:")
    println(equipos.second.nombre+": "+equipos.second.miembros.listaPersonajes.map { it.mostrarEstado() })

    println()

    println("Ahora comienza la simulación:")

    println()

    println("-----------------------------------------------------------------------------------------------")

    println()

    do{
        if(tiempoSimulacion % 5 == 0 && tiempoSimulacion != 0){
            println("-----------------------------------------------------------------------------------------------")

            println()
            //Cada 5 segundos, rellenamos los huecos vacios de la matricula
            rellenarCasillasVacias(cuadricula, repositoryItems)
            println("-----------------------------------------------------------------------------------------------")

            println()
        }

        println("-----------------------------------------------------------------------------------------------")

        println()
        //Realizamos la acción del equipo 1
        accionEquipo(equipos.first, cuadricula)

        //Realizamos la acción del equipo 2
        accionEquipo(equipos.second, cuadricula)

        println("-----------------------------------------------------------------------------------------------")

        println()

        tiempoSimulacion += aumentarContador()
    }while(
        tiempoSimulacion < time &&
        !comprobarVictoria(equipos)
    )

    println()

    println(tiempoSimulacion)

}

fun accionEquipo(equipo: Equipo, cuadricula: Array<Array<Item?>>) {

    println("Es el turno del equipo: ${equipo.nombre}")

    val personaje = equipo.miembros.getOut()
    equipo.miembros.insert(personaje)

    val coordenadas = conseguirCoordenadas(cuadricula)

    personajeTrataDeCojerItem(personaje, coordenadas, cuadricula)

    println()
}

fun personajeTrataDeCojerItem(personaje: Personaje, coordenadas: Pair<Int, Int>, cuadricula: Array<Array<Item?>>) {

    val item = cuadricula[coordenadas.first][coordenadas.second]!!

    println("El personaje: ${personaje.nombre}, trata de tomar el item: $item")

    when(item.tipoItem){
        TipoItem.Material -> {
            if(personaje is Humano){
                println("Como el item es material y el personaje un humano, lo toma.")
                personaje.listaItems.add(item)
                personaje.escudo += 5
                cuadricula[coordenadas.first][coordenadas.second] = null
            }else{
                println("Como el item es material y el personaje NO es un humano, NO lo toma.")
            }
        }
        TipoItem.Hechizo -> {
            if(personaje is Elfo){
                println("Como el item es un hechizo y el personaje un elfo, lo toma.")
                personaje.listaItems.add(item)
                personaje.inmortalidad += 7
                cuadricula[coordenadas.first][coordenadas.second] = null
            }else{
                println("Como el item es un hechizo y el personaje NO es un elfo, NO lo toma.")
            }
        }
        TipoItem.Pocion -> {
            if(personaje is Trasgo){
                println("Como el item es una poción y el personaje un trasgo, lo toma.")
                personaje.listaItems.add(item)
                personaje.maldad += 2
                cuadricula[coordenadas.first][coordenadas.second] = null
            }else{
                println("Como el item es una poción y el personaje NO es un trasgo, NO lo toma.")
            }
        }
        else -> {
            println("Como el item es comida, cualquiera puede tomarlo, por lo que el personaje lo toma.")
            personaje.listaItems.add(item)
            personaje.vida += item.nivel
            cuadricula[coordenadas.first][coordenadas.second] = null
        }
    }
}

fun conseguirCoordenadas(cuadricula: Array<Array<Item?>>): Pair<Int, Int> {
    lateinit var coordenadas: Pair<Int, Int>

    do {
        coordenadas = Pair(
            (0 until cuadricula.size).random(), (0 until cuadricula.size).random()
        )
    }while (cuadricula[coordenadas.first][coordenadas.second] == null)

    return coordenadas
}

fun rellenarCasillasVacias(cuadricula: Array<Array<Item?>>, repositoryItems: Pila) {

    if(!comprobarCuadriculaTieneHuecos(cuadricula)){
        println("No hay huecos vacios para rellenar en la cuadricula")
    }else{
        println("La matriz que actualmente luce así:")
        mostrarMatriz(cuadricula)

        for (i in 0 until cuadricula.size){
            for (j in 0 until cuadricula.size){
                if(cuadricula[i][j] == null){
                    cuadricula[i][j] = repositoryItems.getOut()
                }
            }
        }

        println()

        println("Ha sido rellenada con items, por lo que ha quedado así:")
        mostrarMatriz(cuadricula)
    }

    println()
}

fun comprobarCuadriculaTieneHuecos(cuadricula: Array<Array<Item?>>): Boolean {
    for (i in 0 until cuadricula.size){
        for (j in 0 until cuadricula.size){
            if(cuadricula[i][j] == null){
                return true
            }
        }
    }
    return false
}

fun aumentarContador(): Int {
    Thread.sleep(1000L)
    return 1
}

fun mostrarMatriz(cuadricula: Array<Array<Item?>>) {
    val mensaje: StringBuilder = StringBuilder()

    for (i in 0 until cuadricula.size){
        for (j in 0 until cuadricula.size){
            val item = cuadricula[i][j]
            if(item == null) mensaje.append("   ") else{
                when(item!!.tipoItem){
                    TipoItem.Comida -> {
                        mensaje.append(" C ")
                    }
                    TipoItem.Hechizo -> {
                        mensaje.append(" H ")
                    }
                    TipoItem.Material -> {
                        mensaje.append(" M ")
                    }
                    else -> {
                        mensaje.append(" P ")
                    }
                }
            }
        }
        println(mensaje.toString())
        mensaje.clear()
    }
}

fun iniciarPreparativos(cuadricula: Array<Array<Item?>>, repositoryItems: Pila, equipos: Pair<Equipo, Equipo>) {
    repeat(200){
        repositoryItems.insert(ItemsFactory.getRandomItem())
    }

    repeat(3){
        equipos.first.miembros.insert(PersonajesFactory.getRandomCaracter())
        equipos.second.miembros.insert(PersonajesFactory.getRandomCaracter())
    }

    inicializarMatriz(cuadricula, repositoryItems)
}

fun inicializarMatriz(cuadricula: Array<Array<Item?>>, repositoryItems: Pila) {
    for (i in 0 until cuadricula.size){
        for (j in 0 until cuadricula.size){
            cuadricula[i][j] = repositoryItems.getOut()
        }
    }
}
