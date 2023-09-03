package com.example.practicajavafxenverano.config

import mu.KotlinLogging
import java.io.File
import java.io.FileNotFoundException
import java.util.Properties

class ConfigApp {

    private val logger = KotlinLogging.logger {  }

    val FilePath by lazy {
        System.getProperty("user.dir")+ File.separator+getProperty("appFilePath")
    }

    val DatabaseUrl by lazy {
        getProperty("appUrl") ?: "jdbc:h2:mem:testeando"
    }

    val DatabaseUser by lazy {
        getProperty("appUser") ?: "root"
    }

    val DatabasePassword by lazy {
        getProperty("appPassword") ?: ""
    }

    fun getProperty(name: String): String? {
        val properties = Properties()
        properties.load(
            ClassLoader.getSystemResourceAsStream("application.properties") ?: throw FileNotFoundException("bjinjirfnkorkrbtroi")
        )
        return properties.getProperty(name)
    }

}