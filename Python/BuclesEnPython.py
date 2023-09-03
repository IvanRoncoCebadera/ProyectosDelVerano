import time

contador = 0

while contador < 2:
    contador += 1
    time.sleep(1)
else:
    print("Se termino la secuencia!!!")
print(contador)
print()

contador = 0

while contador < 2:
    contador += 1
    if contador == 1:
        break
print(contador)
print()

lista = [1, 23 ,45, 6, 6, 4, 4]

for number in lista:
    print(str(number))