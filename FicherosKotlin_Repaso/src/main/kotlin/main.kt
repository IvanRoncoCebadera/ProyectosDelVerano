import models.Persona
import module.myModule
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import storage.PersonajeStorageCss
import storage.PersonasStorageJSON
import storage.PersonasStorageXML

fun main(args: Array<String>){
    startKoin {
        modules(myModule)
    }

    println(Testeo().comprobarFuncionesLambda(1, "1", {n: Int, t: String -> n.toString() == t} )) //Al ser una función por parametro (funcion Lambda) y esta ser el último parametro pedido, se puede escribir la funcion fuera de los parentesis
    println(Testeo().comprobarFuncionesLambda(1, "1") { n: Int, t: String -> n.toString() == t })

    println("--------------------------------------------------------------------------------------------")

    Testeo().testear()

    println("--------------------------------------------------------------------------------------------")

    repeat(5){
        Testeo().testear()
    }

    println("--------------------------------------------------------------------------------------------")

    Testeo().miPropioRepeat(5){
        Testeo().testear()
    }

    println("--------------------------------------------------------------------------------------------")

    val lista = mutableListOf<Int>(1, 2, 3, 4 ,5)

    Testeo().miPropioRepeat(7){
        println(lista.removeFirstOrNull()?: "Te pasates con el índice: $it, crack!!" )
    }

}

class Testeo(): KoinComponent{
    fun testear(){

        val personas = listOf<Persona>(
            Persona("53907934M", "Iván", "Ronco Cebadera", 19),
            Persona("79703123F", "Nefertary", "La Gatita", 5)
        )

        println("La versión en CSS:")
        val css: PersonajeStorageCss by inject()

        css.exportToFile(personas)

        for (persona in css.importFile()) {
            println(persona)
        }

        println()
        println("La versión en JSON:")

        val json: PersonasStorageJSON by inject()

        json.exportToFile(personas)

        for (persona in json.importFile()) {
            println(persona)
        }

        println()
        println("La versión en XML:")

        val xml: PersonasStorageXML by inject()

        xml.exportToFile(personas)

        for (persona in xml.importFile()) {
            println(persona)
        }
    }

    fun comprobarFuncionesLambda(valorNumerico: Int, valorTextual: String, funcion: (Int, String) -> Boolean): Boolean{
        return funcion(valorNumerico, valorTextual)
    }

    fun miPropioRepeat(times: Int, accion: (Int) -> Unit){
        for(i in 1 .. times){
            accion(i)
        }
    }
}
