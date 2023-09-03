class Personaje:
    def __init__(self, nombre: str, estado: bool, listaItems: list):
        self.nombre = nombre
        self.estado = estado
        self.listaItems = listaItems

    def __str__(self) -> str:
        return f"Persona({self.nombre}, {self.estado}, {self.listaItems[0]})"