package factories

import models.Item
import models.TipoItem
import java.time.LocalDateTime

object ItemsFactory {

    private var contadorId = 1L

    fun getRandomItem(): Item{
        return Item(
            id = contadorId++,
            fechaCreacion = LocalDateTime.now(),
            nivel = (1..3).random(),
            tipoItem = TipoItem.values().random()
        )
    }

}