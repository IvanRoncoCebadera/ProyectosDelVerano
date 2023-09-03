package storage

import config.ConfigApp
import models.Persona
import java.io.File
import java.lang.Exception
import java.nio.file.Files
import java.nio.file.Path

class PersonajeStorageCss(
    private val config: ConfigApp
) : StorageServiceI<List<Persona>>{

    private val file = File(config.appData + File.separator + "PersonasCSS")

    override fun exportToFile(entity: List<Persona>) {
        val carpetaPath = Path.of(config.appData)
        if(Files.notExists(carpetaPath)){
            Files.createDirectories(carpetaPath)
        }
        try {
            file.writeText("dni;nombre;apellidos;edad\n")
            for (persona in entity) {
                file.appendText("${persona.dni};${persona.nombre};${persona.apellidos};${persona.edad}\n")
            }
        }catch (e: Exception){
            println(e.message)
        }
    }

    override fun importFile(): List<Persona> {
        if(Files.notExists(file.toPath())){
            return emptyList()
        }
        return file.readLines().drop(1)
            .map { it.split(";").map { eso -> eso.trim() } }
            .map {
                Persona(
                    dni = it[0],
                    nombre = it[1],
                    apellidos = it[2],
                    edad = it[3].toInt()
                )
            }
    }
}