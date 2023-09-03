from Item import Item
from interfaz.Mago import Mago

class Vara(Item, Mago):

    poderVara = 0

    def __init__(self, id: int, poderTotalVara: int):
        super().__init__(id)
        self.poderTotalVara = poderTotalVara

    def __str__(self) -> str:
        return f"Vara({self.id}, {self.poderTotalVara}, {self.poderVara})"

    def recargarVara(self, energia: int):
        if self.poderTotalVara == 0:
            print("Se intenta recargar los puntos de poder de la vara, pero como no queda energía para eso, no ocurre nada.")
            return
        if self.poderTotalVara >= energia:
            self.poderVara = energia
            self.poderTotalVara -= energia
        else:
            self.poderVara = self.poderTotalVara
            self.poderTotalVara = 0
        print("Se recarga la vara con un total de "+str(energia)+" puntos de energía.\nA la vara le queda un total de "+str(self.poderTotalVara)+" puntos de poder disponibles.")


    def obtenerPoderVara(self):
        poder = self.poderVara
        self.poderVara = 0
        return poder