package com.example.retosemanal29_kotlin_javafx.routes

import com.example.retosemanal29_kotlin_javafx.HelloApplication
import com.example.retosemanal29_kotlin_javafx.controller.HelloController
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage
import java.util.*

object RoutesManager {

    private lateinit var mainStage: Stage
    private lateinit var _activeStage: Stage
    val activeStage get() = _activeStage
    lateinit var app: Application

    init {
        Locale.setDefault(Locale("es", "ES"))
    }

    fun initMainStage(stage: Stage){
        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("hello-view.fxml"))
        val scene = Scene(fxmlLoader.load(), 610.0, 290.0)
        stage.apply {
            title = "Ordenador de arrays!!!"
            stage.scene = scene
            isResizable = false
            setOnCloseRequest {
                fxmlLoader.getController<HelloController>().onCloseActionClick(it)
            }
        }


        mainStage = stage
        _activeStage = stage

        mainStage.show()
    }
}