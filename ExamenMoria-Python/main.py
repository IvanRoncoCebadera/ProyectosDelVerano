import sys, os, datetime, time, random

path = os.path.abspath("projecto/factories/personajes")

sys.path.append(path)

from PersonajesFactory import createCaracters

path = os.path.abspath("projecto/factories/salas")

sys.path.append(path)

from SalasFactory import createSalas

import Sala, SalaAccion, SalaMagica, Anillo, Vara, Carcaj, Personaje

path = os.path.abspath("projecto/models/cola")

sys.path.append(path)

import ColaSalas

path = os.path.abspath("projecto/utilidades")

sys.path.append(path)

from Utils import quedanPersonajesVivos # Puede que termine teniendo que cambiar esto a un '*'

posicionMago = 0
posicionElfo = 1
posicionHobbit = 2

def main():

    #Tener en cuenta que esto debería ser por argumentos del programa, y falta validarlos
    poder = input("Introduzca el poder máximo de la vara: ")
    flechasIniciales = input("flechasIniciales: ")
    poderMaligno = input("poderMaligno: ")
    flechasMaximas = input("flechasMaxima: ")
    enemigos = input("enemigos: ")

    personajes = createCaracters(int(poder), int(flechasIniciales))

    for pj in personajes:
        print(pj)

    repositorioSalas = ColaSalas.ColaSalas(createSalas(int(poderMaligno), int(flechasMaximas), int(enemigos)))

    tiempoInicial = 0
    tiempoFinal = 0

    tiempoInicial = datetime.datetime.now()

    tiempoSimulacion = 0

    while repositorioSalas.quedanSalas() and quedanPersonajesVivos(personajes):
        
        print("---------------------------------------------------------------------------------")
        print()

        salaActual = repositorioSalas.getOut()

        print("La primera sala contra la que nos toca enfrentarnos es:")
        print(salaActual)
        print()

        realizarEnfrentamientoContraSala(salaActual, personajes)

        time.sleep(2)


def realizarEnfrentamientoContraSala(sala: Sala, personajes):
    if type(sala) is SalaMagica.SalaMagica:
        accionSalaMagica(sala, personajes[posicionMago])
    elif type(sala) is SalaAccion.SalaAccion:
        accionSalaAccion(sala, personajes[posicionElfo])
    else:
        accionSalaHabilidad(sala, personajes[posicionHobbit])

def accionSalaMagica(salaMagica: SalaMagica, mago: Personaje):
    print(f"Como nos encontramos en una sala mágica, la pieza importante del equipo es el: {mago}")
    print()

    vara: Vara = mago.listaItems[0]
    vara.recargarVara(random.randint(1,10))
    print()

    poderMaligno = salaMagica.poderMaligno
    poderVara = vara.obtenerPoderVara()

    if poderMaligno < poderVara:
        print("Como el poder de nuestra vara es mayor que el poder maligno, hemos ganado el encuentro.")
        print()
        return
    else:
        rng = random.randint(1, 100)
        if poderMaligno == poderVara:
            print("El poder de nuestra vara es el mismo que el poder maligno.")
            if rng <= 60:
                print("Pero aun así y gracias a dios, hemos ganado el encuentro.")
                print()
                return
            else:
                print("El poder de nuestra vara es menor que el poder maligno.")
                if rng <= 20:
                    print("Pero aun así y gracias a dios, hemos ganado el encuentro.")
                    print()
                    return
                
    print("Por desgracia hemos terminado perdiendo el encuentro, se acabo la partida.")
    print()
    mago.estado = False

def accionSalaAccion(salaAccion: SalaAccion, elfo: Personaje):
    print(f"Como nos encontramos en una sala de acción, la pieza importante del equipo es el: {elfo}")
    print()

    carcaj: Carcaj = elfo.listaItems[0]

    enemigosSala = salaAccion.enemigos
    while enemigosSala > 0:
        if carcaj.lanzarFlecha():
            enemigosSala -= 1
        else:
            break

    if enemigosSala == 0:
        flechasSala = salaAccion.flechas
        print("Hemos acabado con todos los enemigos, ganando el encuentro, por lo que procedemos a recoger las flechas de la sala y avanzar a la siguiente sala.")
        carcaj.recargarCarcaj(flechasSala)
        print()
    else:
        rng = random.randint(1, 100)
        print("Hemos perdido el encuentro.")
        if rng <= 80:
            print("Sin embargo, hemos conseguido escapar a la siguiente sala.")
            print()
        else:
            print("Desafortunadamente hemos perdido el encuentro, por lo que termino la partida.")
            print()
            elfo.estado = False

def accionSalaHabilidad(salaHabilidad: Sala, hobbit: Personaje):
    print(f"Como nos encontramos en una sala de habilidad, la pieza importante del equipo es el: {hobbit}")
    print()

    rng = random.randint(1, 100)
    anillo: Anillo = hobbit.listaItems[0]

    anillo.ponerseElAnillo()
    print()

    if anillo.estaPuesto:
        if rng <= 90:
            print("Hemos conseguido ganar el encuentro en la sala de habilidad")
            print()
            return
        elif rng <= 20:
            print("Aunque no nos hayamos puesto el anillo, hemos conseguido ganar el encuentro en la sala de habilidad")
            print()
            return
        
    print("Hemos perdido el encuentro en la sala de habilidad.")

    rng = random.randint(1, 100)

    if rng <= 80:
        print("Pero afortunadamente hemos conseguido escapar a la siguienter sala.")
        print()
    else:
        print("Desafortunadamente hemos perdido el encuentro, por lo que termino la partida.")
        print()
        hobbit.estado = False