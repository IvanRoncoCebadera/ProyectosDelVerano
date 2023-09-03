package com.example.practicajavafxenverano

import com.example.practicajavafxenverano.models.Gato
import com.example.practicajavafxenverano.routes.RoutesManager
import com.example.practicajavafxenverano.viewmodel.SharedState
import javafx.event.Event
import javafx.fxml.FXML
import javafx.scene.control.*
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import com.example.practicajavafxenverano.viewmodel.ViewModel
import javafx.collections.FXCollections
import javafx.scene.control.cell.PropertyValueFactory

class HelloController: KoinComponent {

    private val viewmodel: ViewModel by inject()

    @FXML
    private lateinit var ShowNickname: TextField
    @FXML
    private lateinit var ShowAge: TextField
    @FXML
    private lateinit var ShowName: TextField
    @FXML
    private lateinit var ShowId: TextField
    @FXML
    private lateinit var tabla: TableView<Gato>
    @FXML
    private lateinit var ColumnaEdad: TableColumn<Gato, String>
    @FXML
    private lateinit var ColumnaNombre: TableColumn<Gato, String>
    @FXML
    private lateinit var TextFieldNombre: TextField
    @FXML
    private lateinit var BotonHacerExportImport: MenuItem

    @FXML
    fun initialize(){
        initBinding()
        initEvents()
        initStyles()
    }

    private fun initStyles() {
        val styleOpacity = "-fx-opacity: 1"
        ShowAge.style = styleOpacity
        ShowId.style = styleOpacity
        ShowName.style = styleOpacity
        ShowNickname.style = styleOpacity
    }

    private fun initEvents() {
        eventosDeLaTabla()

        BotonHacerExportImport.setOnAction {
            hacerPruebaDeLosFicheros()
        }
    }

    private fun eventosDeLaTabla() {
        tabla.selectionModel.selectedItemProperty().addListener{_, _, gato ->
            gato?.let { viewmodel.onSelectedUpdateGatoReference(gato) }
        }

        TextFieldNombre.setOnKeyReleased {
            filtrarContenidoTabla()
        }
    }

    private fun filtrarContenidoTabla() {
        tabla.items = FXCollections.observableArrayList(
            viewmodel.filtrarTabla(
                TextFieldNombre.text
            )
        )
    }

    private fun initBinding() {
        tabla.items = FXCollections.observableArrayList(viewmodel.state.value.gatos)
        tabla.selectionModel.selectionMode = SelectionMode.SINGLE

        ColumnaNombre.cellValueFactory = PropertyValueFactory("nombre")
        ColumnaEdad.cellValueFactory = PropertyValueFactory("edad")

        viewmodel.state.addListener { _, oldstate, newstate ->
            updateGatoCases(oldstate, newstate)
            updateTable(oldstate, newstate)
        }
    }

    private fun updateGatoCases(oldstate: SharedState, newstate: SharedState) {
        if(oldstate.gatoReference != newstate.gatoReference && newstate.gatoReference != null){
            ShowId.text = newstate.gatoReference.id.toString()
            ShowName.text = newstate.gatoReference.nombre
            ShowAge.text = newstate.gatoReference.edad.toString()
            ShowNickname.text = newstate.gatoReference.apodo
        }
    }

    private fun updateTable(oldstate: SharedState, newstate: SharedState) {
        if(oldstate.gatos != newstate.gatos){
            tabla.selectionModel.clearSelection()
            tabla.items = FXCollections.observableArrayList(newstate.gatos)
        }
    }

    private fun hacerPruebaDeLosFicheros() {
        viewmodel.hacerPruebaDeLosFicheros()
    }

    fun onCloseActionClick(event: Event) {
        val alert = Alert(Alert.AlertType.CONFIRMATION)
        alert.apply {
            headerText = "¿Está seguro de que desea salir?"
            contentText = "Se perderán todos los datos no guardados."
        }.showAndWait().ifPresent {
            if (it == ButtonType.OK) {
                RoutesManager.activeStage.close()
            } else {
                event.consume()
            }
        }
    }
}