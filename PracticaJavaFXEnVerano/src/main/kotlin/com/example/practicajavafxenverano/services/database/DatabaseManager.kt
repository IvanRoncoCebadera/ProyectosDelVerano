package com.example.practicajavafxenverano.services.database

import com.example.practicajavafxenverano.config.ConfigApp
import java.sql.DriverManager

class DatabaseManager(
    private val config: ConfigApp
) {
    val connection get() = DriverManager.getConnection(config.DatabaseUrl, config.DatabaseUser, config.DatabasePassword)

    init {
        initTheDatabase()
    }

    private fun initTheDatabase() {
        connection.use {
            val script =
                "CREATE TABLE IF NOT EXISTS Gatos(" +
                        "Id VARCHAR(50) PRIMARY KEY," +
                        "Nombre VARCHAR(50) NOT NULL," +
                        "Edad INT NOT NULL," +
                        "Apodo VARCHAR(50)" +
                        ");"
            it.prepareStatement(script).executeUpdate()
        }
    }

}