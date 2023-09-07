package com.example.mipropioblockdenotas.routesManager

import android.app.Application
import android.media.audiofx.DynamicsProcessing.Stage
import androidx.appcompat.app.AppCompatActivity
import com.example.mipropioblockdenotas.R
import java.util.Locale

object RoutesManager : AppCompatActivity() {

    private lateinit var mainStage: Stage
    private lateinit var _activeStage: Stage
    val activeStage: Stage get() = _activeStage
    lateinit var app: Application

    init{
        Locale.setDefault(Locale("es", "ES"))
    }

    private enum class Vistas(val path: Int){
        Main(R.layout.activity_main),
        Notes(R.layout.activity_nota_view)
    }

    fun initNotesView(){
        setContentView(R.layout.activity_main)
    }

}