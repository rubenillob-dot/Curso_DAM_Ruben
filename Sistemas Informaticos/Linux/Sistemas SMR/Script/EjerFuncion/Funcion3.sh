#!/bin/bash

# Cuenta hasta 5, imprimiendo los números del 1 al 5 en la salida.
# Puedes ajustar el número pasado a la función para contar hasta cualquier número deseado.

# Definir una función que cuenta hasta un número específico
contar_hasta() {
    objetivo=$1
    contador=1
    
    while [ $contador -le $objetivo ]
    do
        echo $contador
        contador=$((contador+1))
    done
}

# Llamar a la función y pasarle el número hasta el cual contar
echo "Contando hasta 20:"
contar_hasta 20

