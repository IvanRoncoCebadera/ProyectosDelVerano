package com.example.practicajavafxenverano.routes

import com.example.practicajavafxenverano.HelloController
import com.example.projectofinalitv.utils.getResource
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
        val fxmlLoader = FXMLLoader(getResource("hello-view.fxml"))
        val scene = Scene(fxmlLoader.load(), 615.0, 400.0)
        stage.apply {
            title = "Gestión de citas"
            isResizable = false
            setOnCloseRequest {
                fxmlLoader.getController<HelloController>().onCloseActionClick(it)
            }
            stage.scene = scene
        }

        mainStage = stage
        _activeStage = stage

        mainStage.show()
    }
}