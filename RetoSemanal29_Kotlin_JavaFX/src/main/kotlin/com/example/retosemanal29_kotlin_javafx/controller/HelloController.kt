package com.example.retosemanal29_kotlin_javafx.controller

import com.example.retosemanal29_kotlin_javafx.routes.RoutesManager
import com.example.retosemanal29_kotlin_javafx.viewModel.ViewModel
import javafx.fxml.FXML
import javafx.scene.control.Alert
import javafx.scene.control.Button
import javafx.scene.control.ButtonType
import javafx.scene.control.Label
import javafx.scene.control.TextArea
import javafx.scene.control.TextField
import javafx.stage.WindowEvent
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HelloController: KoinComponent {

    @FXML
    private lateinit var botonSacarNumerosPrimos: Button

    @FXML
    private lateinit var botonCalcularNumerosPerdidos: Button

    @FXML
    private lateinit var botonDescendente: Button

    @FXML
    private lateinit var botonAscendente: Button

    @FXML
    private lateinit var resultScreen: TextArea

    @FXML
    private lateinit var numbersScreen: TextField

    @FXML
    private lateinit var welcomeText: Label

    private val viewModel: ViewModel by inject()

    @FXML
    fun initialize(){
        initStyle()

        initEvents()
    }

    private fun initEvents() {
        botonAscendente.setOnAction {
            botonAscendenteSelected()
        }

        botonDescendente.setOnAction {
            botonDescendenteSelected()
        }

        botonCalcularNumerosPerdidos.setOnAction {
            botonCalcularNumerosPerdidosSelected()
        }

        botonSacarNumerosPrimos.setOnAction {
            botonSacarNumerosPrimosSelected()
        }
    }

    private fun botonSacarNumerosPrimosSelected() {
        resultScreen.text = viewModel.botonSacarNumerosPrimosSelected(numbersScreen.text)
    }

    private fun botonCalcularNumerosPerdidosSelected() {
        resultScreen.text = viewModel.botonCalcularNumerosPerdidosSelected(numbersScreen.text)
    }

    private fun botonDescendenteSelected() {
        resultScreen.text = viewModel.botonDescendenteSelected(numbersScreen.text)
    }

    private fun botonAscendenteSelected() {
        resultScreen.text = viewModel.botonAscendenteSelected(numbersScreen.text)
    }

    private fun initStyle() {
        val styleOpacity = "-fx-opacity: 1"

        resultScreen.style = styleOpacity
    }

    fun onCloseActionClick(event: WindowEvent?) {

        val alert = Alert(Alert.AlertType.CONFIRMATION)
        alert.apply {
            headerText = "¿Está seguro de que desea salir?"
            contentText = "No perdera nada, pero me cabrearé, delo por seguro."
        }.showAndWait().ifPresent {
            if (it == ButtonType.OK) {
                RoutesManager.activeStage.close()
            } else {
                event!!.consume()
            }
        }
    }
}