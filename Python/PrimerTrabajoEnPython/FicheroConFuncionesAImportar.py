def pedirNumero() -> int:
    numero: str = ""
    while not numero.isnumeric() :
        numero = input("Puedes introducir un número: ")

        if(numero.isnumeric()):
            print("De acuerdo, continuamos...")
        else:
            print("Eso no me sirve, te he pedido un número. Vuelve a probar:")
    return int(numero)

def sumar(num1, num2):
    print("El resultado de la suma es: ",num1+num2)
    print()

    
def restar(num1, num2):
    print("El resultado de la resta es: ",num1-num2)
    print()

def multiplicar(num1, num2):
    print("El resultado de la multiplicación es: ",num1*num2)
    print()

def dividir(num1, num2):
    print("El resultado de la división es: ",num1/num2)
    print()
def potencia(num1, num2):
    print("El resultado de la potencias de ",num1, ", elevado por ", num2, " es: ",num1**num2)
    print()