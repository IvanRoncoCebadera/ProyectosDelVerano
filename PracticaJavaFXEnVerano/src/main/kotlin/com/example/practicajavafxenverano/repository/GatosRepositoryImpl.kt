package com.example.practicajavafxenverano.repository

import com.example.practicajavafxenverano.models.Gato
import com.example.practicajavafxenverano.services.database.DatabaseManager
import java.sql.Statement
import java.util.UUID

class GatosRepositoryImpl(
    private val databaseManager: DatabaseManager
) : IGatosRepository<UUID, Gato>{

    private val connection get() = databaseManager.connection

    override fun getAll(): List<Gato> {
        var gatos = mutableListOf<Gato>()
        connection.use {
            val sql = "SELECT * FROM Gatos;"

            it.prepareStatement(sql).use { stm ->

                val result = stm.executeQuery()
                while (result.next()) {
                    gatos.add(
                        Gato(
                            id = UUID.fromString(result.getString("Id")),
                            nombre = result.getString("Nombre"),
                            edad = result.getInt("Edad"),
                            apodo = result.getString("Apodo") ?: ""
                        )
                    )
                }
            }
        }
        return gatos
    }

    override fun deleteById(id: UUID) {
        connection.use {
            val sql = "DELETE FROM Gatos WHERE Id = ?;"

            it.prepareStatement(sql).use { stm ->

                stm.setString(1, id.toString())

                stm.executeUpdate()
            }
        }
    }

    override fun save(entity: Gato) {
        (getById(entity.id)) ?. let {
            update(it)
        } ?: run {
            add(entity)
        }
    }

    private fun add(entity: Gato) {
        connection.use {
            val sql = "INSERT INTO Gatos VALUES (?, ?, ?, ?);"
            it.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS).use { stm ->
                stm.setString(1, entity.id.toString())
                stm.setString(2, entity.nombre)
                stm.setInt(3, entity.edad)
                stm.setString(4, entity.apodo)

                stm.executeUpdate()
            }
        }
    }

    private fun update(entity: Gato) {
        connection.use {
            val sql = "UPDATE Gatos SET Nombre = ?, Edad = ?, Apodo = ? WHERE Id = ?;"
            it.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS).use { stm ->
                stm.setString(1, entity.nombre)
                stm.setInt(2, entity.edad)
                stm.setString(3, entity.apodo)
                stm.setString(4, entity.id.toString())

                stm.executeUpdate()
            }
        }
    }

    override fun getById(id: UUID): Gato? {
        var gato: Gato? = null
        connection.use {
            val sql = "SELECT * FROM Gatos WHERE Id = ?;"

            it.prepareStatement(sql).use { stm ->

                stm.setString(1, id.toString())

                val result = stm.executeQuery()
                while (result.next()) {
                    gato =
                        Gato(
                            id = id,
                            nombre = result.getString("Nombre"),
                            edad = result.getInt("Edad"),
                            apodo = result.getString("Apodo") ?: ""
                        )
                }
            }
        }
        return gato
    }
}