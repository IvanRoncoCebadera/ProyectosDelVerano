from abc import abstractmethod
from abc import ABCMeta

class Hobbit(metaclass = ABCMeta):
    @abstractmethod
    def ponerseElAnillo(self):
        pass
    
    @abstractmethod
    def quitarseElAnillo(self):
        pass