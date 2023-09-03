package models

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name="persona")
data class Persona(
    @field:Element(name = "dni")
    @param:Element(name = "dni")
    val dni: String,
    @field:Element(name = "nombre")
    @param:Element(name = "nombre")
    var nombre: String,
    @field:Element(name = "apellidos")
    @param:Element(name = "apellidos")
    var apellidos: String,
    @field:Element(name = "edad")
    @param:Element(name = "edad")
    var edad: Int
)