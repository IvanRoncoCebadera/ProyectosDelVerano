package com.example.practicajavafxenverano.di

import com.example.practicajavafxenverano.config.ConfigApp
import com.example.practicajavafxenverano.repository.GatosRepositoryImpl
import com.example.practicajavafxenverano.services.database.DatabaseManager
import com.example.practicajavafxenverano.services.storage.GatosStorageServiceJson
import com.example.practicajavafxenverano.services.storage.GatosStorageServiceJsonImpl
import org.koin.dsl.module
import com.example.practicajavafxenverano.viewmodel.ViewModel

val myModule = module {
    single { ConfigApp() }

    single { DatabaseManager(get()) }

    single { GatosStorageServiceJsonImpl(get()) }

    single { GatosRepositoryImpl(get()) }

    single { ViewModel(get(), get()) }
}