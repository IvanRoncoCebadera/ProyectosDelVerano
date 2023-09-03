package com.example.retosemanal29_kotlin_javafx

import com.example.retosemanal29_kotlin_javafx.di.myModule
import com.example.retosemanal29_kotlin_javafx.routes.RoutesManager
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin

class HelloApplication : Application(), KoinComponent {

    init {
        startKoin{
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