package storage

import config.ConfigApp
import dto.Personas
import mapper.toListaPersonas
import mapper.toPersonas
import models.Persona
import org.simpleframework.xml.core.Persister
import java.io.File
import java.lang.Exception
import java.nio.file.Files
import java.nio.file.Path

class PersonasStorageXML(
    private val config: ConfigApp
): StorageServiceI<List<Persona>> {

    private val file = File(config.appData + File.separator + "PersonasXML")

    private val persister = Persister()

    override fun exportToFile(entity: List<Persona>) {
        val carpetaPath = Path.of(config.appData)
        if(Files.notExists(carpetaPath)){
            Files.createDirectories(carpetaPath)
        }
        try{
            persister.write(entity.toPersonas(), file)
        }catch (e: Exception){
            println(e.message)
        }
    }

    override fun importFile(): List<Persona> {
        if(Files.notExists(file.toPath())){
            return emptyList()
        }
        return persister.read(Personas::class.java, file).toListaPersonas()
    }
}