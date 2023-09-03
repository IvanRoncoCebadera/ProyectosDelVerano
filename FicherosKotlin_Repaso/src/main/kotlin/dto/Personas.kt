package dto

import models.Persona
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "Personas")
data class Personas(
    @field:ElementList(name = "Personas", inline = true) // Si no pones el inline = true, no podras leer el archivo
    @param:ElementList(name = "Personas", inline = true)
    val personas: List<Persona>
)