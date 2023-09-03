#Las variables:
numero = 3
texto = "hola"
booleano = True

print(numero) #Pone print, pero actual como un println!!!
print(texto)  #Pone print, pero actual como un println!!!
print()

#Concatenación:
print(texto, numero, booleano)
print("Esto funciona:", numero)
print("Esto también, pero especificando el tipo de dato que es:"  + str(numero))
print()

#Desestructuración (no puedo confirmar si es desestructuradión, pero eso parece, no?):
nombre, apellido, edad = "Iván", "Ronco Cebadera", 19
#Se puede desestructurar un String en cada uno de sus caracteres!!!
language = "python"
a, b, c, d, e, f = language
print(a)
print(e)
print()

#Las variables pueden cambiar su tipo a voluntad:
texto = 5

print(texto)
print()

#Aunque especifiquemos el tipo, este puede cambiar siempre!!!
nombre: str = "Iván"
nombre = 3
print(nombre)
print()

                                        #Listas:
lista = list()
otraLista = []

# lista = list(2, 3,4 ,5, 6,67), Así no se puede hacer una lista con datos de una!!!, solo puede haber un dato, como abajo
otraLista = [2, 3, 4 , True, "Hola"]

print(otraLista)
print(otraLista[3])
print()

lista = list("3")

print(lista+otraLista) #Se pueden concatenar
print()

print(lista)
print(len(lista))
print()

#Funciones para las listas:

lista.append("Hola") #append()

print(lista)
print(len(lista))
print()

lista.insert(1, "Adios") #insert(), si no le pones un numero, no funciona

print(lista)
print(len(lista))
print()

lista[1] = "Adios al reves"

print(lista)
print(len(lista))
print()

lista.remove("Hola") #remove(), solo puede ser lo que queramos eliminar, no funciona según la posición

print(lista)
print(len(lista))
print()

poppedElement = lista.pop() #pop()

print(poppedElement)
print(len(lista))
print()

lista = otraLista.copy() #copy()

print(lista)
print(len(lista))
print()

lista.clear() #clear()

print(lista)
print(len(lista))
print()

lista = otraLista.copy()

lista.reverse() #reverse()

print(lista)
print(len(lista))
print()

lista = [1 ,2 ,3, 4,5, 5,6, 7,7,1 ,13,241, 3]
lista.sort(reverse=True) #sort(), toda la lista debe tener los mismos tipos de datos!!!, tiene el parametro reversed

print(lista)
print(len(lista))
print()

print(lista[1:6]) #Cogemos el intervalo, desde la pos 1 a la 6, pero sin contarla, así que la 5!!!
print(len(lista[1:6]))
print()

print(lista.count(3)) #count()
print(lista.index(1)) #index()
print()
                                    #Tuplas:
tupla = tuple()
otraTupla = ()

tupla = tuple("35") #Ocurrren cosas curiosas, el "35", se vuelve ('3', '5')
otraTupla = (35, 60, 30, "Hola") #De esta forma, se queda como entra (35, 60, 30, 'Hola')

print(tupla)
print(otraTupla)
print()

#Funciones de las tuplas:
print(tupla.count('3')) #count()
print(tupla.index('3')) #index()
print()

print(tupla+otraTupla) #Se pueden concatenar
print()

#Las tuplas también tinene las funciones: insert(), tupla[0]..., etc... !!!

                                    #Sets:
Set = set()
otroSet = {}

Set = set() #No puede tener valores dentro
otroSet = {1, 2, 4,5, 4 ,5 ,3, "Hola"} #Los ordena y elimina los repetidos!!!!

print(Set)
print(otroSet)
print()

#Funciones en los sets:
Set.add("Hola") #add()

print(Set)
print()

print(4 in otroSet) #Nos permite saber si lo contine o no
print()

otroSet.remove(4)
print(otroSet)
print()

Set.clear()
print(Set)
print()

Set.add("Adios")
Set.add(3)
print(Set)
print(Set.union(otroSet))
unionSet = Set.union(otroSet) #En los dos casos los sets se unen ordenando los datos y quitando los repetidos, pero puede que tras unos intentos (no se por que pero habeces lo hace otras no)
print(unionSet)
print()

                                    #Dicts(mapas???):
Dict = dict()
otroDict = {}

Dict = dict()
otroDict = {"Nombre": "Iván", "Apellido":{ "Ronco", "Cebadera"}, "Edad": 19}

print(Dict)
print(otroDict)
print()

print(otroDict["Apellido"])
print()

print("Apellido" in otroDict)
print()

otroDict["Nombre"] = "Alvaro"
otroDict["Edad"] = "21" #He cambiado el tipo de int a str(String)
print(otroDict)
print()

print(otroDict.items())
print(otroDict.keys())
print(otroDict.values())
print()

print(dict.fromkeys(otraLista)) #Puede crear las claves a partir de una lista, tupla, set o dict!!!!
