#!/bin/bash

# Verificar si se proporcionó un argumento
if [ $# -eq 0 ]; 
then
    echo "Error: Se requiere un número como argumento."
    exit 1
fi

# Obtener el número del primer argumento
numero="$1"

# Verificar si el argumento es un número positivo
if [ "$numero" -le 0 ]; then
    echo "Error: \"$numero\" no es un número positivo válido."
    exit 1
fi

# Mostrar los divisores del número
echo "Los divisores de $numero son:"
for ((i=1; i<=$numero/2; i++)); 
do
    if ((numero % i == 0)); 
    then
        echo "$i"
    fi
done
echo "$numero"

