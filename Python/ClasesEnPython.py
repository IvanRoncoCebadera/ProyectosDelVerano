from dataclasses import dataclass

class Entidad:
    pass #Permite que dejemos la Clase vacia

@dataclass #Puedo importar el dataclass pero no se que es lo que me aporta, aseguro que no me da los getter, setter, toString y tal
class Persona(Entidad):
    def __init__(self, nombre: str, apellidos: str, edad: int): #Por mucho que especifique el tipo, se puede seguir cambiando
        super().__init__()
        self.nombre = nombre #Importante, si no pongo el 'self.', no se guardan como parametros de la clase
        self.apellidos = apellidos
        self.edad = edad

    def __str__(self):
        return f"Persona: {self.nombre}, {self.apellidos}, {self.edad}"


persona = Persona("Iván", "Ronco Cebadera", "19")

print(persona.__str__())
print()

class Hombre(Persona):
    def __init__(self, nombre: str, apellidos: str, edad: int, añosTrabajados: int):
        super().__init__(nombre, apellidos, edad)
        self.añosTrabajados = añosTrabajados

hombre = Hombre("Iván", "Ronco Cebadera", "19", 0)

print(hombre.__str__()) #Aquí seguimos usando el metodo __str__() de Persona
print()

class Mujer(Persona):
    def __init__(self, nombre: str, apellidos: str, edad: int, añosTrabajados: int):
        super().__init__(nombre, apellidos, edad)
        self.añosTrabajados = añosTrabajados

    def __str__(self):
        return f"Mujer: {self.nombre}, {self.apellidos}, {self.edad}, {self.añosTrabajados}"

mujer = Mujer("Maria", "Ronco Tovar", "34", 14)

print(mujer.__str__()) #Aquí sobreescribimos el metodo __str__() de Persona