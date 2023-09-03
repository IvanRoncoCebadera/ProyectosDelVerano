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

    Testeo().testear()
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
}
