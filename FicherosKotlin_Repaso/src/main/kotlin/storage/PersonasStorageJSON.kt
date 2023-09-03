package storage

import com.google.gson.GsonBuilder
import config.ConfigApp
import dto.Personas
import mapper.toListaPersonas
import mapper.toPersonas
import models.Persona
import java.io.File
import java.lang.Exception
import java.nio.file.Files
import java.nio.file.Path

class PersonasStorageJSON(
    private val config: ConfigApp
) : StorageServiceI<List<Persona>>{

    private val file = File(config.appData + File.separator + "PersonasJSON")

    private val gson = GsonBuilder().setPrettyPrinting().create()

    override fun exportToFile(entity: List<Persona>) {
        val carpetaPath = Path.of(config.appData)
        if(Files.notExists(carpetaPath)){
            Files.createDirectories(carpetaPath)
        }
        try{
            val jsonText = gson.toJson(entity.toPersonas())
            file.writeText(jsonText)
        }catch (e: Exception){
            println(e.message)
        }
    }

    override fun importFile(): List<Persona> {
        if(Files.notExists(file.toPath())){
            return emptyList()
        }
        return gson.fromJson(file.readText(), Personas::class.java).toListaPersonas()
    }
}