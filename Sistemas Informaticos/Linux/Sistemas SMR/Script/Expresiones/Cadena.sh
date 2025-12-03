#!/bin/bash

# Usando un if-else
cadena="hola"

if [ "$cadena" = "hola" ]; 
then
    echo "La cadena es 'hola'."
else
    echo "La cadena no es 'hola'."
fi

# Usando un bucle until
numero=0

until [ "$numero" != "0" ]
do
    echo "Ingrese un número diferente de cero:"
    read numero
done

