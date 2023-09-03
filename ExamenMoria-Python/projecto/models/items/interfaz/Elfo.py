from abc import abstractmethod
from abc import ABCMeta

class Elfo(metaclass = ABCMeta):
    @abstractmethod
    def recargarCarcaj(self, flechas: int):
        pass
    
    @abstractmethod
    def lanzarFlecha(self):
        pass