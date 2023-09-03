from Sala import Sala

class SalaMagica(Sala):
    def __init__(self, id: int, poderMaligno: int):
        super().__init__(id)
        self.poderMaligno = poderMaligno

    def __str__(self) -> str:
        return f"SalaMágica({self.numeroSala}, {self.poderMaligno})"