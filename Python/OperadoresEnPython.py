#Operadores básicos
print(5 + 4)
print(5 - 4)
print(5 * 4)
print(5 / 4)
print(5 % 4)
print(5 // 4) #Realiza la división devolviendo como resultado un numero entero
print(5 ** 4) #Realiza la potencia de 5 eleveado a 4
print(5 + 4 - 5 ** 4)
print()

# Operaciones con cadenas de texto
print("Hola " + "Python " + "¿Qué tal?")
print("Hola " + str(5))
print()

# Operaciones mixtas
print("Hola " * 5) #Se repite el texto 5 veces
print("Hola " * (2 ** 3)) #Se repite el texto el número de veces resultantes de la operación
print()

#Operaciones de comparación
print(3 > 4)
print(3 < 4)
print(3 >= 4)
print(4 <= 4)
print(3 == 4)
print(3 != 4)
print()

# Operaciones con cadenas de texto (la verdad es que no entiendo la lógica de poder usar esto, pero bueno aquí está)
print("Hola" > "Python")
print("Hola" < "Python")
print("aaaa" >= "abaa")  # Ordenación alfabética por ASCII
print(len("aaaa") >= len("abaa"))  # Cuenta caracteres
print("Hola" <= "Python")
print("Hola" == "Hola")
print("Hola" != "Python")
print()

#Operadores or, and y not
print(1 > 2 or 1 < 2)
print(1 > 2 and 1 < 2)
print(not (1 < 2))
print()

#Operadores en Strings
print("Este es un String\ncon salto de línea")
print("\tEste es un String con tabulación")
print("\\tEste es un String \\n escapado")
print()

# Formateo (son distintas formas de concatenar un string)
name, surname, age = "Brais", "Moure", 35
print("Mi nombre es {} {} y mi edad es {}".format(name, surname, age))
print("Mi nombre es %s %s y mi edad es %d" % (name, surname, age))
print("Mi nombre es " + name + " " + surname + " y mi edad es " + str(age))
print(f"Mi nombre es {name} {surname} y mi edad es {age}")
print()

#Se puede desestructurar un String en cada uno de sus caracteres!!!
language = "python"
a, b, c, d, e, f = language
print(a)
print(e)
print()

#Se puede tomar solo unos caracteres de un String
language_slice = language[1:3]
print(language_slice)

language_slice = language[1:]
print(language_slice)

language_slice = language[4]
print(language_slice)

language_slice = language[-2]
print(language_slice)

language_slice = language[0:6:2] #Esto esta cogiendo los caracteres de las posiciones: 0, 2 y 6, en ese orden
print(language_slice)
print()

# Reverse (Con esto escribimos el String en reverso)
reversed_language = language[::-1]
print(reversed_language)
print()

# Funciones del lenguaje
print(language.capitalize()) #Pone la pimera letra en mayúsculas
print(language.upper())
print(language.count("t")) #Cuenta cuantas 't's hay en el String
print(language.isnumeric()) #Valida si el String es un número
print("1".isnumeric())
print(language.lower())
print(language.lower().isupper()) #Comprueba si TODO el String está en mayúsculas
print(language.startswith("Py"))
print("Py" == "py")  # No es lo mismo, es keySensitive
print()