#!/bin/bash

#En este caso, vamos a solicitar al usuario que ingrese un número y el script determinará si ese número es par o impar. 
#El script continuará solicitando números hasta que el usuario ingrese "0" para salir.

echo "Ingrese un número (o 0 para salir):"
read numero

while [ $numero -ne 0 ]
do
    if [ $((numero % 2)) -eq 0 ]; 
    then
        echo "$numero es un número par."
    else
        echo "$numero es un número impar."
    fi

    echo "Ingrese otro número (o 0 para salir):"
    read numero
done

echo "¡Gracias por jugar!"

