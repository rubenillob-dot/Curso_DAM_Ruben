#!/bin/bash

# Usando un if-else
numero=10

if [ $numero -eq 10 ]; 
then
    echo "El número es igual a 10."
else
    echo "El número no es igual a 10."
fi

# Usando un bucle while
contador=1

while [ $contador -le 5 ]
do
    echo "Contador: $contador"
    contador=$((contador+1))
done

