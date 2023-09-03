from abc import abstractmethod
from abc import ABCMeta

class Mago(metaclass = ABCMeta):
    @abstractmethod
    def recargarVara(self, energia: int):
        pass
    
    @abstractmethod
    def poderVara(self):
        pass