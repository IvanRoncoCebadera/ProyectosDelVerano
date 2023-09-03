package com.example.retosemanal29_kotlin_javafx.di

import com.example.retosemanal29_kotlin_javafx.viewModel.ViewModel
import org.koin.dsl.module

val myModule = module {

    single { ViewModel() }

}