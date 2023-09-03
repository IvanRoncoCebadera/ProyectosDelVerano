package com.example.practicajavafxenverano.repository

interface IGatosRepository<ID, T> {
    fun getAll(): List<T>
    fun getById(id: ID): T?
    fun save(entity: T)
    fun deleteById(id: ID)
}