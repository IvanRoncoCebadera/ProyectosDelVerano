package com.example.practicajavafxenverano.services.storage

import com.example.practicajavafxenverano.config.ConfigApp
import com.example.practicajavafxenverano.dto.mappers.toDto
import com.example.practicajavafxenverano.dto.mappers.toGatos
import com.example.practicajavafxenverano.dto.models.ListaGatosDto
import com.example.practicajavafxenverano.models.Gato
import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import com.google.gson.GsonBuilder
import java.io.File
import java.io.FileNotFoundException
import java.io.FileReader
import java.lang.Exception
import java.nio.file.Files
import java.nio.file.Path

class GatosStorageServiceJsonImpl(
    private val config: ConfigApp
): GatosStorageServiceJson<List<Gato>, Exception> {

    private val fileName = config.FilePath+File.separator+"gatos.json"

    override fun exportData(data: List<Gato>): Result<List<Gato>, Exception> {
        val file = File(fileName)
        if (!file.exists()){
            Files.createDirectories(Path.of(config.FilePath))
        }
        return try {
            val gson = GsonBuilder().setPrettyPrinting().create()
            val jsonString = gson.toJson(data.toDto())
            file.writeText(jsonString)
            Ok(data)
        }catch (e: Exception){
            Err(e)
        }
    }

    override fun importData(): Result<List<Gato>, Exception> {
        val file = File(fileName)
        if(!file.exists()){
            return Err(FileNotFoundException("kvkfvmofkkmr"))
        }
        return try{
            val gson = GsonBuilder().setPrettyPrinting().create()
            Ok(gson.fromJson(FileReader(file), ListaGatosDto::class.java).toGatos())
        }catch (e: Exception){
            Err(e)
        }
    }
}