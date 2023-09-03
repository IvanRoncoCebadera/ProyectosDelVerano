# Cómo consultar el tipo de dato
print(type("Soy un dato str"))  # Tipo 'str'
print(type(5))  # Tipo 'int'
print(type(1.5))  # Tipo 'float'
print(type(3 + 1j))  # Tipo 'complex'
print(type(True))  # Tipo 'bool'
print(type(print("Mi cadena de texto")))  # Tipo 'NoneType'

#Los comentarios se hacen de las siguientes formas:
#Soy un comentario

"""
Soy un comentario,
pero en multiples
lineas
"""

'''
Soy un comentario,
pero en multiples
lineas
'''

#Se puede transformar un tipo a otro de las siguientes formas:
textoNumero = "53"
print(5 + int(textoNumero))
print()