#!/bin/bash

#El script verificará si cada número del 1 al 5 es par o impar y mostrará un mensaje correspondiente

echo "Verificando si los números del 1 al 5 son pares o impares:"

# Utilizar un bucle for para iterar sobre los números del 1 al 5
for numero in {1..5}
do
    echo "Número: $numero"

    # Verificar si el número es par o impar
    if [ $((numero % 2)) -eq 0 ]; 
    then
        echo "$numero es un número par."
    elif [ $((numero % 2)) -ne 0 ]; 
    then
        echo "$numero es un número impar."
    fi
done


# El operador % es el operador de módulo en Bash, que devuelve el residuo de la división de dos números.
# -eq: Es un operador de prueba que significa "es igual a". Se utiliza para verificar si dos valores son iguales.
# 0: Es el valor con el que estamos comparando el residuo de la división.



