"""
Dato importante al importar cosas de otro fichero, debo guardar.
Si, tal cual, guardar 'save' o 'save all' para que al hacer import no me de:
ImportError: cannot import name 'pedirNumero' from 'FicheroConFuncionesAImportar'
"""
from FicheroConFuncionesAImportar import pedirNumero, sumar, restar, multiplicar, dividir, potencia

print("Hola usuario necesito que me ayudes!!!!!")

primerNumero = pedirNumero()


segundoNumero = pedirNumero()

print("De acuerdo, según los números que has introducido sacamos los siguienes resultados:")
print()
sumar(num1=primerNumero, num2=segundoNumero)
restar(num1=primerNumero, num2=segundoNumero)
multiplicar(num1=primerNumero, num2=segundoNumero)
dividir(num1=primerNumero, num2=segundoNumero)
potencia(num1=primerNumero, num2=segundoNumero)