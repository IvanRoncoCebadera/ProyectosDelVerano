package com.example.practicajavafxenverano.services.storage

import com.github.michaelbull.result.Result

interface GatosStorageServiceJson <T, E> {
    fun exportData(data: T): Result<T, E>

    fun importData(): Result<T, E>
}