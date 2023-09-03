class Sala:
    def __init__(self, id: int):
        self.numeroSala = id

    def __str__(self) -> str:
        return f"SalaHabilidad({self.numeroSala})"