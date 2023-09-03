import sys, os

path = os.path.abspath("projecto/models/salasPython")

sys.path.append(path)
import Sala, SalaMagica, SalaAccion
import random

def createSalas(poderMaligno, flechas, enemigos) -> list:
    salas = list()

    contador = 0

    while contador < 36:
        contador += 1

        rng = random.randint(1,99)

        if rng <= 33:
            salas.append(
                SalaMagica.SalaMagica(
                contador, random.randint(1, poderMaligno)
                )
            )
        elif rng <= 66:
            salas.append(
                SalaAccion.SalaAccion(
                contador, random.randint(1, flechas), random.randint(1, enemigos)
                )
            )
        else:
            salas.append(
                Sala.Sala(contador)
            )

    return salas