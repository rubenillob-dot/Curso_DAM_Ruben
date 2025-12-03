#!/bin/bash

# Solicitar al usuario que ingrese el primer número

echo "Ingrese el primer número:"
read num1

# Solicitar al usuario que ingrese el segundo número

echo "Ingrese el segundo número:"
read num2

# Comprobar cuál de los dos números es el más pequeño
if [ "$num1" -lt "$num2" ]; 
then
    echo "El número más pequeño es: $num1"

elif [ "$num2" -lt "$num1" ]; 
then
    echo "El número más pequeño es: $num2"

else
    echo "Los números son iguales."
fi

