from Item import Item
from interfaz.Elfo import Elfo

class Carcaj(Item, Elfo):
    def __init__(self, id: int, flechasIniciales: int):
        super().__init__(id)
        self.flechasTotales = flechasIniciales

    def __str__(self) -> str:
        return f"Carcaj({self.id}, {self.flechasTotales})"

    def lanzarFlecha(self) -> bool:
        if self.flechasTotales == 0:
            print("No quedan más flechas para disparar a los enemigos.")
            print()
            return False
        self.flechasTotales -= 1
        print("Has disparado una flecha matando a un enemigo, te quedán "+str(self.flechasTotales)+" flechas en el carcaj.")
        print()
        return True

    def recargarCarcaj(self, flechas: int):
        self.flechasTotales += flechas
        print("Se han encontrado "+str(self.flechasTotales)+" flechas en la sala y se las han quedado, ahora disponemos de "+str(flechas)+" felchas en el carcaj.")