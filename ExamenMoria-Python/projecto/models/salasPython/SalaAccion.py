from Sala import Sala

class SalaAccion(Sala):
    def __init__(self, id: int, flechas: int, enemigos: int):
        super().__init__(id)
        self.flechas = flechas
        self.enemigos = enemigos

    def __str__(self) -> str:
        return f"SalaAccion({self.numeroSala}, {self.flechas}, {self.enemigos})"