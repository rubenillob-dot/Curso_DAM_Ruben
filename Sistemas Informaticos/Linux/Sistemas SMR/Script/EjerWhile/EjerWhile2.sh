#!/bin/bash

#Utiliza un bucle while para imprimir los números del 1 al 10 en la salida estándar y 
#luego indica que el bucle ha terminado.

# Inicializar un contador
contador=1

# Usar el bucle while para imprimir los números del 1 al 10
while [ $contador -le 10 ]
do
    echo $contador
    contador=$((contador+1))  # Incrementar el contador
done

echo "Fin del bucle"

