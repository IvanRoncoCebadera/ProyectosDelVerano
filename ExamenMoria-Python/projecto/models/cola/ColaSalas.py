import sys, os

path = os.path.abspath("projecto/models/salasPython")

sys.path.append(path)
import Sala

class ColaSalas:
    def __init__(self, listaSalas):
        self.salas: list = listaSalas

    def insert(self, sala):
        self.salas.append(sala)

    def getOut(self) -> Sala:
        return self.salas.pop(0)
    
    def quedanSalas(self) -> bool:
        return self.salas.__len__() > 1