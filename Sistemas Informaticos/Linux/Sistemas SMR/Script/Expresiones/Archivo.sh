#!/bin/bash

# Usando un if-else
archivo="mi_archivo.txt"

if [ -f "$archivo" ]; 
then
    echo "El archivo existe y es un archivo regular."
else
    echo "El archivo no existe o no es un archivo regular."
fi

# Usando un bucle for
for fichero in *
do
    if [ -d "$fichero" ]; 
    then
        echo "$fichero es un directorio."
    fi
done

