package com.example.mipropioblockdenotas

import com.example.mipropioblockdenotas.models.Nota

interface OnClickListener {
    fun onClickDelete()
    fun onClickAdd(nota: Nota)
}