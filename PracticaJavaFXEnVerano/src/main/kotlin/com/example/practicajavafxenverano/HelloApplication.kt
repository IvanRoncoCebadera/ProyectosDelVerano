package com.example.practicajavafxenverano

import com.example.practicajavafxenverano.di.myModule
import com.example.practicajavafxenverano.routes.RoutesManager
import javafx.application.Application
import javafx.stage.Stage
import org.koin.core.context.startKoin

class HelloApplication : Application() {

    init {
        startKoin {
            modules(myModule)
        }
    }

    override fun start(stage: Stage) {
        RoutesManager.apply {
            app = this@HelloApplication
        }
        RoutesManager.initMainStage(stage)
    }
}

fun main() {
    Application.launch(HelloApplication::class.java)
}