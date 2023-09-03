import sys, os

path = os.path.abspath("projecto/models/personajes")

sys.path.append(path)

path = os.path.abspath("projecto/models/items")

sys.path.append(path)

import Vara, Carcaj, Anillo, Personaje, random

def createCaracters(poderMaximo, flechasIniciales) -> list:
    personajes = list()

    personajes.append(
        Personaje.Personaje("Gandalf", True, [Vara.Vara(1, random.randint(1, poderMaximo))])
    )

    personajes.append(
        Personaje.Personaje("Legolas", True, [Carcaj.Carcaj(1, random.randint(1, flechasIniciales))])
    )

    personajes.append(
        Personaje.Personaje("Frodo", True, [Anillo.Anillo(1, True)])
    )

    return personajes