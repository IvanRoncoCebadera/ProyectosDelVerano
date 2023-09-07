package com.example.mipropioblockdenotas.viewmodel

import com.example.mipropioblockdenotas.models.Nota

class ViewModel {



}



class  SharedState(
    val listaDeNotas: List<Nota> = emptyList(),
    val notaSeleccionada: Nota? = null
)