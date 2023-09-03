from Item import Item

from interfaz.Hobbit import Hobbit
import random

class Anillo(Item, Hobbit):
    def __init__(self, id: int, estaPuesto: bool):
        super().__init__(id)
        self.estaPuesto = estaPuesto

    def __str__(self) -> str:
        return f"Anillo({self.id}, {self.estaPuesto})"

    def ponerseElAnillo(self):
        print("Tratamos de ponernos el anillo.")

        rng = random.randint(1,100)

        if rng <= 50:
            print("Hemos conseguido ponernos el anillo.")
            self.estaPuesto = True
        else:
            self.quitarseElAnillo()
    
    def quitarseElAnillo(self):
        print("No hemos conseguido ponernos el anillo.")
        self.estaPuesto = False